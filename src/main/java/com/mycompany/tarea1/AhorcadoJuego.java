package com.mycompany.tarea1;

import java.util.Scanner;

public class AhorcadoJuego {
    
    private String palabraSecreta;
    private char[] letrasDescubiertas;
    private int intentosRestantes;
    private static final int maximo_intentos = 6;

    public AhorcadoJuego(String palabra) {
        palabraSecreta = palabra.toUpperCase();
        letrasDescubiertas = new char[palabraSecreta.length()];
        intentosRestantes = maximo_intentos;
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido al juego del ahorcado!");

        while (intentosRestantes > 0 && !estaCompleta()) {
            System.out.println("\nPalabra actual: " + obtenerPalabraDescubierta());
            System.out.println("Intentos restantes: " + intentosRestantes);
            System.out.print("Ingresa una letra: ");
            char letra = scanner.next().toUpperCase().charAt(0);
            comprobarLetra(letra);
        }

        if (estaCompleta()) {
            System.out.println("\n¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
        } else {
            System.out.println("\n¡Oh no! Te has quedado sin intentos. La palabra era: " + palabraSecreta);
        }

        scanner.close();
    }

    private void comprobarLetra(char letra) {
        boolean acierto = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                letrasDescubiertas[i] = letra;
                acierto = true;
            }
        }

        if (!acierto) {
            intentosRestantes--;
        }
    }

    private boolean estaCompleta() {
        for (char letra : letrasDescubiertas) {
            if (letra == 0) {
                return false;
            }
        }
        return true;
    }

    private String obtenerPalabraDescubierta() {
        StringBuilder sb = new StringBuilder();
        for (char letra : letrasDescubiertas) {
            if (letra != 0) {
                sb.append(letra);
            } else {
                sb.append('_');
            }
            sb.append(' ');
        }
        return sb.toString();
    }

    public static void InicioJuego () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Jugador 1, ingresa la palabra a adivinar: ");
        String palabraAdivinar = scanner.next().toUpperCase();

        AhorcadoJuego juego = new AhorcadoJuego(palabraAdivinar);
        juego.jugar();
    }
    
    
}
        


    

