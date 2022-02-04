/**
 * Programa que encuentra hasta 10 numero
 * que son divisibles entre 18
 */
public class Ejemplo1 {
    public static void main (String args[]) {
        int x = 10; // Asignar x = 10
        int y = 8; // Asignar y = 8
        while(x != 0) { // Ejecutar mientras X no sea igual a 0
            int z = y % 18; // Asignar z = y modulo 18
            if (z == 0) { // Si z es igual a 0
                System.out.println(y); // imprimir el valor de y
                x = x - 1; // disminuir en una unidad el valor de x
            }
            y = y + 1; // aumentar en una unidad el valor de y
        }
    }
    
    public static int moduloDe(int val0, int val1) {
        return val0 % val1;
    }

    public static char charRet() {
        return '8'; //ascii
    }

    public static boolean boolRet() {
        return true;
    }
}