/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**Clase para Obtener los Puntos
 *
 * * @author andres_fel.acosta@uao.edu.co Andres Felipe Acosta lozada 2201212
 * luisa_maria.cuero@uao.edu.co Luisa María Cuero Ampudia 2195064
 * julieta.lara@uao.edu.co Julieta Lara Romero 2200619
 * juan_fernando.aldana@uao.edu.co Juan Fernando Aldana 2201173
 * @date 29 Marzo 2022
 * @version 1.0
 */
public class Punto {

    private double x;
    private double y;

    public Punto() {}

    public Punto( double x,  double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX( double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY( double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Punto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
