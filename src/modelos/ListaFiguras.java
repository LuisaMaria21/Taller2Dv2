package modelos;

import java.util.List;

/**
 * 
 ** @author andres_fel.acosta@uao.edu.co Andres Felipe Acosta lozada 2201212
 * luisa_maria.cuero@uao.edu.co Luisa María Cuero Ampudia 2195064
 * julieta.lara@uao.edu.co Julieta Lara Romero 2200619
 * juan_fernando.aldana@uao.edu.co Juan Fernando Aldana 2201173
 * @date 29 Marzo 2022
 * @version 1.0
 */

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