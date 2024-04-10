package entities;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author DELL
 */
public class Vehicle implements Serializable {
    private String vehicleID;
    private String vehicleName;
    private String vehicleColor;
    private int vehiclePrice;
    private String vehicleBrand;
    private String type;
    private int productYear;

    public Vehicle(String vehicleID, String vehicleName, String vehicleColor, int vehiclePrice, String vehicleBrand, String type, int productYear) {
        this.vehicleID = vehicleID;
        this.vehicleName = vehicleName;
        this.vehicleColor = vehicleColor;
        this.vehiclePrice = vehiclePrice;
        this.vehicleBrand = vehicleBrand;
        this.type = type;
        this.productYear = productYear;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public int getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(int vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getProductYear() {
        return productYear;
    }

    public void setProductYear(int productYear) {
        this.productYear = productYear;
    }
    
    @Override
    public String toString() {
        return String.format("%-14s%-15s%-16s%-16d%-17s%-18s%-13d", this.getVehicleID(), this.getVehicleName(), 
                             this.getVehicleColor(), this.getVehiclePrice(), 
                             this.getVehicleBrand(), this.getType(), this.getProductYear());               
    }

//    @Override
//    public int compareTo(Vehicle o) {
//        return this.getVehicleName().compareTo(o.getVehicleName());
//    }         
}
