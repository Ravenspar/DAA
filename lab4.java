public class HorspoolStringMatching {

    private static final int ALPHABET_SIZE = 256;
    public static void main(String[] args) {
    String text = "BESS_KNEW_ABOUT_BAOBABS";
    String pattern = "BAOBAB";
    int index = search(text, pattern);
    if (index != -1) {
    System.out.println("Pattern found at index " + index);
    } else {
    System.out.println("Pattern not found in the text.");
    }
    }
    public static int[] preprocessPattern(String pattern) {
    int[] table = new int[ALPHABET_SIZE];
    int patternLength = pattern.length();
    for (int i = 0; i < ALPHABET_SIZE; i++) {
    table[i] = patternLength;
    }
    for (int i = 0; i < patternLength - 1; i++) {
    char c = pattern.charAt(i);
    table[c] = patternLength - 1 - i;
    }
    return table;
    }
    public static int search(String text, String pattern) {
    int textLength = text.length();
    int patternLength = pattern.length();
    int[] shiftTable = preprocessPattern(pattern);
    int i = patternLength - 1;
    while (i < textLength) {
    int j = patternLength - 1;
    while (j >= 0 && text.charAt(i) == pattern.charAt(j)) {
    i--;
    j--;
    }
    if (j == -1) {
    return i + 1; } else {
        i += Math.max(1, patternLength - 1 - j + shiftTable[text.charAt(i)]);
    }
    }
    return -1;
    }
    }