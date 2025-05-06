/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Validations;
//PRUEBA EJEMPLO EJERCICIO 

import exceptions.ErrDNIFormatException;
import exceptions.ErrPostalCodeException;

/**
 *
 * @author andre
 */
public class UserDataValidations {

    /**
     *
     * @param typeDoc verificar documento de id
     * @param id si el id es otro retornara false
     * @throws exceptions.ErrDNIFormatException
     */
    public static void checkId(int typeDoc, String id) throws ErrDNIFormatException { //error bien //error mal

       
           
                 if (typeDoc != 1) {
                     System.out.println("no ok");
                 }
 String dniNum = id.substring(0, 9);
                String dniLet = id.substring(8);
                String dniNumStr = "";
                //   int dniNumInt = 0; //las inicias
                for (int i = 0; i < 8; i++) {
                    dniNumStr = dniNumStr + id.charAt(i);

                    int dniNumInt = Integer.parseInt(dniNumStr);
                    String caracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
                    if (caracteres.charAt(dniNumInt % 23) != dniLet.charAt(0)) {
                        System.out.println("dni ok: " + caracteres);
                    } else {
                        System.out.println("dni no ok");

                    }

              
               
                
            
        }
//        if (id.length() != 9) {
//            return false;
//        }

//el susbtring que e suna funcion de quedarte con una parte de un string que esta bien 
//desde la posicion 0 hasta la posicojn 9 no incluye la nuve en plan corta el string y lo guarda en la var y luego tienes que hacer otro
//para guardar el numero que resta
        //    String dniLet = "" + id.charAt(8);
//
//        if (!isNumeric(dniNumStr)) {
//            return false;
//        }
//        if (!isAlphabetic(dniLet)) {
//            return false;
//        }
//       
//     
//           return true;       
        //return (caracteres.charAt(dniNumInt % 23) != dniLet.charAt(0);
    }
    //segun la primera operacion del residuo divido entre 23 pues te dara un num que se asignara a la letra en plan la posicion del char cuando cuentas en
    //la posicion del array en plan si sale de residuo 12 pues la letra del string 
    //== es una comparacion estas como retornadndo un boolean de si es true ña comparacion lo devuelve o si es false pues no. en plan puedes hacer un if de t/f o 
    //retornar toda la expresion que es muucho mas facil. si comparas la letra que pone el usuario con el residuo y tal esta chido

    /**
     *
     * @param date validar el formatop e fecha sea correcto dd/mm/yyyy funcion
     * split
     * @return true si el formato es correcto false si no lo es
     */
    public static boolean checkFormatDate(String date) {
        if (date == null) {
            return false;
            //que no me aceopte nuilos
        }

        String[] parts = date.split("/");
        if (parts.length != 3) {
            return false;
        }

        String diaStr = parts[0];
        String mesStr = parts[1];
        String yearStr = parts[2];

        if (!isNumeric(diaStr) || !isNumeric(mesStr) || !isNumeric(yearStr)) {
            return false;
        }

        int dia = Integer.parseInt(diaStr);
        int mes = Integer.parseInt(mesStr);
        int year = Integer.parseInt(yearStr);

        if (dia < 1 || dia > 31) {
            return false;
        }
        if (mes < 1 || mes > 12) {
            return false;
        }
        switch (mes) {
            case 2:
                if (BisiestoYear(year)) {
                    if (dia > 29) {
                        return false;
                    }
                } else {
                    if (dia > 28) {
                        return false; // el 28 de febrero 
                    }
                }
                break;
            case 4, 6, 9: //meses que acaben en 31 que me dan igual
                return false;
            case 11:
                if (dia == 30) {

                }
                break;
        }
        if (year < 2000) {
            return false;
        }

        return true;
    }

