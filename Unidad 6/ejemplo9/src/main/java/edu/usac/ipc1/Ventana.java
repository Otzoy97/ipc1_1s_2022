package edu.usac.ipc1;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.InputEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.jar.JarEntry;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import edu.usac.ipc1.ordenamiento.Bubblesort;
import edu.usac.ipc1.ordenamiento.Dato;

public class Ventana extends JFrame {

    private JFileChooser selectorDeArchivos;
    private Archivo archivoSeleccionado;
    private volatile JLabel lblArreglo;
    private volatile JLabel lblPasos;
    private volatile JPanel panelLblPasos;
    private volatile Dato[] datos;
    private volatile AtomicBoolean corriendo = new AtomicBoolean(false);
    private volatile AtomicInteger pasos = new AtomicInteger(0);
    private Bubblesort subproceBubblesort;
    /**
     * Cuando el ordenamiento sea ejecutado paso a paso,
     * esta variable servirá para determinar el número de iteración 
     * para el ordenamiento bubblesort
     */
    private int apuntadorPasoAPaso = 0;

    public Ventana() {
        init(); // construye la interfaz gráfica
    }

    /**
     * Despliega un selector de archivo para seleccionar y abrir un archivo
     */
    private void openFile() {
        try {
            selectorDeArchivos = new JFileChooser(archivoSeleccionado.getPath().getParent().toString());
        } catch (Exception ex) {
            if (selectorDeArchivos == null) {
                selectorDeArchivos = new JFileChooser();
            }
        }
        // selectorDeArchivos.setFileFilter(new FileNameExtensionFilter("Documentos de
        // texto (*.txt)", "txt"));
        selectorDeArchivos.setFileSelectionMode(JFileChooser.FILES_ONLY);
        selectorDeArchivos.setMultiSelectionEnabled(false);
        int option = selectorDeArchivos.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            archivoSeleccionado = new Archivo(selectorDeArchivos.getSelectedFile().getAbsolutePath());
        }
    }

    private void cargarDatos() {
        if (archivoSeleccionado != null) {
            this.panelLblPasos.removeAll();
            this.panelLblPasos.validate();
            this.pasos.set(0);
            this.apuntadorPasoAPaso = 0;
            String textoCsv = archivoSeleccionado.leer();
            String[] lineas = textoCsv.split("\n");
            datos = new Dato[lineas.length];
            int contadorDatos = 0;
            String[] datoLinea;
            for (String fila : lineas) {
                if (!fila.isEmpty()) {
                    datoLinea = fila.split(",");
                    try {
                        datos[contadorDatos] = new Dato(datoLinea[0], Long.parseLong(datoLinea[1]));
                        contadorDatos++;
                    } catch (NumberFormatException e) {
                    }
                }
            }
            JOptionPane.showMessageDialog(this, String.format("%d datos cargados", contadorDatos), "Bubblesort",
                    JOptionPane.INFORMATION_MESSAGE);
            lblArreglo.setText(String.format("[ %s ]", Dato.join(datos)));
        } else {
            JOptionPane.showMessageDialog(this, "Primero seleccione un archivo", "Bubblesort",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void ordenarDatos() {
        subproceBubblesort = new Bubblesort();
        subproceBubblesort.start();
    }

    private void pasoAPaso() {
        if (datos == null) {
            return;
        }
        // Esta es la condición de salida del ordenamiento Bubblesort
        if (apuntadorPasoAPaso < datos.length - 1) {
            // Se crea un panel para agregar etiquetas
            // que indiquen los movimientos que se están realizando en el arreglo
            JPanel panel0 = new JPanel();
            panel0.setLayout(new GridLayout(0, 1));
            // Configura un borde al panel para indicar la iteración actual
            panel0.setBorder(new TitledBorder(LineBorder.createBlackLineBorder(),
                    String.format("Iteración No. %d", apuntadorPasoAPaso + 1)));
            // A través de un ciclo-for ordena el arreglo usando
            // el algoritmo Bubblesort 
            for (int j = 0; j < datos.length - apuntadorPasoAPaso - 1; j++) {
                if (datos[j].getValor() > datos[j + 1].getValor()) {
                    Dato ref = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = ref;
                }
                /// Agrega un etiqueta con los datos del arreglo al panel0
                JLabel lbl = new JLabel(String.format("%02d - [ %s ]", j, Dato.join(datos)));
                lbl.setFont(new Font("Courier New", Font.PLAIN, 24));
                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                panel0.add(lbl);
                panel0.validate();
            }
            // Aumenta los pasos
            pasos.incrementAndGet();
            // Agrega el panel al panel principal para
            // que así sean visible los movimientos que se realizaron 
            // durante el ciclo-for
            this.panelLblPasos.add(panel0);
            this.panelLblPasos.validate();
            // Actualizar el número de pasos
            this.lblPasos.setText(String.format("%d pasos", pasos.get()));
            apuntadorPasoAPaso++;
        }
    }

    private void init() {
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gBag;

        /// Se agrega un evento a la ventana
        /// Este evento se ejecutará cada vez que la ventana se quiera cerrar
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                // Al cambiar /corriendo/ a false, detendrá
                // cualquier hilo que dependa de que /corriendo/ sea true
                corriendo.set(false);
                dispose();
            }
        });

        setTitle("Bubblesort");
        setPreferredSize(new Dimension(800, 600));
        setMinimumSize(new Dimension(800, 600));

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Archivo");
        JMenuItem jMenuItem0 = new JMenuItem("Abrir...");
        jMenuItem0.setAccelerator(KeyStroke.getKeyStroke('A', InputEvent.CTRL_DOWN_MASK));
        jMenuItem0.addActionListener(e -> openFile());

        JMenuItem jMenuItem1 = new JMenuItem("Cargar datos");
        jMenuItem1.setAccelerator(KeyStroke.getKeyStroke('L', InputEvent.CTRL_DOWN_MASK + InputEvent.SHIFT_DOWN_MASK));
        jMenuItem1.addActionListener(e -> cargarDatos());

        JMenuItem jMenuItem2 = new JMenuItem("Ordenar");
        jMenuItem2.setAccelerator(KeyStroke.getKeyStroke('R', InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.addActionListener(e -> ordenarDatos());

        JButton btnPaso = new JButton("Paso");
        btnPaso.setFont(new Font("Courier New", Font.PLAIN, 24));
        btnPaso.addActionListener(e -> pasoAPaso());

        jMenu.add(jMenuItem0);
        jMenu.add(jMenuItem1);
        jMenu.add(jMenuItem2);
        jMenuBar.add(jMenu);
        setJMenuBar(jMenuBar);

        lblArreglo = new JLabel("[]");
        lblArreglo.setFont(new Font("Courier New", Font.PLAIN, 18));
        lblArreglo.setHorizontalAlignment(SwingConstants.CENTER);

        lblPasos = new JLabel("0 Pasos");
        lblPasos.setFont(new Font("Courier New", Font.PLAIN, 18));
        lblArreglo.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel01 = new JPanel();
        panel01.setLayout(new GridBagLayout());
        panel01.setBorder(LineBorder.createBlackLineBorder());

        panelLblPasos = new JPanel();
        panelLblPasos.setLayout(new GridLayout(0, 1));

        JScrollPane scp01 = new JScrollPane(panelLblPasos, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scp01.setPreferredSize(new Dimension(700, 500));

        gBag = new GridBagConstraints();
        gBag.gridx = 0;
        gBag.gridy = 0;
        gBag.fill = GridBagConstraints.BOTH;
        gBag.weightx = 1;
        gBag.insets = new Insets(10, 10, 5, 10);
        panel01.add(btnPaso, gBag);

        gBag = new GridBagConstraints();
        gBag.gridx = 0;
        gBag.gridy = 1;
        gBag.fill = GridBagConstraints.BOTH;
        gBag.weightx = 1;
        gBag.insets = new Insets(0, 10, 5, 10);
        panel01.add(lblArreglo, gBag);

        gBag = new GridBagConstraints();
        gBag.gridx = 0;
        gBag.gridy = 2;
        gBag.fill = GridBagConstraints.BOTH;
        gBag.weightx = 1;
        gBag.insets = new Insets(0, 10, 5, 10);
        panel01.add(lblPasos, gBag);

        gBag = new GridBagConstraints();
        gBag.gridx = 0;
        gBag.gridy = 0;
        gBag.fill = GridBagConstraints.HORIZONTAL;
        gBag.weightx = 1;
        gBag.insets = new Insets(10, 10, 10, 10);
        add(panel01, gBag);

        gBag = new GridBagConstraints();
        gBag.gridx = 0;
        gBag.gridy = 1;
        gBag.fill = GridBagConstraints.BOTH;
        gBag.weightx = 1;
        gBag.weighty = 1;
        gBag.insets = new Insets(10, 10, 10, 10);
        add(scp01, gBag);

        pack();
    }

}
