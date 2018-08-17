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
public class ProjectSingleton {
    
    private static ProjectSingleton projectSingleton;

    private static final ArrayList<Employee> listEmployee = new ArrayList<>();
    private static final ArrayList<Vehicle> listVehicle = new ArrayList<>();
    private ProjectSingleton(){   
    }
    public static ProjectSingleton getProjectSingletonInstance(){
        if(projectSingleton == null){
            projectSingleton = new ProjectSingleton();
        }
        return projectSingleton;        
    }
    
    public void addEmployee(Employee employee){
        listEmployee.add(employee);
    }
   
    public String displayAllEmployeeDetails(){
        final String[] dtl = {""};
        listEmployee.forEach((employee) -> {
           dtl[0] = employee.displayEmployeeDetails(employee);
        });
        return  dtl[0];
    }
    
    public void addVehicle(Vehicle vehicle){
        listVehicle.add(vehicle);
    }
    
    public void displayAllVehicleDetails(){
        listVehicle.forEach((vehicle) -> {
             vehicle.displayVehicleDetails(vehicle);
             System.out.println("LOOK HERE "+vehicle.displayVehicleDetails(vehicle));
        });
    }
    
    public double  getTotalPayroll() {
        double payRoll=0;
        for (Employee employee : listEmployee) {
            payRoll += employee.calculateEarning();
        }
        return payRoll;
    }
    
    public void displayTotalPayRoll(){
        System.out.println(String.format("Total Payroll = %.2f", getTotalPayroll()));
    }
    
}
