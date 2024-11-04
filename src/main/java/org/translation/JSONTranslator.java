package org.translation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * An implementation of the Translator interface which reads in the translation
 * data from a JSON file. The data is read in once each time an instance of this class is constructed.
 */
public class JSONTranslator implements Translator {
    // TODO (DONE) Task: pick appropriate instance variables for this class
    private Map<String, JSONObject> countryToLanguages = new HashMap();
    private ArrayList<String> countryCodes = new ArrayList<>();
    private ArrayList<String> languageCodes = new ArrayList<>();
    /**
     * Constructs a JSONTranslator using data from the sample.json resources file.
     */
    public JSONTranslator() {
        this("sample.json");
    }

    /**
     * Constructs a JSONTranslator populated using data from the specified resources file.
     * @param filename the name of the file in resources to load the data from
     * @throws RuntimeException if the resource file can't be loaded properly
     */
    public JSONTranslator(String filename) {
        // read the file to get the data to populate things...
        try {

            String jsonString = Files.readString(Paths.get(getClass().getClassLoader().getResource(filename).toURI()));

            JSONArray jsonArray = new JSONArray(jsonString);
            // TODO (DONE) Task: use the data in the jsonArray to populate your instance variables
            //            Note: this will likely be one of the most substantial pieces of code you write in this lab.

            // populate the languageCodes ArrayList
            JSONObject oneObject = jsonArray.getJSONObject(0);
            Iterator<String> keys = oneObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                if (!"alpha3".equals(key) && !"alpha2".equals(key) && !"id".equals(key)) {
                    languageCodes.add(key);
                }
            }
            // populate countryCodes ArrayList
            for (int i = 0; i != jsonArray.length(); i++) {
                JSONObject objects = jsonArray.getJSONObject(i);
                String code = (String) objects.get("alpha3");
                countryCodes.add(code);
            }
            // populate countryToLanguages dictionary
            for (int i = 0; i != jsonArray.length(); i++) {
                JSONObject objects = jsonArray.getJSONObject(i);
                String code = (String) objects.get("alpha3");
                countryToLanguages.put(code, objects);
            }

        }
        catch (IOException | URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<String> getCountryLanguages(String country) {
        // TODO (DONE) Task: return an appropriate list of language codes,
        //            but make sure there is no aliasing to a mutable object

        return languageCodes;
    }

    @Override
    public List<String> getCountries() {
        // TODO (DONE) Task: return an appropriate list of country codes,
        //            but make sure there is no aliasing to a mutable object
        return countryCodes;
    }

    @Override
    public String translate(String country, String language) {
        // TODO (DONE) Task: complete this method using your instance variables as needed
        JSONObject countryEntry = countryToLanguages.get(country);
        return (String) countryEntry.get(language);
    }
}
