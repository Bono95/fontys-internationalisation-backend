package mailclient;

import model.blog.Blog;
import model.user.User;
import repository.user.HibernateUserRepository;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MailClient implements Runnable {

    private Blog blog;
    private HibernateUserRepository userRepo;
    private List<User> admins;

    final static String USERNAME = Settings.USERNAME;
    final static String PASSWORD = Settings.PASSWORD;

    Properties properties;

    public MailClient(Blog blog) {
        properties = new Properties();
        //region properties.put
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        //endregion
        admins = new ArrayList<User>();
        userRepo = new HibernateUserRepository();
        this.blog = blog;
    }

    public void run() {
        List<User> tempUsers = userRepo.getAll();
        for(User u : tempUsers){
            if(u.isModerator()){
                admins.add(u);
            }
        }

        Session session = Session.getInstance(properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });

        try {
            Address[] meel = new Address[admins.size()];
            for(int i = 0; i < admins.size(); i++) {
                meel[i] = new InternetAddress(admins.get(i).getEmail());
            }

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO,
                    meel);
            message.setSubject("Nieuwe Blog: " + blog.getTitle());

            String text = "<h3>Nieuwe blog!</h3>" +
                    "<p>Beste Administrator,</p>" +
                    "<p>Er is een nieuwe blog ingeschoten met de titel: <b>'" + blog.getTitle() +"'</b>. " +
                    "Deze blog kan vanaf nu beoordeeld en geaccepteerd of geannuleerd worden door een administrator.</p>" +
                    "<p>De blog is geschreven door: " + blog.getCreator().getFirstName() + " " + blog.getCreator().getInfix() + " " + blog.getCreator().getLastName() + ".</p>" +
                    "<br/>" +
                    "<h3>Fontys Zien Administratie</h3>";

            message.setContent(text, "text/html");
            Transport.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
}
