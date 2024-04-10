package vehicle_mng;

import entities.Vehicle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import utils.FileManagement;
import utils.MyUtils;

/**
 *
 * @author DELL
 */
public class VehicleManagement {

    List<Vehicle> listOfVehicle = new ArrayList();
    Scanner sc = new Scanner(System.in);

    public VehicleManagement(List<Vehicle> vehicleL) {
        listOfVehicle = vehicleL;
    }

    public void addVehicle() {
        while (true) {
            String newVehicleID, newVehicleName, newVehicleColor, newVehicleBrand, newVehicleType;
            int newVehiclePrice, newProductYear;
            System.out.println("Enter new vehicle details:");
            newVehicleID = MyUtils.checkStringPattern2("Input vehicle ID: ", "ID cannot be empty", listOfVehicle, "vehicle ID");
            newVehicleName = MyUtils.inputNonBlankString("Input the vehicle's name: ", "vehicle name");
            newVehicleColor = MyUtils.inputNonBlankString("Input the vehicle's color: ", "vehicle color");
            newVehiclePrice = MyUtils.inputInt("Input the price of the vehicle: ", "price");
            newVehicleBrand = MyUtils.inputNonBlankString("Input the brand of the vehicle: ", "vehicle brand");
            newVehicleType = MyUtils.inputNonBlankString("Input the type of the vehicle: ", "vehicle type");
            newProductYear = MyUtils.inputInt("Input the product year: ", "product year");
            Vehicle obj = new Vehicle(newVehicleID, newVehicleName, newVehicleColor, newVehiclePrice, newVehicleBrand, newVehicleType, newProductYear);
            listOfVehicle.add(obj);
            System.out.println("Add vehicle " + newVehicleID + " successfully");
            if (MyUtils.checkYesOrNo("Continue to add a new product (Y/N)?: ")) {
                continue;
            }
            break;
        }
    }

    public void checkExistVehicle() {
        if (listOfVehicle.isEmpty()) {
            System.out.println("Empty list! No vehicle searching can be performed");
        } else {
            String codeTmp = MyUtils.inputString("Input the ID of vehicle to check: ");
            Vehicle proc = MyUtils.searchId(codeTmp, listOfVehicle);
            if (proc == null) {
                System.out.println("No Vehicle found");
            } else {
                System.out.println("Existed Vehicle");
            }
        }
    }

    public void updateVehicleInfo() {
        boolean check = false;
        if (listOfVehicle.isEmpty()) {
            System.out.println("Empty list! No update can be performed");
        } else {
            String codeTmp = MyUtils.inputString("Input the code of vehicle to update: ");
            Vehicle proc = MyUtils.searchId(codeTmp, listOfVehicle);
            if (proc == null) {
                System.out.println("Vehicle does not exist");
            } else {
                System.out.println("Found it!");
                String newName, newColor, newBrand, newType;
                int newPrice = 0, newProductYear = 0;
                System.out.println("Input new information of the vehicle " + codeTmp + ":");
                System.out.println("Old name of the vehicle: " + proc.getVehicleName());
                newName = MyUtils.inputString("Input new name of the vehicle: ");
                if (newName.length() > 0) {
                    proc.setVehicleName(newName);
                }
                System.out.println("Old color of the vehicle: " + proc.getVehicleColor());
                newColor = MyUtils.inputString("Input new color of the vehicle: ");
                if (newColor.length() > 0) {
                    proc.setVehicleColor(newColor);
                }
                System.out.println("Old price of the vehicle: " + proc.getVehiclePrice());           
                newPrice = MyUtils.inputInteger("Input new price of the vehicle: ", proc.getVehiclePrice(), "the price");
                if (newPrice > 0) {
                    proc.setVehiclePrice(newPrice);
                }
                System.out.println("Old brand of the vehicle: " + proc.getVehicleBrand());
                newBrand = MyUtils.inputString("Input new brand of the vehicle: ");
                if (newBrand.length() > 0) {
                    proc.setVehicleBrand(newBrand);
                }
                System.out.println("Old type of the vehicle: " + proc.getType());
                newType = MyUtils.inputString("Input new type of the vehicle: ");
                if (newType.length() > 0) {
                    proc.setType(newType);
                }
                System.out.println("Old product year of the vehicle: " + proc.getProductYear());
                newProductYear = MyUtils.inputInteger("Input new product year of the vehicle: ", proc.getProductYear(), "the product year");
                if (newProductYear > 0) {
                    proc.setProductYear(newProductYear);
                }
                System.out.println("\nThe result after updated:");
                Vehicle obj = new Vehicle(codeTmp, proc.getVehicleName(), proc.getVehicleColor(),
                        proc.getVehiclePrice(), proc.getVehicleBrand(), proc.getType(), proc.getProductYear());
                System.out.printf("%10s%16s%16s%16s%16s%16s%26s\n", "Vehicle ID", "Vehicle name", "Vehicle color",
                        "Vehicle Price", "Vehicle brand", "Vehicle type", "Vehicle product year");
                System.out.println(obj);
            }

        }
    }

