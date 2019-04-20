package com.arqueomaps.serverarqueo.resolvers;

import com.arqueomaps.serverarqueo.entities.Civilization;
import com.arqueomaps.serverarqueo.entities.Figure;
import com.arqueomaps.serverarqueo.entities.Place;
import com.arqueomaps.serverarqueo.repositories.CivilizationRepository;
import com.arqueomaps.serverarqueo.repositories.FigureRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlaceResolver implements GraphQLResolver<Place> {

    @Autowired
    private CivilizationRepository civilizationRepository;
    @Autowired
    private FigureRepository figureRepository;

    public Civilization getCivilization(Place place){
        return civilizationRepository.findById(place.getCivilization().getId()).orElse(null);
    }

    public Figure getFigure(Place place){
        return figureRepository.findById(place.getFigure().getId()).orElse(null);
    }

}
