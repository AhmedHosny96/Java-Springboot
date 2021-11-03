package com.example.locations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location , Long> {

    // custom function to check if location exists

    Optional<Location> findLocationByName (String name);

//    Optional<Location> findLocationById (Long id);
}
