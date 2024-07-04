package com.EcoVoyagers.repositorie;

import com.EcoVoyagers.model.Itinerary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItineraryRepository extends CrudRepository<Itinerary, Integer> {
}
