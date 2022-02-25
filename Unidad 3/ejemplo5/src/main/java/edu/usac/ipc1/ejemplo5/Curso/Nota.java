package edu.usac.ipc1.ejemplo5.Curso;

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

import edu.usac.ipc1.ejemplo5.Estudiante.Estudiante;

public class Nota extends JInternalFrame {

    private Estudiante estudiantes[];

    public Nota(Estudiante[] estudiantes) {
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
        JLabel lblNota = new JLabel("Nota");
        lblNota.setHorizontalAlignment(SwingConstants.CENTER);
        // Inicializa los campos de texto
        this.txtCarnet = new JTextField();
        this.txtCodigo = new JTextField();
        this.txtNota = new JTextField();
        // Inicializa el botón de crear
        this.btnColocarNota = new JButton("Colocar nota");
        // Establece el comportamiento del botón al
        // ser presionado
        this.btnColocarNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                colocarNota();
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
        this.add(lblNota, gridBagConstraints);
        // Agrega campo de texto nombre
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        this.add(txtNota, gridBagConstraints);
        // Agrega boton
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        this.add(btnColocarNota, gridBagConstraints);
        pack();
    }

    private void colocarNota() {
        // busca un espacio vacío para agregar al nuevo estudiante
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null && estudiantes[i].carnet == Integer.parseInt(this.txtCarnet.getText())) {
                // El espacio no es nulo y el carnet del objeto estudiante es igual
                // al carnet especifificado en campo de texto txtCarnet               
                Curso refCurso = estudiantes[i].buscarCurso(Integer.parseInt(this.txtCodigo.getText()));
                if (refCurso != null) {
                    refCurso.colocarNota(Float.parseFloat(this.txtNota.getText()));
                    JOptionPane.showMessageDialog(this, "Nota colocada exitosamente", "Colocar nota", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Este estudiante no tiene asignado ese curso", "Colocar nota", JOptionPane.WARNING_MESSAGE);
                }
                break;
            }
            // El espacio es nulo,
            // seguirá con la siguiente interación
        }
    }

    private JTextField txtCarnet;
    private JTextField txtCodigo;
    private JTextField txtNota;
    private JButton btnColocarNota;
}
