package adaydoner.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="adaydoner.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	@Autowired
	private Environment env;
	
	//define a bean for view resolver
	@Bean
	public ViewResolver viewResolver(){
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	
	@Bean
	public DataSource securityDataSource(){
		
	//create connection pool
	ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

	//set the jdbc driver
	try{
		securityDataSource.setDriverClass(env.getProperty("jdbc.driver")); // property den driveri okur.
	} catch (PropertyVetoException pvexc){
		throw new RuntimeException(pvexc);
	}

	//logging
	System.out.println(">>> jdbc.url = " + env.getProperty("jdbc.url"));
	System.out.println(">>> jdbc.user = " + env.getProperty("jdbc.user"));
	
	//set database connection
	securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
	securityDataSource.setUser(env.getProperty("jdbc.user"));
	securityDataSource.setPassword(env.getProperty("jdbc.password"));
	
	//set connection pool proops
	securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
	securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize")); 
	securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
	securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
	
	
	
	
	return securityDataSource;
	}
	
	private int getIntProperty(String stringPropertyName){
		String stringPropertyValue = env.getProperty(stringPropertyName);
		
		int intPropertyValue = Integer.parseInt(stringPropertyValue);
		
		return intPropertyValue;
	}
}
