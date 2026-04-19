package com.pluralsight;
import java.util.*;
import java.util.Arrays;

public class VehicleApp {

    static Scanner myScanner = new Scanner(System.in);

    //static vehicle array that can be accessed throughout all methods
    static Vehicle[] vehicles = new Vehicle[20];

    public static void main(String[] args) {

        //initialized variable for vehicle counter
        int vehicleCounter = 0;

        //preloading vehicle array with 6 vehicles
        vehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000,13500);
        vehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        vehicles[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        vehicles[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        vehicles[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        //for loop that iterates through the array, checks if the vehicle index isn't null, if not then the counter goes up
        for (int i = 0; i < vehicles.length; i++) {

            if (vehicles[i] != null) {
                vehicleCounter++;
            }
        }
        //Prints out the amount of vehicles we have in inventory
        System.out.println("We have " + vehicleCounter + " vehicles in our inventory.");

        //
        while (true) {
            System.out.println("\nWhat do you want to do?");
            System.out.println(" 1 - List all vehicles");
            System.out.println(" 2 - Search by make/model");
            System.out.println(" 3 - Search by price range");
            System.out.println(" 4 - Search by color");
            System.out.println(" 5 - Add a vehicle");
            System.out.println(" 6 - Quit");
            System.out.println("Enter your command: ");
            int command = myScanner.nextInt();
            myScanner.nextLine();

            switch(command) {
                case 1:
                    listAllVehicles(vehicles, vehicleCounter);
                    break;
                case 2:
                    findVehiclesByPrice();
                    break;
                case 5:
                    addAVehicle(vehicleCounter);
                    break;
                case 6:
                    System.exit(0);
            }
        }

    }
    //method that displays AVAILABLE vehicles in inventory
    public static void listAllVehicles(Vehicle[] vehicles, int vehicleCounter) {

        System.out.println("Here are the vehicles listed below.\n");
        for (int i = 0; i < vehicleCounter; i++) {

            System.out.println(
                    vehicles[i].getVehicleID() + " | " +
                    vehicles[i].getMakeModel() + " | " +
                    vehicles[i].getColor() + " | " +
                    vehicles[i].getOdometerReading() + " miles | $" +
                    vehicles[i].getPrice());
        }
    }

    public static void findVehiclesByPrice() {

    }
    //method for adding a new vehicle
    public static int addAVehicle(int vehicleCounter) {
        System.out.println("Lets add a vehicle!");
        for(int i = 0; i < vehicles.length; i++) {

            //if the index in vehicle array is empty, then it takes in user input for ID, Make/Model, color, mileage, and price.
            //Then inputs those values into vehicle object
            if (vehicles[i] == null) {

                System.out.print("Enter vehicle ID: ");
                long vehicleID = myScanner.nextInt();
                myScanner.nextLine();
                System.out.print("Enter vehicle make/model: ");
                String vehicleMake = myScanner.nextLine();
                System.out.print("Enter vehicle color: ");
                String vehicleColor = myScanner.nextLine();
                System.out.print("Enter mileage: ");
                int vehicleMiles = myScanner.nextInt();
                System.out.print("Enter vehicle price: ");
                double vehiclePrice = myScanner.nextDouble();

                //vehicle array taking in properties of a vehicle
                vehicles[vehicleCounter] = new Vehicle(vehicleID, vehicleMake, vehicleColor, vehicleMiles, vehiclePrice);
            }
        }
        //vehicle counter goes up by one each time you add a vehicle
        return vehicleCounter + 1;
    }
}
