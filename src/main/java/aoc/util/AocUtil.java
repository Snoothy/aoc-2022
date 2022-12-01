package aoc.util;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class AocUtil {
    private AocUtil() {
        // EMPTY
    }

    public static List<String> readFileToStrings(final String filename) throws Exception {
        Path path = readFile(filename);

        try (final Stream<String> lines = Files.lines(path)) {
            return lines.collect(Collectors.toList());
        }
    }

    public static int[] readFileToIntArray(final String filename) throws Exception {
        Path path = readFile(filename);

        try (final Stream<String> lines = Files.lines(path)) {
            return lines.mapToInt(s -> getInt(s)).toArray();
        }
    }

    private static int getInt(String s){
        if (s == null || "".equals(s)) return -1;

        return Integer.parseInt(s);
    }
    private static Path readFile(String filename) throws FileNotFoundException, URISyntaxException {
        URL url = AocUtil.class.getClassLoader().getResource(filename);
        if (url == null) {
            throw new FileNotFoundException("Unable to locate file: " + filename);
        }
        return Paths.get(url.toURI());
    }
}
