package Classes;

public class City implements Comparable<City> {

    private String name;
    private int population;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return STR."=> \{this.name}: \{this.population}";
    }

    @Override
    public int compareTo(City o) {
        return Integer.compare(o.getPopulation(), this.population);
    }

}
