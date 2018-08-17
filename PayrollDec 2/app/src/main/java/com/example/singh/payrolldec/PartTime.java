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
public class PartTime extends Employee{
 
    private  int HourlyRate;
    private  int NoOfHoursWorked;
    private static  ArrayList<PartTime> ListOfPartTime = new ArrayList<>();
    
    public  PartTime(){
        
    }
    public int getHourlyRate(){
        return this.HourlyRate;
    }
    public int getNoOfHoursWorked(){
        return this.NoOfHoursWorked;
    }
    
    public PartTime ( String employeeName, int age, Vehicle employeeVehicle, int hourlyRate, int noOfHoursWorked){
        super( employeeName, age, employeeVehicle);
        this.HourlyRate = hourlyRate;
        this.NoOfHoursWorked = noOfHoursWorked;
    }
    
    public void addEmployee(PartTime employee){
        try {
            ListOfPartTime.add(employee);
            
        } catch (Exception e) {
            System.err.println("Unexpected error occur. Please try again");
        }
        
    }
    @Override
    public void displayAllEmployeeDetails() {
        for (Employee employee : ListOfPartTime) {
             
            
        }
    }

    @Override
    public double calculateEarning() {
        return this.HourlyRate*this.NoOfHoursWorked; 
    }
    
    @Override
    public String displayEmployeeDetails(Employee employee){
        System.out.println("======================Part Time Employee Details======================");
        String temp = employee.printMyData();

        System.out.println(employee.printMyData());
            if(Objects.isNull(employee.getVehicle())){
                System.err.println("Employee has no Vehicle registered");
            }
            else{
                System.out.println("Employee has a "+employee.getVehicle().getClass().getSimpleName());
                System.out.println(employee.getVehicle().printMyData());
                temp =" "+employee.printMyData()+ "\nEmployee has a "+employee.getVehicle().getClass().getSimpleName()+" \n"+employee.getVehicle().printMyData();

            }
            return temp;
    }


}
