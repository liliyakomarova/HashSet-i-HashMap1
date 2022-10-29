import java.util.HashMap;
import java.util.Map;

public class Main {
    protected static String text = "Lorem ipsum dolor sit amet, consectetur " +
            "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore " +
            "magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
            "laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in " +
            "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
            "mollit anim id est laborum.";

    public static void main(String[] args) {
        char[] kitSymbols = text.toCharArray();

        Map<Character, Integer> symbols = new HashMap<>();
        for (int i = 0; i < kitSymbols.length; i++) {
            if (!symbols.containsKey(text.charAt(i)) && Character.isLetter(text.charAt(i))) {
                symbols.put(text.charAt(i), 1);
            } else {
                if (symbols.containsKey(text.charAt(i))) {
                    symbols.put(text.charAt(i), symbols.get(text.charAt(i)) + 1);
                }
            }
        }

        for (Map.Entry<Character, Integer> currentSymbols : symbols.entrySet()) {
            System.out.println(currentSymbols.getKey() + " - " + currentSymbols.getValue());
        }

        Map.Entry<Character, Integer> maxSymbols = getMaxSymbol(symbols);
        Map.Entry<Character, Integer> minSymbols = getMinSymbol(symbols);

        System.out.println("Больше всего в тексте встречается буква: " + maxSymbols.getKey());
        System.out.println("Меньше всего в тексте встречается буква: " + minSymbols.getKey());
    }

    protected static Map.Entry<Character, Integer> getMaxSymbol(Map<Character, Integer> symbols) {
        int maxCount = -1;
        Map.Entry<Character, Integer> rezultEntry = null;

        for (Map.Entry<Character, Integer> currentEntry : symbols.entrySet()) {
            if (currentEntry.getValue() > maxCount) {
                rezultEntry = currentEntry;
                maxCount = currentEntry.getValue();
            }
        }
        return rezultEntry;
    }
    protected static Map.Entry<Character, Integer> getMinSymbol(Map<Character, Integer> symbols) {
        int minCount = Integer.MAX_VALUE;
        Map.Entry<Character, Integer> rezultEntry = null;

        for (Map.Entry<Character, Integer> currentEntry : symbols.entrySet()) {
            if (currentEntry.getValue() < minCount) {
                rezultEntry = currentEntry;
                minCount = currentEntry.getValue();
            }
        }
        return rezultEntry;
    }
}