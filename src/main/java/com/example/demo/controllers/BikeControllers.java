package com.example.demo.controllers;


import com.example.demo.models.Bike;
import com.example.demo.repositories.BikeRepositories;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bike")
public class BikeControllers {

    @Autowired
    private BikeRepositories bikeRepository;

    @GetMapping
    public List<Bike> list() {
        return bikeRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Bike get(@PathVariable Long id) {
        return bikeRepository.getOne(id);
    }

    @PostMapping
    public Bike create(@RequestBody final Bike bike){
        return bikeRepository.saveAndFlush(bike);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable  Long id) {
        bikeRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Bike update(@PathVariable Long id, @RequestBody Bike bike){
        Bike existingBike = bikeRepository.getOne(id);
        BeanUtils.copyProperties(bike,existingBike, "bike_id");
        return bikeRepository.saveAndFlush(existingBike);
    }
}
