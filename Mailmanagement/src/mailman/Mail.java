package mailman;

class Mail {

    private String sender;
    private String reciver;
    private String subject;
    private String content;
    private String tag;
    private boolean spam;

    public Mail(String sender, String reciver, String subject, String content) {
        this.sender = sender;
        this.reciver = reciver;
        this.subject = subject;
        this.content = content;
        this.tag = "No Tag";
        this.spam = false;
    }

    public String toString() {
        return "Sender      : " + sender +
                "\nReceiver : " + reciver +
                "\nSubject  : " + subject +
                "\nContent  : " + content +
                "\nTag      : " + tag+
                "\nSpam     : " + spam;
    }

    public void addtag(String tag) {
        this.tag = tag;
    }

    public void addspam(boolean spam) {
        this.spam = spam;
    }
}
