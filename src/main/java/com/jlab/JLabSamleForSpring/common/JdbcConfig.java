package com.jlab.JLabSamleForSpring.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class JdbcConfig {

    @Bean
    public Dialect jdbcDialect(JdbcTemplate jdbcTemplate) {
        // Use SQLiteDialect as the custom dialect
        return SQLiteDialect.INSTANCE;
    }

    @Bean
    public JdbcCustomConversions jdbcCustomConversions() {
        return new JdbcCustomConversions();
    }
}