/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2final;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author KaChi
 */
public class Obstacle {
    int x, y; // obstacle contains x and y varaible

    public Obstacle(int x, int y) { //constuctor
        this.x = x; //store the x in to the local x and y
        this.y = y;
    }
    public void draw(Graphics g) { //graphics
	g.setColor(Color.BLACK); //set the obstacle object color to black
        g.fillRect(x, y, 10, 10); //set the obstacle object size
    }
}
