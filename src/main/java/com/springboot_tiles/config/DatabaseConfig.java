package com.springboot_tiles.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DatabaseConfig {
	@Autowired
	private Environment environment;
	
	@Bean(name = "datasource")
	public DriverManagerDataSource getDataSourceSQL(){
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
		dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
	    
	    return dataSource;
	}
   
	@Bean(name="tm1")
    @Autowired
    @Primary
    public PlatformTransactionManager txManager() { 
    	return new DataSourceTransactionManager(getDataSourceSQL()); 
    }
}
