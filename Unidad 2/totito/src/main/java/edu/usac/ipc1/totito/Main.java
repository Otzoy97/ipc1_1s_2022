package edu.usac.ipc1.totito;

/**
 * (1) Al iniciar el juego se asignar una figura al jugador "humano"
 * (2) El jugador humano indica la celda en donde quiere iniciar 
 * (3) Luego de esta acción, la máquina aleatoriamente colocará su figura en alguna celda vacía
 * (4) La acción 2 y 3 se repetirá hasta que todas las celdas estén llenas o
 *     hasta que haya una columna o fila que contenga tres figuras iguales consecutivas
 * (5) Una vez finalizado el juego comenzará un nuevo juego
 * @author otzoy
 */
public class Main {
    
    
    public static int humano;
    public static int maquina;
    public static int[][] tablero = new int[3][3];
    
    public static void main(String args[]) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String entrada_usuario;
        /// Se iniciará mostrando el tablero
        /// Se indicará al usuario cuál es su figura
        /// Se pedira que ingrese un par ordenado que indique
        /// la posición de su figura
        /// Se actualizará el tablero con la figura de la máquina ya colocada
        /// Se realizará estas acciones hasta que todo el tablero esté lleno
        /// O hayan 3 figuras consecutivas en una fila o columna
        imprimir();
        asignarFigura();
        System.out.println("Su figura es: " + (humano == 2 ? "O" : "X"));
        while(contarEspaciosVacios() > 0) {
            System.out.print("Indique la posición: "); //x,y
            entrada_usuario = sc.nextLine();
            if (traducirEntrada(entrada_usuario)){
                imprimir();
                if(determinarGanador(humano)) {
                    System.out.println("El humano ha ganado");
                    break;
                }
                // Mueve la máquina
                if (contarEspaciosVacios() > 0) {
                    moverPc();
                    imprimir(); 
                    if(determinarGanador(maquina)) {
                        System.out.println("La máquina ha ganado");
                        break;
                    }
                }  
            }
            
        }
    }
    
    /**
     * Verifica que toda una fila o toda una columna
     * tenga la mimsa figura
     * @param figura
     * @return 
     */
    public static boolean determinarGanador(int figura) {
        for (int i = 0 ; i < 3 ; i++) {
            if (tablero[i][0] == figura && 
                    tablero[i][1] == figura && 
                    tablero [i][2] == figura) {
                return true;
            }
        }
        for (int i = 0 ; i < 3 ; i++) {
            if (tablero[0][i] == figura && 
                    tablero[1][i] == figura && 
                    tablero [2][i] == figura) {
                return true;
            }
        }
        for (int i = 0; i < 3 ; i++) {
            
        }
        return false;
    }
    
    /**
     * Convierte la entrada del usuario a una coordenada
     * que indicará donde colocar la figura del usuario
     * @param str 
     * @return
     */
    public static boolean traducirEntrada(String str) {
        // Elimina los espacios al inicio de la cadena
        // y al final de la cadena
        str = str.trim();
        // Separando las coordenadas
        String[] parOrdenado = str.split(",");
        // Intenta convertir la entrada del usuario
        try {
            int posX = Integer.parseInt(parOrdenado[0]);
            int posY = Integer.parseInt(parOrdenado[1]);
            // Hay espacios aún?
            if (contarEspaciosVacios() > 0) {
                // La coordenada dada por el usuario
                // está vacía?
                if (esVacio(posX, posY)) {
                    // Colocar figura
                    colocarFigura(humano, posX, posY);
                } else {
                    // Informar al usuario que esa posición
                    // ya está tomada
                    System.out.println("Esa posición ya está tomada");
                    return false;
                }
            } else {
                // Informar al usuario que no hay espacios disponibles
                System.out.println("No hay espacios vacíos");
                return false;
            }
        } catch (Exception ex) {
            System.out.println("La entrada del usuario no es válida");
            return false;
        }
        return true;
    }
    
    /**
     * Coloca una figura en el tablero
     * @param figura numero que representa una figura 
     * @param posX posición en X
     * @param posY posición en Y
     */
    public static void colocarFigura(int figura, int posX, int posY) {
        tablero[posX][posY] = figura;
    }
    
    /**
     * Al inicio del juego, usará una probabilidad para 
     * determinar la figura del humano y la figura de la máquina
     */
    public static void asignarFigura() {
        int prob = (int) (Math.random() * 99 + 1);
        if (prob < 50) { 
            // asignar O a humano
            humano = 1;
            maquina = 2;
        } else {
            humano = 1;
            maquina = 2;
        }
    }
    
    /**
     * Esta función simulará que la máquina
     * coloca una figura en una posición del tablero
     * 
     * Usará dos probabilidades, 
     * Una para determinar aleatoriamente la posición de la fila
     * Otra para determinar aleatoriamente la posición de la columna
     */
    public static void moverPc() {
        int probX = 0; // = (int) (Math.random()*3 + 1);
        int probY = 0; // = (int)
        do {
            // Buscará un espacio vacío
            // para colocar la figura de la máquina
            probX = (int) (Math.random()*3); //0 - 2
            probY = (int) (Math.random()*3); //0 - 2
        } while(!esVacio(probX, probY));
        // Coloca el número que representa
        // la figura de la máquina
        colocarFigura(maquina, probX, probY);
    }
    
    /**
     * Determina si un espacio del tablero es vacío
     * @param x posición "X" del arreglo
     * @param y posicion "Y" del arreglo
     * @return 
     */
    public static boolean esVacio(int x, int y) {
        if (tablero[x][y] != 0) {
            // Todo arreglo de enteros
            // es inicializado con 0
            // En el tablero solo pueden existir 3 números
            // 0, 1 y 2. Siendo 1 y 2 la representación
            // de las figuras que usa el humano y la máquina
            return false;
        }
        return true;
    }
    
    /**
     * Determinará el número de espacios vacios con los
     * que cuenta el tablero aún
     * @return 
     */
    public static int contarEspaciosVacios() {
        int ctx = 0;
        for (int i = 0 ; i < tablero.length ; i++) {
            for (int j = 0 ; j < tablero[0].length; j++){
                if (tablero[i][j] == 0) {
                    ctx++;
                }
            }
        }
        return ctx;
    }
    
    /**
     * Imprimirá el tablero del totito
     * 
     * Usará como referencia los número almacenado en el arreglo
     * Esos números le indicarán que figura deberá imprimir esta función
     */
    public static void imprimir() {
        for (int i = 0 ; i < tablero.length ; i++) {
            for (int j = 0 ; j < tablero[0].length; j++){
                if (tablero[i][j] == 1) {
                    System.out.print(" X ");
                } else if (tablero[i][j] == 2) {
                    System.out.print(" O ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println("");
        }
        System.out.println("---------------");
    }
    
}
