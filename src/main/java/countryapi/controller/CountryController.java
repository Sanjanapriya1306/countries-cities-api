package countryapi.controller;

import countryapi.model.City;
import countryapi.model.Country;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/countries")
    public List<Country> getCountries() {

        return List.of(
                new Country(1, "India"),
                new Country(2, "USA"),
                new Country(3, "UK")
        );
    }

    @GetMapping("/countries/{countryId}/cities")
    public List<City> getCities(@PathVariable int countryId) {

        switch (countryId) {

            case 1:
                return List.of(
                        new City(101, "Hyderabad", "Telangana", "India", "10000000"),
                        new City(102, "Mumbai", "Maharashtra", "India", "20000000"),
                        new City(103, "Delhi", "Delhi", "India", "30000000")
                );

            case 2:
                return List.of(
                        new City(201, "New York", "New York", "USA", "8000000"),
                        new City(202, "Chicago", "Illinois", "USA", "2700000"),
                        new City(203, "Dallas", "Texas", "USA", "1300000")
                );

            case 3:
                return List.of(
                        new City(301, "London", "England", "UK", "9000000"),
                        new City(302, "Manchester", "England", "UK", "550000"),
                        new City(303, "Liverpool", "England", "UK", "500000")
                );

            default:
                return List.of();
        }
    }

    @GetMapping("/cities/{cityId}")
    public City getCityDetails(@PathVariable int cityId) {

        switch (cityId) {

            case 101:
                return new City(
                        101,
                        "Hyderabad",
                        "Telangana",
                        "India",
                        "10000000"
                );

            case 102:
                return new City(
                        102,
                        "Mumbai",
                        "Maharashtra",
                        "India",
                        "20000000"
                );

            case 103:
                return new City(
                        103,
                        "Delhi",
                        "Delhi",
                        "India",
                        "30000000"
                );

            default:
                return null;
        }
    }
}