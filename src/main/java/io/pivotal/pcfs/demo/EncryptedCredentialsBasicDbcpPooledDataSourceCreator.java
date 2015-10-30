package io.pivotal.pcfs.demo;

import org.springframework.cloud.service.AbstractServiceConnectorCreator;
import org.springframework.cloud.service.ServiceConnectorConfig;
import org.springframework.cloud.service.common.RelationalServiceInfo;

public class EncryptedCredentialsBasicDbcpPooledDataSourceCreator extends AbstractServiceConnectorCreator<EncryptedCredentialsBasicDataSource, RelationalServiceInfo>  {

	public EncryptedCredentialsBasicDbcpPooledDataSourceCreator() {
		super();
	}

	public EncryptedCredentialsBasicDataSource create(RelationalServiceInfo serviceInfo, ServiceConnectorConfig serviceConnectorConfig) {
		EncryptedCredentialsBasicDataSource basicDataSource = new  EncryptedCredentialsBasicDataSource();
		basicDataSource.setDriverClassName(null /*TODO - how do we get this value? */);
		basicDataSource.setUrl(serviceInfo.getJdbcUrl());
		basicDataSource.setUsername(serviceInfo.getUserName());
		//TODO - password doesn't seem to get set?
		basicDataSource.setPassword(serviceInfo.getPassword());
		//TODO - grab other values from service definition and set those on the datasource
		basicDataSource.setMaxTotal(10);
		
		return basicDataSource;
	}
}
