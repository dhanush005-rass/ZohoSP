package problem;

class Militarytime {
    public static void convertToMilitary(String time12) {
        // Extract components
        int hr = (time12.charAt(0) - '0') * 10 + (time12.charAt(1) - '0');
        int min = (time12.charAt(3) - '0') * 10 + (time12.charAt(4) - '0');
        int sec = (time12.charAt(6) - '0') * 10 + (time12.charAt(7) - '0');
        String ampm = "" + time12.charAt(8) + time12.charAt(9);

        // Convert hours
        if (ampm.equals("AM")) {
            if (hr == 12) hr = 0; // midnight
        } else { // PM
            if (hr != 12) hr += 12; // afternoon
        }

        // Print in military format with leading zeros
        System.out.printf("%02d:%02d:%02d%n", hr, min, sec);
    }

    public static void main(String[] args) {
        convertToMilitary("07:05:45PM"); // 19:05:45
        convertToMilitary("12:00:00AM"); // 00:00:00
        convertToMilitary("12:45:54PM"); // 12:45:54
    }
}
