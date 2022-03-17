package edu.usac.ipc1.ordenamiento;

public class Dato {
    private String etiqueta;
    private long valor;

    public Dato(String etiqueta, long valor) {
        this.etiqueta = etiqueta;
        this.valor = valor;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public long getValor() {
        return valor;
    }

    public static String join(Dato[] dato) {
        StringBuilder sb = new StringBuilder();
        if (dato != null) {
            for (Dato dato2 : dato) {
                if (dato2 != null) {
                    sb.append(dato2.getValor()).append(", ");
                }
            }
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        return sb.toString();
    }
}
