package javaapplication5;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import processing.core.PApplet;

public class Sketch extends PApplet {

    @Override
    public void setup() {
        size(200, 200);
        stroke(155, 0, 0);
    }

    @Override
    public void draw() {
        line(mouseX, mouseY, width / 2, height / 2);
    }
}
