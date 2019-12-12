package com.arqueomaps.serverarqueo.resolvers;

import com.arqueomaps.serverarqueo.entities.Civilization;
import com.arqueomaps.serverarqueo.entities.Figure;
import com.arqueomaps.serverarqueo.entities.Place;
import com.arqueomaps.serverarqueo.repositories.CivilizationRepository;
import com.arqueomaps.serverarqueo.repositories.FigureRepository;
import com.arqueomaps.serverarqueo.repositories.PlaceRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private CivilizationRepository civilizationRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private FigureRepository figureRepository;

    public Civilization newCivilization(String Name, String Description){
        Civilization civilization = new Civilization();
        civilization.setName(Name);
        civilization.setDescription(Description);
        civilizationRepository.save(civilization);
        return civilization;
    }


    //TODO: How to add an array of Places?
    public int newPlacesOfCiv(Place[] Places, int id_civilization){
        Civilization civilization = civilizationRepository.findById(id_civilization).orElse(null);
        for (int i = 0; i < Places.length; i++) {
            Place placeTemp = Places[i];
            placeTemp.setCivilization(civilization);
            placeRepository.save(placeTemp);
        }
        return id_civilization;
    }

    public boolean deleteCivilization(int Id){
        civilizationRepository.deleteById(Id);
        return true;
    }

    public Place newPlace(String Name,String Description, Float Latitude, Float Longitude, String Tag, int id_civilization, int id_figure){
        Place place = new Place();
        place.setName(Name);
        place.setDescription(Description);
        place.setLatitude(Latitude);
        place.setLongitude(Longitude);
        place.setTag(Tag);
        place.setCivilization(civilizationRepository.findById(id_civilization).orElse(null)); //Possible null pointer exception
        place.setFigure(figureRepository.findById(id_figure).orElse(null));
        placeRepository.save(place);
        return place;
    }

    public boolean deletePlace(int Id){
        placeRepository.deleteById(Id);
        return true;
    }

    public Place updatePlaceById(int Id, String Name, String Description, Float Latitude, Float Longitude){
        Place place = placeRepository.findById(Id).orElse(null);
        place.setName(Name);
        place.setDescription(Description);
        place.setLatitude(Latitude);
        place.setLongitude(Longitude);
        placeRepository.save(place);
        return place;
    }

    public Figure newFigure(String Name, String Description, Float Area, String Author, String CreationDate){
        Figure figure = new Figure();
        figure.setName(Name);
        figure.setDescription(Description);
        figure.setArea(Area);
        figure.setAuthor(Author);
        figure.setCreationDate(CreationDate);
        figureRepository.save(figure);
        return figure;
    }

    public boolean deleteFigure(int Id){
        figureRepository.deleteById(Id);
        return true;
    }


}
