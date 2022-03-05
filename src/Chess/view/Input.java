package Chess.view;

import Chess.model.Coordinate;

import java.util.Scanner;

/**
 * Clase Input encargada de todo el apartado de insercion de datos por parte del usuario
 * @author Pau Bigorra
 * @version 1.0
 */
public class Input {
    /**
     * Metodo encargado de mostrar un String y devuelve un String introducido por el usuario
     * @param message Mensaje que mostrara al utlilizarlo
     * @return devuelve un String intruducido por el usuario
     */
    public static String getString(String message){
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }
    /**
     * Metodo encargado de mostrar un String y devuelve un int(numero) introducido por el usuario
     * @param message Mensaje que mostrara al utlilizarlo
     * @return devuelve un int(numero) intruducido por el usuario
     */
    public static int getInteger(String message){
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        while (!sc.hasNextInt()) {
            System.out.println("Error. You have to enter a integer number.");
            sc.next();
        }
        return sc.nextInt();
    }
    /**
     * Metodo encargado de mostrar un String y devuelve un float(numero) introducido por el usuario
     * @param message Mensaje que mostrara al utlilizarlo
     * @return devuelve un float(numero) intruducido por el usuario
     */
    public static float getFloat(String message){
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        while (!sc.hasNextFloat()) {
            System.out.println("Error. You have to enter a float number.");
            sc.next();
        }
        return sc.nextFloat();
    }
    /**
     * Metodo encargado de mostrar un String y devuelve un char(una letra) introducido por el usuario
     * @param message Mensaje que mostrara al utlilizarlo
     * @return devuelve un char(una letra) intruducido por el usuario
     */
    public static String getChar(String message){
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }
    /**
     * Metodo encargado de mostrar un String y devuelve una coordenada introducida por el usuario
     * @param message Mensaje que mostrara al utlilizarlo
     * @return devuelve una coordenada introducida por el usuario
     */
    public static Coordinate getCoordinate(String message){
        Scanner sc = new Scanner(System.in);
        /*System.out.println(message);


        int numero=0;
        char letra= sc.next().toUpperCase().charAt(0);
        if (letra=='P'){
            return new Coordinate(letra,0);
        }
        String aux = String.valueOf(letra);
        letra=aux.toUpperCase().charAt(0);
        while (letra<'A'||letra>'H'){
            System.out.println("Has insertado una letra que no esta en el tablero");
            letra=sc.next().toUpperCase().charAt(0);

        }
        while (numero<1||numero>8){
            System.out.println(message2);
            while (!sc.hasNextInt()){
                System.out.println("El numero insertado no es una cordenda");
                sc.next();
            }
            numero=sc.nextInt();
        }*/


        boolean salida=false;
        int numero=0;
        char letra=' ';
        do {
            System.out.println(message +"\n" +
                    "Por favor introduzca las coordenadas de la siguiente manera:  a2=A2 ");

            String aux =sc.next();
            if (aux.length()==2){
                char[] corde = aux.toCharArray();
                corde[0] = Character.toUpperCase(corde[0]);
                int auxNum= (int) corde[1]-48;
                if (corde[0]=='P')
                    return new Coordinate(corde[0],0 );
                if (corde[0]>='A'&&corde[0]<='H'&&auxNum>=1&&auxNum<=8){
                    letra=corde[0];
                    numero=auxNum;
                    salida=true;
                }
                else {
                    System.out.println("Coordenadas introducidas incorrectas." +
                            "Presione cualquier tecla para continuar");
                    sc.next();
                }
            }else {
                System.out.println("Coordenadas introducidas incorrectas." +
                        "Presione cualquier tecla para continuar");
                sc.next();
            }
        }while (!salida);

        return new Coordinate(letra,numero);
    }
}
