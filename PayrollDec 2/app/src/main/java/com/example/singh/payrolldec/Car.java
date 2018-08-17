/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.singh.payrolldec;

import java.util.ArrayList;

/**
 *
 * @author Abdeali
 */
public class Car extends Vehicle implements IVehicle{
    
    public Car(){
        
    }
    private double cc;
    private String Type; 
    private static ArrayList<Car> ListOfCar = new ArrayList<>();
    public Car( String make , String model, double cc , String type){
        super.setMake(make);
        super.setModel(model);
        this.cc = cc;
        this.Type = type;
    }
    
    public double getCC(){
        return  this.cc;
    }
    
    public String getType(){
        return  this.Type;
    }
    
    
    public void addVehicle(Car car){
        try {
            ListOfCar.add(car);
            
        } catch (Exception e) {
            System.err.println("Unexpected error occur. Please try again");
        }
        
    }
    @Override
    public String printMyData() {
        return String.format("Vehicle Make = %s Model = %s CC = %f Type = %s" ,
                 super.getMake(), super.getModel(),this.getCC(), this.getType());
    }
    
    @Override
    public void displayAllVehicleDetails(){
        if(!ListOfCar.isEmpty()){
       ListOfVehicle.forEach(vehicle -> {
            displayVehicleDetails(vehicle);
            
        });
        }
        else{
            System.err.println("No Data for Vehicles");
        }
    }
    public void displayVehicleDetails(Car car) {
        System.out.println(car.printMyData());
    }
    
}
