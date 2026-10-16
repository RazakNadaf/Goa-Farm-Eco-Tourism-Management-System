import java.util.Scanner;

/**
 * Goa Farm &amp; Eco Tourism Management System
 * Author: Razak Nadaf
 * Roll No: 2638
 * Description: Real-life Tourism and Agriculture system demonstrating
 * Single, Multilevel, Multiple, Hierarchical and Hybrid Inheritance.
 */

public class GoaFarmEcoTourism {

    // Single Inheritance
    static class Farmer {
        protected String farmerName;
        protected String village;

        Farmer(String farmerName, String village) {
            this.farmerName = farmerName;
            this.village = village;
        }

        void displayFarmer() {
            System.out.println("Farmer Name : " + farmerName);
            System.out.println("Village     : " + village);
        }
    }

    static class OrganicFarmer extends Farmer {
        private String crop;

        OrganicFarmer(String farmerName, String village, String crop) {
            super(farmerName, village);
            this.crop = crop;
        }

        void displayOrganicFarm() {
            displayFarmer();
            System.out.println("Organic Crop: " + crop);
        }
    }

    // Multilevel Inheritance
    static class TourismService {
        protected String serviceName;
        protected double basePrice;

        TourismService(String serviceName, double basePrice) {
            this.serviceName = serviceName;
            this.basePrice = basePrice;
        }

        void displayService() {
            System.out.println("Service Name: " + serviceName);
            System.out.println("Base Price  : Rs. " + basePrice);
        }
    }

    static class FarmTour extends TourismService {
        protected String farmLocation;

        FarmTour(String serviceName, double basePrice, String farmLocation) {
            super(serviceName, basePrice);
            this.farmLocation = farmLocation;
        }

        void displayFarmTour() {
            displayService();
            System.out.println("Farm Location: " + farmLocation);
        }
    }

    static class RiceFarmTour extends FarmTour {
        private String activity;

        RiceFarmTour(String serviceName, double basePrice,
                String farmLocation, String activity) {
            super(serviceName, basePrice, farmLocation);
            this.activity = activity;
        }

        void displayRiceTour() {
            displayFarmTour();
            System.out.println("Activity     : " + activity);
        }
    }

    // Multiple Inheritance using Interfaces
    interface Accommodation {
        void provideAccommodation();
    }

    interface FarmingActivity {
        void provideFarmingActivity();
    }

    static class FarmStay implements Accommodation, FarmingActivity {
        private String guestName;
        private int nights;
        private double roomPrice = 1800;

        FarmStay(String guestName, int nights) {
            this.guestName = guestName;
            this.nights = nights;
        }

        public void provideAccommodation() {
            System.out.println("Accommodation: Traditional Farm Stay");
        }

        public void provideFarmingActivity() {
            System.out.println("Farming Activity: Paddy Field Experience");
        }

        double calculateCost() {
            return nights * roomPrice;
        }

        void displayBooking() {
            System.out.println("Guest Name   : " + guestName);
            System.out.println("Number of Nights: " + nights);
            System.out.println("Room Price/Night: Rs. " + roomPrice);
            System.out.println("Total Cost      : Rs. " + calculateCost());
        }
    }

    // Hierarchical Inheritance
    static class AgriculturalFarm {
        protected String farmName;
        protected String location;

        AgriculturalFarm(String farmName, String location) {
            this.farmName = farmName;
            this.location = location;
        }

        void displayFarmDetails() {
            System.out.println("Farm Name: " + farmName);
            System.out.println("Location : " + location);
        }
    }

    static class RiceFarm extends AgriculturalFarm {

        RiceFarm(String farmName, String location) {
            super(farmName, location);
        }

        void displayRiceFarm() {
            displayFarmDetails();
            System.out.println("Farm Type: Rice Farm");
            System.out.println("Main Crop: Paddy");
        }
    }

    static class SpiceFarm extends AgriculturalFarm {

        SpiceFarm(String farmName, String location) {
            super(farmName, location);
        }

        void displaySpiceFarm() {
            displayFarmDetails();
            System.out.println("Farm Type: Spice Farm");
            System.out.println("Main Crops: Pepper, Cardamom and Cinnamon");
        }
    }

