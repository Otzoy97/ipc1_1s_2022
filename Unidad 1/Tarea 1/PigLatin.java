import java.util.Scanner;

public class PigLatin {
    public static void main(String[] args) {
        System.out.println("Ingrese una oración en ingles sin contracciones y sin signos de puntuación");
        System.out.print(">> ");
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String words[] = sentence.toLowerCase().trim().split(" ");
        for (int i = 0; i < words.length; i++) {
            int idx = indexOfFirstVowel(words[i]);
            // Imprime la palabra modificada
            // "Cortará" la palabra, mostrando desde la primera posición de la vocal (incluyendo la vocal),
            // inmediatemente después irá el inicio de la palabra hasta la priemra posición de la vocal (excluyendo la vocal)
            // por último se le agregará la palabra "ay"
            System.out.print(words[i].substring(idx) + words[i].substring(0, idx) + "ay ");
        }
        sc.close();
    }


    /**
     * Buscará el indice de la primera vocal de la palabra
     * @param str palabra
     * @return
     */
    public static int indexOfFirstVowel(String str) {
        // Recorre cada caracter de la palabra
        // buscando una coincidencia con una vocal minúscula
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' 
                    || str.charAt(i) == 'e' 
                    || str.charAt(i) == 'i' 
                    || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u') {
                return i;
            }
        }
        return 0;
    }
}
