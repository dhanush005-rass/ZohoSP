package place;


public class Security {

    public static int code(String security) {
        boolean up = false, low = false, numer = false;

        for (char ch : security.toCharArray()) {
            if (Character.isUpperCase(ch)) up = true;
            if (Character.isLowerCase(ch)) low = true;
            if (Character.isDigit(ch)) numer = true;
        }
        int missingTypes = 0;
        if (!up) missingTypes++;
        if (!low) missingTypes++;
        if (!numer) missingTypes++;

        int replace = 0;
        for (int i = 2; i < security.length(); i++) {
            if (security.charAt(i) == security.charAt(i - 1) && security.charAt(i) == security.charAt(i - 2)) {
                replace++;
                i += 2;
            }
        }
        int length = security.length();
        int modification = 0;

        if (length < 6) {
            modification = Math.max(6 - length, Math.max(missingTypes, replace));
        } else if (length > 20) {
            int deleteCount = length - 20;
            modification = deleteCount + Math.max(missingTypes, replace);
        } else {
            modification = Math.max(missingTypes, replace);
        }
        if((length<6&&replace>0))
        {
        	return modification+replace;
        }
        if(length>20&&replace>0)
        {
        	return modification-1;
        }
        return modification;
    }

    public static void main(String[] args) {
        //System.out.println(code("e"));
        //System.out.println(code("eE2"));
    	System.out.println(code("JJJJJJ"));
       // System.out.println(code("123456777123456789hhh"));
    }
}
