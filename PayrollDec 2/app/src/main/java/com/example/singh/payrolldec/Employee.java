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
public class Employee implements IEmployee{

    private  String EmployeeId;
    public static String Detail="";

    private  int Age;
    private  String Name;
    private  Vehicle EmployeeVehicle;
    private static  ArrayList<Employee> ListOfEmployee = new ArrayList<>();

    public Employee(){
    }
    
    public Employee( String name, int age, Vehicle vehicle){
     this.Name = name;
     this.Age = age;
     this.EmployeeVehicle = vehicle;
    }
    

    public String getEmployeeName(){
       return this.Name;
    }
    
    public int  getEmployeeAge(){
        return this.Age;
    }
    
    public  Vehicle getVehicle(){
        return this.EmployeeVehicle;
    }
    
//    public void setEmployeeId (String employeeId){
//         this.EmployeeId = employeeId;
//    }
//    
//    public void setEmployeeName(String employeeName){
//        this.Name = employeeName;
//    }
//    
//    public void  setEmployeeAge(int age){
//        this.Age = age;
//    }
//    
//    public  void setVehicle(Vehicle employeeVehicle){
//        this.EmployeeVehicle = employeeVehicle;
//    }
    
    public void addEmployee(Employee employee){
        try {
            ListOfEmployee.add(employee);
            
        } catch (Exception e) {
            System.err.println("Unexpected error occur. Please try again");
        }
        
    }
    @Override
    public void displayAllEmployeeDetails() {
        ListOfEmployee.forEach((employee) -> {
            displayEmployeeDetails(employee);
        });
    }

    @Override
    public double calculateEarning() {
        return 1000.00; 
    }

    @Override
    public String printMyData() {
        return String.format("Name = %s \nYear Of Birth = %d",
                           this.getEmployeeName(),this.calcBirthYear(this.getEmployeeAge()));
    }
    
    public String displayEmployeeDetails(Employee employee){
        System.out.println("======================Employee Details======================");
        Detail = employee.printMyData();
       String temp = "";
        System.out.println(Detail);

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
