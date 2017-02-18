package com.ayudarg.elasticsearch;

import java.net.InetSocketAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

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

}
