import java.io.IOException;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;


public class UsedCarsAPI {

    public static void searchCarsAPI(ArrayList<String> urlList) {

        boolean titleFlag = false;
        boolean numplateFlag = false;
        boolean kilometresFlag = false;
        boolean bodyFlag = false;
        boolean seatsFlag = false;
        String preURL = "https://api.tmsandbox.co.nz/v1/Listings/";

        System.out.println("------------------------------------------------------------------------");
        System.out.println("Query used cars using APIs and confirm that the four details are shown");
        System.out.println("------------------------------------------------------------------------\n");
            
        try {
            for (int i = 0; i < urlList.size(); i++) {

                //Authenticate
                URL url = new URL(preURL + urlList.get(i) + ".xml");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Authorization", "OAuth oauth_consumer_key=01438AD1DECC4A39111D85ACD983F43F, oauth_token=6F73A60437B45B4FD54E2CB7BCA0AF2D, oauth_signature_method=PLAINTEXT, oauth_signature=32FFBEFA9FD0F88B2214D46A9FEDACB5%269B4EC3519BCDC95BD8A15240CB72B774");

                //Write
                BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) { 

                    Document document = Jsoup.parse(inputLine);

                    if (titleFlag == false) {
                        String carName = document.title();
                        System.out.println("Car Name: " + carName);
                        System.out.println("------------------------------------------");
                        titleFlag = true;
                    }
                    
                    //Prints car details
                    Elements liElements = document.getElementsByTag("DisplayName");
                    for (Element item : liElements) {
                        String line = item.text();
                        
                        if (line.contains("Number plate")) {
                            String value = item.nextElementSibling().text();
                            System.out.println(line + ": " + value);
                            numplateFlag = true;
                            System.out.println("------------------------------------------");
                        } else if ((line.contains("Kilometres"))) {
                            String value = item.nextElementSibling().text();
                            System.out.println(line + ": " + value);
                            kilometresFlag = true;
                            System.out.println("------------------------------------------");
                        } else if ((line.contains("Body"))) {
                            String value = item.nextElementSibling().text();
                            System.out.println(line + ": " + value);
                            bodyFlag = true;
                            System.out.println("------------------------------------------");
                        } else if ((line.contains("Seats"))) {
                            String value = item.nextElementSibling().text();
                            System.out.println(line + ": " + value);
                            seatsFlag = true;
                            System.out.println("------------------------------------------");
                        }
                    }     
                }

                //Prints missing details
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
                System.out.println("\n");

                //Reset Flags
                titleFlag = false;
                numplateFlag = false; 
                kilometresFlag = false;
                bodyFlag = false;
                seatsFlag = false;  
            }
        }
                
                catch (IOException e) {
                e.printStackTrace();
            }
        }
    }