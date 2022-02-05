import java.util.Scanner;

/**
 * 
 */
public class Ejemplo4 {

    static int[][] primera_matriz;
    static int[][] segunda_matriz;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String entrad_usuario;
        boolean seguir_ciclo = true;
        /**
         * El usuario deberá ingresar una matriz
         * de la siguiente forma: 8,80,9;9,9,9;1,5,6;144,56,7
         * 8 80 9
         * 9 9 9
         * 1 5 6
         * 144 56 7
         **/
        while (seguir_ciclo) {
            System.out.println("1. Ingresar primera matriz");
            System.out.println("2. Ingresar segunda matriz");
            System.out.println("3. Sumar matrices");
            System.out.println("4. Restar matrices");
            System.out.println("5. Multiplicar matrices");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            entrad_usuario = sc.nextLine();
            switch (entrad_usuario) {
                case "1":
                    System.out.println("Por favor especifique los valores para la matriz");
                    entrad_usuario = sc.nextLine();
                    convertirMatriz(1, entrad_usuario.trim());
                    break;
                case "2":
                    System.out.println("Por favor especifique los valores para la matriz");
                    entrad_usuario = sc.nextLine();
                    convertirMatriz(2, entrad_usuario.trim());
                    break;
                case "3": {
                    // int[][] resultado = new int[primera_matriz.length][primera_matriz[0].length];
                    for (int i = 0; i < primera_matriz.length; i++) {
                        for (int j = 0; j < primera_matriz[0].length; j++) {
                            // resultado[i][j] = primera_matriz[i][j] + segunda_matriz[i][j];
                            System.out.print(primera_matriz[i][j] + segunda_matriz[i][j] + " ");
                        }
                        System.out.println("");
                    }
                }
                    break;
                case "4": {
                    // int[][] resultado = new int[primera_matriz.length][primera_matriz[0].length];
                    for (int i = 0; i < primera_matriz.length; i++) {
                        for (int j = 0; j < primera_matriz[0].length; j++) {
                            // resultado[i][j] = primera_matriz[i][j] - segunda_matriz[i][j];
                            System.out.print(primera_matriz[i][j] - segunda_matriz[i][j] + " ");
                        }
                        System.out.println("");
                    }
                }
                    break;
                case "5": {
                    // la cant de columnas de la primera matriz
                    // tiene que ser igual a la cant de filas de la 2da matriz
                    if (primera_matriz[0].length != segunda_matriz.length) {
                        System.out.println("No se puede multiplicar");
                    }
                    for (int i = 0; i < primera_matriz.length; i++) {
                        for (int j = 0; j < segunda_matriz[0].length; j++) {
                            System.out.print(primera_matriz[i][j] * segunda_matriz[j][i] + " ");   
                        }
                        System.out.println("");
                    }
                    /*
                    for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columnas; j++) {
                
                for (int k = 0; k < fila; k++) {
                    
                    matrizR[i][j] += cuadrada[i][k] * matrizPrincipal[k][j];
                    
                }
                System.out.print("|" + matrizR[i][j] + "|");
            }
            System.out.print("");
        }
                    */
                }
                    break;
                case "6":
                    seguir_ciclo = false;
                    break;
            }
        }
        sc.close();
    }

    /**
     * Esta función convertirá una cadena que representa una matriz
     * a una matriz de números.
     * Se validará que la matriz posea la misma cantidad de "columnas"
     * Si no tiene la mismma cantidad de columnas se indicará al usuario
     * Y no se guardará la matriz en memoria
     * 
     * @param no_matriz
     * @param cadena_matriz
     */
    public static boolean convertirMatriz(int no_matriz, String cadena_matriz) {
        String[] filas = cadena_matriz.split(";");
        String[] celda_temporal;
        // Se asignará a la matriz uno
        if (no_matriz == 1) {
            primera_matriz = new int[filas.length][filas[0].split(",").length];
            for (int i = 0; i <= filas.length - 1; i++) {
                // 0,1,2,3,4,5,6
                celda_temporal = filas[i].split(",");
                for (int j = 0; j < celda_temporal.length; j++) {
                    primera_matriz[i][j] = Integer.parseInt(celda_temporal[j]);
                }
            }
        } else {
            segunda_matriz = new int[filas.length][filas[0].split(",").length];
            // Se asignará a la matriz dos
            for (int i = 0; i <= filas.length - 1; i++) {
                // 0,1,2,3,4,5,6
                celda_temporal = filas[i].split(",");
                for (int j = 0; j < celda_temporal.length; j++) {
                    segunda_matriz[i][j] = Integer.parseInt(celda_temporal[j]);
                }
            }
        }
        return true;
    }

}