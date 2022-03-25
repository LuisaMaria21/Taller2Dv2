/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.scene.paint.Color;

/**
 *
 * @author juan_fernando.aldana
 */
public class punto2D {
    
 private double X;
    private double Y;
    
    private Color r;
    private Color b;

    public punto2D(double X, double Y, Color r, Color b) {
        this.X = X;
        this.Y = Y;
        this.r = r;
        this.b = b;
    }
    
   

    public punto2D() {
    }
    

    /**
     * Get the value of Y
     *
     * @return the value of Y
     */
    public double getY() {
        return Y;
    }

    /**
     * Set the value of Y
     *
     * @param Y new value of Y
     */
    public void setY(double Y) {
        this.Y = Y;
    }


    /**
     * Get the value of X
     *
     * @return the value of X
     */
    public double getX() {
        return X;
    }

    /**
     * Set the value of X
     *
     * @param X new value of X
     */
    public void setX(double X) {
        this.X = X;
    }

    public Color getR() {
        return r;
    }

    public void setR(Color r) {
        this.r = r;
    }

    public Color getB() {
        return b;
    }

    public void setB(Color b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return  X + "," + Y;
    }

}
