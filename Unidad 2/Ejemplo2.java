import java.util.Scanner;

/**
 * Este es un ejemplo de una calculadora
 * La calduladora puede realizar 4 operaciones básicas:
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
            System.out.println("1. suma"); // Imprimir lo que se encuentra en paréntesis y un salto de línea
            System.out.println("2. resta");
            System.out.println("3. multiplicacion");
            System.out.println("4. division");
            System.out.println("5. salir");
            System.out.print("Por favor, ingrese una opción: "); // Imprime lo que se encuentra en paréntesis y ya
            String entrada_del_usuario = sc.nextLine(); // Lee toda la "entrada" del usuario hasta el primer salto de
                                                        // línea
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

            /* switch (entrada_del_usuario) {
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