    // Hybrid Inheritance
    static class EcoTourism {
        protected String destination;

        EcoTourism(String destination) {
            this.destination = destination;
        }

        void displayEcoTourism() {
            System.out.println("Eco Tourism Destination: " + destination);
        }
    }

    static class EcoFarmTour extends EcoTourism
            implements Accommodation, FarmingActivity {

        private int tourists;
        private double tourPrice = 1200;

        EcoFarmTour(String destination, int tourists) {
            super(destination);
            this.tourists = tourists;
        }

        public void provideAccommodation() {
            System.out.println("Accommodation: Eco-Friendly Farm Stay");
        }

        public void provideFarmingActivity() {
            System.out.println("Farming Activity: Organic Farming Experience");
        }

        double calculatePackageCost() {
            return tourists * tourPrice;
        }

        void displayPackage() {
            displayEcoTourism();
            System.out.println("Number of Tourists: " + tourists);
            System.out.println("Package Price/Person: Rs. " + tourPrice);
            System.out.println("Total Package Cost: Rs. " + calculatePackageCost());
        }
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==============================================");
            System.out.println("   GOA FARM & ECO TOURISM MANAGEMENT SYSTEM");
            System.out.println("==============================================");
            System.out.println("1. Organic Farmer - Single Inheritance");
            System.out.println("2. Rice Farm Tour - Multilevel Inheritance");
            System.out.println("3. Farm Stay - Multiple Inheritance");
            System.out.println("4. Agricultural Farms - Hierarchical Inheritance");
            System.out.println("5. Eco Farm Tour - Hybrid Inheritance");
            System.out.println("6. Exit");
            System.out.println("==============================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\n--- Single Inheritance ---");

                    OrganicFarmer farmer = new OrganicFarmer(
                            "Ramesh Naik",
                            "Ponda",
                            "Organic Rice");

                    farmer.displayOrganicFarm();
                    break;

                case 2:
                    System.out.println("\n--- Multilevel Inheritance ---");

                    RiceFarmTour riceTour = new RiceFarmTour(
                            "Goa Rice Farm Tour",
                            1000,
                            "Curtorim",
                            "Paddy Cultivation Experience");

                    riceTour.displayRiceTour();
                    break;

                case 3:
                    System.out.println("\n--- Multiple Inheritance ---");

                    System.out.print("Enter Guest Name: ");
                    String guestName = sc.nextLine();

                    System.out.print("Enter Number of Nights: ");
                    int nights = sc.nextInt();

                    if (nights <= 0) {
                        System.out.println("Number of nights must be greater than 0.");
                        break;
                    }

                    FarmStay stay = new FarmStay(guestName, nights);

                    stay.provideAccommodation();
                    stay.provideFarmingActivity();
                    stay.displayBooking();
                    break;

                case 4:
                    System.out.println("\n--- Hierarchical Inheritance ---");

                    RiceFarm riceFarm = new RiceFarm(
                            "Green Goa Rice Farm",
                            "Chandor");

                    SpiceFarm spiceFarm = new SpiceFarm(
                            "Goa Spice Garden",
                            "Ponda");

                    System.out.println("\nRice Farm Details:");
                    riceFarm.displayRiceFarm();

                    System.out.println("\nSpice Farm Details:");
                    spiceFarm.displaySpiceFarm();
                    break;

                case 5:
                    System.out.println("\n--- Hybrid Inheritance ---");

                    System.out.print("Enter Number of Tourists: ");
                    int tourists = sc.nextInt();

                    if (tourists <= 0) {
                        System.out.println("Number of tourists must be greater than 0.");
                        break;
                    }

                    EcoFarmTour ecoTour = new EcoFarmTour(
                            "Goa Eco Village",
                            tourists);

                    ecoTour.provideAccommodation();
                    ecoTour.provideFarmingActivity();
                    ecoTour.displayPackage();
                    break;

                case 6:
                    System.out.println("\nThank you for using Goa Farm & Eco Tourism Management System!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please enter a number from 1 to 6.");
            }

        } while (choice != 6);

        sc.close();
    }
}