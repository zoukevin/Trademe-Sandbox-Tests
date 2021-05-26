import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;

public class UsedCars {

    public static void findCars(String URL) {
        // Variables
        boolean numplateFlag = false;
        boolean kilometresFlag = false;
        boolean bodyFlag = false;
        boolean seatsFlag = false;

        try {

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
            System.out.println("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchAllCars() {
        ArrayList<String> urlList = new ArrayList<String>();
        String preURL = "https://www.tmsandbox.co.nz/motors";

        try {

            Document document = Jsoup.connect("https://www.tmsandbox.co.nz/motors/used-cars").get();
            Elements carList = document.getElementsByClass("tmm-search-card-list-view__link");

            System.out.println("------------------------------------------------------------------------");
            System.out.println("Query used cars and confirmed that four different details are shown");
            System.out.println("------------------------------------------------------------------------\n");

            for (Element postURL : carList) {
                String URL = preURL + postURL.attr("href");
                if (!urlList.contains(URL)) {
                    urlList.add(URL);
                }
            }
            for (int i = 0; i < urlList.size(); i++) { 
                findCars(urlList.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}