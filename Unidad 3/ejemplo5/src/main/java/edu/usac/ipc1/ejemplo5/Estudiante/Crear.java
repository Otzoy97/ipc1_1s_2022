package edu.usac.ipc1.ejemplo5.Estudiante;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Crear extends JInternalFrame {

    private Estudiante estudiantes[];

    public Crear(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
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
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lblApellido = new JLabel("Apellido");
        lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
        this.txtNombre = new JTextField();
        this.txtApellido = new JTextField();
        this.txtCarnet = new JTextField();
        this.btnCrear = new JButton("Crear");
        // Establece el comportamiento del botón al
        // ser presionado
        this.btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                agregarEstudiante();
            }
        });

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(lblCarnet, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        this.add(txtCarnet, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(lblNombre, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        this.add(txtNombre, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(lblApellido, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        this.add(txtApellido, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        this.add(btnCrear, gridBagConstraints);

        pack();
    }

    private void agregarEstudiante() {
        // busca un espacio vacío para agregar al nuevo estudiante
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null) {
                // El espacio no es nulo
                // saltará a la siguiente iteración
                continue;
            } else {
                // El espacio es nulo,
                // Creará y colocará un objeto estudiante en ese espacio
                estudiantes[i] = new Estudiante(Integer.parseInt(this.txtCarnet.getText()),
                        this.txtNombre.getText(), this.txtApellido.getText());
                // Informará al usuario del éxito de la operación
                JOptionPane.showMessageDialog(this, "Estudiante agregado exitosamente", "Nuevo", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }

    private JTextField txtCarnet;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JButton btnCrear;
}
