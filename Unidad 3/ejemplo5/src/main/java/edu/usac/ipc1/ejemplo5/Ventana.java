package edu.usac.ipc1.ejemplo5;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Ventana extends JFrame {
    public Ventana() {
        this.setTitle("Asignación de cursos");
        this.init();
    }

    private void init() {
        this.desktopPane = new JDesktopPane();
        // Barra de menú
        JMenuBar menuBar = new JMenuBar();
        // Item de barra de menú
        JMenu estudiante = new JMenu("Estudiante");
        JMenu cursos = new JMenu("Cursos");
        // Submenús para estudiante
        JMenuItem crearEstudiante = new JMenuItem("Nuevo...");
        JMenuItem mostrarEstudiantes = new JMenuItem("Listar");
        JMenuItem consultarEstudiante = new JMenuItem("Ver notas...");
        // Submenús para cursos
        JMenuItem crearCurso = new JMenuItem("Nuevo...");
        JMenuItem mostrarCursos = new JMenuItem("Ver cursos...");
        // Agrega submenus a menu estudiante
        estudiante.add(consultarEstudiante);
        estudiante.add(mostrarEstudiantes);
        estudiante.add(crearEstudiante);
        // Agrega submenus a menu cursos
        cursos.add(mostrarCursos);
        cursos.add(crearCurso);
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
        this.add(this.desktopPane);
    }

    private void formWindowClosing(WindowEvent evt) {
        int res = JOptionPane.showConfirmDialog(this, "¿Desea salir de la aplicación=?", "Asignación",
                JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }

    public static void main(String args[]) {
        Ventana ventan = new Ventana();
        ventan.setVisible(true);
        ventan.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventan.setLocationRelativeTo(null);
    }

    private JDesktopPane desktopPane;
}
