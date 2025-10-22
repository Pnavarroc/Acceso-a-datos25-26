package org.iesch.com.RestProductos;

import org.iesch.com.RestProductos.modelo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class RestProductosApplication  {//implements CommandLineRunner


	/*
	/@Autowired
	List<Product> productos;
*/
	public static void main(String[] args) {
		SpringApplication.run(RestProductosApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		//System.out.println(productos);
	}*/
}
