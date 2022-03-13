package edu.usac.ipc1.tarea2.cliente;

import javax.swing.table.AbstractTableModel;

public class ClienteTableModel extends AbstractTableModel {

    private String[] nombreColumnas = {"CUI", "Nombre", "Apellido"};
    private Cliente[] referenciaAClientes;

    public ClienteTableModel(Cliente[] ref) {
        this.referenciaAClientes = ref;
    }

    @Override
    public int getRowCount() {
        if (referenciaAClientes == null) {
            return 0;
        }
        int contador = 0;
        for (int i = 0 ;  i < this.referenciaAClientes.length ; i++) {
            if (this.referenciaAClientes[i] != null) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public String getColumnName(int index) {
        return nombreColumnas[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.referenciaAClientes[rowIndex].getCUI();
            case 1:
                return this.referenciaAClientes[rowIndex].getNombre();
            case 2:
                return this.referenciaAClientes[rowIndex].getApellido();
        }
        return "";
    }

}
