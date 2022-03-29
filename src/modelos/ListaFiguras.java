package modelos;

import java.util.List;

// Esta clase es necesaria para poder guardar el archivo XML
public class ListaFiguras {

    private List<Figura> figuras;

    public ListaFiguras(List<Figura> figuras) {
        this.figuras = figuras;
    }

    public List<Figura> getFiguras() {
        return figuras;
    }
}