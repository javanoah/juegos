import Matrices.Tablero;
import org.w3c.dom.html.HTMLTableCaptionElement;

import java.util.Locale;

public class TicTacToe {

    public static void msgPantalla(String texto, int opt){

        switch (opt){

            case 1:
                System.out.println(texto.toUpperCase());
                break;

            case 2:
                System.out.println(texto.toLowerCase());
                break;

            case 3:
                System.out.println(texto.substring(0,1).toUpperCase()+texto.substring(1,texto.length()-1));
                break;

            case 4:
                String textTemp = texto.toLowerCase();
                System.out.println(textTemp.substring(0,1).toUpperCase()+textTemp.substring(1,textTemp.length()));
                break;


            default:
                System.out.println(texto);
                break;
        }


    }

    // Dibujar tabero
    // Rellenar los datos
    // Dibujar líneas verticales

    public static void dibujartablero(String tablero[][]) {

        msgPantalla("EstAmoS DibUjAndO El tABlErO...", 4);

        dibujarlineaHorizontal();
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + "|");
            }
            // System.out.println("|"+" "+"|"+" "+"|"+" "+"|");
            System.out.println();
            dibujarlineaHorizontal();
        }
    }
    // Dibujar líneas horizontales

    public static void dibujarlineaHorizontal() {
        System.out.println("-------");
    }


    // Introducir ficha=Posición de la ficha
    // Detectar si está vacía

    // Fila Columna

    public static boolean casillaVacia(String tablero[][], int x, int y) {
        if (tablero[x][y] == " ") {
            return true;
        }
        return false;
    }


    // Detectar si el tablero está lleno

    public static boolean tableroLleno(String tablero[][]) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //  if (tablero[i][j] == " ") return false;
                if (casillaVacia(tablero, i, j)) return false;
            }
        }
        return true;

    }


    public static boolean comprobarLineas(String tablero[][]) {

        if (comprobarHorizontales(tablero)
                || comprobarVerticales(tablero) || diagonalPrincipal(tablero) || diagonalInvertida(tablero)) {
            return true;
        }

        return false;
    }


    // Comprobar líneas
    // Comprobar horizontales
    public static boolean comprobarHorizontales(String tablero[][]) {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == tablero[i][1] && tablero[i][2] == tablero[i][1])
                return true;
        }
        return false;
    }

    // Comprobar verticales

    public static boolean comprobarVerticales(String tablero[][]) {
        for (int i = 0; i < 3; i++) {
            if (tablero[0][i] == tablero[1][i] && tablero[2][i] == tablero[1][i])
                return true;
        }
        return false;
    }
    // Comprobar diagonales


    // Diagonal principal

    public static boolean diagonalPrincipal(String tablero[][]) {

        String casillaInicial = tablero[0][0];


        if (tablero[0][0] == tablero[1][1] && tablero[2][2] == tablero[1][1]) return true;
        return false;
    }

    public static boolean diagonalInvertida(String tablero[][]) {

        int fila = 1, columna = 1;
        if (tablero[fila][columna] == tablero[fila - 1][columna + 1] &&
                tablero[fila + 1][columna - 1] == tablero[fila][columna] && !casillaVacia(tablero, fila, columna)
                // ¿Están vacías las casillas?
            && !casillaVacia(tablero, fila-1, columna+1)
            && !casillaVacia(tablero, fila+1, columna-1)) {
            return true;
        }
        return false;
    }





/*        for (int i = 0; i < 3; i++) {
            for (int j = i; j < 3; j++) {
                if(i!=j) continue;
                if(casillaVacia(tablero,i,j) || casillaInicial != tablero[i][j]) return false;

                if(casillaInicial == tablero[i][j] && j==tablero.length-1) return true; */
            //}

        // return false;


    // Diagonal invertida

    public static void main(String[] args) {


        System.out.println("Tic Tac Toe");
        // Fichas del tablero = [][],x,O,' '
        String tablero[][] = {
                {"O","X","X"},
                {"X","O","X"},
                {"X","X","O"},
        };



        dibujartablero(tablero);

//        if (tableroLleno(tablero)){
//            System.out.println("Tablero LLENO");
//        }else{
//            System.out.println("Aún quedan casillas");
//        }

        if (comprobarHorizontales(tablero)){
            System.out.println("Hay Horizontales");
        }
        if (comprobarVerticales(tablero)){
            System.out.println("Hay Verticales");
        }

        if (diagonalPrincipal(tablero)){
            System.out.println("Hay una diagonal principal");
        }
        if (diagonalInvertida(tablero)){
            System.out.println("Hay una diagonal invertida");
        }


        if (comprobarLineas(tablero)){
            System.out.println("Hay ganador");
        }


    }
}
