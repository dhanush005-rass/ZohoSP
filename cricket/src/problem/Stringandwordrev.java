package problem;

class Stringandwordrev {

    // Reverse a single word
    public static String revwd(String str) {
        StringBuilder strn = new StringBuilder(str);
        return strn.reverse().toString();
    }

    // Reverse each word in a sentence
    public static String stwdrev(String sen) {
        String[] words = sen.split("\\s+"); // split by spaces
        StringBuilder resen = new StringBuilder();
        for (String word : words) {
            resen.append(revwd(word)).append(" ");
        }
        return resen.toString().trim(); // remove trailing space
    }

    // For testing
    public static void main(String[] args) {
        String sentence = "Hello world from Java";
        String reversed = stwdrev(sentence);
        System.out.println(reversed);  // Output: "olleH dlrow morf avaJ"
    }
}
