package edu.usac.ipc1.tarea2.transferencia;

import java.text.SimpleDateFormat;

import javax.swing.table.AbstractTableModel;

public class TransferenciaTableModel extends AbstractTableModel {

    private String[] nombreColumnas = { "Origen", "Destino", "Fecha", "Monto" };
    private Transferencia[] refTransferencias;
    private Transferencia[] filterTransferencias;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public TransferenciaTableModel(Transferencia[] r) {
        this.refTransferencias = r;
    }

    public void updateTransferencias(String guid) {
        if (refTransferencias != null) {
            this.filterTransferencias = new Transferencia[this.refTransferencias.length];
            int idxFilterTransferencias = 0;
            for (int i = 0; i < refTransferencias.length; i++) {
                if (refTransferencias[i] != null && (refTransferencias[i].getGuidOrigen().equals(guid)
                        || refTransferencias[i].getGuidDestino().equals(guid))) {
                    filterTransferencias[idxFilterTransferencias++] = refTransferencias[i];
                }
            }
        }
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int contador = 0;
        if (filterTransferencias != null) {
            for (int i = 0; i < filterTransferencias.length; i++) {
                if (filterTransferencias[i] != null) {
                    contador++;
                }
            }
        }
        return contador;
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 1:
                return refTransferencias[rowIndex].getGuidOrigen();
            case 2:
                return refTransferencias[rowIndex].getGuidDestino();
            case 3:
                return dateFormat.format(refTransferencias[rowIndex].getFecha());
            case 4:
                return String.format("Q. %,.2f", refTransferencias[rowIndex].getMonto());
        }
        return "";
    }

}
