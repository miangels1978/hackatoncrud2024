package com.EcoVoyagers.controller;

import com.EcoVoyagers.model.Itinerary;
import com.EcoVoyagers.service.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ItineraryController {

    @Autowired
    ItineraryService itineraryService;

    @GetMapping(path = "/itineraries")
    public ArrayList<Itinerary> getAllItineraries() {
        return itineraryService.getAllItineraries();
    }

    @PostMapping(path = "/itineraries")
    public Itinerary addItinerary(@RequestBody Itinerary newItinerary) {
        return itineraryService.addItinerary(newItinerary);
    }

    @DeleteMapping(path = "/itineraries/{id}")
    public String deleteItinerary(@PathVariable("id") int id, @RequestBody Itinerary deleteItinerary) {
        boolean isRemoved = itineraryService.deleteItinerary(id, deleteItinerary);
        if (isRemoved) {
            return "Itinerary with identification " + id + " was deleted successfully.";
        } else {
            return "Itinerary with id " + id + " was not found.";
        }
    }

    @PutMapping(path = "/itineraries/{id}")
    public Itinerary updateItinerary(@PathVariable("id") int id, @RequestBody Itinerary updatedItinerary) {
        return itineraryService.updateItinerary(id, updatedItinerary);
    }
}
