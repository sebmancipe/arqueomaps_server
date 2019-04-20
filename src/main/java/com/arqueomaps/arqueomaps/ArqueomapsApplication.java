package com.arqueomaps.arqueomaps;

import com.arqueomaps.arqueomaps.entities.Civilization;
import com.arqueomaps.arqueomaps.entities.Figure;
import com.arqueomaps.arqueomaps.entities.Place;
import com.arqueomaps.arqueomaps.repositories.CivilizationRepository;
import com.arqueomaps.arqueomaps.repositories.FigureRepository;
import com.arqueomaps.arqueomaps.repositories.PlaceRepository;
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
	public CommandLineRunner demo(CivilizationRepository civilizationRepository, FigureRepository figureRepository, PlaceRepository placeRepository) {
		return (args) -> {
			Civilization civilization = new Civilization();
			civilization.setName("Maya");
			civilization.setDescription("Civilización indígena centroamericana");
			civilizationRepository.save(civilization);

			Civilization civilization1 = new Civilization();
			civilization1.setName("Inca");
			civilization1.setDescription("Civilización indígena suramericana");
			civilizationRepository.save(civilization1);

            Civilization civilization2 = new Civilization();
            civilization2.setName("Chibcha");
            civilization2.setDescription("Civilización indígena suramericana");
            civilizationRepository.save(civilization2);

            Figure figure = new Figure();
            figure.setName("Formación 1");
            figure.setDescription("Figuras formadas por los puntos x,y,z");
            figure.setAuthor("Sebastián Mancipe");
            figure.setCreationDate("18 Marzo 2019");
            figureRepository.save(figure);


			Figure figure1 = new Figure();
			figure1.setName("Formación 2");
			figure1.setDescription("Figuras formadas por los puntos a,b,c");
			figure1.setAuthor("Karen Gonzales");
			figure1.setCreationDate("17 Marzo 2019");
			figureRepository.save(figure1);

            Place place = new Place();
            place.setName("Desierto El Infiernito");
            place.setDescription("Desierto encontrado a 3km de Villa de Leyva");
            place.setLatitude(5.6494393f);
            place.setLongitude(-73.5163933f);
            place.setTag("Natural");
            place.setCivilization(civilization2);
            place.setFigure(figure1);
            placeRepository.save(place);

			Place place1 = new Place();
			place1.setName("Laguna de Guatavita");
			place1.setDescription("Laguna en Sesquilé, Cundinamarca");
			place1.setLatitude(4.9774675f);
			place1.setLongitude(-73.7768294f);
			place1.setTag("Natural");
			place1.setCivilization(civilization1);
			place1.setFigure(figure1);
			placeRepository.save(place1);

		};
	}

}
