import si.mazi.rescu.RestProxyFactory;

import java.util.*;
import java.util.stream.Collectors;

public class VatRateController {
    public static final String BASE_URL = "http://5.189.172.205:15500";

    public static void main(String[] args) {
        final VatRateService vatRateService = RestProxyFactory.createProxy(VatRateService.class, BASE_URL);
        final Rates rates = vatRateService.getRates();
        final Map<String, Country> countries = rates.getCountries();

        final Map<Float, Set<String>> sortedCodes = CountrySorter.sortByStandardRate(countries);
        final int size = sortedCodes.entrySet().size();
        findByOrderAndPrint(sortedCodes, countries, 0, "1. country with lowest rate: ");
        findByOrderAndPrint(sortedCodes, countries,1, "2. country with lowest rate: ");
        findByOrderAndPrint(sortedCodes, countries,size - 1, "1. country with highest rate: ");
        findByOrderAndPrint(sortedCodes, countries,size - 2, "2. country with highest rate: ");
    }

    private static void findByOrderAndPrint(
            Map<Float, Set<String>> sortedCodes,
            Map<String, Country> countries,
            int order,
            String message
    ) {
        sortedCodes.entrySet()
                .stream()
                .skip(order)
                .findFirst()
                .ifPresent(e -> System.out.println(message + VatRateViewer.countriesByCodesToString(e.getValue(), countries)));
    }

}
