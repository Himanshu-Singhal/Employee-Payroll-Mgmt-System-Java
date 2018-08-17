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
public class FixedBasedPartTime extends PartTime{
    private  int FixedAmount;
    private  static ArrayList<FixedBasedPartTime> ListOfFixedBasedPartTime = new ArrayList<>();
    public FixedBasedPartTime(){
        
    }
    public FixedBasedPartTime( String employeeName, int age,
            Vehicle employeeVehicle, int hourlyRate, int noOfHoursWorked, int fixedAmount) {
        super(employeeName, age, employeeVehicle, hourlyRate, noOfHoursWorked);
        this.FixedAmount = fixedAmount;
    }
    
    public int getFixedAmount(){
        return this.FixedAmount;
    }
    
    public void addEmployee(FixedBasedPartTime employee){
        try {
            ListOfFixedBasedPartTime.add(employee);
            
        } catch (Exception e) {
            System.err.println("Unexpected error occur. Please try again");
        }        
    }
    
    @Override
    public void displayAllEmployeeDetails() {
        for (Employee employee : ListOfFixedBasedPartTime) {
            displayEmployeeDetails(employee);            
        }
    }
    
    @Override
    public double calculateEarning() {
        return super.calculateEarning() + this.FixedAmount;
    }

    @Override
    public String printMyData() {
        return super.printMyData()
                +"\nEmployee is Part Time \\ Fixed Based. \n" 
                +String.format(" -Rate : %d \n -Hours Worked : %d \n -Fixed Rate: %d \n -Earning : %.2f", 
                                    super.getHourlyRate(), this.getNoOfHoursWorked(), this.FixedAmount, this.calculateEarning());
    }
    @Override
    public String displayEmployeeDetails(Employee employee){
        System.out.println("======================Fixed Base Part Time Employee Details======================");
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
