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
public class Vehicle implements IVehicle{

    private  String Make;
    private  String Model;
    static   ArrayList<Vehicle> ListOfVehicle = new ArrayList<>();
    public  Vehicle(){      
    }
    
    public Vehicle( String make, String model) {
        this.Model = model;
        this.Make = make;
    }
    

    public void  setMake(String make ){
        this.Make = make;
    }
    
    public void setModel(String model){
       this.Model = model;
    }
    

    public String getMake(){
       return this.Make;
    }
    
    public String getModel(){
       return this.Model;
    }
    

//    @Override
//    public ArrayList<Vehicle> getAllVehicleDetails() {
//        //ArrayList<Vehicle> listOfVehicle = new ArrayList<>();
//        
//        return listOfVehicle;
//    }
    public void addVehicle(Vehicle vehicle){
        try {
            ListOfVehicle.add(vehicle);
            
        } catch (Exception e) {
            System.err.println("Unexpected error occur. Please try again");
        }
        
    }
    @Override
    public String printMyData() {

        return String.format(" Make = %s Model = %s",  this.getMake(), this.getModel());
    }
    
    @Override
    public void displayAllVehicleDetails(){
        if(!ListOfVehicle.isEmpty()){
       ListOfVehicle.forEach(vehicle -> {
            displayVehicleDetails(vehicle);

        });
        }
        else{
            System.err.println("No Data for Vehicles super");
        }
    }
    
    public String displayVehicleDetails(Vehicle vehicle)
    {
                System.out.println(vehicle.printMyData());
        return vehicle.printMyData();
    }
} 
