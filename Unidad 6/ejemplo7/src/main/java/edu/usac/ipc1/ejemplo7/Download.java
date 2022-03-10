package edu.usac.ipc1.ejemplo7;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * https://www.baeldung.com/java-download-file
 */
public class Download extends Thread {

    private String url, path;

    public Download(String url, String path) {
        this.url = url;
        this.path = path;
    }

    @Override
    public void run() {
        BufferedInputStream in = null;
        FileOutputStream fOutStream = null;
        try {
            System.out.println("Descarga iniciada " + path);
            in = new BufferedInputStream(new URL(this.url).openStream());
            fOutStream = new FileOutputStream(path);
            byte dBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dBuffer, 0, 1024)) != -1)  {
                fOutStream.write(dBuffer, 0, bytesRead);
            }
            System.out.println("Descarga terminada " + path);
        } catch (IOException ex) {
            System.out.println("No se pudo descargar el archivo " + path);
        }
    }
}
