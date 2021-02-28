package com.entelgy.app.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfigurationRestTemplate {

	@Bean(name = "clientRest")
	public RestTemplate registerRestTemplate() {
		return new RestTemplate();
	}
}
