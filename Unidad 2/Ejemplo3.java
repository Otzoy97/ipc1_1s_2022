import java.util.Scanner;
/**
 * Conversor de binario a decimal y viceversa
 * 
 * binario = [0,1]
 * decimal = [0,1,2,3,4,5,6,7,8,9]
 * 80/2=40 R=0
 * 40/2=20 R=0
 * 20/2=10 R=0
 * 10/2=5 R=0
 * 5/2=2 R=1
 * 2/2=1 R=0
 * 1/2=0 R=1
 * 1010000
 *     101
 * (1) Dividir dentro de 2 el decimal, almacenar el residuo
 * tomar el resultado de la división y dividirlo nuevamente dentro de 2, almacenar el residuo
 * (2) Realizar el anterior paso hasta que el último resultado de la división sea 1
 * (3) Ordenar los residuos del reverso e imprimirlo en pantalla
 * 
 */
public class Ejemplo3 {
    public static void main(String[] args) {
        //boolean condicion_de_salida = true;
        // "new" le indica a la computadora
        // que reserve un espacio en memoria para
        // acceder a los métodos de Scanner
        Scanner sc = new Scanner(System.in);
        String input_;
        while(true) { 
            // while acepta un booleano como condición
            // cuando esa condición ya no se cumpla, el ciclo terminará
            // este ciclo while se usa porque no sé cuántas
            // veces el usuario querrá usar este programa
            // la condición del while me indica que 
            System.out.println("1. convertir de binario a decimal");
            System.out.println("2. convertir de decimal a binario");
            System.out.println("3. salir");
            System.out.print("Ingrese la opción: ");
            // nextLine, le indica al programa 
            // que espere por la entrada del usuario via teclado
            // El usuario entoonces, deberá escribir en consola y presional enter
            // Al presionar enter el programa capturará la entrada del usuario 
            // y la almacenará en la variable de tipo cadena (String) 
            // con identificador input_
            input_ = sc.nextLine();
            switch(input_) {
                // La estructura switch evalúa la igualdad de
                // la  una variable dada contra los casos que
                // se especifiquen dentro de él.
                case "1":
                /**Ejecutar si es igual a 1 */
                System.out.println("Operación no soportada");
                break;
                case "2":
                /**Ejecutar si es igual a 2 */
                    // Se solicita al usuario que ingrese un número base decimal
                    System.out.print("Por favor indique el número decimal: ");
                    input_ = sc.nextLine();
                    System.out.println("El número binario es: " + toBinary(input_));
                break;
                case "3":
                /**Ejecutar si es igual a 3 */
                return;
                default:
                /**Ejecutar si no es igual 1, ni a 2, ni a 3 */
                System.out.println("Por favor ingrese un valor válido: 1, 2 o 3");
                break;
            }
        }
    }

    /**
     * Esta es una función.
     * Esta función servirá para convertir un cadena que representa un
     * número decimal a una cadena que representa un número binario
     * @param decimal
     */
    public static String toBinary(String decimal) {
        // Para poder realizar operaciones aritméticas
        // sobre una cadena, primero se debe convertir
        // esa cadena a un número
        int no_decimal = Integer.parseInt(decimal);
        int resultado;
        String binario = ""; //scope 
        // A través de un ciclo se dividirá el 
        // no_decimal, cada residuo se concatenará 
        // a la cadena binario
        // Ya que no se sabe cuántas veces se tendrá
        // que dividir, se usará un while
        boolean salir = true;
        while(salir) {
            // se divide dentro de dos para determinar el 
            // el siguiente número a dividir
            resultado = no_decimal / 2;
            // Se concatena al inicio de la 
            // cadena que representa un número binario
            // el residuo de la división
            binario = (no_decimal % 2) + binario;  //101010
            // Si resultado es igual a uno
            //if (no_decimal == 1) {
                // cuando el dividendo sea igual a 1
                // se detendrá el ciclo
                //break;                
            //}
            // se reemplaza no_decimal con resultado
            // para que en la siguiente iteración
            // no_decimal tenga diferente valor
            salir = resultado != 0;
            no_decimal = resultado;
        }
        return binario;
    }
}