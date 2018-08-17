/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.singh.payrolldec;

/**
 *
 * @author Abdeali
 */
public class FinalJavaProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Car car1 = new Car("Mahindra", "Scorpio", 1000, "SUV");
        ProjectSingleton.getProjectSingletonInstance().addVehicle(car1);
        
        Car car2 = new Car("Mercedes-Benz", "C-Class", 750, "Sedan");
        ProjectSingleton.getProjectSingletonInstance().addVehicle(car2);
        
        Car car3 = new Car("Audi", "Q7", 750, "SUV");
        ProjectSingleton.getProjectSingletonInstance().addVehicle(car3);
        
        Motorcycle motorcycle1 = new Motorcycle( "Yahama", "R1", 1000 , true);
        ProjectSingleton.getProjectSingletonInstance().addVehicle(motorcycle1);
        
        Motorcycle motorcycle2 = new Motorcycle( "Kawasaki", "Ninja", 1000 , true);
        ProjectSingleton.getProjectSingletonInstance().addVehicle(motorcycle2);
        
        Motorcycle motorcycle3 = new Motorcycle( "Hero", "Passion Pro", 1000 , false);
        ProjectSingleton.getProjectSingletonInstance().addVehicle(motorcycle3);
       
        System.out.println("============================Display Vehicle================================");
        ProjectSingleton.getProjectSingletonInstance().displayAllVehicleDetails();
       
        System.out.println("============================Display Emlpoyees================================");
        
        Intern intern = new Intern( "Abdeali", 25, motorcycle2, "Lambton College");
        ProjectSingleton.getProjectSingletonInstance().addEmployee(intern);
        
        FullTime fullTime = new FullTime( "Steve", 45, car1, 1000 , 100);
        ProjectSingleton.getProjectSingletonInstance().addEmployee(fullTime);
       
        
        
       CommissionBasedPartTime commissionBasedPartTime = new CommissionBasedPartTime(10,  "Stuart", 36, car3, 10, 20);
       ProjectSingleton.getProjectSingletonInstance().addEmployee(commissionBasedPartTime);
        
        
        
       FixedBasedPartTime fixedBasedPartTime = new FixedBasedPartTime( "Irina", 28, null, 15, 35, 50);
       ProjectSingleton.getProjectSingletonInstance().addEmployee(fixedBasedPartTime);
     
       
       ProjectSingleton.getProjectSingletonInstance().displayAllEmployeeDetails();
       
       System.out.println("===========================Total Payroll================================");
       ProjectSingleton.getProjectSingletonInstance().displayTotalPayRoll();
       
       
        
    }
    
}
