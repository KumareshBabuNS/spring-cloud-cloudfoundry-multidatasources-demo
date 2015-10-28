package io.pivotal.pcfs.demo;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;

public class SpringApplicationTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetInstanceHappyPath() {
		assertNotNull(SpringApplication.getInstance());
	}

	@Test
	public void testGetInventoryDatasourceHappyPath() throws Exception{
		DataSource inventoryDatasource = SpringApplication.getInstance().getInventoryDatasource();
		assertNotNull(inventoryDatasource);
		assertNotNull(inventoryDatasource.getConnection());
	}

	@Test
	public void testGetProductDatasourceHappyPath() throws Exception{
		DataSource productDatasource = SpringApplication.getInstance().getProductDatasource();
		assertNotNull(productDatasource);
		assertNotNull(productDatasource.getConnection());
	}

}
