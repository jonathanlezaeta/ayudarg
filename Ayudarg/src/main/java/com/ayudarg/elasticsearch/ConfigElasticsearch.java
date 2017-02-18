package com.ayudarg.elasticsearch;

public class ConfigElasticsearch {
	private String host;
	private int port;
	public static final String HOST = "localhost";
	public static final int PORT = 9300;
	
	public ConfigElasticsearch(){
		this.host = HOST;
		this.port = PORT;
	}
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
}
