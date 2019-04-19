package com.arqueomaps.arqueomaps.resolvers;

import com.arqueomaps.arqueomaps.entities.Civilization;
import com.arqueomaps.arqueomaps.repositories.CivilizationRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping
public class Query implements GraphQLQueryResolver {

    private CivilizationRepository CivilizationRepository;

    public Iterable<Civilization> getAllCivilizations(){
        return CivilizationRepository.findAll();
    }

    /*public Civilization getCivilizationById(int Id){
        List<Civilization> civilizations = getAllCivilizations();
        for (int i = 0; i < civilizations.size(); i++) {
            if(civilizations.get(i).getId()==Id)return civilizations.get(i);
        }
        return null;
    }*/

}