    public void deleteVehicle() {
        if (listOfVehicle.isEmpty()) {
            System.out.println("Fail");
            System.out.println("The vehicle list is empty");
        } else {
            String codeTmp = MyUtils.inputString("Input the id of vehicle to delete: ");
            Vehicle vec = MyUtils.searchId(codeTmp, listOfVehicle);
            if (vec == null) {
                System.out.println("Invalid vehicle id");
            } else {
                System.out.printf("%10s%16s%16s%16s%16s%16s%26s\n", "Vehicle ID", "Vehicle name", "Vehicle color",
                        "Vehicle Price", "Vehicle brand", "Vehicle type", "Vehicle product year");
                System.out.println(vec);
                if (MyUtils.receiveUserChoice("Do you want to delete this vehicle(Y/N)?: ").equals("Y")) {
                    listOfVehicle.remove(vec);
                    System.out.println("Success!");
                    System.out.println("The vehicle " + vec.getVehicleID() + " has been deleted");
                }
            }
        }
    }

    public void searchVehicleByName() {
        ArrayList<Vehicle> listVec = new ArrayList<>();
        if (listOfVehicle.isEmpty()) {
            System.out.println("The vehicle list is empty");
            System.out.println("No searching by name can be done");
        } else {
            String nameVec = MyUtils.inputString("Input the name of vehicle to search: ");
            listVec = MyUtils.searchName(nameVec, listOfVehicle);
            if (listVec.isEmpty()) {
                System.out.println("The list of vehicle " + nameVec + " cannot be found");
            } else {
                System.out.println("Founded!");
                System.out.println("The list of vehicle with the name " + nameVec);
                Collections.sort(listVec, new SortByName());
                System.out.printf("%10s%16s%16s%16s%16s%16s%26s\n", "Vehicle ID", "Vehicle name", "Vehicle color",
                        "Vehicle Price", "Vehicle brand", "Vehicle type", "Vehicle product year");
                for (Vehicle vehicle : listVec) {
                    System.out.println(vehicle);
                }
            }
        }
    }

    public void searchVehicleById() {
        ArrayList<Vehicle> listVec = new ArrayList<>();
        if (listOfVehicle.isEmpty()) {
            System.out.println("The vehicle list is empty");
            System.out.println("No searching by name can be done");
        } else {
            String idVec = MyUtils.inputString("Input the id of vehicle to search: ");
            Vehicle vec = MyUtils.searchId(idVec, listOfVehicle);
            if (vec == null) {
                System.out.println("Invalid vehicle id");
            } else {
                System.out.println("Founded!");
                System.out.printf("%10s%16s%16s%16s%16s%16s%26s\n", "Vehicle ID", "Vehicle name", "Vehicle color",
                        "Vehicle Price", "Vehicle brand", "Vehicle type", "Vehicle product year");
                System.out.println(vec);
            }
        }
    }

