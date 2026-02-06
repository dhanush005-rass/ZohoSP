package problem;

class Numberformating {
    public static String formatestr(int num) {
        StringBuilder nstr = new StringBuilder();
        int count = 0;

        while (num > 0) {
            nstr.append((char) ((num % 10) + '0'));
            num /= 10;
            count++;

            if (count == 3 && num > 0) {
                nstr.append(',');
                count = 0;
            }
        }

        return nstr.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(formatestr(123456789)); // Output: 123,456,789
    }
}
