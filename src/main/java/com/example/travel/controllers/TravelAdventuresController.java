package com.example.travel.controllers;

import com.example.travel.entities.Adventure;
import com.example.travel.repositories.AdventureRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(path = "/travelAdventures")
public class TravelAdventuresController {
    private final AdventureRepository adventureRepository;
    public TravelAdventuresController(AdventureRepository adventureRepo){
        this.adventureRepository = adventureRepo;
    }

    @GetMapping
    public Iterable<Adventure> getAdventures() {
        return adventureRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Adventure> getById(@PathVariable Integer id) {
        return this.adventureRepository.findById(id);
    }

    @GetMapping(path = "/byCountry/{country}")
    public Iterable<Adventure> getAdventuresByCountry(@PathVariable String country) {
        return adventureRepository.findByCountry(country);
    }

    @GetMapping(path = "/byState")
    public Iterable<Adventure> getAdventuresByState(@RequestParam String state) {
        return adventureRepository.findByState(state);
    }

    @PostMapping
    public void addAdventure(@RequestBody Adventure adventure) {
        this.adventureRepository.save(adventure);
    }

    @PutMapping(path = "/{id}")
    public Optional<Adventure> updateAdventure(@PathVariable Integer id, @RequestBody Adventure adventure ) {
        Optional<Adventure> updateAdventure = this.adventureRepository.findById(id);
        if(updateAdventure.isPresent()){
            updateAdventure.get().setBlogCompleted(adventure.getBlogCompleted());
            this.adventureRepository.save(updateAdventure.get());
            return updateAdventure;
        }else {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAdventure(@PathVariable Integer id) {
        this.adventureRepository.deleteById(id);
    }

}
