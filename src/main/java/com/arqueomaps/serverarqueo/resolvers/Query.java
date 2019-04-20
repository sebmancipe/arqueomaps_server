package com.arqueomaps.serverarqueo.resolvers;

import com.arqueomaps.serverarqueo.entities.Civilization;
import com.arqueomaps.serverarqueo.entities.Figure;
import com.arqueomaps.serverarqueo.entities.Place;
import com.arqueomaps.serverarqueo.repositories.CivilizationRepository;
import com.arqueomaps.serverarqueo.repositories.FigureRepository;
import com.arqueomaps.serverarqueo.repositories.PlaceRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping
public class Query implements GraphQLQueryResolver {

    @Autowired
    private CivilizationRepository civilizationRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private FigureRepository figureRepository;


    public Iterable<Civilization> getAllCivilizations(){
        return civilizationRepository.findAll();
    }

    public Civilization getCivilizationById(int Id){
        return civilizationRepository.findById(Id).orElse(null);
    }

    public Iterable<Place> getAllPlaces(){
        return placeRepository.findAll();
    }

    public Place getPlaceById(int Id){
        return placeRepository.findById(Id).orElse(null);
    }

    public Iterable<Figure> getAllFigures(){
        return figureRepository.findAll();
    }

    public Figure getFigureById(int Id){
        return figureRepository.findById(Id).orElse(null);
    }

    public Iterable<Place> getAllPlacesFromCivilization(int Id){ return civilizationRepository.findAllPlacesFromCivilization(Id);}

}
