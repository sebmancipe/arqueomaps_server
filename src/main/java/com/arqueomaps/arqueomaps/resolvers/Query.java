package com.arqueomaps.arqueomaps.resolvers;

import com.arqueomaps.arqueomaps.entities.Civilization;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    public List<Civilization> getAllCivilizations(){
        Civilization civilization_1 = new Civilization();
        civilization_1.setId(1);
        civilization_1.setName("Maya");
        civilization_1.setDescription("Civilización Maya, presente en México");

        Civilization civilization_2 = new Civilization();
        civilization_2.setId(2);
        civilization_2.setName("Inca");
        civilization_2.setDescription("Civilización Inca, presente en Perú");

        List<Civilization> array = Arrays.asList(civilization_1,civilization_2);
        return array;
    }

    public Civilization getCivilizationById(int Id){
        List<Civilization> civilizations = getAllCivilizations();
        for (int i = 0; i < civilizations.size(); i++) {
            if(civilizations.get(i).getId()==Id)return civilizations.get(i);
        }
        return null;
    }

}
