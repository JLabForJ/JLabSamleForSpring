package com.jlab.JLabSamleForSpring.common;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@EnableJdbcRepositories
public class DataSourceConfig {

/*
    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        // ... other configuration details
        
        return dataSource;
    }
*/

	@Bean
	@SuppressWarnings("rawtypes")
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
 // Replace with your actual driver class name
        
        dataSourceBuilder.url("jdbc:sqlite:D:\\workspace_root\\workspaceTest2024\\JLabSamleForSpring\\JLabSamleForSpringDB.db"); // Replace with your actual database file path
        try {
			System.out.println("Created connection URL: " + dataSourceBuilder.build().getConnection().getMetaData().getURL());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        dataSourceBuilder.username("your_username"); // Replace with your database username (if required)
//        dataSourceBuilder.password("your_password"); // Replace with your database password (if required)
        
        // Optional configuration for Hikari connection pool
//        dataSourceBuilder.poolName("MyHikariPool");
//        dataSourceBuilder.minimumIdle(5);
//        dataSourceBuilder.maximumPoolSize(10);
//        dataSourceBuilder.connectionTimeout(30000); // 30 seconds

        return dataSourceBuilder.build();
    }
	
}