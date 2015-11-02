package io.pivotal.pcfs.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class CloudConfig {

	@Configuration
	@Profile("cloud")
	static class CloudConfiguration {

		@Bean
		public CloudFactory cloudFactory() {
			return new CloudFactory();
		}

		@Bean
		@Qualifier("inventoryDataSource")
		public DataSource inventoryDataSource(CloudFactory cloudFactory) {
			Cloud cloud = cloudFactory.getCloud();
			return cloud.getServiceConnector("inventory-db",
					EncryptedCredentialsBasicDataSource.class, null);
		}

		@Bean
		@Qualifier("productDataSource")
		public DataSource productDataSource(CloudFactory cloudFactory) {
			Cloud cloud = cloudFactory.getCloud();
			return cloud.getServiceConnector("product-db",
					EncryptedCredentialsBasicDataSource.class, null);
		}

	}

	@Configuration
	@Profile("default")
	static class LocalConfiguration {

		@Bean
		@Qualifier("inventoryDataSource")
		public DataSource inventoryDataSource() {
			return new EmbeddedDatabaseBuilder().setName("inventory")
					.setType(EmbeddedDatabaseType.H2).build();
		}

		@Bean
		@Qualifier("productDataSource")
		public DataSource productDataSource() {
			return new EmbeddedDatabaseBuilder().setName("product")
					.setType(EmbeddedDatabaseType.H2).build();
		}

	}

}
