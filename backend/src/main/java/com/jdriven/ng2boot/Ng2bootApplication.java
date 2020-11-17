package com.jdriven.ng2boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication
public class Ng2bootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ng2bootApplication.class, args);
	}
}
