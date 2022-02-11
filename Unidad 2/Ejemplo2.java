import java.util.Scanner;

/**
 * Este es un ejemplo de una calculadora
 * El propósito de este ejemplo es demostrar el uso
 * de diferentes estructuras de control y ciclos para 
 * generar un programa que simula el comportamiento de una
 * calculadora
 * Este programa funciona en un entorno ideal, es decir,
 * no se asegura que la entrada del usuario se la correcta.
 * Se asume que el usuario está ingresado la información
 * que se le está solicitando
 * 
 * La calculadora puede realizar 4 operaciones básicas:
 * 1.- suma
 * 2.- resta
 * 3.- multiplicación
 * 4.- división
 */
public class Ejemplo2 { // Calculadora
    public static void main(String args[]) {
        while (true) { 
            // Ya que no se conoce con certeza la cantidad
            // de veces que el usuario querrá realizar operaciones, se usa un while.

            // A través de un ciclo, el programa seguirá pidiendo
            // al usuario que ingrese una opción.
            // El programa únicamente terminará al momento que el usuario 
            // ingrese la opción 5

            Scanner sc = new Scanner(System.in);

            /// System.out.println Imprime lo que se encuentra en paréntesis y luego un salto de línea
            System.out.println("1. suma"); 
            System.out.println("2. resta");
            System.out.println("3. multiplicacion");
            System.out.println("4. division");
            System.out.println("5. salir");
            // System.out.print Imprime lo que se encuentra en paréntesis y ya, no realiza un salto de línea
            System.out.print("Por favor, ingrese una opción: "); 
            String entrada_del_usuario = sc.nextLine(); // nextLine Lee toda la "entrada" del usuario hasta el primer salto de
                                                        // línea. En esta caso, la entrada del usuario se está asignando
                                                        // inmediatamente a entrada_del_usuario.
            // Si el usuario ingresa la opción 5, el ciclo se detendrá y el  programa terminará
            if (entrada_del_usuario.equals("5")) {
                break;
            }
            // si la entrada del usuario es 1, entonces realizar una suma
            // sino, verificar que la entrada del usuario es 2, entonces realizar una resta
            // sino, verificar que la entrada del usuario es 3, entonces realizar una
            // multiplicación
            // sino, verificar que la entrada del usuario es 4, entonces realizar una
            // división.

            // Esto es un if-elseif
            // La comparación con entrada_del_usuario
            // se realiza con equals, porque String 
            // es un tipo de dato "no primitivo"
            // Cuando se quiere realizar comparaciones de igualdad o desigualdad
            // se debe usar equals y no el operador de igualdad ==
            if (entrada_del_usuario.equals("1")) {
                System.out.print("Primer operando:  ");
                String op1 = sc.nextLine();
                System.out.print("Segundo operando:  ");
                String op2 = sc.nextLine();
                int op1_numero = Integer.parseInt(op1);
                int op2_numero = Integer.parseInt(op2);
                int resultado = op1_numero + op2_numero;
                System.out.println("El resultado de la suma es: " + resultado);
            } else if (entrada_del_usuario.equals("2")) {
                System.out.print("Primer operando:  ");
                String op1 = sc.nextLine();
                System.out.print("Segundo operando:  ");
                String op2 = sc.nextLine();
                int op1_numero = Integer.parseInt(op1);
                int op2_numero = Integer.parseInt(op2);
                int resultado = op1_numero - op2_numero;
                System.out.println("El resultado de la resta es: " + resultado);
            } else if (entrada_del_usuario.equals("3")) {
                System.out.print("Primer operando:  ");
                String op1 = sc.nextLine();
                System.out.print("Segundo operando:  ");
                String op2 = sc.nextLine();
                int op1_numero = Integer.parseInt(op1);
                int op2_numero = Integer.parseInt(op2);
                int resultado = op1_numero * op2_numero;
                System.out.println("El resultado de la multiplicación es: " + resultado);
            } else if (entrada_del_usuario.equals("4")) {
                System.out.print("Primer operando:  ");
                String op1 = sc.nextLine();
                System.out.print("Segundo operando:  ");
                String op2 = sc.nextLine();
                int op1_numero = Integer.parseInt(op1);
                int op2_numero = Integer.parseInt(op2);
                int resultado = op1_numero / op2_numero;
                System.out.println("El resultado de la división es: " + resultado);
            }
            /// El if-elseif que se realizó anteriormente
            /// puede ser reemplazado por el switch que
            /// se encuentra acontinuación
            /// para probar con el switch deben comentar
            /// todo el bloque de código de if-elseif y 
            /// descomentar el bloque de switch

            /* switch (entrada_del_usuario) {
                /// Los bloques de codigo que se encuentran
                /// dentro de los casos se encierran entre llaves
                /// para evitar que el programa de error
                /// de duplicación de variables
                /// Revisar la grabación correspondiente para 
                /// este ejemplo en el minuto 01:15:09
                /// para mayor información o detalle
                case "1": {
                    System.out.print("Primer operando:  ");
                    String op1 = sc.nextLine();
                    System.out.print("Segundo operando:  ");
                    String op2 = sc.nextLine();
                    int op1_numero = Integer.parseInt(op1);
                    int op2_numero = Integer.parseInt(op2);
                    int resultado = op1_numero + op2_numero;
                    System.out.println("El resultado de la suma es: " + resultado);
                }
                    break;
                case "2": {
                    System.out.print("Primer operando:  ");
                    String op1 = sc.nextLine();
                    System.out.print("Segundo operando:  ");
                    String op2 = sc.nextLine();
                    int op1_numero = Integer.parseInt(op1);
                    int op2_numero = Integer.parseInt(op2);
                    int resultado = op1_numero - op2_numero;
                    System.out.println("El resultado de la resta es: " + resultado);
                }
                    break;
                case "3": {
                    System.out.print("Primer operando:  ");
                    String op1 = sc.nextLine();
                    System.out.print("Segundo operando:  ");
                    String op2 = sc.nextLine();
                    int op1_numero = Integer.parseInt(op1);
                    int op2_numero = Integer.parseInt(op2);
                    int resultado = op1_numero * op2_numero;
                    System.out.println("El resultado de la multiplicacion es: " + resultado);
                }
                    break;
                case "4": {
                    System.out.print("Primer operando:  ");
                    String op1 = sc.nextLine();
                    System.out.print("Segundo operando:  ");
                    String op2 = sc.nextLine();
                    int op1_numero = Integer.parseInt(op1);
                    int op2_numero = Integer.parseInt(op2);
                    int resultado = op1_numero / op2_numero;
                    System.out.println("El resultado de la division es: " + resultado);
                }
                    break;
            } */
        }
    }
}