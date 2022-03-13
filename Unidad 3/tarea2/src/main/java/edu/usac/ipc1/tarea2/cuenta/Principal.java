/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.usac.ipc1.tarea2.cuenta;

import javax.swing.JOptionPane;

import edu.usac.ipc1.tarea2.cliente.Cliente;
import edu.usac.ipc1.tarea2.cliente.ClienteDialog;
import edu.usac.ipc1.tarea2.transferencia.Transferencia;
import edu.usac.ipc1.tarea2.transferencia.TransferenciaTableModel;

/**
 *
 * @author otzoy
 */
public class Principal extends javax.swing.JFrame {

    Cliente[] clientes = new Cliente[10];
    Transferencia[] transferencias = new Transferencia[100];
    CuentaTableModel cuentaTableModel;
    TransferenciaTableModel transTableModel;

    /**
     * Creates new form Principal
     */
    public Principal() {
        cuentaTableModel = new CuentaTableModel(clientes);
        transTableModel = new TransferenciaTableModel(transferencias);
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        dialogCuentas = new javax.swing.JDialog();
        javax.swing.JPanel jPanel4 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        txtCUIBuscarCuenta = new javax.swing.JTextField();
        javax.swing.JButton btnBuscarCuenta = new javax.swing.JButton();
        javax.swing.JPanel jPanel5 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
        txtBuscarNombre = new javax.swing.JTextField();
        txtBuscarApellido = new javax.swing.JTextField();
        javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tableCuentas = new javax.swing.JTable();
        dialogTransferencias = new javax.swing.JDialog();
        javax.swing.JPanel jPanel6 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel13 = new javax.swing.JLabel();
        javax.swing.JButton btnBuscarTransferencias = new javax.swing.JButton();
        txtGUIDTransferencias = new javax.swing.JTextField();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        tableTransferencias = new javax.swing.JTable();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        txtClienteApellido = new javax.swing.JTextField();
        txtClienteCUI = new javax.swing.JTextField();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        txtClienteNombre = new javax.swing.JTextField();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        javax.swing.JButton btnAgregarCliente = new javax.swing.JButton();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        txtCuentCUI = new javax.swing.JTextField();
        txtCuentaMonto = new javax.swing.JTextField();
        javax.swing.JButton btnCrearCuenta = new javax.swing.JButton();
        cmbCuentaTipo = new javax.swing.JComboBox<>();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        txtTransferenciaOrigen = new javax.swing.JTextField();
        txtTransferenciaDestino = new javax.swing.JTextField();
        txtTransferenciaMonto = new javax.swing.JTextField();
        javax.swing.JButton btnTransferir = new javax.swing.JButton();
        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        javax.swing.JMenuItem clientesMenu = new javax.swing.JMenuItem();
        javax.swing.JMenuItem cuentaMenu = new javax.swing.JMenuItem();
        javax.swing.JMenuItem transferenciaMenu = new javax.swing.JMenuItem();

        dialogCuentas.setTitle("Consultar cuentas de cliente");
        dialogCuentas.setMinimumSize(new java.awt.Dimension(300, 300));
        dialogCuentas.setPreferredSize(new java.awt.Dimension(800, 300));
        dialogCuentas.getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel10.setText("CUI");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(jLabel10, gridBagConstraints);

        txtCUIBuscarCuenta.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel4.add(txtCUIBuscarCuenta, gridBagConstraints);

        btnBuscarCuenta.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnBuscarCuenta.setText("Buscar");
        btnBuscarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCuentaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(btnBuscarCuenta, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        dialogCuentas.getContentPane().add(jPanel4, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel12.setBackground(new java.awt.Color(204, 255, 204));
        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 9)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Apellido");
        jLabel12.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel5.add(jLabel12, gridBagConstraints);

        txtBuscarNombre.setEditable(false);
        txtBuscarNombre.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel5.add(txtBuscarNombre, gridBagConstraints);

        txtBuscarApellido.setEditable(false);
        txtBuscarApellido.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel5.add(txtBuscarApellido, gridBagConstraints);

        jLabel11.setBackground(new java.awt.Color(204, 255, 204));
        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 9)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Nombre");
        jLabel11.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel5.add(jLabel11, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        dialogCuentas.getContentPane().add(jPanel5, gridBagConstraints);

        tableCuentas.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tableCuentas.setModel(cuentaTableModel);
        tableCuentas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableCuentas.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tableCuentas);
        tableCuentas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        dialogCuentas.getContentPane().add(jScrollPane1, gridBagConstraints);

        dialogTransferencias.setTitle("Transferencias de una cuenta");
        dialogTransferencias.setMinimumSize(new java.awt.Dimension(300, 300));
        dialogTransferencias.setPreferredSize(new java.awt.Dimension(1000, 300));
        dialogTransferencias.getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel13.setText("GUID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel6.add(jLabel13, gridBagConstraints);

        btnBuscarTransferencias.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnBuscarTransferencias.setText("Buscar");
        btnBuscarTransferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTransferenciasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel6.add(btnBuscarTransferencias, gridBagConstraints);

        txtGUIDTransferencias.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel6.add(txtGUIDTransferencias, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        dialogTransferencias.getContentPane().add(jPanel6, gridBagConstraints);

        tableTransferencias.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tableTransferencias.setModel(this.transTableModel);
        tableTransferencias.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableTransferencias.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tableTransferencias);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        dialogTransferencias.getContentPane().add(jScrollPane2, gridBagConstraints);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Entidad bancaria");
        setMinimumSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Crear cliente", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        txtClienteApellido.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(txtClienteApellido, gridBagConstraints);

        txtClienteCUI.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(txtClienteCUI, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel8.setText("Apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel1.add(jLabel8, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel6.setText("CUI");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel1.add(jLabel6, gridBagConstraints);

        txtClienteNombre.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(txtClienteNombre, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel7.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel1.add(jLabel7, gridBagConstraints);

        btnAgregarCliente.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAgregarCliente.setText("Agregar");
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel1.add(btnAgregarCliente, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Crear cuenta", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setText("CUI");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setText("Tipo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setText("Monto inicial");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(jLabel3, gridBagConstraints);

        txtCuentCUI.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel2.add(txtCuentCUI, gridBagConstraints);

        txtCuentaMonto.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel2.add(txtCuentaMonto, gridBagConstraints);

        btnCrearCuenta.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCrearCuenta.setText("Crear cuenta");
        btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(btnCrearCuenta, gridBagConstraints);

        cmbCuentaTipo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbCuentaTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monetaria", "Ahorro" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel2.add(cmbCuentaTipo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Transferir", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setText("Origen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setText("Destino");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(jLabel5, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel9.setText("Monto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(jLabel9, gridBagConstraints);

        txtTransferenciaOrigen.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel3.add(txtTransferenciaOrigen, gridBagConstraints);

        txtTransferenciaDestino.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel3.add(txtTransferenciaDestino, gridBagConstraints);

        txtTransferenciaMonto.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel3.add(txtTransferenciaMonto, gridBagConstraints);

        btnTransferir.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnTransferir.setText("Transferir");
        btnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel3.add(btnTransferir, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jPanel3, gridBagConstraints);

        jMenu1.setText("Consultar");

        clientesMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        clientesMenu.setText("Clientes...");
        clientesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesMenuActionPerformed(evt);
            }
        });
        jMenu1.add(clientesMenu);

        cuentaMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cuentaMenu.setText("Cuentas...");
        cuentaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuentaMenuActionPerformed(evt);
            }
        });
        jMenu1.add(cuentaMenu);

        transferenciaMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        transferenciaMenu.setText("Transferencias...");
        transferenciaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferenciaMenuActionPerformed(evt);
            }
        });
        jMenu1.add(transferenciaMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        if (this.txtClienteCUI.getText().isBlank() || this.txtClienteNombre.getText().isBlank()
                || this.txtClienteApellido.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "LLene todos los campos", "Entidad bancaria - crear cliente",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        for (int i = 0; i < this.clientes.length; i++) {
            if (this.clientes[i] == null) {
                this.clientes[i] = new Cliente(this.txtClienteCUI.getText().trim(),
                        this.txtClienteNombre.getText().trim(), this.txtClienteApellido.getText().trim());
                break;
            } else {
                if (this.clientes[i].getCUI().equalsIgnoreCase(this.txtClienteCUI.getText().trim())) {
                    JOptionPane.showMessageDialog(this, "No se admiten CUI repetidos",
                            "Entidad bancaria - crear cliente", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(this, "Cliente creado", "Entidad bancaria - crear cliente",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaActionPerformed
        if (this.txtCuentCUI.getText().isBlank() || this.txtCuentaMonto.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "LLene todos los campos", "Entidad bancaria - crear cuenta",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        for (int i = 0; i < this.clientes.length; i++) {
            if (this.clientes[i] != null && this.clientes[i].getCUI().equals(this.txtCuentCUI.getText().trim())) {
                try {
                    Double monto = Double.parseDouble(this.txtCuentaMonto.getText().trim());
                    if (monto < 100) {
                        JOptionPane.showMessageDialog(this, "El monto debe ser mayor o igual a 100", "Crear cuenta",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    this.clientes[i].addCuenta(new Cuenta(this.cmbCuentaTipo.getSelectedItem().toString(), monto));
                    JOptionPane.showMessageDialog(this, "Cuenta creada", "Entidad bancaria - crear cuenta",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "El monto debe ser un número", "Crear cuenta",
                            JOptionPane.ERROR_MESSAGE);
                }

                break;
            }
        }
    }//GEN-LAST:event_btnCrearCuentaActionPerformed


    private void cuentaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuentaMenuActionPerformed
        dialogCuentas.setVisible(true);
    }//GEN-LAST:event_cuentaMenuActionPerformed

    private void btnBuscarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCuentaActionPerformed
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null && clientes[i].getCUI().equals(this.txtCUIBuscarCuenta.getText().trim())) {
                this.txtBuscarNombre.setText(clientes[i].getNombre());
                this.txtBuscarApellido.setText(clientes[i].getApellido());
                this.cuentaTableModel.updateCuentas(this.txtCUIBuscarCuenta.getText().trim());
            }
        }
    }//GEN-LAST:event_btnBuscarCuentaActionPerformed

    private void clientesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesMenuActionPerformed
        new ClienteDialog(this, true, clientes).setVisible(true);
    }//GEN-LAST:event_clientesMenuActionPerformed

    private void btnTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirActionPerformed
        if (this.txtTransferenciaDestino.getText().isBlank() || this.txtTransferenciaMonto.getText().isBlank()
                || this.txtTransferenciaOrigen.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "LLene todos los campos", "Entidad bancaria - transferir",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        Double monto = null;
        try {
            monto = Double.parseDouble(this.txtTransferenciaMonto.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El campo de monto debe ser un número válido", "Entidad bancaria - transferir",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (monto == null || monto <= 0) {
            JOptionPane.showMessageDialog(this, "El campo de monto debe ser mayor a 1", "Entidad bancaria - transferir",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        Cuenta origen = null, destino = null;
        for (int i = 0; i < this.clientes.length; i++) {
            if (this.clientes[i] != null) {
                origen = this.clientes[i].findCuenta(this.txtTransferenciaOrigen.getText().trim());
                if (origen != null) {
                    break;
                }
            }
        }
        for (int i = 0; i < this.clientes.length; i++) {
            if (this.clientes[i] != null) {
                destino = this.clientes[i].findCuenta(this.txtTransferenciaDestino.getText().trim());
                if (destino != null) {
                    break;
                }
            }
        }
        if (origen == null) {
            JOptionPane.showMessageDialog(this, "La cuenta de origen no existe", "Entidad bancaria - transferir",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (destino == null) {
            JOptionPane.showMessageDialog(this, "La cuenta de destino no existe", "Entidad bancaria - transferir",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (origen.getFondos().compareTo(monto) < 0) {
            JOptionPane.showMessageDialog(this, "La cuenta de origen no tiene los fondos suficientes para completar la transferencia", "Entidad bancaria - transferir",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        for (int i = 0; i < this.transferencias.length; i++) {
            if (this.transferencias[i] == null) {
                this.transferencias[i] = new Transferencia(origen.getGuid(), destino.getGuid(), monto.doubleValue());
                origen.addFondos(-monto);
                destino.addFondos(monto);
                JOptionPane.showMessageDialog(this, "Transferencia exitosa", "Entidad bancaria - transferir",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }//GEN-LAST:event_btnTransferirActionPerformed

    private void transferenciaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferenciaMenuActionPerformed
        dialogTransferencias.setVisible(true);
    }//GEN-LAST:event_transferenciaMenuActionPerformed

    private void btnBuscarTransferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTransferenciasActionPerformed
        this.transTableModel.updateTransferencias(this.txtGUIDTransferencias.getText().trim());
    }//GEN-LAST:event_btnBuscarTransferenciasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCuentaTipo;
    private javax.swing.JDialog dialogCuentas;
    private javax.swing.JDialog dialogTransferencias;
    private javax.swing.JTable tableCuentas;
    private javax.swing.JTable tableTransferencias;
    private javax.swing.JTextField txtBuscarApellido;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextField txtCUIBuscarCuenta;
    private javax.swing.JTextField txtClienteApellido;
    private javax.swing.JTextField txtClienteCUI;
    private javax.swing.JTextField txtClienteNombre;
    private javax.swing.JTextField txtCuentCUI;
    private javax.swing.JTextField txtCuentaMonto;
    private javax.swing.JTextField txtGUIDTransferencias;
    private javax.swing.JTextField txtTransferenciaDestino;
    private javax.swing.JTextField txtTransferenciaMonto;
    private javax.swing.JTextField txtTransferenciaOrigen;
    // End of variables declaration//GEN-END:variables
}
