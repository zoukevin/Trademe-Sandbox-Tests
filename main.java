import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class TradeMe {
   public static void main(String[] args) {

      //Variables
      boolean numplateFlag = false; 
      boolean kilometresFlag = false; 
      boolean bodyFlag = false;
      boolean seatsFlag = false;
      /* The different URLS used in used car listings
      https://www.tmsandbox.co.nz/motors/used-cars/nissan/auction-2149276142.htm
      https://www.tmsandbox.co.nz/motors/used-cars/mazda/auction-2149277054.htm
      https://www.tmsandbox.co.nz/motors/used-cars/ford/auction-2149275115.htm
      */
      String URL = "https://www.tmsandbox.co.nz/motors/used-cars/nissan/auction-2149276142.htm";

      try {
         
         Document document = Jsoup.connect(URL).get();

         String carName = document.title();
         System.out.println("Car Name: " + carName.replace("| Trade Me", ""));
         System.out.println("------------------------------------------");

         Elements child = document.getElementsByTag("li");
         for (Element item : child) {
            String line = item.text();

            if (line.contains("Number plate")) {
               System.out.println(line.replace("Number plate ", "Number Plate: "));
               numplateFlag = true;
               System.out.println("------------------------------------------");
            } else if ((line.contains("Kilometres"))) {
               System.out.println(line.replace("Kilometres ", "Kilometres: "));
               kilometresFlag = true;
               System.out.println("------------------------------------------");
            } else if ((line.contains("Body"))) {
               System.out.println(line.replace("Body ", "Body: "));
               bodyFlag = true;
               System.out.println("------------------------------------------");
            } else if ((line.contains("Seats"))) {
               System.out.println(line.replace("Seats", "Seats: "));
               seatsFlag = true;
               System.out.println("------------------------------------------");
            } 
         }
         if (numplateFlag == false) {
            System.out.println("The number plate is missing");
         }
         if (kilometresFlag == false) {
            System.out.println("Mileage in kilometres is missing");
         }
         if (bodyFlag == false) {
            System.out.println("The car body specifications are missing");
         }
         if (seatsFlag == false) {
            System.out.println("The number of seats are missing");
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}