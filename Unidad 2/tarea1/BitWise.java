import java.util.Scanner;

public class BitWise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" MENÚ PRINCIPAL");
        System.out.println(" 1. AND");
        System.out.println(" 2. NOT");
        System.out.println(" 3. OR");
        System.out.println(" 4. XOR");
        System.out.print("Ingrese una opción: ");
        String opt = sc.nextLine();
        String op1 = "", op2 = "";
        switch (opt) {
            case "1":
                System.out.print("Ingrese el primer operando: ");
                op1 = sc.nextLine();
                System.out.print("Ingrese el segundo operando: ");
                op2 = sc.nextLine();
                System.out.println(andBitWise(op1.trim(), op2.trim()));
                break;
            case "2":
                System.out.print("Ingrese el primer operando: ");
                op1 = sc.nextLine();
                System.out.println(notBitWise(op1.trim()));
                break;
            case "3":
                System.out.print("Ingrese el primer operando: ");
                op1 = sc.nextLine();
                System.out.print("Ingrese el segundo operando: ");
                op2 = sc.nextLine();
                System.out.println(orBitWise(op1.trim(), op2.trim()));
                break;
            case "4":
                System.out.print("Ingrese el primer operando: ");
                op1 = sc.nextLine();
                System.out.print("Ingrese el segundo operando: ");
                op2 = sc.nextLine();
                System.out.println(xorBitWise(op1.trim(), op2.trim()));
                break;
            default:
                break;
        }
        sc.close();
    }

    /**
     * La operación and me indica que será verdadera o 1
     * sí y solo sí ambos operandos son verdaderos
     * 
     * En la operación bitwise, cada bit de ambos operandos
     * en la misma posición deberá ser 1 para que el resultado
     * de ese bit sea 1. De lo contrario será 0.
     * @param op1
     * @param op2
     * @return
     */
    public static String andBitWise(String op1, String op2) {
        if (op1.length() != op2.length()) {
            return "Lo operandos deben tener la misma longitud";
        }
        String op3 = "";
        for (int i = 0; i < op1.length(); i++) {
            if (op1.charAt(i) == '1' && op2.charAt(i) == '1') {
                op3 += "1";
            } else {
                op3 += "0";
            }
        }
        return op3;
    }

    /***
     * La operación or me indica que será verdadera o 1
     * sí y solo sí al menos un operando es verdadero
     * 
     * En la operación bitwise, al menos un bit de cada operando
     * en la misma posición debe ser 1 para que el resultado
     * de ese bit sea 1. De lo contrario será 0
     * @param op1
     * @param op2
     * @return
     */
    public static String orBitWise(String op1, String op2) {
        if (op1.length() != op2.length()) {
            return "Lo operandos deben tener la misma longitud";
        }
        String op3 = "";
        for (int i = 0; i < op1.length(); i++) {
            if (op1.charAt(i) == '1' || op2.charAt(i) == '1') {
                op3 += "1";
            } else {
                op3 += "0";
            }
        }
        return op3;
    }

    /**
     * La operación not me indica que un operando verdadero
     * será falso, y viceversa
     * 
     * En la operación bitwise, cada bit 1 será 0, y cada bit 0
     * será 1
     * @param op1
     * @return
     */
    public static String notBitWise(String op1) {
        String op3 = "";
        for (int i = 0; i < op1.length(); i++) {
            if (op1.charAt(i) == '1') {
                op3 += "0";
            } else {
                op3 += "1";
            }
        }
        return op3;
    }

    /**
     * La operación xor me indica que verdader o 1
     * sí y solo sí ambos operandos son diferentes.
     * 
     * En la operación bitwise, al menos se verificará que un bit
     * se 1 y el otro 0 para que el resultado
     * de ese bit sea 1. De lo contrario será 0.
     * @param op1
     * @param op2
     * @return
     */
    public static String xorBitWise(String op1, String op2) {
        if (op1.length() != op2.length()) {
            return "Lo operandos deben tener la misma longitud";
        }
        String op3 = "";
        for (int i = 0; i < op1.length(); i++) {
            if ((op1.charAt(i) == '1' && op2.charAt(i) == '0') || op1.charAt(i) == '0' && op2.charAt(i) == '1') {
                op3 += "1";
            } else {
                op3 += "0";
            }
        }
        return op3;
    }
}
