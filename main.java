class TradeMeAutomation {
   public static void main(String[] args) {

      UsedCars part1 = new UsedCars();
      Charities part2 = new Charities();
      UsedCarsAPI part3 = new UsedCarsAPI();
      
      part1.searchAllCars();
      part2.findCharities();
      part3.searchCarsAPI();
   }
}