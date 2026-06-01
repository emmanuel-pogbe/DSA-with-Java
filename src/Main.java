public class Main {
    public static String reverseSentence(String sentence) {
        String[] words = sentence.split(" ");


        // reverse list of words
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i].trim());
            reversed.append(" ");

        }
//        return String.join(" ", words);
        return reversed.toString().trim();
    }

    public static void main(String[] args) {
        String sentence = "This is a  test";
        String reversed = reverseSentence(sentence);

        System.err.println(reversed);
    }
}
