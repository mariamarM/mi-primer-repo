/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author mariaandoli
 */
public class ErrDNIFormatException extends Exception {

    public ErrDNIFormatException(String errMessage) {
        super(errMessage);

    }

    public static void validateDNIErr(String dniErr) throws ErrDNIFormatException {

        if (dniErr.length() != 9) {
            throw new ErrDNIFormatException("El DNI tiene que tener 9 caracteres, 8 numeros y 1 letra mayuscula.");
        }
//        String dniNum = dniErr.substring(0, 9);
//        String dniLet = dniErr.substring(8);
//        String dniNumStr = "";
//        //   int dniNumInt = 0; //las inicias
//        for (int i = 0; i < 8; i++) {
//            dniNumStr = dniNumStr + dniErr.charAt(i);
//        }

    }
}
