package io.pivotal.pcfs.demo;

import javax.sql.DataSource;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@Profile("cloud")
public class CloudConfig {

	@Configuration
	@Profile("cloud")
	static class CloudConfiguration {

		@Bean
		public CloudFactory cloudFactory(){
			return new CloudFactory();
		}
		
		@Bean
		public DataSource inventoryDataSource(CloudFactory cloudFactory) {
            Cloud cloud = cloudFactory.getCloud();
            return cloud.getServiceConnector("inventory-db", DataSource.class, null);

		}

		@Bean
		public DataSource productDataSource(CloudFactory cloudFactory) {
//            Cloud cloud = cloudFactory.getCloud();
//            return cloud.getServiceConnector("product-db", DataSource.class, null);
			return null;
		}
		
	}

	@Configuration
	@Profile("default")
	static class LocalConfiguration {

		@Bean
		public DataSource inventoryDataSource() {
			return new EmbeddedDatabaseBuilder()
	            .setName("inventory")
	            .setType(EmbeddedDatabaseType.H2)
	            .build();
		}
		
		@Bean
		public DataSource productDataSource() {
			return new EmbeddedDatabaseBuilder()
	            .setName("product")
	            .setType(EmbeddedDatabaseType.H2)
	            .build();
		}
		
	}

}
