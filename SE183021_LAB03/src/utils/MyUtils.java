package utils;

import entities.Vehicle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class MyUtils {

    public static Scanner sc = new Scanner(System.in);

    public static boolean checkStringDuplicated(String newCode, List<Vehicle> procList) {
        return searchId(newCode, procList) != null;
    }

    public static Vehicle searchId(String newString, List<Vehicle> procList) {
        for (int i = 0; i < procList.size(); i++) {
            if (newString.equals(procList.get(i).getVehicleID())) {
                return procList.get(i);
            }
        }
        return null;
    }

    public static ArrayList<Vehicle> searchName(String newString, List<Vehicle> procList) {
        ArrayList<Vehicle> listVec = new ArrayList<>();
        for (int i = 0; i < procList.size(); i++) {
            if (newString.equalsIgnoreCase(procList.get(i).getVehicleName())) {
                listVec.add(procList.get(i));
            }
        }
        if (listVec.isEmpty()) {
            return null;
        } else {
            return listVec;
        }
    }

    public static String checkStringPattern2(String welcome, String pattern, List<Vehicle> procList, String tmp) {
        String data = "";
        boolean check = true;
        do {
            System.out.print(welcome);
            data = sc.nextLine().trim();
            if (data.isEmpty()) {
                System.out.println(pattern);
            } else if (checkStringDuplicated(data, procList)) {
                System.out.println(tmp + " cannot be duplicated");
            } else {
                check = false;
            }
        } while (check);
        return data;
    }

    public static String inputNonBlankString(String msg, String text) {
        String data;
        boolean check = true;
        do {
            System.out.print(msg);
            data = sc.nextLine();
            if (data.isEmpty()) {
                System.out.println("The " + text + " cannot be empty");
            } else {
                check = false;
            }
        } while (check);
        return data;
    }

    public static int inputInt(String msg, String tmp) {
        boolean check = true;
        int data = 0;
        do {
            try {
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine());
                if (data < 0) {
                    System.out.println("The " + tmp + " must be greater than 0");
                } else {
                    check = false;
                }
            } catch (NumberFormatException e) {

                System.out.println("Please input an integer!");
                check = true;
            }
        } while (check);
        return data;
    }

    public static int inputInt2(String msg, String tmp, int old) {
        boolean check = true;
        int data = 0;
        do {
            try {
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine());
                if (data < 0) {
                    System.out.println("The " + tmp + " must be greater than 0");
                } else {
                    check = false;
                }
            } catch (NumberFormatException e) {
                String s;
                s = data + "";
                if (!s.equals("")) {
                    return old;
                }
                System.out.println("Please input an integer!");
                check = true;
            }
        } while (check);
        return data;
    }

    public static int inputInteger(String msg, int old, String tmp) {
        String data;
        boolean check = false;
        do {
            System.out.print(msg);
            data = sc.nextLine();
            if (data.matches("\\d+")) {
                int a = Integer.parseInt(data);
                return a;
            } else if (data.equals("")) {
                return old;
            } else {
                System.out.println("Please input an integer!");
                check = true;
            }
        } while (check);
        return 0;
    }

    public static String inputString(String msg) {
        System.out.print(msg);
        String data = sc.nextLine().trim();
        return data;
    }

    //sort descending order
    public static void sortAscendingOrder(List<Vehicle> list) {
        Comparator<Vehicle> c = new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle obj1, Vehicle obj2) {
                //return Double.compare(obj1.getInventory_Number(), obj2.getInventory_Number());
                return obj2.getVehiclePrice() - obj1.getVehiclePrice();
            }
        };
        Collections.sort(list, c);
    }

    public static String receiveUserChoice(String welcome) {
        boolean check;
        String data;
        do {
            System.out.println(welcome);
            data = sc.nextLine();
            if (data.equals("Y")) {
                System.out.println("Confirmed");
                check = false;
            } else if (data.equals("N")) {
                System.out.println("Confirmed");
                check = false;
            } else {
                System.out.println("Please choose only " + "Y" + " or " + "N");
                check = true;
            }
        } while (check);
        return data;
    }

    public static boolean checkYesOrNo(String msg) {
        String data;
        while (true) {
            System.out.println(msg);
            data = sc.nextLine();
            if (data.equalsIgnoreCase("Y")) {
                return true;
            } else if (data.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Must input Y or N to select option");
                continue;
            }
        }
    }

}
