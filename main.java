import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.*;
import java.io.*;

import java.util.regex.*; 

class TradeMe {
   public static void main(String[] args) {

      //Variables
      //boolean numplateFlag = false; 
      //boolean kilometresFlag = false; 
      //boolean bodyFlag = false;
      //boolean seatsFlag = false;
      /* The different URLS used in used car listings
      https://www.tmsandbox.co.nz/motors/used-cars/nissan/auction-2149276142.htm
      https://www.tmsandbox.co.nz/motors/used-cars/mazda/auction-2149277054.htm
      https://www.tmsandbox.co.nz/motors/used-cars/ford/auction-2149275115.htm
      */
      //String URL = "https://www.tmsandbox.co.nz/motors/used-cars/nissan/auction-2149276142.htm";

      try {

            URL charityURL = new URL("https://api.trademe.co.nz/v1/Charities.xml");
            BufferedReader in = new BufferedReader(
            new InputStreamReader(charityURL.openStream()));
            String inputLine;
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Retrieved a list of charities and confirmed that St John is in the list");
            System.out.println("------------------------------------------------------------------------\n");


            while ((inputLine = in.readLine()) != null) {
               Document document = Jsoup.parse(inputLine);
               for (Element charity : document.select("charityType")) {
                  String charityName = charity.text();
                  String result = charityName.replaceAll("([a-z])([A-Z])", "$1 $2");
                  if (result.equals("St John")) {
                     System.out.println("------------------------------------------");
                     System.out.println(result);
                     System.out.println("------------------------------------------");
                  } else {
                     System.out.println(result);
                  }
               }
            }

            //URL carURL = new URL("https://api.trademe.co.nz/v1/Search/Motors/Used.xml");
            //BufferedReader in2 = new BufferedReader(
            //new InputStreamReader(carURL.openStream()));
            //String inputLine2;
            //String username = " 4CC345A03859D40609B09B6C51D894CD";
            //String password = "9595D637C6096492718AB19A7D6F25CA";
            //callback = https://www.tmsandbox.co.nz/
            //HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            //String encoded = Base64.getEncoder().encodeToString((username+":"+password).getBytes(StandardCharsets.UTF_8));  //Java 8
            //connection.setRequestProperty("Authorization", "Basic "+encoded);

            //System.out.println("------------------------------------------------------------------------");
            //System.out.println("Retrieved a list of charities and confirmed that St John is in the list");
            //System.out.println("------------------------------------------------------------------------\n");


            //while ((inputLine2 = in2.readLine()) != null) {
               //Document document = Jsoup.parse(inputLine2);
               //System.out.println(inputLine2);
               //for (Element car : document.select("charityType")) {
                  //String usedCarName = car.text();
                  //System.out.println(usedCarName);
                  //String result = charityName.replaceAll("([a-z])([A-Z])", "$1 $2");
                  //if (result.equals("St John")) {
                     //System.out.println("------------------------------------------");
                     //System.out.println(result);
                     //System.out.println("------------------------------------------");
                  //} else {
                     //System.out.println(result);
                  //}
               //}
               

            //}

            in.close();
   


         /*
         Document document = Jsoup.connect(URL).get();

         String carName = document.title();
         System.out.println("Car Name: " + carName.replace("| Trade Me", ""));
         System.out.println("------------------------------------------");

         Elements liElements = document.getElementsByTag("li");
         for (Element item : liElements) {
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
         */
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}