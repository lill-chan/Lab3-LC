package org.translation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO (DONE) Task: modify this class so that it also supports the Spanish language code "es" and
//            one more language code of your choice. Each member of your group should add
//            support for one additional language code on a branch; then push and create a pull request on GitHub.

// Extra Task: if your group has extra time, you can add support for another country code in this class.

/**
 * An implementation of the Translator interface which translates
 * the country code "can" to several languages.
 */
public class InLabByHandTranslator implements Translator {
    /**
     * Returns the language abbreviations for all languages whose translations are
     * available for the given country.
     *
     * @param country the country
     * @return list of language abbreviations which are available for this country
     */
    // TODO (DONE) Checkstyle: Static variable definition in wrong order.
    private static final String CANADA = "can";
    private static Map<String, String> canadaDictionaryNames = new HashMap<>(5);
    private static Map<String, String> canadaLanguageNames = new HashMap<>(5);
    public InLabByHandTranslator() {
        canadaDictionaryNames.put("de", "Kanada");
        canadaDictionaryNames.put("en", "Canada");
        canadaDictionaryNames.put("ko", "캐나다");
        canadaDictionaryNames.put("es", "Canadá");
        canadaDictionaryNames.put("zh", "加拿大");

        canadaLanguageNames.put("zh", "Chinese");
        canadaLanguageNames.put("en", "English");
        canadaLanguageNames.put("de", "German");
        canadaLanguageNames.put("es", "Spanish, Castilian");
        canadaLanguageNames.put("ko", "Korean");
    }

    @Override
    public List<String> getCountryLanguages(String country) {
        // TODO (DONE) Checkstyle: The String "can" appears 4 times in the file.
        if (CANADA.equals(country)) {
            return new ArrayList<>(List.of("de", "en", "zh", "es", "ko"));
        }
        return new ArrayList<>();
    }

    /**
     * Returns the country abbreviations for all countries whose translations are
     * available from this Translator.
     *
     * @return list of country abbreviations for which we have translations available
     */
    @Override
    public List<String> getCountries() {
        return new ArrayList<>(List.of(CANADA));
    }

    /**
     * Returns the name of the country based on the specified country abbreviation and language abbreviation.
     *
     * @param country  the country (code)
     * @param language the language (code)
     * @return the name of the country in the given language or null if no translation is available
     */
    @Override
    public String translate(String country, String language) {
        // TODO (DONE) Checkstyle: Return count is 5 (max allowed for non-void methods/ lambdas is 2).
        // TODO (DONE) Checkstyle: String literal expressions should be on the left side of an equals comparison.

        // List<String> listOfCountryNames = getCountryLanguages(country);

        if (country.equals(CANADA)) {

            for (String code : canadaLanguageNames.keySet()) {
                if (code.equals(language)) {
                    return canadaDictionaryNames.get(code);
                }
            }

        }
        return null;

        //        if ("de".equals(language)) {
        //            return "Kanada";
        //        }
        //        else if ("en".equals(language)) {
        //            return "Canada";
        //        }
        //        else if ("zh".equals(language)) {
        //            return "加拿大";
        //        }
        //        else if ("es".equals(language)) {
        //            return "Canadá";
        //        }
        //        else if ("ko".equals(language)) {
        //            return "캐나다";
        //        }
    }
}
