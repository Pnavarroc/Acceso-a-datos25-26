package com.example.demoJPACoches;

import com.example.demoJPACoches.model.Coche;
import com.example.demoJPACoches.model.Persona;
import com.example.demoJPACoches.repositorio.CocheRepositorio;
import com.example.demoJPACoches.repositorio.PersonaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJpaCochesApplication implements CommandLineRunner {

	@Autowired
	PersonaRepositorio personaRepositorio;
	@Autowired
	CocheRepositorio cocheRepositorio;


	public static void main(String[] args){
		SpringApplication.run(DemoJpaCochesApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		Persona personatmp =personaRepositorio.findById(1L).get();
		System.out.println();
		System.out.println(personatmp.getNombre()+" tiene estos coches:");
		System.out.println("Hacemos getCoches");
		personatmp.getCoches().stream().forEach(System.out::println);

//		System.out.println("Muestra persona 1");
//		Persona personatmp = personaRepositorio.findById(1L).get();
//
//		System.out.println(personatmp.getNombre());
//		System.out.println(personatmp.getApellido());
//
//		personatmp.getCoches().stream().forEach(System.out::println);
//
//		//System.out.println(personaRepositorio.findById(1L).get());
//		System.out.println("Muestra coche 1");
//		System.out.println(cocheRepositorio.findById(1L));



	}
}
