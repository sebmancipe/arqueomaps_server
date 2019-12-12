package com.arqueomaps.serverarqueo.repositories;

import com.arqueomaps.serverarqueo.entities.Civilization;
import com.arqueomaps.serverarqueo.entities.Place;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CivilizationRepository extends CrudRepository<Civilization,Integer> {
    @Query("SELECT t FROM Place t WHERE t.civilization.Ids=:id_search")
    Iterable<Place> findAllPlacesFromCivilization(@Param("id_search") int Id);
}
