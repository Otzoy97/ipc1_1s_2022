package edu.usac.ipc1.ejemplo5.curso;

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

import edu.usac.ipc1.ejemplo5.estudiante.Estudiante;

public class Asignar extends JInternalFrame {

    private Estudiante estudiantes[];

    public Asignar(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
        this.init();
    }

    private void init() {
        // Configura el lienzo de la ventana
        GridBagConstraints gridBagConstraints;
        getContentPane().setLayout(new GridBagLayout());
        // Configura la propiedades de la ventana
        setTitle("Crear curso");
        setMinimumSize(new Dimension(250, 200));
        setPreferredSize(new Dimension(500, 400));
        setIconifiable(true);
        setClosable(true);
        setResizable(true);
        setMaximizable(true);
        // Crea las etiquetas de la ventana
        JLabel lblCarnet = new JLabel("Carnet");
        lblCarnet.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lblCodigo = new JLabel("Codigo");
        lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lblSeccion = new JLabel("Seccion");
        lblSeccion.setHorizontalAlignment(SwingConstants.CENTER);
        // Inicializa los campos de texto
        this.txtCarnet = new JTextField();
        this.txtNombre = new JTextField();
        this.txtCodigo = new JTextField();
        this.txtSeccion = new JTextField();
        // Inicializa el botón de crear
        this.btnCrear = new JButton("Crear");
        // Establece el comportamiento del botón al 
        // ser presionado
        this.btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                asignarCurso();
            }
        });
        // Agrega etiqueta carnet
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(lblCarnet, gridBagConstraints);
        // Agrega campo de texto carnet
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        this.add(txtCarnet, gridBagConstraints);
        // Agrega etiqueta codigo
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(lblCodigo, gridBagConstraints);
        // Agrega campo de texto codigo
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        this.add(txtCodigo, gridBagConstraints);
        // Agrega etiqueta nombre
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(lblNombre, gridBagConstraints);
        // Agrega campo de texto nombre
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        this.add(txtNombre, gridBagConstraints);
        // Agrega etiqueta seccion
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(lblSeccion, gridBagConstraints);
        // Agrega campo de texto seccion
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        this.add(txtSeccion, gridBagConstraints);
        // Agrega boton
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.insets = new Insets(10,10,10,10);
        this.add(btnCrear, gridBagConstraints);
        pack();
    }


    private void asignarCurso() {
        // busca un espacio vacío para agregar al nuevo estudiante
        boolean cursoSeAsigno = false;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null && estudiantes[i].carnet == Integer.parseInt(this.txtCarnet.getText())) {
                // El espacio no es nulo y el carnet del objeto estudiante es igual
                // al carnet especifificado en campo de texto txtCarnet
                estudiantes[i].asignarCurso(new Curso(Integer.parseInt(txtCodigo.getText()),this.txtNombre.getText(), this.txtSeccion.getText()));
                JOptionPane.showMessageDialog(this, "Curso asignado exitosamente", "Asignar curso", JOptionPane.INFORMATION_MESSAGE);                cursoSeAsigno = true;
                break;
            }
            // El espacio es nulo
            // seguirá con la siguiente interación
        }
        if (!cursoSeAsigno) {
            JOptionPane.showMessageDialog(this, "No existe el estudiante con ese carnet", "Asignar curso", JOptionPane.WARNING_MESSAGE);
        }   
    }

    private JTextField txtCarnet;
    private JTextField txtNombre;
    private JTextField txtCodigo;
    private JTextField txtSeccion;
    private JButton btnCrear;
}
