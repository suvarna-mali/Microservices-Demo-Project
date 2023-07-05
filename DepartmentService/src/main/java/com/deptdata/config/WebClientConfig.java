package com.deptdata.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.deptdata.Client.EmployeeClient;

@Configuration
public class WebClientConfig {

	@Autowired
	private LoadBalancedExchangeFilterFunction loadfunction;
	
	@Bean
	public WebClient employeeWebClient()
	{
		return WebClient.builder()
				.baseUrl("http://employee-service")
				.filter(loadfunction)
				.build();
	}
	@Bean
	public EmployeeClient empclient()
	{
		HttpServiceProxyFactory serviceproxyfactory =HttpServiceProxyFactory
				.builder(WebClientAdapter.forClient(employeeWebClient())).build();
		return serviceproxyfactory.createClient(EmployeeClient.class);
	}
	
}
