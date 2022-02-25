package Chess.view;

import Chess.model.Coordinate;

import java.util.Scanner;

public class Input {
    public static String getString(String message){
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }
    public static int getInteger(String message){
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        while (!sc.hasNextInt()) {
            System.out.println("Error. You have to enter a integer number.");
            sc.next();
        }
        return sc.nextInt();
    }
    public static float getFloat(String message){
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        while (!sc.hasNextFloat()) {
            System.out.println("Error. You have to enter a float number.");
            sc.next();
        }
        return sc.nextFloat();
    }
    public static String getChar(String message){
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }
    public static Coordinate getCoordinate(String message,String message2){
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
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
        }

        return new Coordinate(letra,numero);
    }
}
