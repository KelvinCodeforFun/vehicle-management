package menu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class SubMenuManagementS1 extends ArrayList<String> {

    public SubMenuManagementS1() {
        super();
    }

    public int getUserChoice() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        for (int i = 0; i < this.size(); i++) {
            System.out.println((5) + "." + this.get(i));
        }
        System.out.println("___________________________");
        do {
            System.out.print("Select 1..3: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 3) {
                    System.out.println("**Select option from 1 to 3");
                }
            } catch (Exception e) {
                System.out.println("**Please input numberic data");
            }
        } while (choice < 1 || choice > 3);
        return choice;
    }
}
