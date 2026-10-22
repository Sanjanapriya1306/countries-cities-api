package countryapi.model;

public class City {

    private int id;
    private String name;
    private String state;
    private String country;
    private String population;

    public City(int id,
                String name,
                String state,
                String country,
                String population) {

        this.id = id;
        this.name = name;
        this.state = state;
        this.country = country;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPopulation() {
        return population;
    }
}