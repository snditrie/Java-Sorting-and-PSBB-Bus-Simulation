import java.util.*;

public class SortCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input one line of words(S): ");
        String input = scanner.nextLine().toLowerCase();

        scanner.close();

        Map<Character, Integer> vowelMap = new TreeMap<>();
        Map<Character, Integer> consonantMap = new TreeMap<>();

        // Process input string
        for (char c : input.toCharArray()) {
            if (isVowel(c)) {
                vowelMap.put(c, vowelMap.getOrDefault(c, 0) + 1);
            } else if (c != ' ') {
                consonantMap.put(c, consonantMap.getOrDefault(c, 0) + 1);
            }
        }

        // Build output strings
        String charVowel = buildSortedString(vowelMap);
        String charConsonant = buildSortedString(consonantMap);

        System.out.println("Vowel Characters: ");
        System.out.println(charVowel);

        System.out.println("Consonant Characters: ");
        System.out.println(charConsonant);
    }

    public static String buildSortedString(Map<Character, Integer> map) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char character = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static Boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
