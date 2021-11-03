package com.example.locations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private final LocationRepository locationRepository ;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
    //get all locations
    public List<Location> getLocations () {
        return locationRepository.findAll();
    }
    //get by id
    public Location getById(Long id) {
        return  locationRepository.findById(id).orElse(null);
    }
    // create location
    public void createLocation(Location location){
        Optional<Location> locationByName = locationRepository
                .findLocationByName(location.getName());
        if(locationByName.isPresent()){
            throw new IllegalStateException("Location already exists");
        }
        locationRepository.save(location);
    }
    // delete location
    public void deleteLocation(Long id){
        boolean exists = locationRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Location doesnt exist");
        }
        locationRepository.deleteById(id);
    }
    //update location

    @Transactional
    public void updateLocation(Long id, Location location) {

        // check if location is found

        Location location1 = locationRepository.findById(id)
                .orElseThrow( () -> new IllegalStateException("location not found"));
        // validation
        if(location1 != null){
            location1.setName(location.getName());
            location1.setCode(location.getCode());
            location1.setType(location.getType());

            locationRepository.save(location1);
        }
    }

}
