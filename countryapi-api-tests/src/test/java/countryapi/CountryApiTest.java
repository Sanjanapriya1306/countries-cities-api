package countryapi;

import io.qameta.allure.Description;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class CountryApiTest {

    private static final String API_BASE_URL = System.getProperty("api.baseUrl", "http://localhost:8080");

    @Test
    @Description("Verify the API returns the country list with expected IDs and names")
    void getCountriesReturnsCountryList() {
        given()
                .baseUri(API_BASE_URL)
                .filter(new AllureRestAssured())
        .when()
                .get("/countries")
        .then()
                .statusCode(200)
                .body("size()", equalTo(3))
                .body("[0].id", equalTo(1))
                .body("[0].name", equalTo("India"));
    }

    @Test
    @Description("Verify the API returns cities for India")
    void getCitiesReturnsCitiesForCountry() {
        given()
                .baseUri(API_BASE_URL)
                .filter(new AllureRestAssured())
        .when()
                .get("/countries/1/cities")
        .then()
                .statusCode(200)
                .body("size()", equalTo(3))
                .body("[0].name", equalTo("Hyderabad"))
                .body("[0].country", equalTo("India"));
    }

    @Test
    @Description("Verify an unknown country returns an empty city list")
    void getCitiesReturnsEmptyListForUnknownCountry() {
        given()
                .baseUri(API_BASE_URL)
                .filter(new AllureRestAssured())
        .when()
                .get("/countries/999/cities")
        .then()
                .statusCode(200)
                .body("size()", equalTo(0));
    }

    @Test
    @Description("Verify the API returns details for Hyderabad")
    void getCityDetailsReturnsCity() {
        given()
                .baseUri(API_BASE_URL)
                .filter(new AllureRestAssured())
        .when()
                .get("/cities/101")
        .then()
                .statusCode(200)
                .body("id", equalTo(101))
                .body("name", equalTo("Hyderabad"))
                .body("state", equalTo("Telangana"));
    }
}
