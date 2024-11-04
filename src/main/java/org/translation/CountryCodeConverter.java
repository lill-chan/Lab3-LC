package org.translation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.util.Map.entry;

/**
 * This class provides the service of converting country codes to their names.
 */
public class CountryCodeConverter {
    // TODO (DONE) Task: pick appropriate instance variable(s) to store the data necessary for this class
    public static final int TWOFIFTY = 250;
    private Map<String, String> countryDictionary = new HashMap(TWOFIFTY);
    private Map<String, String> codeDictionary = new HashMap(TWOFIFTY);

    /**
     * Default constructor which will load the country codes from "country-codes.txt"
     * in the resources folder.
     */
    public CountryCodeConverter() {
        this("country-codes.txt");
    }

    /**
     * Overloaded constructor which allows us to specify the filename to load the country code data from.
     * @param filename the name of the file in the resources folder to load the data from
     * @throws RuntimeException if the resource file can't be loaded properly
     */
    public CountryCodeConverter(String filename) {

        try {
            List<String> lines = Files.readAllLines(Paths.get(getClass()
                    .getClassLoader().getResource(filename).toURI()));
            // TODO (DONE) Task: use lines to populate the instance variable(s)
            for (int i = 1; i != lines.size(); i++) {
                String[] entry = lines.get(i).split("\\t");
                countryDictionary.put(entry[0], entry[2]);
                codeDictionary.put(entry[2], entry[0]);
            }
            // System.out.println(countryDictionary);
        }
        catch (IOException | URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Returns the name of the country for the given country code.
     * @param code the 3-letter code of the country
     * @return the name of the country corresponding to the code
     */
    public String fromCountryCode(String code) {
        // TODO (DONE) Task: update this code to use an instance variable to return the correct value
        Collection<String> set = codeDictionary.keySet();
        for (String entry : set) {
            String value = ((HashMap) codeDictionary).get(entry).toString();
            if (entry.equals(code.toUpperCase())) {
                return value;
            }
        }
        return code;
    }

    /**
     * Returns the code of the country for the given country name.
     * @param country the name of the country
     * @return the 3-letter code of the country
     */
    public String fromCountry(String country) {
        // TODO (DONE) Task: update this code to use an instance variable to return the correct value

        for (String entry : countryDictionary.keySet()) {

            if (entry.equals(country)) {
                String value = ((HashMap) countryDictionary).get(entry).toString();
                return value.toLowerCase();
            }
        }
        return null;
    }

    /**
     * Returns how many countries are included in this code converter.
     * @return how many countries are included in this code converter.
     */
    public int getNumCountries() {
        // TODO (DONE) Task: update this code to use an instance variable to return the correct value
        return codeDictionary.size();
    }
}
