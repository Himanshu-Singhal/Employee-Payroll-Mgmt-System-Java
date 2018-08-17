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
public class FullTime extends Employee{
 
    private  int Salary;
    private  int  Bonus ;
    private static  ArrayList<FullTime> ListOfFullTime = new ArrayList<>();
    
    public FullTime(){
        
    }
    public FullTime( String employeeName, int age, Vehicle employeeVehicle, int salary, int bonus){
     super( employeeName, age, employeeVehicle);
     this.Bonus = bonus;
     this.Salary = salary;
    }
    
    public int getSalary(){
        return this.Salary;
    }
    
    public int getBonus(){
        return this.Bonus;
    }
    
    public void addEmployee(FullTime employee){
        try {
            ListOfFullTime.add(employee);
            
        } catch (Exception e) {
            System.err.println("Unexpected error occur. Please try again");
        }
        
    }
    @Override
    public void displayAllEmployeeDetails() {
        ListOfFullTime.forEach((employee) -> {
            displayEmployeeDetails(employee);
        });
    }

    @Override
    public double calculateEarning() {
        return this.getBonus() + this.getSalary();
    }

    @Override
    public String printMyData() {
        return super.printMyData()
                +"\nEmployee is Full Time. \n" 
                +String.format(" -Salary : %d \n -Bonus : %d \n -Earning : %.2f", 
                                    this.getSalary(), this.Bonus, this.calculateEarning());
    }
    
    @Override
    public String displayEmployeeDetails(Employee employee){
        System.out.println("======================Full Time Employee Details======================");
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
            return temp;
    }
}
