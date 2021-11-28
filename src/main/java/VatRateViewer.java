import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class VatRateViewer {
    public static String countriesByCodesToString(Set<String> codes, Map<String, Country> countries) {
        return codes.stream()
                .map(s -> countryCodeToString(s, countries.get(s)))
                .collect(Collectors.joining(","));
    }

    public static String countryCodeToString(String code, Country country) {
        return country.getCountry()
                + "("
                + code
                + "):"
                + country.getStandardRate();
    }
}
