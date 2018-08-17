/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.singh.payrolldec;

import static com.example.singh.payrolldec.Vehicle.ListOfVehicle;
import java.util.ArrayList;

/**
 *
 * @author Abdeali
 */
public class Motorcycle extends Vehicle{
     public Motorcycle(){
        
    }
    private double cc;
    private boolean IsSportBike; 
    private static ArrayList<Motorcycle> ListOfMotorcycle = new ArrayList<>();
    public Motorcycle( String make , String model, double cc , boolean  isSportBike){
        super.setMake(make);
        super.setModel(model);
        this.cc = cc;
        this.IsSportBike = isSportBike;
    }
    
    public double getCC(){
        return  this.cc;
    }
    
    public boolean  getIsSportBike(){
        return  this.IsSportBike;
    }
    
    
    public void addVehicle(Motorcycle car){
        try {
            ListOfMotorcycle.add(car);
            
        } catch (Exception e) {
            System.err.println("Unexpected error occur. Please try again");
        }
        
    }
    @Override
    public String printMyData() {
        return String.format(" Make = %s Model = %s CC = %f Sport Bike = %b" ,
                super.getMake(), super.getModel(),this.getCC(), this.getIsSportBike());
    }
    
    @Override
    public void displayAllVehicleDetails(){
        if(!ListOfMotorcycle.isEmpty()){
       ListOfVehicle.forEach(this::displayVehicleDetails);
        }
        else{
            System.err.println("No Data for Vehicles");
        }
    }
    public void displayVehicleDetails(Motorcycle motorcycle) {
        System.out.println(motorcycle.printMyData());
    }
}
