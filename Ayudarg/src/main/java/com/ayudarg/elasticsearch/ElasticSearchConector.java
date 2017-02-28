package com.ayudarg.elasticsearch;

import java.net.InetSocketAddress;
import java.util.ArrayList;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

import com.ayudar.elasticsearch.model.RecursoModelEs;
import com.google.gson.Gson;

public class ElasticSearchConector {
	private Client elasticSearchClient;
	private ConfigElasticsearch config;

	public ElasticSearchConector() {
		this.config = new ConfigElasticsearch();
			Settings settings = Settings.settingsBuilder() .put("cluster.name", "ayudarg").build();
			elasticSearchClient = TransportClient.builder().settings(settings).build() .addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress(config.getHost(), config.getPort())));
	}

	public Client getElasticSearchClient() {
		return elasticSearchClient;
	}

	public void setElasticSearchClient(Client elasticSearchClient) {
		this.elasticSearchClient = elasticSearchClient;
	}
	
	public QueryBuilder getQuery(String field, String value) {
		BoolQueryBuilder finalQuery = QueryBuilders.boolQuery();
		QueryBuilder query = QueryBuilders.queryStringQuery(value);
		finalQuery.must(query);
		return finalQuery;
	}

	public ArrayList<RecursoModelEs> getRecursosByInsitucion(String idInstitucion){
		Gson gson = new Gson();
		Client client = this.getElasticSearchClient();
		SearchResponse requestBuilder = client.prepareSearch("ayudarg")
				.setTypes("recurso")
				.setSearchType(SearchType.QUERY_AND_FETCH)
			    .setQuery(QueryBuilders.matchQuery("institucion.idInstitucion", idInstitucion))
			    .setFrom(0).setSize(60).setExplain(true)
			    .execute()
			    .actionGet();
		SearchHit[] results = requestBuilder.getHits().getHits(); 
		ArrayList<RecursoModelEs> resp = new ArrayList<RecursoModelEs>();
		for (SearchHit hit : results) {
			RecursoModelEs recurso = gson.fromJson(hit.getSourceAsString(), RecursoModelEs.class);
			resp.add(recurso);
		}		
		return resp;
	}
	
	public RecursoModelEs getRecursoById(String id){
		Gson gson = new Gson();
		Client client = this.getElasticSearchClient();
		SearchResponse requestBuilder = client.prepareSearch("ayudarg")
				.setTypes("recurso")
				.setSearchType(SearchType.QUERY_AND_FETCH)
			    .setQuery(QueryBuilders.matchQuery("id", id))
			    .setFrom(0).setSize(60).setExplain(true)
			    .execute()
			    .actionGet();
		SearchHit[] results = requestBuilder.getHits().getHits(); 
		for (SearchHit hit : results) {
			return gson.fromJson(hit.getSourceAsString(), RecursoModelEs.class);
		}				
		return new RecursoModelEs();
	}
	
	public void updateRecurso(RecursoModelEs recurso){
		Gson gson = new Gson();
		Client client = this.getElasticSearchClient();
		String json = gson.toJson(recurso, RecursoModelEs.class);
		UpdateRequestBuilder br = client.prepareUpdate("ayudarg", "recurso", recurso.getId());
		br.setDoc(json.getBytes());
		br.execute();
		client.admin().indices().prepareRefresh("ayudarg").get();		
	}
	
	public void insertRecurso(String uniqueId, RecursoModelEs recurso){
		Gson gson = new Gson();
 		IndexResponse responseAdd = this.elasticSearchClient.prepareIndex("ayudarg", "recurso", uniqueId)
				.setSource(gson.toJson(recurso)).execute().actionGet();		
		if(!responseAdd.isCreated()){
			System.out.println("The document was not added");
		}
		 this.elasticSearchClient.admin().indices().prepareRefresh("ayudarg").get();	
	}
	
	public ArrayList<RecursoModelEs> searchRecursos(String localidadId, ArrayList<Long> categorias){
		Gson gson = new Gson();
		Client client = this.getElasticSearchClient();
		SearchResponse requestBuilder = client.prepareSearch("ayudarg")
				.setTypes("recurso")
				.setSearchType(SearchType.QUERY_AND_FETCH)
			    .setQuery(QueryBuilders.matchQuery("institucion.localidadId", localidadId))
			    .setQuery(QueryBuilders.termsQuery("categorias", categorias))
			    .setFrom(0).setSize(60).setExplain(true)
			    .execute()
			    .actionGet();
		SearchHit[] results = requestBuilder.getHits().getHits(); 
		ArrayList<RecursoModelEs> resp = new ArrayList<RecursoModelEs>();
		for (SearchHit hit : results) {
			RecursoModelEs recurso = gson.fromJson(hit.getSourceAsString(), RecursoModelEs.class);
			resp.add(recurso);
		}		
		return resp;		
	}
	
}
