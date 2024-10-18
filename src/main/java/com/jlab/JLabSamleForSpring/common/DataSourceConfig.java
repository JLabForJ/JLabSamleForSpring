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

	@Bean
	@SuppressWarnings("rawtypes")
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
        
        dataSourceBuilder.url("jdbc:sqlite:D:\\workspace_\\JLabSamleForSpring\\JLabSamleForSpringDB.db"); // Replace with your actual database file path
        try {
			System.out.println("Created connection URL: " + dataSourceBuilder.build().getConnection().getMetaData().getURL());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return dataSourceBuilder.build();
    }
	
}