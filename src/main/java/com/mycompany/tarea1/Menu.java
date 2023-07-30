package com.mycompany.tarea1;
import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENÚ DE  JUEGOS =====");
            System.out.println("1. Ahorcados");
            System.out.println("2. Basketball");
            System.out.println("3. Cartas");
            System.out.println("4. Salir");
            System.out.print("Ingresa la opción deseada: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                   
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
