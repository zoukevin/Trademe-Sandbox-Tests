class TradeMeAutomation {
   public static void main(String[] args) {

      UsedCars part1 = new UsedCars();
      Charities part2 = new Charities();
      UsedCarsAPI part3 = new UsedCarsAPI();

      // The different URLS used in used car listings
      // https://www.tmsandbox.co.nz/motors/used-cars/nissan/auction-2149276142.htm
      // https://www.tmsandbox.co.nz/motors/used-cars/mazda/auction-2149277054.htm
      // https://www.tmsandbox.co.nz/motors/used-cars/ford/auction-2149275115.htm

      //part1.findCars("https://www.tmsandbox.co.nz/motors/used-cars/nissan/auction-2149276142.htm");
      part1.searchAllCars();
      part2.findCharities();
      part3.searchCarsAPI();
   }
}