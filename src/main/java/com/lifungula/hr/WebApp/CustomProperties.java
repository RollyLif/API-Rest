package com.lifungula.hr.WebApp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;


@Configuration
@ConfigurationProperties(prefix="com.lifungula.hr.api")
@Data
public class CustomProperties {
	
	private String apiUrl;

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	
	
}
