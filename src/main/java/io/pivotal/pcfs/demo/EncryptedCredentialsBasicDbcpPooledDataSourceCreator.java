package io.pivotal.pcfs.demo;

import org.springframework.cloud.service.AbstractServiceConnectorCreator;
import org.springframework.cloud.service.ServiceConnectorConfig;

public class EncryptedCredentialsBasicDbcpPooledDataSourceCreator extends AbstractServiceConnectorCreator<EncryptedCredentialsBasicDataSource, EncryptedCredentialsServiceInfo>  {

	public EncryptedCredentialsBasicDbcpPooledDataSourceCreator() {
		super();
	}

	public EncryptedCredentialsBasicDataSource create(EncryptedCredentialsServiceInfo serviceInfo, ServiceConnectorConfig serviceConnectorConfig) {
		EncryptedCredentialsBasicDataSource basicDataSource = new  EncryptedCredentialsBasicDataSource();
		basicDataSource.setDriverClassName(serviceInfo.getDriverClassName());
		basicDataSource.setUrl(serviceInfo.getJdbcUrl());
		basicDataSource.setUsername(serviceInfo.getUserName());
		basicDataSource.setPassword(serviceInfo.getPassword());
		basicDataSource.setMaxTotal(10);
		
		return basicDataSource;
	}
}
