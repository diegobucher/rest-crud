package br.inf.datainfo.usuarios_rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Aplicacao {

	public static void main(String[] args) {
		SpringApplication.run(Aplicacao.class, args);
	}

}
