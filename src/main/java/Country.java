import com.fasterxml.jackson.annotation.JsonProperty;

public record Country(String country, Float standardRate) {
    public Country(
            @JsonProperty("country") String country,
            @JsonProperty("standard_rate") Float standardRate
    ) {
        this.country = country;
        this.standardRate = standardRate;
    }

    public String getCountry() {
        return country;
    }

    public Float getStandardRate() {
        return standardRate;
    }
}
