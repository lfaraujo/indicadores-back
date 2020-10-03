package br.com.indicadores.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource
				.setUrl("jdbc:mysql://localhost:3306/indicadores_db?useTimezone=true&serverTimezone=America/Recife");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("32416363Felipe@lf");
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return driverManagerDataSource;
	}

}
