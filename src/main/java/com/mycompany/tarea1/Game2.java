package com.mycompany.tarea1;

import java.util.Scanner;

public class Game2 {
    Scanner scanner = new Scanner(System.in);
    String player1, player2;
    int turns, pointsPJ1 = 0, pointsPJ2 = 0;

    public Game2(){}
    public void game(){
        enterPlayers();
        enterTurns();
        if((int)(Math.random()*100+1)<51){
            turns(player1,player2);
        }
        else{
            turns(player2,player1);
        }
        finishMatch();
    }
    public void enterPlayers(){
        System.out.println("Introduzca el nombre de los jugadores\n\nJugador 1:");
        player1 = scanner.nextLine();
        System.out.println("\nJugador 2:");
        player2 = scanner.nextLine();
    }
    public void enterTurns(){
        String numero;
        System.out.println("\nIngrese la cantidad de turnos que tendrá cada jugador:");
        do{
            numero = scanner.nextLine();
            if(isNumber(numero)){
                turns = Integer.parseInt(numero);
            }
            else{
                System.out.println("\nIngrese un número para los turnos:");
            }
        } while (!isNumber(numero));
    }
    public void turns(String player1, String player2){
        this.player1=player1;
        this.player2=player2;
        //String pjAtk = player1, pjDef = player2;
        int attackOption=0, defenseOption=0;
        boolean turn1 = true;
        for (int i = 0; i < turns; i++) {
            for (int j = 0; j < 2; j++) {
                String number;
                if(turn1){
                    System.out.println("\n"+this.player1+": Te toca atacar");
                    do{
                        System.out.println("\n1. Salto largo\t2. Salto corto");
                        number = scanner.nextLine();
                        if(isNumber(number)){
                            attackOption = Integer.parseInt(number);
                        }
                    } while(isNumber(number) && !validNumber(attackOption));
                    System.out.println("\n"+this.player2+": Te toca defender");
                    do{
                        System.out.println("\n1. Defensa cuerpo a cuerpo\t2. Defensa fuerte");
                        number = scanner.nextLine();
                        if(isNumber(number)){
                            defenseOption = Integer.parseInt(number);
                        }
                    } while(isNumber(number) && !validNumber(defenseOption));

                    if(!isFault(defenseOption,this.player2)){
                        attack(attackOption,this.player1,defenseOption);
                    }
                    else{
                        System.out.println("\n"+this.player1+"Obtiene un tiro libre\n");
                        attack(3,this.player1,defenseOption);
                    }
                    turn1 = false;
                }
                else{
                    System.out.println("\n"+this.player2+": Te toca atacar");
                    do{
                        System.out.println("\n1. Salto largo\t2. Salto corto");
                        number = scanner.nextLine();
                        if(isNumber(number)){
                            attackOption = Integer.parseInt(number);
                        }
                    } while(isNumber(number) && !validNumber(attackOption));
                    System.out.println("\n"+this.player1+": Te toca defender");
                    do{
                        System.out.println("\n1. Defensa cuerpo a cuerpo\t2. Defensa fuerte");
                        number = scanner.nextLine();
                        if(isNumber(number)){
                            defenseOption = Integer.parseInt(number);
                        }
                    } while(isNumber(number) && !validNumber(defenseOption));

                    if(!isFault(defenseOption,this.player1)){
                        attack(attackOption,this.player2,defenseOption);
                    }
                    else{
                        System.out.println("\n"+this.player1+"Obtiene un tiro libre\n");
                        attack(3,this.player2,defenseOption);
                    }
                    turn1 = true;
                }
                System.out.println("\nMarcador:\n"+this.player1+": "+this.pointsPJ1+"\t"+this.player2+": "+this.pointsPJ2);
            }
        }
    }
    public void finishMatch(){
        if(pointsPJ1>pointsPJ2){
            System.out.println("\n\tGANADOR ----> "+player1+"   "+pointsPJ1+" puntos");
        }
        else if(pointsPJ1<pointsPJ2){
            System.out.println("\n\tGANADOR ----> "+player2+"   "+pointsPJ2+" puntos");
        }
        else{
            System.out.println("\n\tEMPATE   "+pointsPJ1+"  -  "+pointsPJ2);
        }
        pointsPJ1 = 0;
        pointsPJ2 = 0;
        turns = 0;
    }
    public void attack(int type, String player, int defenseType){
        if(type == 1){ //Salto largo +3 puntos
            if(defenseType == 1){
                if(randomNumber()<51){
                    System.out.println("\n"+player+": Anotó en un salto largo\t+3 puntos");
                    if(this.player1.equals(player)){
                        pointsPJ1 = pointsPJ1+3;
                    }
                    else{
                        pointsPJ2 = pointsPJ2+3;
                    }
                }
                else{
                    System.out.println("\n"+player+": Falló el tiro\t+0 puntos");
                }
            }
            else if(defenseType == 2){
                if(randomNumber()<36){
                    System.out.println("\n"+player+": Anotó en un salto largo\t+3 puntos");
                    if(this.player1.equals(player)){
                        pointsPJ1 = pointsPJ1+3;
                    }
                    else{
                        pointsPJ2 = pointsPJ2+3;
                    }
                }
                else{
                    System.out.println("\n"+player+": Falló el tiro\t+0 puntos");
                }
            }
        }
        else if(type == 2){ //Salto corto +2 puntos
            if(defenseType==1){
                if(randomNumber()<66){
                    System.out.println("\n"+player+": Anotó en un salto corto\t+2 puntos");
                    if(this.player1.equals(player)){
                        pointsPJ1 = pointsPJ1+2;
                    }
                    else{
                        pointsPJ2 = pointsPJ2+2;
                    }
                }
                else{
                    System.out.println("\n"+player+": Falló el tiro\t+0 puntos");
                }
            }
            else if(defenseType==2){
                if(randomNumber()<51){
                    System.out.println("\n"+player+": Anotó en un salto corto\t+2 puntos");
                    if(this.player1.equals(player)){
                        pointsPJ1 = pointsPJ1+2;
                    }
                    else{
                        pointsPJ2 = pointsPJ2+2;
                    }
                }
                else{
                    System.out.println("\n"+player+": Falló el tiro\t+0 puntos");
                }
            }
        }
        else if(type == 3){ // Tiro Libre +2 puntos
            if(randomNumber()<91){
                System.out.println("\n"+player+": Anotó en un tiro libre\t+2 puntos\n");
                if(this.player1.equals(player)){
                    pointsPJ1 = pointsPJ1+2;
                }
                else{
                    pointsPJ2 = pointsPJ2+2;
                }
            }
            else{
                System.out.println("\n"+player+": Falló el tiro libre\t+0 puntos\n");
            }
        }
    }
    public boolean isFault(int type, String player){
        if(type == 1){
            if(randomNumber()<36){
                System.out.println("\n"+player+": Realizó defensa cuerpo a cuerpo\nProvocó una falta");
                return true;
            }
            else{
                System.out.println("\n"+player+": Realizó defensa cuerpo a cuerpo");
                return false;
            }
        }
        else{
            if(randomNumber()<66){
                System.out.println("\n"+player+": Realizó defensa fuerte\nProvocó una falta");
                return true;
            }
            else{
                System.out.println("\n"+player+": Realizó defensa fuerte");
                return false;
            }
        }
    }
    public boolean isNumber(String number){
        try{
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean validNumber(int number){
        return number == 1 || number == 2;
    }
    public int randomNumber(){
        return (int)(Math.random()*100+1);
    }
}
