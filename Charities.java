import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.net.*;
import java.io.*;

public class Charities {
   public static void findCharities() {
      try {
         URL charityURL = new URL("https://api.trademe.co.nz/v1/Charities.xml");
         boolean flag = false;
         BufferedReader in = new BufferedReader(new InputStreamReader(charityURL.openStream()));
         String inputLine;
         
         System.out.println("------------------------------------------------------------------------");
         System.out.println("Retrieved a list of charities and confirmed that St John is in the list");
         System.out.println("------------------------------------------------------------------------\n");

         //Print all charities
         while ((inputLine = in.readLine()) != null) {
            Document document = Jsoup.parse(inputLine);
            for (Element charity : document.select("charityType")) {
               String charityName = charity.text();
               String result = charityName.replaceAll("([a-z])([A-Z])", "$1 $2");
               if (result.equals("St John")) {
                  flag = true;
                  System.out.println("------------------------------------------");
                  System.out.println(result);
                  System.out.println("------------------------------------------");
               } else {
                  System.out.println(result);
               }
            }
         }
         if (flag == false) {
            System.out.println("St John was not listed in the available charities");
         }
         
         System.out.println("\n");
         in.close();

      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}