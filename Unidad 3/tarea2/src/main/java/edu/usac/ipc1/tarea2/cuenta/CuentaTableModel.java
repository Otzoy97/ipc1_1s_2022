package edu.usac.ipc1.tarea2.cuenta;

import javax.swing.table.AbstractTableModel;

import edu.usac.ipc1.tarea2.cliente.Cliente;

public class CuentaTableModel extends AbstractTableModel {

    private String[] nombreColumnas = {"GUID", "Tipo", "Monto"};
    private Cliente[] refClientes;
    private Cuenta[] refCuentas;

    public CuentaTableModel(Cliente[] c) {
        this.refClientes = c;
    }

    public void updateCuentas(String CUI) {
        if (refClientes != null) {
            for (int i = 0; i < refClientes.length ; i++) {
                if (refClientes[i] != null && refClientes[i].getCUI().equals(CUI))  {
                    refCuentas = refClientes[i].getCuentas();
                    fireTableDataChanged();
                }
            }
        }
    }
    
    @Override
    public int getRowCount() {
        if (refCuentas == null) {
            return 0;
        }
        int contador = 0;
        for (int i = 0; i < this.refCuentas.length; i++) {
            if (this.refCuentas[i] != null) {
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
                return this.refCuentas[rowIndex].getGuid();
            case 1:
                return this.refCuentas[rowIndex].getTipo();
            case 2:
                return String.format("Q. %,.2f", refCuentas[rowIndex].getFondos());
        }
        return "";
    }
}
