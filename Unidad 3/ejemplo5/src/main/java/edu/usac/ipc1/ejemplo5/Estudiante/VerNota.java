package edu.usac.ipc1.ejemplo5.estudiante;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VerNota extends JInternalFrame {

    // private Estudiante estudiantes[];
    private VerNotaTableModel modeloTabla;

    public VerNota(Estudiante[] estudiantes) {
        this.modeloTabla = new VerNotaTableModel(estudiantes);
        /// this.estudiantes = estudiantes;
        this.init();
    }

    private void init() {
        // Configura el lienzo de la ventana
        GridBagConstraints gridBagConstraints;
        getContentPane().setLayout(new GridBagLayout());
        // Configura la propiedades de la ventana
        setTitle("Crear estudiante");
        setMinimumSize(new Dimension(250, 200));
        setPreferredSize(new Dimension(500, 400));
        setIconifiable(true);
        setClosable(true);
        setResizable(true);
        setMaximizable(true);
        // Crea los componentes de la ventana
        JLabel lblCarnet = new JLabel("Carnet");
        lblCarnet.setHorizontalAlignment(SwingConstants.CENTER);
        // Configura la tabla
        JScrollPane scp0 = new JScrollPane();
        tableCurso = new JTable();
        // Establece el modelo de datos que usara la tabla
        tableCurso.setModel(this.modeloTabla);
        // Establece el alto de cada fila
        tableCurso.setRowHeight(50);
        // Establece la fuente a usar para desplegar
        // la info en la tabla
        tableCurso.setFont(new java.awt.Font("SansSerif", 0, 12));
        // Hacew que las columnas en la tabla se adapten
        // ocupando proporcionalmente todo el espacio disponible
        tableCurso.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        // Deshabilita la opción de cambiar el orden de las columnas
        tableCurso.getTableHeader().setReorderingAllowed(false);
        // Coloca un "scroll bar" horizontal y vertical para la tabla
        // Esto hará que si la información en la tabla se "desborda"
        // aparezcan barras de desplazamiento abajo y a un costado
        scp0.setViewportView(tableCurso);
        // Configura el campo de texto y el botón
        this.txtCarnet = new JTextField();
        txtCarnet.setFont(new java.awt.Font("SansSerif", 0, 12));
        this.btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new java.awt.Font("SansSerif", 0, 12));
        // Establece el comportamiento del botón al
        // ser presionado
        this.btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                buscarEstudiante();
            }
        });

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.insets = new Insets(10, 10, 0, 10);
        this.add(lblCarnet, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.insets = new Insets(10, 10, 0, 10);
        this.add(txtCarnet, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.insets = new Insets(10, 10, 0, 10);
        this.add(btnBuscar, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        this.add(scp0, gridBagConstraints);
        pack();
    }

    /**
     * Acción que ejecutará el botón Buscar al ser presionado
     */
    private void buscarEstudiante() {
        // Actualiza el modelo de la tabla para visualizar
        // los datos de las notas
        if (this.txtCarnet.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un número de carné", "Ver Notas",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            this.modeloTabla.buscarEstudiante(Integer.parseInt(this.txtCarnet.getText()));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número de carné válido", "Ver Notas",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private JTable tableCurso;
    private JTextField txtCarnet;
    private JButton btnBuscar;
}
