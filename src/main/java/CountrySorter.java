import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CountrySorter {
    public static Map<Float, Set<String>> sortByStandardRate(final Map<String, Country> countries) {
        final Map<Float, Set<String>> sortedCodes = new TreeMap<>();
        for (Map.Entry<String, Country> entry : countries.entrySet()) {
            final Float standardRate = entry.getValue().getStandardRate();
            final Set<String> codes = sortedCodes.computeIfAbsent(standardRate, f -> new HashSet<>());
            codes.add(entry.getKey());
        }
        return sortedCodes;
    }
}
