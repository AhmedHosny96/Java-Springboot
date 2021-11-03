package com.example.locations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocationsApplication.class, args);
    }

    private LocationRepository repository;
    CommandLineRunner runner(LocationRepository repository) {
      return args -> {

      };
    }
}
