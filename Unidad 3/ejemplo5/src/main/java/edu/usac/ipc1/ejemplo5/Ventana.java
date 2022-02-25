package edu.usac.ipc1.ejemplo5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import edu.usac.ipc1.ejemplo5.Curso.Curso;
import edu.usac.ipc1.ejemplo5.Curso.Nota;
import edu.usac.ipc1.ejemplo5.Estudiante.Crear;
import edu.usac.ipc1.ejemplo5.Estudiante.Estudiante;

public class Ventana extends JFrame {

    public Estudiante[] estudiante;
    public Curso[] cursos;

    public Ventana() {
        estudiante = new Estudiante[10];
        cursos = new Curso[10];
        this.init();
    }

    private void init() {
        // Configura el lienzo de la ventana
        GridBagConstraints gridBagConstraints;
        getContentPane().setLayout(new GridBagLayout());
        // Configura la ventana
        setTitle("Asignación de cursos");
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(800, 600));
        // Configura el panel de escritorio
        this.desktopPane = new JDesktopPane();
        this.desktopPane.setBackground(new Color(155, 155, 155));
        this.desktopPane.setDragMode(JDesktopPane.LIVE_DRAG_MODE);
        // Barra de menú
        JMenuBar menuBar = new JMenuBar();
        // Item de barra de menú
        JMenu estudiante = new JMenu("Estudiante");
        JMenu cursos = new JMenu("Cursos");
        // Submenús para estudiante
        JMenuItem crearEstudiante = new JMenuItem("Nuevo...");
        crearEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                agregarInternalFrame(1);
            }
        });
        JMenuItem mostrarEstudiantes = new JMenuItem("Listar");
        mostrarEstudiantes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                listarEstudiante();
            }
        });
        JMenuItem consultarEstudiante = new JMenuItem("Ver notas...");
        // Submenús para cursos
        JMenuItem crearCurso = new JMenuItem("Asignar...");
        crearCurso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                agregarInternalFrame(2);
            }
        });
        JMenuItem colocarNota = new JMenuItem("Colocar nota...");
        colocarNota.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                agregarInternalFrame(3);
            }
        });
        // Agrega submenus a menu estudiante
        estudiante.add(crearEstudiante);
        estudiante.add(mostrarEstudiantes);
        estudiante.add(consultarEstudiante);
        // Agrega submenus a menu cursos
        cursos.add(crearCurso);
        cursos.add(colocarNota);
        // Agrega menus a barra de menú
        menuBar.add(estudiante);
        menuBar.add(cursos);
        // Comportamiento al cerrar ventana
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        // Agrega menú a ventana
        this.setJMenuBar(menuBar);
        // Agrega vista de escritorio a ventana
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        this.add(this.desktopPane, gridBagConstraints);
        pack();
    }

    private void agregarInternalFrame(int option) {
        switch (option) {
            case 1:
                Crear crear = new Crear(this.estudiante);
                desktopPane.add(crear);
                crear.toFront();
                crear.setVisible(true);
                try {
                    crear.setSelected(true);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                break;
            case 2:
                edu.usac.ipc1.ejemplo5.Curso.Asignar cursoCrear = new edu.usac.ipc1.ejemplo5.Curso.Asignar(
                        this.estudiante);
                desktopPane.add(cursoCrear);
                cursoCrear.toFront();
                cursoCrear.setVisible(true);
                try {
                    cursoCrear.setSelected(true);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                break;
            case 3:
                Nota nota = new Nota(this.estudiante);
                desktopPane.add(nota);
                nota.toFront();
                nota.setVisible(true);
                try {
                    nota.setSelected(true);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                break;
        }
    }

    private void formWindowClosing(WindowEvent evt) {
        int res = JOptionPane.showConfirmDialog(this, "¿Desea salir de la aplicación?", "Asignación",
                JOptionPane.YES_NO_CANCEL_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }

    private void listarEstudiante() {
        for (int i = 0; i < estudiante.length; i++) {
            if (estudiante[i] != null) {
                estudiante[i].obtenerDatos();
            }
        }
    }

    public static void main(String args[]) {
        Ventana ventan = new Ventana();
        ventan.setVisible(true);
        // ventan.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // ventan.setLocationRelativeTo(null);
    }

    private JDesktopPane desktopPane;
}
