package edu.usac.ipc1.ejemplo5.estudiante;

import javax.swing.table.AbstractTableModel;

/**
 * Esta clase funciona como el modelo de dato que usará
 * la tabla que se visualiza en el JInternalFrame VerNota
 * 
 * Esta clase hereda de AbstractTableModel
 */
public class VerNotaTableModel extends AbstractTableModel {

    // Especifica las columnas que usará el modelo
    private final String[] columnas = { "Curso", "Nombre", "Sección", "Nota" };
    // Referencia al estudiante cuyos datos están siendo
    // visualizados en la tabla
    private Estudiante infoEstudiante;
    // Referencia al listado total de estudiantes
    private Estudiante[] refEstudiantes;

    /**
     * Constructor por defecto para VerNotaTableModel
     * @param refEstudiantes referencia de arreglo de estudiantes
     */
    public VerNotaTableModel(Estudiante[] refEstudiantes) {
        this.refEstudiantes = refEstudiantes;
    }

    /**
     * Ejecuta una busqueda sobre el arreglo refEstudiantes
     * 
     * Si se encuentra un estudiante con el carnet especificado, ese
     * valor estára referenciado en infoEstudiante
     * @param carnet número de carnet
     */
    public void buscarEstudiante(int carnet) {
        // Recorre el arreglo refEstudiantes
        for (int i = 0; i < refEstudiantes.length; i++) {
            // Busca una coincidencia
            if (refEstudiantes[i] != null && refEstudiantes[i].carnet == carnet) {
                // Si encuentra una coincidencia
                // infoEstudiante tomará la referencia
                this.infoEstudiante = this.refEstudiantes[i];
                // Le indica a la tabla que debe "redibujarse"
                // para actualizar la información que está mostrando
                fireTableDataChanged();
                break;
            }
        }
    }

    /**
     * Devuelve el conteo de filas
     * 
     * Esta función es usado por la vista de tabla para decidir cuantas
     * filas deberá renderizar
     */
    @Override
    public int getRowCount() {
        int count = 0;
        if (infoEstudiante == null) {
            return 0;
        }
        for (int i = 0; i < infoEstudiante.cursos.length; i++) {
            if (infoEstudiante.cursos[i] != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Devuelve el conteo de columnas
     * 
     * Esta función es usada por la vista de tabla para decidir cuantas
     * columnas deberá renderizar
     */
    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    /**
     * Devuelve el nombre de las columnas
     * 
     * Esta función es usada por la vista de tabla para decidir que
     * título usar en cada columna
     */
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    /**
     * Devuelve el valor para cada celda de la tabla
     * 
     * Esta función es usada por la vista de tabla para decidir que
     * valor mostrar en cada celda de la tabla
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return infoEstudiante.cursos[rowIndex].codigo + "";
            case 1:
                return infoEstudiante.cursos[rowIndex].nombre + "";
            case 2:
                return infoEstudiante.cursos[rowIndex].seccion + "";
            case 3:
                return infoEstudiante.cursos[rowIndex].obtenerNota() + "";
        }
        return null;
    }

}
