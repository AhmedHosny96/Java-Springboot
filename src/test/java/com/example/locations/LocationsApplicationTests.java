package com.example.locations;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class LocationsApplicationTests {

    @Autowired
    private LocationRepository locationRepository ;
    @Test
    public void createLocation () {
        Location location = new Location();

        location.setName("Addis Abeba");
        location.setCode("AA");
        location.setType("Urban");

        locationRepository.save(location);
    }

}
