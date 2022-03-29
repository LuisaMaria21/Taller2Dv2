package modelos;

import java.util.*;

public class Figura {
    private String tipo;
    private List<Punto> coordenadas = new ArrayList<>();
    private String colorRelleno;
    private String colorContorno;
    private double tamanioFigura;
    private double tamanioContorno;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(final String tipo) {
        this.tipo = tipo;
    }

    public List<Punto> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(final List<Punto> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public void agregarCoordenada(final Punto coordenada) {
        this.coordenadas.add(coordenada);
    }

    public double getCoordenadaX() {
        return this.coordenadas.get(0).getX();
    }

    public double getCoordenadaY() {
        return this.coordenadas.get(0).getY();
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(final String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public double getTamanioFigura() {
        return tamanioFigura;
    }

    public void setTamanioFigura(final double tamanioFigura) {
        this.tamanioFigura = tamanioFigura;
    }

    public String getColorContorno() {
        return colorContorno;
    }

    public void setColorContorno(final String colorContorno) {
        this.colorContorno = colorContorno;
    }

    public double getTamanioContorno() {
        return tamanioContorno;
    }

    public void setTamanioContorno(final double tamanioContorno) {
        this.tamanioContorno = tamanioContorno;
    }

    @Override
    public String toString() {
        return "Figura{" +
                "tipo='" + tipo + '\'' +
                ", coordenadas=" + coordenadas +
                ", colorRelleno='" + colorRelleno + '\'' +
                ", colorContorno='" + colorContorno + '\'' +
                ", tamanioFigura=" + tamanioFigura +
                ", tamanioContorno=" + tamanioContorno +
                '}';
    }
}
