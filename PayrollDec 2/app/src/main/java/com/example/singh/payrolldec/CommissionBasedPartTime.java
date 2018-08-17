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
public class CommissionBasedPartTime extends PartTime{
    
    private  double CommissionPercentage;
    private static  ArrayList<CommissionBasedPartTime> ListOfCommissionBasedPartTime = new ArrayList<>();
    
    public CommissionBasedPartTime(){
        
    }
    public CommissionBasedPartTime(double CommissionPercentage,  String employeeName, int age, Vehicle employeeVehicle, int hourlyRate, int noOfHoursWorked) {
        super( employeeName, age, employeeVehicle, hourlyRate, noOfHoursWorked);
        this.CommissionPercentage = CommissionPercentage;
    }
    
    public void addEmployee(CommissionBasedPartTime employee){
        try {
            ListOfCommissionBasedPartTime.add(employee);
            
        } catch (Exception e) {
            System.err.println("Unexpected error occur. Please try again");
        }        
    }
    @Override
    public void displayAllEmployeeDetails() {
        for (Employee employee : ListOfCommissionBasedPartTime) {
            displayEmployeeDetails(employee);
        }
    }
    
    @Override
    public double calculateEarning() {
        return super.calculateEarning() + ((this.CommissionPercentage / 100)*super.calculateEarning());
    }

    @Override
    public String printMyData() {
        return super.printMyData()
                +"\nEmployee is Part Time \\ Commission Based. \n" 
                +String.format(" -Rate : %d \n -Hours Worked : %d \n -Commission Percent : %.2f \n -Earning : %.2f", 
                                    super.getHourlyRate(), this.getNoOfHoursWorked(), this.CommissionPercentage, this.calculateEarning());
    }

    @Override
    public String displayEmployeeDetails(Employee employee){
        System.out.println("======================Commission Base Part Time Employee Details======================");
        String temp = "";
         System.out.println(employee.printMyData());            
            if(Objects.isNull(employee.getVehicle())){
                System.err.println("Employee has no Vehicle registered");
            }
            else{
                System.out.println("Employee has a "+employee.getVehicle().getClass().getSimpleName());
                System.out.println(employee.getVehicle().printMyData());
                temp =" "+employee.printMyData()+ "\nEmployee has a "+employee.getVehicle().getClass().getSimpleName()+" \n"+employee.getVehicle().printMyData();

            }
            return  temp;
    }
    
}
