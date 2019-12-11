import com.github.javafaker.Faker;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CreateBancCard {
    public static  Faker faker = new Faker();
    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();

    public static String stringFormatter(int stringMaxLength, String stringToFormat) {
        int stringToFormatLength = stringToFormat.length();
        int stringLength = stringMaxLength - stringToFormatLength;
        StringBuilder stringSpaces = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            stringSpaces.append(" ");
        }
        return stringToFormat+stringSpaces;
    }

    public static void createCard() {
        List<String> lines = Arrays.asList(stringFormatter(18, lastName), stringFormatter(12, firstName));
        Path file = Paths.get("file1.txt");
        try {
            Files.write(file, Collections.singleton(String.join("", lines)), StandardCharsets.UTF_8);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public static void main(String[] args) {
        createCard();
    }
}