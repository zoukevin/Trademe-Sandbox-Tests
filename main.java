class TradeMeAutomation {
   public static void main(String[] args) {

      UsedCars part1 = new UsedCars();
      Charities part2 = new Charities();

      //The different URLS used in used car listings
      //https://www.tmsandbox.co.nz/motors/used-cars/nissan/auction-2149276142.htm
      //https://www.tmsandbox.co.nz/motors/used-cars/mazda/auction-2149277054.htm
      //https://www.tmsandbox.co.nz/motors/used-cars/ford/auction-2149275115.htm
      
      part1.findCars("https://www.tmsandbox.co.nz/motors/used-cars/mazda/auction-2149277054.htm");
      part2.findCharities();

   }
}

                //URL carURL = new URL("https://api.trademe.co.nz/v1/Search/Motors/Used.xml");
                //BufferedReader in2 = new BufferedReader(
                //new InputStreamReader(carURL.openStream()));
                //String inputLine2;
                //String key = "1D37F9C9D44F0A1F25FC19C5D7BDB191";
                //String secret = "47AB2DCF21BE36807EB08CEE8BE21D2D";
                //String callback = "https://abc.com/callback";
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