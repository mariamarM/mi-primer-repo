/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author andre
 */
public class ErrPostalCodeException extends Exception {
   public ErrPostalCodeException(String errMessage) {
        super(errMessage);

    }

    public static void validatePostalCodeErr(String CPErr) throws ErrPostalCodeException {
        if (CPErr.length() != 5) {
            throw new ErrPostalCodeException ("El codigo postal no llega a 5 digitos o incompleto.");
            //que solo me ponga 5 chars de largo del zip
        }
        //for para recorrer tooodo el string y me diga si son digitos
//        for (int i = 0; i < CPErr.length(); i++) {
//            if (Character.isDigit(CPErr.charAt(i))) {
//            throw new ErrPostalCodeException ("El codigo postal no contiene digitos numericos.");
//
//            }
//        }
       

    } 
}
 