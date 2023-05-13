package Ch4Conditionals;

public class StringTest {
    public static void main(String[] args) {
        String line = "AOneTest";
        System.out.println(NewString(line));
    }

    public static boolean isUpperCase(char c) {
        return ( c >= 'A' && c <= 'Z') ;
    }

    public static String NewString(String line) {
        line = line + "_";
        StringBuilder correct = new StringBuilder();
        correct.append(line.charAt(0));
        for (int i = 1; i < line.length() - 1; i++) {
            if (isUpperCase(line.charAt(i)) && isUpperCase(line.charAt(i + 1)) && isUpperCase(line.charAt(i - 1))) {
                correct.append(line.charAt(i));
            } else if (isUpperCase(line.charAt(i))) {
                correct.append("_").append(line.charAt(i));
            } else {
                correct.append(line.charAt(i));
            }
        }
        return correct.toString();
    }
}