    public void showAll() {
        if (listOfVehicle.isEmpty()) {
            System.out.println("Fail");
            System.out.println("The vehicle list is empty");
            //Show all data into the screen 
        } else {
            System.out.println("The list of vehicle");
            System.out.printf("%10s%16s%16s%16s%16s%16s%26s\n", "Vehicle ID", "Vehicle name", "Vehicle color",
                        "Vehicle Price", "Vehicle brand", "Vehicle type", "Vehicle product year");
            for (Vehicle vehicle : listOfVehicle) {
                System.out.println(vehicle);
            }
        }
    }

    public void showByPrice() {
        ArrayList<Vehicle> vecList = new ArrayList<>();
        int price = MyUtils.inputInt("Input the price: ", "the price");
        for (Vehicle vehicle : listOfVehicle) {
            if (vehicle.getVehiclePrice() < price) {
                vecList.add(vehicle);
            }
        }
        if (vecList.isEmpty()) {
            System.out.println("There are no vehicle that match the condition!");
        } else {
            System.out.println("The list of vehicle having the price lower than " + price);
            Collections.sort(vecList, new SortByPrice());
            System.out.printf("%10s%16s%16s%16s%16s%16s%26s\n", "Vehicle ID", "Vehicle name", "Vehicle color",
                        "Vehicle Price", "Vehicle brand", "Vehicle type", "Vehicle product year");
            for (Vehicle vehicle : vecList) {
                System.out.println(vehicle);
            }
        }
    }

    public boolean loadDataFromFileVehicle(List<Vehicle> vecList, String fileName) {
        FileManagement fm = new FileManagement();
        return fm.loadDataFromFile(vecList, fileName);
    }

    public boolean saveDateToFileVehicle(List<Vehicle> vecList, String fileName) {
        FileManagement fm = new FileManagement();
        return fm.saveDataToFile(vecList, fileName, "Save vehicle to file successfully!!");
    }

    public void printAll() {
        if (listOfVehicle.isEmpty()) {
            System.out.println("Fail");
            System.out.println("The vehicle list is empty");
            //Show all data into the screen 
        } else {
            System.out.println("The list of vehicle");
            System.out.printf("%10s%16s%16s%16s%16s%16s%26s\n", "Vehicle ID", "Vehicle name", "Vehicle color",
                        "Vehicle Price", "Vehicle brand", "Vehicle type", "Vehicle product year");
            for (Vehicle vehicle : listOfVehicle) {
                System.out.println(vehicle);
            }
        }
    }

    public void printByYear() {
        ArrayList<Vehicle> vecList = new ArrayList<>();
        int yearInput = MyUtils.inputInt("Input year: ", "the year");
        for (Vehicle vehicle : listOfVehicle) {
            if (vehicle.getProductYear() >= yearInput) {
                vecList.add(vehicle);
            }
        }
        if (vecList.isEmpty()) {
            System.out.println("There are no vehicle that match the condition!");
        } else {
            System.out.println("The list of vehicle having product year greater than " + yearInput);
            Collections.sort(vecList, new SortByYear());
            System.out.printf("%10s%16s%16s%16s%16s%16s%26s\n", "Vehicle ID", "Vehicle name", "Vehicle color",
                        "Vehicle Price", "Vehicle brand", "Vehicle type", "Vehicle product year");
            for (Vehicle vehicle : vecList) {
                System.out.println(vehicle);
            }
        }
    }
}

class SortByName implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle a, Vehicle b) {
        return b.getVehicleName().compareTo(a.getVehicleName());
    }
}

class SortByPrice implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o2.getVehiclePrice() - o1.getVehiclePrice();
    }
}

class SortByYear implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o2.getProductYear() - o1.getProductYear();
    }
}
