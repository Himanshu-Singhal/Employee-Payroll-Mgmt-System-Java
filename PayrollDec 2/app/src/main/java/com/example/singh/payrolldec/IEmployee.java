/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.singh.payrolldec;

import java.util.Calendar;


/**
 *
 * @author Abdeali
 */
public interface IEmployee extends IPrintable  {
 void displayAllEmployeeDetails();
 double calculateEarning();
 default int calcBirthYear(int Age){
     Calendar now = Calendar.getInstance(); 
     return (now.get(Calendar.YEAR) - Age);
 }
}
