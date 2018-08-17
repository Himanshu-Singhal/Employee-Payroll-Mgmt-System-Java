/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.singh.payrolldec;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Abdeali
 */
public class Intern extends Employee{
    
    private  String SchoolName;
    private static  ArrayList<Intern> ListOfIntern = new ArrayList<>();
    public Intern( String name, int age, Vehicle vehicle, String schoolName) {
        super( name, age, vehicle);
        this.SchoolName= schoolName;
    }
    public Intern(){
        
    }
    public void addEmployee(Intern employee){
        try {
            ListOfIntern.add(employee);
            
        } catch (Exception e) {
            System.err.println("Unexpected error occur. Please try again");
        }
        
    }
    @Override
    public void displayAllEmployeeDetails() {
        for (Employee employee : ListOfIntern) {
            System.out.println(employee.printMyData());
            
            if(Objects.isNull(employee.getVehicle())){
                System.err.println("Employee has no Vehicle registered");
            }
            else{
                System.out.println("Employee has a "+employee.getVehicle().getClass().getSimpleName());
                System.out.println(employee.getVehicle().printMyData());
            }                        
        }
    }
    public String getSchoolName(){
        return this.SchoolName;
    }
    
    @Override
    public String printMyData() {
        return super.printMyData()
                +"\nEmployee is Intern. \n" 
                + String.format(" -School Name : %s \n -Earnings : %.2f", 
                                    this.getSchoolName(),  super.calculateEarning());
    }
}
