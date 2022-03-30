package modelos;

import java.util.*;

/**
 * Clase para guardar cada parte de la figura o sus componentes
 * 
 ** @author andres_fel.acosta@uao.edu.co Andres Felipe Acosta lozada 2201212
 * luisa_maria.cuero@uao.edu.co Luisa María Cuero Ampudia 2195064
 * julieta.lara@uao.edu.co Julieta Lara Romero 2200619
 * juan_fernando.aldana@uao.edu.co Juan Fernando Aldana 2201173
 * @date 29 Marzo 2022
 * @version 1.0
 */

public class Figura {
    private String tipo;
    private List<Punto> coordenadas = new ArrayList<>();
    private String colorRelleno;
    private String colorContorno;
    private double tamanioFigura;
    private double tamanioContorno;

    public Figura(String tipo, String colorRelleno, String colorContorno, double tamanioFigura, double tamanioContorno) {
        this.tipo = tipo;
        this.colorRelleno = colorRelleno;
        this.colorContorno = colorContorno;
        this.tamanioFigura = tamanioFigura;
        this.tamanioContorno = tamanioContorno;
    }

    public Figura() {
    }
    
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Punto> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas( List<Punto> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public void agregarCoordenada( Punto coordenada) {
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

    public void setColorRelleno( String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public double getTamanioFigura() {
        return tamanioFigura;
    }

    public void setTamanioFigura( double tamanioFigura) {
        this.tamanioFigura = tamanioFigura;
    }

    public String getColorContorno() {
        return colorContorno;
    }

    public void setColorContorno( String colorContorno) {
        this.colorContorno = colorContorno;
    }

    public double getTamanioContorno() {
        return tamanioContorno;
    }

    public void setTamanioContorno( double tamanioContorno) {
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
