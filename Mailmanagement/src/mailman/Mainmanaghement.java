package mailman;
import java.util.*;

class Mainmanaghement {

    static Map<String, Mail> mails = new HashMap<>();
    static List<String> tags = new ArrayList<>();
    private Scanner s = new Scanner(System.in);

    public void addmail(String sender, String reciver, String subject, String content) {
        Mail newmail = new Mail(sender, reciver, subject, content);
        mails.put(sender, newmail);
        System.out.println("Mail Added Successfully");
    }

    public void removemail(String sender) {
        if (mails.containsKey(sender)) {
            mails.remove(sender);
            System.out.println("Mail Removed Successfully");
        } else {
            System.out.println("The Sender Does Not Exist!");
        }
    }

    public void addtag(String sender, String Tag) {
        if (mails.containsKey(sender)) {
            Mail mail = mails.get(sender);
            mail.addtag(Tag);
            mails.put(sender, mail);
            tags.add(Tag);
            System.out.println("The Tag Added Successfully");
        } else {
            System.out.println("The Sender Does Not Exist!");
        }
    }

    public void stats() {
        System.out.println("There Are Total " + mails.size() + " Mails");
        System.out.println("The List Of Tags Are: ");
        for (String tag : tags) {
            System.out.println(tag + " ");
        }
        System.out.println("Enter the Number of Recent Mails You Want: ");
        int n = s.nextInt();
        int ct = 0;
        for (Mail mail : mails.values()) {
            if (ct < n) {
                System.out.println(mail.toString());
                System.out.println("________________________");
                ct++;
            }
        }
    }

    public void search(String query) {
        System.out.println("Search Results: ");
        for (Mail mail : mails.values()) {
            String str = mail.toString();
            if (str.contains(query)) {
                System.out.println(mail.toString());
            }
        }
    }
}
