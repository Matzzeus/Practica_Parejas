package com.mycompany.tarea1;
import java.util.Scanner;
public class Menu {
    static Game2 Juego2 = new Game2 ();
    static Game3 Juego3 = new Game3 ();
    
    
    
    public  Menu (){
     
    }
    public static boolean isNumber(String number){
        try{
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void menu (){
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        String linea = "";

        do {
            System.out.println("\n===== MENÚ DE  JUEGOS =====");
            System.out.println("1. Ahorcados");
            System.out.println("2. Basketball");
            System.out.println("3. Cartas");
            System.out.println("4. Salir");
            System.out.print("Ingresa la opción deseada: ");
            
            do {
                linea = scanner.nextLine();
                if (isNumber (linea)){
                    opcion = Integer.parseInt(linea);
                }
                else{
                    System.out.println("Solo es valido números");
                }
            } while ( !isNumber (linea));
            
            switch (opcion) {
                case 1:
                    AhorcadoJuego.InicioJuego();
                    break;
                case 2:
                    Juego2.game(); 
                    break;
                case 3:
                   Juego3.game();
                    break;
                case 4:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elige una opción válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
