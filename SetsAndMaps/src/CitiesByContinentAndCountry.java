import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> continents = new LinkedHashMap<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String [] cityDetails = sc.nextLine().split("[, ]+");
            AddContinent(continents, cityDetails[0], cityDetails[1], cityDetails[2]);
        }

        for( var continent : continents.entrySet())
        {
            System.out.println(STR."\{continent.getKey()}: ");
            for( var country : continent.getValue().entrySet())
            {
                System.out.print(STR."    \{country.getKey()} -> ");
                System.out.println(STR."\{String.join(", ", country.getValue())}");
            }
        }
    }

    private static void AddContinent(LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> continents, String continentName, String countryName, String cityName)
    {
        continents.putIfAbsent(continentName, new LinkedHashMap<>());
        if(continents.containsKey(continentName))
        {
            AddCountry(continents.get(continentName), countryName, cityName);
        }
    }

    private static void AddCountry(LinkedHashMap<String, ArrayList<String>> countries, String countryName, String cityName)
    {
        countries.putIfAbsent(countryName, new ArrayList<>());
        if(countries.containsKey(countryName))
        {
            if(!countries.get(countryName).contains(cityName))
            {
                countries.get(countryName).add(cityName);
            }
        }
    }

}
