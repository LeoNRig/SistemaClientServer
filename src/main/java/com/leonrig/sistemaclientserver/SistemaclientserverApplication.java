package com.leonrig.sistemaclientserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaclientserverApplication {

	public static void main(String[] args) {

		SpringApplication.run(SistemaclientserverApplication.class, args);

		new Thread(()->{
		try {
			Servidor.main(args);
		}catch(Exception e) {
			e.printStackTrace();
		}
		}).start();
	}

}
