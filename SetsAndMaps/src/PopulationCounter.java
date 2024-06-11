import Classes.City;
import com.sun.source.tree.Tree;

import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, TreeSet<City>> countries = new TreeMap<>();

        while(true)
        {
            String [] inputData = sc.nextLine().split("[ |]+");

            switch(inputData.length)
            {
                case 1:
                    switch (inputData[0])
                    {
                        case "report":
                            printCountries(countries);
                            //print report
                            return;
                    }
                default:
                    String countryName = inputData[1];
                    String cityName = inputData[0];
                    int population = Integer.parseInt(inputData[2]);
                    addCity(countries, countryName, cityName, population);
                    //add to hashmap
            }
        }
    }
    //Sofia|S|1000000
    //BG|S|99999
    //TK|K|98
    //PG|h|9999999

    private static void addCity(TreeMap<String, TreeSet<City>> countries, String countryName, String cityName, int population)
    {
        countries.putIfAbsent(countryName, new TreeSet<>());
        if(countries.containsKey(countryName))
        {
            countries.get(countryName).add(new City(cityName, population));
        }
    }

    private static void printCountries(TreeMap<String, TreeSet<City>> countries)
    {
        for(var country : countries.entrySet())
        {
            int totalPopulation = country.getValue().stream().mapToInt(City::getPopulation).sum();
            System.out.println(STR."\{country.getKey()} (total population: \{totalPopulation})");
            for (int i = 0; i < country.getValue().size(); i++) {
                System.out.println(country.getValue().toArray()[i].toString());
            }
        }
    }
}
