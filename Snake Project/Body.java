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
public class Body{
    int x, y; //Body contains x and y varaible

    public Body(int x, int y) { //constuctor
        this.x = x;
        this.y = y;
    }
  
    public void draw(Graphics g) { //graphics
	g.setColor(Color.green); //set the body object color to green
        g.fillRect(x, y, 10, 10); //set the body size and its filling the object color
        g.setColor(Color.black); //set the body object color to black
        g.drawRect(x, y, 10, 10); //set the body size and its outline color to black
    }
}
