/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;
import Model.Validations.UserDataValidations;
import static Model.Validations.UserDataValidations.isNumeric;
import exceptions.ErrPostalCodeException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import exceptions.ErrPostalCodeException;
import exceptions.ErrDNIFormatException;
/**
 *
 * @author andre
 */
public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        String option;
        do{
        System.out.println("1.- testCheckId");
        System.out.println("2.- testcheckFormtDate");
        System.out.println("3.- testCheckCalculateAge");
        System.out.println("4.- testCheckPostalCode");
        System.out.println("5.- testCheckisNumeric");
        System.out.println("6.- testCheckisAlphabetic");
        System.out.println("7.- testCheckEmail");
        System.out.println("8.- testCheckName");
        System.out.println("z.- Salir");
        
        option = scan.nextLine();
        switch (option) {
            case "1":
            {
                try {
                    testcheckId();
                } catch (ErrDNIFormatException ex) {
                    System.out.println(ex);
                   // Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case "2":
                testcheckFormatDate();
                break;
            case "3":
                testcheckCalculateAge();
                break;
            case "4":
                testcheckPostalCode();
                break;
            case "5":
                testcheckisNumeric();
                break;
            case "6":
                testcheckIsAlphabetic();
                break;
            case "7":
                testcheckEmail();
                break;
            case "8":
                testcheckName();
                break;

        }
        
        }while( !option.equals("z"));
    }

    static void testcheckId() throws ErrDNIFormatException{
        System.out.println("Enter your id: ");
         String nif = scan.next();
         String caracteres = "TRWAGMYFPDXBNJZSQVHLCKE";

         
        if(nif.length() != 9){
            UserDataValidations.checkId(1, nif);
            System.out.println(" valid nif estructure." + nif);

        }else{
            System.out.println("no valid id");
        }
    
    }

    static void testcheckFormatDate() {
        System.out.println("Enter your birthdate in format dd/mm/yyyy: ");
        String fecha = scan.nextLine();
        UserDataValidations.checkFormatDate(fecha);
               if(UserDataValidations.checkFormatDate(fecha)){
            System.out.println("Date is valid.");
        }else{
            System.out.println(" Date no es valid");
        }
    }

    static void testcheckCalculateAge() {
            System.out.println("Enter your birthdate to calculate your age: dd/mm/yyyy: ");
            String UsrBirth = scan.next();
            UserDataValidations.calculateAge(UsrBirth);
            int age = 0;
            age = UserDataValidations.calculateAge(UsrBirth);
          if(age == -1){
              System.out.println("No valid");
        }else{
            System.out.println(age);
        }
          //empiezas poniendo el error entonces si es verdadero que te printe solo la edad 
    }

    static void testcheckPostalCode() {
        try {
            System.out.println("Enter your Postal Code in 5 digits:  ");
            String CP = scan.next();
            UserDataValidations.checkPostalCode(CP);
            
            if(CP.length() !=5){
                System.out.println("CP is not valid.");

            } else {
                System.out.println("CP is valid.");
            }
        } catch (ErrPostalCodeException ex) {
            System.out.println(ex);
        }
    }

    static void testcheckisNumeric() {
        System.out.println("Enter a random String to prove if its numeric:  ");
        String checkString = scan.nextLine();
        UserDataValidations.isNumeric(checkString);
         if(UserDataValidations.isNumeric(checkString)){
            System.out.println("number is valid.");
        }else{
            System.out.println("number no es valid");
        }
    }

    static void testcheckIsAlphabetic() {
        System.out.println("Enter a random String with ints to reverse it to int data: ");
        String checkAlphabetic = scan.next();
        UserDataValidations.isAlphabetic(checkAlphabetic);
        if(UserDataValidations.isAlphabetic(checkAlphabetic)){
            System.out.println(" is valid.");
        }else{
            System.out.println("no es valid");
        }

    }

    static void testcheckEmail() {
     System.out.println("Enter your email with any of these tarminations: .com/.es/.cat/.org/.outlook  ");
        String email = scan.next();
        UserDataValidations.checkEmail(email);
             if(UserDataValidations.checkEmail(email)){
            System.out.println("email  is valid.");
        }else{
            System.out.println("email no es valid");
        }
    }

    static void testcheckName() {
        System.out.println("Enter your name: ");
        String nom = scan.nextLine();
        UserDataValidations.checkName(nom);
             if(UserDataValidations.checkName(nom)){
            System.out.println("name  is valid.");
        }else{
            System.out.println("name no es valid");
        }
    }                          
}
