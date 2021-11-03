package com.example.locations;


import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")

public class LocationController {

    @Autowired
    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping( "/locations" )
    public List<Location> getAllLocations (){
        return locationService.getLocations();
    }

    //get by id

    @GetMapping("/locations/{id}")

    public Location getLocationById(@PathVariable("id") Long id){
        return locationService.getById(id);
    }

    //post new location

    @PostMapping(value = "/createLocation" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createLocation(@RequestBody Location location){
        locationService.createLocation(location);
    }

    //update location

    @PutMapping(value = "/locations/{id}")
    public void updateLocation (@PathVariable("id") Long id ,@RequestBody Location location) {
        locationService.updateLocation(id , location);
    }

    // delete location

    @DeleteMapping("/locations/{id}")
    public void deleteLocation(@PathVariable("id") Long id ) {
        locationService.deleteLocation(id);
    }



}
