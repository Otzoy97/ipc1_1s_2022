package edu.usac.ipc1.tarea2.cliente;

public class ClienteDialog extends javax.swing.JDialog {

    ClienteTableModel tableModel;

    public ClienteDialog(java.awt.Frame parent, boolean modal, Cliente[] refCliente) {
        super(parent, modal);
        tableModel = new ClienteTableModel(refCliente);
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tableClientes.setModel(this.tableModel);
        jScrollPane1.setViewportView(tableClientes);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable tableClientes;
    // End of variables declaration//GEN-END:variables
}
