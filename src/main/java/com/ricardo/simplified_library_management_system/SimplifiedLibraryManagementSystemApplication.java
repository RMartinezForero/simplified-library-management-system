package com.ricardo.simplified_library_management_system;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimplifiedLibraryManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimplifiedLibraryManagementSystemApplication.class, args);
		//TODO: eliminar lo de aqui abajo
		AtomicLong a = new AtomicLong(5);
		a.getAndIncrement();
	}

}
