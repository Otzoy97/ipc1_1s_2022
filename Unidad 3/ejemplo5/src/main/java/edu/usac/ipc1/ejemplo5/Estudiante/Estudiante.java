package edu.usac.ipc1.ejemplo5.estudiante;

import edu.usac.ipc1.ejemplo5.curso.Curso;

/**
 *
 * @author otzoy
 */
public class Estudiante {

    public int carnet;
    public String nombre;
    public String apellido;
    public Curso[] cursos;
    
    /**
     * Constructor para Estudiante
     * @param carnet
     * @param nombre
     * @param apellido 
     */
    public Estudiante(int carnet, String nombre, String apellido) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cursos = new Curso[10];
    }

    /**
     * Agregar un curso al arreglo de cursos del estudiante
     *
     * @param curso
     */
    public void asignarCurso(Curso curso) {
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] == null) {
                cursos[i] = curso;
                break;
            }
        }
    }

    /**
     * Imprime en consola los datos del estudiante y los cursos asignados
     */
    public void obtenerDatos() {
        System.out.println(carnet + ": " + apellido + ", " + nombre);
        System.out.println(" -- Cursos asignados --");
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] == null) {
                continue;
            }
            cursos[i].obtenerDatos();
        }
    }

    /**
     * Elimina un curso del arreglo de cursos del estudiante
     *
     * @param codigo
     */
    public void desasignarCurso(int codigo) {
        for (int i = 0; i < 10; i++) {
            if (cursos[i] == null) {
                continue;
            }
            if (cursos[i].codigo == codigo) {
                cursos[i] = null;
                break;
            }
        }
    }

    /**
     * Busca el curso con el código especificado en el 
     * arreglo de cursos del estudiante
     * 
     * Si el curso existe, devuelve una referencia
     * Si no existe, devuelve null
     * @param codigo
     * @return 
     */
    public Curso buscarCurso(int codigo) {
        Curso curso = null;
        for (int i = 0; i < 10; i++) {
            if (cursos[i] == null) {
                continue;
            }
            if (cursos[i].codigo == codigo) {
                curso = cursos[i];
            }
        }
        return curso;
    }
}
