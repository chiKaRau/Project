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
public class Food{
    int x, y; //Food contains x and y varaible

    public Food(int x, int y) { //constuctor
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics g) { //graphics
	g.setColor(Color.red); //set the Food object color to red
        g.fillRect(x, y, 10, 10); //set the Food object size
    }
}

