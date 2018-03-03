package gr.ntua.ece.softeng.kidspiration;







import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;











public class SendEmail {







//public	final String username = "kidspiration.ath@gmail.com";
//public	final String password = "stack-over-flowers";



        public void sendEmail(String something,String EmailTo) {


            String username = "kidspiration.ath@gmail.com";
            String password = "stack-over-flowers";

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("kidspiration.ath@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(EmailTo));
                //InternetAddress.parse("giannis.plakas@yahoo.gr"));
                message.setSubject("Kidspiration:Επαναφορα κωδικου");
                //message.setText("Dear Mail Crawler,"
                //	+ "\n\n No spam to my email, please!");


                message.setContent("<h1>Hello</h1>"
                        + ""
                        + ""
                        + (" <a href=https://www.w3schools.com/?ID="+something+">Password reset</a>" ), "text/html");

                Transport.send(message);

                System.out.println("Done");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }



        public void sendCheckEmail(String EmailTo) {


            String username = "kidspiration.ath@gmail.com";
            String password = "stack-over-flowers";

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("kidspiration.ath@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(EmailTo));
                //InternetAddress.parse("giannis.plakas@yahoo.gr"));
                message.setSubject("Kidspiration:Αποδειξη");
                //message.setText("Dear Mail Crawler,"
                //	+ "\n\n No spam to my email, please!");


                //	message.setContent("<h1>Hello</h1>"
                //			+ ""
                //		+ ""
                //			+ (" <a href=https://www.w3schools.com/?ID="+something+">Password reset</a>" ), "text/html");

                MimeBodyPart messageBodyPart = new MimeBodyPart();

                Multipart multipart = new MimeMultipart();

                messageBodyPart = new MimeBodyPart();
                String dir = System.getProperty("user.dir");
                // new File(dir + "/src/resources/psp.png")
                String file = dir + "/src/resources/iiTextImageExample.pdf";
                String fileName = "Kisdpiration.pdf";
                DataSource source = new FileDataSource(file);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(fileName);
                multipart.addBodyPart(messageBodyPart);

                message.setContent(multipart);



                Transport.send(message);

                System.out.println("Done");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }


//KSEXWRISH KLASH
/**

        public String randomgeneratedstring() {

            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();
            StringBuilder buffer = new StringBuilder(targetStringLength);
            for (int i = 0; i < targetStringLength; i++) {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            String generatedString = buffer.toString();

            // System.out.println(generatedString);
            return generatedString;
        }
**/

        //main gia na vlepeis pws douleui
        /**
        public static void main(String[] args) throws UnsupportedEncodingException {

            SendEmail emailer = new SendEmail();
            String something =emailer.randomgeneratedstring();
            emailer.sendEmail(something,"giannis.plakas@yahoo.gr");
            emailer.sendCheckEmail("giannis.plakas@yahoo.gr");



        }
         **/
    }



