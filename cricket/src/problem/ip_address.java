package problem;

class ip_address {

    public static boolean ipv4(String ip) {
        String[] parts = ip.split("\\.");

        // Must have exactly 4 parts
        if (parts.length != 4) {
            return false;
        }

        for (String part : parts) {
            try {
                // Must be a valid integer
                int num = Integer.parseInt(part);

                // Must be in range 0 to 255
                if (num < 0 || num > 255) {
                    return false;
                }

                // No leading zeros (optional strict check)
                if (part.length() > 1 && part.startsWith("0")) {
                    return false;
                }

            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(ipv4("192.168.1.1"));     // true
        System.out.println(ipv4("255.255.255.0"));   // true
        System.out.println(ipv4("256.100.50.25"));   // false
        System.out.println(ipv4("192.168.1"));       // false
        System.out.println(ipv4("abc.def.ghi.jkl")); // false
        System.out.println(ipv4("192.168.01.1"));    // false
    }
}
