package gr.ntua.ece.softeng.kidspiration;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.print.DocFlavor.URL;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;




public class PdfCreator {


    //to onoma tou tespa
    public void createPdf(String username, String id, ArrayList<Integer> ids, int ticket_cost, String eventName, String date) throws URISyntaxException, DocumentException, MalformedURLException, IOException {

        //to logo ekei pou einia apo8hkeu
        Path path = Paths.get(PdfCreator.class.getResource("/img/logo/logo.png").toURI());

        Document document = new Document();					//ekeipou 8a paei na apo9hkeutei
        FileOutputStream fileOutputStream=new FileOutputStream("src/main/resources/checks/"+id+".pdf",false);
       PdfWriter.getInstance(document, fileOutputStream);

        document.open();									//ARA GRAFW KAI OPOU 8ELW
        Image img = Image.getInstance(path.toAbsolutePath().toString());

        Font font = FontFactory.getFont(FontFactory.COURIER, 15, BaseColor.BLACK);
        String s1 = "Hello "+ username + "! \n\nYour tickets for the event " + eventName + " have id: \n";
        String s2 = "Event Date: " + date + "\nTicket cost: " + ticket_cost +"\n";
        Chunk chunk = new Chunk(s1, font);
        Chunk chunk5 = new Chunk(s2, font);
                //      //  Chunk chunk2 = new Chunk(info, font);

        img.scaleAbsolute(100, 100);
        document.add( (img));
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);

        String message = "";
        for(int i = 0; i < ids.size(); i++){
            message = message + ids.get(i) + "\n";
        }
        Chunk chunk2 = new Chunk(message,font);


        //document.add(chunk2);
        document.add(new Paragraph (chunk));
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(chunk2);
        //img.scaleAbsolute(100, 100);

        //document.add( (img));

        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(chunk5);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
      //  document.add(new Paragraph (chunk2));
        document.close();



    }







    /**

     public static void main(String[] args) throws DocumentException, MalformedURLException, IOException, URISyntaxException {



     //	java.net.URL resource = ClassLoader.getSystemResource("/");

     //katalavainw oti diavazw apo opou 8elw mesa sto recource****
     Path path = Paths.get(PdfCreator.class.getResource("/img/nagiouka.png").toURI());

     Document document = new Document();
     //Edw den h8ele / to path ...panw H8ELE	!!
     PdfWriter.getInstance(document, new FileOutputStream("src/resources/iiTextImageExample.pdf"));
     document.open();									//ARA GRAFW KAI OPOU 8ELW
     Image img = Image.getInstance(path.toAbsolutePath().toString());

     Font font = FontFactory.getFont(FontFactory.COURIER, 20, BaseColor.BLACK);
     Chunk chunk = new Chunk("Kidspiration :Erxomaste ", font);
     Chunk chunk2 = new Chunk("Paok Mounia gamw ton piraia ", font);



     document.add(new Paragraph (chunk));
     document.add(Chunk.NEWLINE);
     document.add(Chunk.NEWLINE);
     document.add(Chunk.NEWLINE);
     document.add(Chunk.NEWLINE);
     document.add(Chunk.NEWLINE);
     document.add(Chunk.NEWLINE);
     img.scaleAbsolute(100, 100);

     document.add( (img));

     document.add(Chunk.NEWLINE);
     document.add(Chunk.NEWLINE);
     document.add(Chunk.NEWLINE);
     document.add(Chunk.NEWLINE);
     document.add(Chunk.NEWLINE);
     document.add(Chunk.NEWLINE);
     document.add(new Paragraph (chunk2));
     document.close();



     }
     **/
}
