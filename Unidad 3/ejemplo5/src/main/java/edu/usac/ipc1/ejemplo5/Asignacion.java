package edu.usac.ipc1.ejemplo5;

/**
 *
 * @author otzoy
 */
public class Asignacion {

    //public static Estudiante estudiante;

    public static void main(String args[]) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String entrada_usuario;
        System.out.println("Ingrese sus datos separados por comas");
        entrada_usuario = sc.nextLine();
        // El programa esperara una cadena
        // de la forma: carnet,nombre,apellido
        // Si no, el programa fallará
        // NullPointerException
        String[] datosBrutos = entrada_usuario.split(",");
        Estudiante estudiante = new Estudiante(Integer.parseInt(datosBrutos[0]), datosBrutos[1], datosBrutos[2]);
        // Se pedirá al usuario que seleccione una opción
        boolean mostrar_menu = true;
        do {
            System.out.println("Asignar cursos");
            System.out.println("1. Asignar nuevo curso");
            System.out.println("2. Desasignar curso");
            System.out.println("3. Listar cursos");
            entrada_usuario = sc.nextLine();
            switch (entrada_usuario) {
                case "1":
                    System.out.println("Especifique los datos del curso");
                    // Se espera una cadena de la forma codigo,nombre,seccion
                    entrada_usuario = sc.nextLine();
                    datosBrutos = entrada_usuario.split(",");
                    estudiante.asignarCurso(new Curso(Integer.parseInt(datosBrutos[0]), datosBrutos[1], datosBrutos[2]));
                    break;
                case "2":
                    System.out.println("Especifique el código del curso");
                    entrada_usuario = sc.nextLine();
                    Curso curso = estudiante.buscarCurso(Integer.parseInt(entrada_usuario));
                    if (curso == null) {
                        System.out.println("El estudiante no tiene asignado este curso");
                    } else {
                        System.out.println("Se desasignará el curso con los datos: ");
                        curso.obtenerDatos();
                        estudiante.desasignarCurso(Integer.parseInt(entrada_usuario));
                        System.out.println("-- CURSO DESASIGNADO --");
                    }
                    break;
                case "3":
                    estudiante.obtenerDatos();
                    System.out.println("-- ÚLTIMA LINEA --");
                    break;
                case "4":
                    mostrar_menu = false;
                    break;
            }
        } while (mostrar_menu);
    }
}
