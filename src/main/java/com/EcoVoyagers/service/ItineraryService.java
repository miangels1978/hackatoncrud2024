package com.EcoVoyagers.service;

import com.EcoVoyagers.model.Itinerary;
import com.EcoVoyagers.repositorie.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.ArrayList;

@Service
public class ItineraryService {

    @Autowired
    ItineraryRepository itineraryRepository;

    public ArrayList<Itinerary> getAllItineraries() {
        return (ArrayList<Itinerary>) itineraryRepository.findAll();
    }

    public Itinerary addItinerary(Itinerary newItinerary) {
        return itineraryRepository.save(newItinerary);
    }

    public boolean deleteItinerary(int id) {
        try {
            itineraryRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Itinerary updateItinerary(int id, Itinerary updatedItinerary) {
        Optional<Itinerary> optionalTask = itineraryRepository.findById(id);
        if (optionalTask.isPresent()) {
            Itinerary existingItinerary = optionalTask.get();
            existingItinerary.setDestination(updatedItinerary.getDestination());
            existingItinerary.setActivity(updatedItinerary.getActivity());
            // actualizar otros campos según sea necesario
            return itineraryRepository.save(existingItinerary);
        } else {
            return null;
        }
    }


}
