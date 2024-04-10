package main;

import entities.Vehicle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import menu.MenuManagementMain;
import menu.SubMenuManagementS1;
import menu.SubMenuManagementS2;
import menu.SubMenuManagementS3;
import vehicle_mng.VehicleManagement;

/**
 *
 * @author DELL
 */
public class AppDemo {
    public static void main(String[] args) {
        String outputFile = "vehicle.dat";
        Scanner sc = new Scanner(System.in);
        MenuManagementMain menuMain = new MenuManagementMain();
        int userChoiceMain, userChoiceSubS1, userChoiceSubS2, userChoiceSubS3;
        List<Vehicle> listOfVehicle = new ArrayList();
        VehicleManagement obj = new VehicleManagement(listOfVehicle);
        obj.loadDataFromFileVehicle(listOfVehicle, outputFile);
        menuMain.add("Add new vehicle");
        menuMain.add("Check exists vehicle");
        menuMain.add("Update vehicle");
        menuMain.add("Delete vehicle");
        menuMain.add("Search vehicle");
        menuMain.add("Display all vehicle");
        menuMain.add("Save data to file");
        menuMain.add("Print vehicle list");
        menuMain.add("Close the application");
        do {
            System.out.println("\nVEHICLE MANAGEMENT");
            userChoiceMain = menuMain.getUserChoice();
            switch (userChoiceMain) {
                case 1:
                    obj.addVehicle();
                    break;
                case 2:
                    obj.checkExistVehicle();
                    break;
                case 3:
                    obj.updateVehicleInfo();
                    break;
                case 4:
                    obj.deleteVehicle();
                    break;
                case 5:
                    SubMenuManagementS1 menuSubS1 = new SubMenuManagementS1();
                    menuSubS1.add("1. Search by Name");
                    menuSubS1.add("2. Search by Id");
                    menuSubS1.add("3. Back to main menu");
                    do {
                        System.out.println("\nSUB MENU");
                        userChoiceSubS1 = menuSubS1.getUserChoice();
                        switch (userChoiceSubS1) {
                            case 1:
                                obj.searchVehicleByName();
                                break;
                            case 2:
                                obj.searchVehicleById();
                                break;
                            default:
                                break;
                        }
                    } while (userChoiceSubS1 > 0 && userChoiceSubS1 < 3);
                    break;
                case 6:
                    SubMenuManagementS2 menuSubS2 = new SubMenuManagementS2();
                    menuSubS2.add("1. Show all");
                    menuSubS2.add("2. Show by price");
                    menuSubS2.add("3. Back to main menu");
                    do {
                        System.out.println("\nSUB MENU");
                        userChoiceSubS2 = menuSubS2.getUserChoice();
                        switch (userChoiceSubS2) {
                            case 1:
                                obj.showAll();
                                break;
                            case 2:
                                obj.showByPrice();
                                break;
                            default:
                                break;
                        }
                    } while (userChoiceSubS2 > 0 && userChoiceSubS2 < 3);
                    break;
                case 7:
                    obj.saveDateToFileVehicle(listOfVehicle, outputFile);
                    break;
                case 8:
                    SubMenuManagementS3 menuSubS3 = new SubMenuManagementS3();
                    menuSubS3.add("1. Print all");
                    menuSubS3.add("2. Print by year");
                    menuSubS3.add("3. Back to main menu");
                    do {
                        System.out.println("\nSUB MENU");
                        userChoiceSubS3 = menuSubS3.getUserChoice();
                        switch (userChoiceSubS3) {
                            case 1:
                                obj.printAll();
                                break;
                            case 2:
                                obj.printByYear();
                                break;
                            default:
                                break;
                        }
                    } while (userChoiceSubS3 > 0 && userChoiceSubS3 < 3);
                    break;
                default:
                    System.out.println("Quitting application!");
                    break;
            }
        } while (userChoiceMain > 0 && userChoiceMain < 9);
    }
}