    /**
     *
     * @param birthDate cacula la edad en bvasa a la fecha de nacimiento
     * @return que devuelva -1 si la fecha NO es coherente sino, devolvera la
     * edad correcta.
     */
    public static int calculateAge(String birthDate) {
        if (!checkFormatDate(birthDate)) {
            return -1; //que sino es asi te lo devuelva el -1
        }
        String[] partes = birthDate.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int year = Integer.parseInt(partes[2]);

        java.time.LocalDate hoy = java.time.LocalDate.now();
        int MesActual = hoy.getMonthValue();
        int DiaActual = hoy.getDayOfMonth();
        int yearActual = hoy.getYear();

        int edad = yearActual - year;

        if (MesActual < mes) {
            //que si el mes actual es menor que el mes de nacimiento no los ha compldo todavia
            edad--;
        } else if (MesActual == mes && DiaActual < dia) {
            //mismo que el mes pero con dia que no ha cumplido los años todavia y se hace para ajustar a la edat
            edad--;
        }
        return edad;
        //monthvalue es el 1 = enero y 12 diciembre y que eso lo tome como ints en plan 25 de enero pues el mes es 1        }
//el period te hace la diferencia entre dos fechas en plan para los cumpleaños o wtvr 
    }

    /**
     *
     * @param zip que sena 5 numeros y que todos sean numericos
     * @throws exceptions.ErrPostalCodeException
     */
    public static void checkPostalCode(String zip) throws ErrPostalCodeException {
        //for para recorrer tooodo el string y me diga si son digitos
        for (int i = 0; i < zip.length(); i++) {
            if (Character.isDigit(zip.charAt(i))) {
                System.out.println("");
            }
        }
    }

    /**
     *
     * @param str que el string sea todos chars numericos isDigit se usa
     * @return que sea el contenido numerico true
     */
    public static boolean isNumeric(String str) {
        if (str == null) {//que no me ponga nulos
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
                //que pase por cada char y me lo guarde en la i y queb e diga si es num o no
            }
        }
        return true;
    }

    /**
     *
     * @param str que el string solo lleve letras
     * @return true si es efectivamente asi o false si no cumple que sean
     * letras.
     */
    public static boolean isAlphabetic(String str) {
        for (int i = 0; i < str.length(); i++) { //me esta leyendo todo el string para verificarlo despues
            char c = str.charAt(i);//que la i me las guarde en la c en plan cada i me las guarde en los chars de la c
            if (!Character.isLetter(c)) { //que te diga si no es ni un num ni un ESPÀCIO
                return false;
            }
            return true;
            //si encuentra un num se para y devuelve false si hay un espacio o una letra continua y devueve true
        }

        return false;
    }

    /**
     *
     * @param email debe contener un @ y que cumpla los formatos de email, con
     * termminaciones .com/.es/.cat
     * @return si es correcto el formato devolvera true de lo cotrario sera
     * false.
     */
    public static boolean checkEmail(String email) {
        int Indicearroba = email.indexOf("@");
        //que el @ este en una posicion ok del string osea que no se enucnetre fuera de del correo y tapoco este al final
        if (Indicearroba <= 0 || Indicearroba == email.length() - 1) {
            return false;
        }
        String[] dominiosRegistrados = {".com", ".es", ".cat", ".outlook", ".org"};
        for (String dominiosRegistrado : dominiosRegistrados) {
            if (email.endsWith(dominiosRegistrado)) {
                //devuelve true cuando la cadena EMAIL acaba exacto con el dominioregistrado que ha puesto el user
                return true;
            }
        }
        return false;
        //user@gmail.com / user@outlook.com devolveran true
        //@gmail.com / user@ /user@gmail.xyz devolvera false

    }

    /**
     *
     * @param name validacion de longitud logica maximo de 16 nums por ejemplo y
     * que no cotenga numeros
     * @return si cumple los requisitos devolvera true sino devolvera false.
     */
    public static boolean checkName(String name) {
        if (name.length() < 3) {
            return false; //longitud moderada 50 vc bien si se pasa esta dead 
        }
        if(isNumeric(name)) { //solo letras si NO son numeros
            return false;
        }
        return true; //si no pasa por ninguna de esos condicionales te devolvera true y esta todo keey
    }

    /**
     *
     * @param anyo para saber si el año es bisiesto lo uso para el date y
     * formatdate
     * @return verifica si es bisiesto el año a la hora de poner fecha
     */
    public static boolean BisiestoYear(int anyo) {
        if (anyo % 4 != 0) {
            return false;
        } else if (anyo % 100 != 0) {
            return true;
        } else {
            return anyo % 400 == 0;
        }
        //muucho mas simple : return (anyo % 4 == 0) && (anyo % 100  != 0 || anyo % 400 != 0);
    }
}
