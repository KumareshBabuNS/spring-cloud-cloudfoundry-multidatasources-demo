package io.pivotal.pcfs.demo;

import javax.sql.DataSource;

import org.apache.commons.codec.binary.Base64;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {

	private static final SpringApplication instance = new SpringApplication();
	private ApplicationContext applicationContext;
	
	private SpringApplication(){
		//enforce non instantiability
		applicationContext = new AnnotationConfigApplicationContext(CloudConfig.class);
	}
	
	
	public static SpringApplication getInstance(){
		return instance;
	}
	
	
	public DataSource getInventoryDatasource(){
		return applicationContext.getBean("inventoryDataSource", DataSource.class);
	}
	
	public DataSource getProductDatasource(){
		return applicationContext.getBean("productDataSource", DataSource.class);
	}
	
}
