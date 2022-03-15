package edu.usac.ipc1.ejemplo8;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.InputEvent;

import javax.swing.BorderFactory;
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
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Editor extends JFrame {
    private JTextArea txtContent;
    private boolean isSaved = false;
    private Archivo archivo;
    private JFileChooser fileChooser;
    private JButton play_stop;
    // OJO, si se trabajan con varios hilos y esos hilos
    // manipulan las mismas variables, es importante declarar
    // las variables con la palabra reservada "volatile".
    // Por ejemplo, acá se declararon JLabel's en volatile
    // porque el valor de esas variables (objetos) serán
    // manipulados desde diferentes hilos.

    // Etiquetas que se actualizarán
    // desde otros subprocesos
    private volatile JLabel lblPalabrasValor;
    private volatile JLabel lblPalabraPorMinutoValor;
    private volatile JLabel lblCronometroValor;
    private volatile Long miliSeconds = 0l;
    // Indicará si los subprocesos estarán corriendo
    public static volatile Boolean running = false;

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.setVisible(true);
        editor.setLocationRelativeTo(null);
    }

    public Editor() {
        init();
    }

    private void init() {
        setTitle("Editor de texto");
        setMinimumSize(new java.awt.Dimension(800, 600));
        /// Se agrega un evento a la ventana
        /// Este evento se ejecutará cada vez que la ventana
        /// se cierre
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                running = false;
                dispose();
            }
        });
        GridBagConstraints gridBagConstraints;
        getContentPane().setLayout(new GridBagLayout());

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Archivo");
        JMenuItem jMenuItem0 = new JMenuItem("Abrir...");
        jMenuItem0.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
        jMenuItem0.addActionListener(e -> openFile());
        JMenuItem jMenuItem1 = new JMenuItem("Guardar");
        jMenuItem1.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.addActionListener(e -> save());
        JMenuItem jMenuItem2 = new JMenuItem("Guardar como...");
        jMenuItem2.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK + InputEvent.SHIFT_DOWN_MASK));
        jMenuItem2.addActionListener(e -> saveFileAs());

        jMenu.add(jMenuItem0);
        jMenu.add(jMenuItem1);
        jMenu.add(jMenuItem2);
        jMenuBar.add(jMenu);
        setJMenuBar(jMenuBar);

        JPanel panel0 = new JPanel();
        panel0.setLayout(new GridBagLayout());

        JLabel lblPalabras = new JLabel("Palabras");
        lblPalabras.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 12));
        JLabel lblPalabraPorMinuto = new JLabel("Palabras/minuto");
        lblPalabraPorMinuto.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 12));
        JLabel lblCronometro = new JLabel("Cronometro");
        lblCronometro.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 12));
        play_stop = new JButton("Play/Stop");
        play_stop.addActionListener(e -> playAndStopThreads());

        lblPalabrasValor = new JLabel("0");
        lblPalabrasValor.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 12));
        lblPalabraPorMinutoValor = new JLabel("0");
        lblPalabraPorMinutoValor.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 12));
        lblCronometroValor = new JLabel("00:00.000");
        lblCronometroValor.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 12));

        txtContent = new JTextArea();
        txtContent.setFont(new Font("Courier New", Font.PLAIN, 12));
        txtContent.setWrapStyleWord(true);
        txtContent.setLineWrap(true);
        txtContent.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JScrollPane scp0 = new JScrollPane(txtContent);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panel0.add(lblPalabras, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        gridBagConstraints.weightx = 1;
        panel0.add(lblPalabrasValor, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panel0.add(lblPalabraPorMinuto, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        gridBagConstraints.weightx = 1;
        panel0.add(lblPalabraPorMinutoValor, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panel0.add(lblCronometro, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        gridBagConstraints.weightx = 1;
        panel0.add(lblCronometroValor, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        panel0.add(play_stop, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        panel0.add(scp0, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        add(panel0, gridBagConstraints);

    }

    /**
     * Esta función se ejecutará al presionar el botón "Play/Stop"
     */
    private void playAndStopThreads() {
        // Si running es false, iniciará un nuevo hilo
        if (!Editor.running) {
            // Asigna runnig true para que el while
            // dentro de la función run de Cronometro, no termine
            // y mantener vivo el hilo
            Editor.running = true;
            // El cronometro comenzará en 0 milisegundos
            this.miliSeconds = 0l;
            // Ejecuta el subproceso (hilo) Cronometro concurrentemente
            new Cronometro(this.miliSeconds, this.lblCronometroValor).start();
        } else {
            // Si running es true, asignará un false
            // haciendo que el while que se ejecuta en la función
            // run the Cronometro terminé y por consiguiente
            // el hilo de Cronometro finalice.
            Editor.running = false;
        }
    }

    /**
     * Guarda el contenido del editor en un archivo nuevo
     */
    private void saveFileAs() {
        try {
            fileChooser = new JFileChooser(archivo.getPath().getParent().toString());
        } catch (Exception ex) {
            if (fileChooser == null) {
                fileChooser = new JFileChooser();
            }
        }
        fileChooser.setFileFilter(new FileNameExtensionFilter("Documentos de texto (*.txt)", "txt"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            archivo = new Archivo(fileChooser.getSelectedFile().getAbsolutePath() + ".txt");
            archivo.crear();
            String msg = archivo.escribir(this.txtContent.getText());
            JOptionPane.showMessageDialog(this, msg, "Editor", JOptionPane.INFORMATION_MESSAGE);
            isSaved = true;
        }
    }

    /**
     * Guarda los cambios en el archivo de texto seleccionado
     */
    private void save() {
        if (!this.isSaved) {
            this.saveFileAs();
        } else {
            String msg = archivo.escribir(this.txtContent.getText());
            JOptionPane.showMessageDialog(this, msg, "Editor", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Despliega un selector de archivo para seleccionar y abrir un archivo
     */
    private void openFile() {
        try {
            fileChooser = new JFileChooser(archivo.getPath().getParent().toString());
        } catch (Exception ex) {
            if (fileChooser == null) {
                fileChooser = new JFileChooser();
            }
        }
        fileChooser.setFileFilter(new FileNameExtensionFilter("Documentos de texto (*.txt)", "txt"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            archivo = new Archivo(fileChooser.getSelectedFile().getAbsolutePath());
            this.txtContent.setText(archivo.leer());
            isSaved = true;
        }
    }
}
