package org.example;

import java.util.Random;
import java.util.Scanner;

public class Examen {
static Scanner sc = new Scanner(System.in);
static Random rand = new Random();

    public static void Ejercicio1(){
        boolean check = true; //Declaramos un booleano para poder hacer diferentes checks a lo largo del código
        int ronda = 1, j1Puntos = 0, pcPuntos = 0, pcJugada = -1; // Inicializamos los int para poder usarlos según corresponda
        String j1 = "", pc = "", aux = ""; // Inicializamos los String para poder usarlos según corresponda


        do {
            System.out.println("Ronda" + ronda); //Imprimimos por pantalla la Ronda actual

            do {
                pcJugada = rand.nextInt(3); //Le indicamos que haga un número random entre 0 y 2 (un total de 3 valores)
                switch (pcJugada) {                 //Le asignamos en un switch la jugada que le corresponda a la máquina
                    case 0 -> pc = "p";
                    case 1 -> pc = "a";
                    case 2 -> pc = "t";
                }

                System.out.print("Piedra, papel o tijera? (p/a/t)"); //Le pedimos la usuario que introduzca un carácter
                aux = sc.nextLine(); //Almacenamos la entrada por teclado
                if (aux.equalsIgnoreCase("p")) { //Comparamos la entrada por teclado ignorando las mayusculas
                    j1 = "p";
                    check = false; //Si el jugador ha introducido el carácter indicado en el if se romperá el bucle do-while

                } else if (aux.equalsIgnoreCase("t")) {
                    j1 = "t";
                    check = false;

                } else if (aux.equalsIgnoreCase("a")) {
                    j1 = "a";
                    check = false;

                } else {
                    System.out.println("ERROR: Valor no válido"); // Si ningún carácter ha sido válido, se lo indicaremos y seguiremos atrapados en el bucle.
                }
            } while (check);
            check = true; //Devolvemos el check a su valor por defecto

            aux = j1 + " " + pc; //Vamos a crear un String con los posibles resultados en el formato "[Jugador] [Máquina]" y lo compararemos en el switch

            switch (aux){
                case "a a": {
                    System.out.println("Papel empata con papel!"); //Indicamos el resultado de la comparación.
                    break; //Salimos del Switch
                }
                case "p p": {System.out.println("Piedra empata con piedra!");
                    break;
                    }
                case "t t": {
                    System.out.println("Tijera empata con tijera!");
                    break;
                }
                case "a p": {
                    System.out.println("Papel gana a piedra!");
                    j1Puntos++; //Cuando sea indicado, le sumaremos puntos al ganador.
                    break;
                }
                case "a t":{
                    System.out.println("Papel pierde contra tijera!");
                    pcPuntos++;
                    break;
                }
                case "p a":{
                    System.out.println("Piedra pierde contra papel!");
                    pcPuntos++;
                    break;
                }
                case "p t":{
                    System.out.println("Piedra gana a tijera!");
                    j1Puntos++;
                    break;
                }
                case "t a":{
                    System.out.println("Tijera gana a papel!");
                    j1Puntos++;
                    break;
                }
                case "t p":{
                    System.out.println("Tijera pierde contra piedra!");
                    pcPuntos++;
                    break;
                }
            }
            System.out.println("Marcador actual (PC - usuario): " + pcPuntos + "-" +j1Puntos + "\n"); //Imprimimos por pantalla el marcador
            ronda++;
        } while (ronda<4); //Mientras la ronda sea menor que 4 (no inclusive) se segurá repitiendo el juego

        if (j1Puntos > pcPuntos) { //Ahora simplemente comparamos la puntuación del jugador con la máquina
            System.out.println("GANA EL USUARIO!");
        } else if ( j1Puntos == pcPuntos) {
            System.out.println("EMPATE!!");
        } else {
            System.out.println("GANA LA MÁQUINA!");
        }

    }
    public static void Ejercicio2(){

    }
}
