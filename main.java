import java.util.ArrayList;

class TradeMeAutomation {
   public static void main(String[] args) {

      UsedCars part1 = new UsedCars();
      Charities part2 = new Charities();
      UsedCarsAPI part3 = new UsedCarsAPI();
      
      ArrayList<String> urls = part1.searchAllCars();
      part2.findCharities();
      part3.searchCarsAPI(urls);
   }
}