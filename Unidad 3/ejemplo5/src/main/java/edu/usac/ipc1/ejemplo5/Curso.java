package edu.usac.ipc1.ejemplo5;

/**
 *
 * @author otzoy
 */
public class Curso {
    public int codigo;
    public String nombre;
    public String seccion;
    private float nota;
    
    public Curso(int codigo, String nombre, String seccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.seccion = seccion;
        this.nota = 0f;
    }
    
    /**
     * Setter
     * @param nota 
     */
    public void colocarNota(float nota) {
        this.nota = nota;
    }
    
    /**
     * Getter
     * @return 
     */
    public float obtenerNota() {
        return nota;
    }
    
    /**
     * Imprime en consola los datos del curso
     */
    public void obtenerDatos() {
        System.out.println(codigo + " - " + nombre + " " + seccion + ": " + nota);
    }
}
