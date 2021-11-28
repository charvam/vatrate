import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record Rates(Map<String, Country> countries) {
    public Rates(
            @JsonProperty("rates") Map<String, Country> countries
    ) {
        this.countries = countries;
    }

    public Map<String, Country> getCountries() {
        return countries;
    }
}
