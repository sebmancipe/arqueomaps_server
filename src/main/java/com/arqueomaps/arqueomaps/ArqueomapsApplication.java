package com.arqueomaps.arqueomaps;

import com.arqueomaps.arqueomaps.entities.Civilization;
import com.arqueomaps.arqueomaps.repositories.CivilizationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ArqueomapsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArqueomapsApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CivilizationRepository civilizationRepository) {
		return (args) -> {
			Civilization civilization = new Civilization();
			civilization.setName("Maya");
			civilization.setDescription("Civilización indígena centroamericana");
			civilizationRepository.save(civilization);
		};
	}

}
