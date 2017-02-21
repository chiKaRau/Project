/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2final;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author KaChi
 */
public class Screen extends JPanel implements ActionListener, KeyListener{
    int WIDTH = 800, HEIGHT = 800; //two int varaible scalled width and height 
    public static int time = 50; //global int varaible with the called time
    Timer t; //Timer called t
    int x = 400, y = 400;//two int varaibles called x and y
    boolean right = false, left = false, up = false, down = false; //boolean varriable called right, left
                                                                    //up, and down
    LinkedList<Food> foods; //A linkedlist which using object of food
    LinkedList<Body> snake; //A linkedlist which using object of body
    LinkedList<Obstacle> block; //A linkedlist which using object of obstacle
    boolean started = false; // A boolean varriable called started
    Body b; //a object of Body
    Food f; //a object of food
    Obstacle k; //a object of obstacle
    
    Random rand = new Random(); //random variable called rand
    int size = 3; //a int variable which value is 3
    
    public Screen(){ //constructor
        
        init(); //calling the method init
    }
    
    
    public void init(){ //init method
        
        block = new LinkedList<Obstacle>(); //initiating the objects
        foods = new LinkedList<Food>();
        snake = new LinkedList<Body>();
        
        level(); //calling the method level
        t = new Timer(time, this); //initiating the timer and assign its parameter from the time varriable
                                    //which is 50
        t.start();  //start the program by using the timer
        addKeyListener(this); //addkeylistener to this class
        setFocusable(true); //set focusable
        setFocusTraversalKeysEnabled(false);
    }

    public void tracking(){
 
        if(x < 0 || x > WIDTH || y < 0 || y > HEIGHT){ //a comparsion that if the snake hit the wall
                                                    //cross the WIDTH and HEIGHT
            hit(); //call the hit method
        }
    }
    
    public void level(){ //level methods
        Object[] options = {"Level 1", "Level 2", "Level 3"}; //button name to level 1, 2, 3
        
        int option = JOptionPane.showOptionDialog(null, "Please Select a Level","Level Option", //assign JOptionPane to option
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,options[2]);
        
        switch(option) { //using swtich 
            case JOptionPane.YES_OPTION: //if pressed level 1 
                time = 50; //time equals to 50(no change to the init value of time)
                break;
            case JOptionPane.NO_OPTION:  //if pressed level 2
                time = 30; //time equals to 30(more faster)
                break;
            case JOptionPane.CANCEL_OPTION: //if pressed level 3 
                time = 10; //time equals to 10(super fast)
                break;
            case JOptionPane.CLOSED_OPTION: //if pressed close button
                System.exit(0); //close the window
                break;
        } 


    }
    
    public void hit() { //hit method
        t.stop(); //stop the program
        if (JOptionPane.showConfirmDialog(null, "Snake: You hit the wall! \nRestart the Game?", "OUCH!!!", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            //a popup box that asks if the user want to restart the game
            x = 400; //set the snake position to the center
            y = 400;
            while(snake.size() != 3) { //reduce the snake size back to 3
                snake.remove();
                size = 3;
            }
            init(); //call the init methods again
            
        } else { //if user dont want to restart, then close the game
         System.exit(0);
        }
    }
    
    public void move() { //move method
        if(right) x += 10; //if right, left, up or down true, x and y 
                            //would either increase or decrease
        if(left) x -= 10;
        if(up) y -= 10;
        if(down) y += 10;
    }
    
    public void snake(){ //snake method
        if(snake.size() == 0) { //if nothing, create a new snake body
            b = new Body(x, y);
            snake.add(b);
        }
        move(); //call move method
        
        if (started) {
            for (int i = 0; i < snake.size(); i++) { //track when the snake eat himself
                if ((x == snake.get(i).x) && y == snake.get(i).y) {
                    hit();
                }
            }
        }
        
        b = new Body(x, y); //make the snake move 
        snake.add(b); //by keep adding body to the snake

        if(snake.size() > size) { 
            snake.remove(0); //and remove the extra size of the snake
        }
    }
    
    public void food(){ //food methods
        if(foods.size() == 0) { //if there no food object,
            int ok = 0;
            int rx = 0;
            int ry = 0;
            while(ok != 1){ 
                rx = (int) (rand.nextInt(700) + 1); //set random location
                ry = (int) (rand.nextInt(700) + 1);
                
                if((rx % 10) == 0 && (ry % 10) == 0) { //if it position is not on the 10s position
                    ok = 1;
                } 
            }
            f = new Food(rx, ry); //add a new food object
            foods.add(f);
        }
        
        if(snake.get(snake.size() - 1).x == foods.get(0).x && snake.get(snake.size() - 1).y == foods.get(0).y) { //if snake eat the food
            foods.remove(); //remove the food
            size++; //incrase the size of the snake
            started = true;
        }
    }
    
    public void block() { //block method
        if(block.size() == 0) { //if there are no block on the screen
            int ok = 0;
            int rx = 0;
            int ry = 0;
            while(ok != 15){
                rx = (int) (rand.nextInt(750) + 1);
                ry = (int) (rand.nextInt(750) + 1);
                
                if((rx % 10) == 0 && (ry % 10) == 0) {
                    k = new Obstacle(rx, ry); //add a new block
                    block.add(k);
                    int temp = 10;
                    
                    int r = (int)(rand.nextInt(2) + 1);
                    
                    for(int i = 0; i < 5; i++) { //set a long blocks
                        
                        if(r == 1) {
                            k = new Obstacle(rx + temp , ry); //add one and use temp to move the position
                        } else if (r == 2) {
                            k = new Obstacle(rx , ry + temp);
                        }
                        block.add(k);
                        
                        if((k.x == foods.get(0).x && k.y == foods.get(0).y) || 
                                (k.x == 400 && k.y == 400) || 
                                ((k.x >= 350 && k.x <= 450) && (k.y >= 350 && k.y <= 450)))  { //if their position are the same as the apple or snake,
                                                                                                //remove the block
                            block.remove(k);
                        }
                        
                        temp += 10;
                    }
                    ok++;
                } 
            }
        }
        
        for(int i = 0; i < block.size(); i++) { //if the snake hit the block
            if(snake.get(snake.size() - 1).x == block.get(i).x && snake.get(snake.size() - 1).y == block.get(i).y) {
                hit(); //call the hit method
            }
        }
    }
    
    public void update(){
        snake(); //call snake method
        food(); //call food method
        block(); //call block method
    }
    
    @Override
    public void paintComponent(Graphics g){ //graphics
        super.paintComponent(g);
        g.setColor(Color.DARK_GRAY); //set the screen backgroud color
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.BLACK); //draw line on the screen
        for(int i = 0; i < WIDTH / 10; i++) {
            g.drawLine(i * 10, 0, i * 10, HEIGHT);
        }
        for(int i = 0; i < HEIGHT / 10; i++) {
            g.drawLine(0, i * 10, WIDTH, i * 10);
        }

        for(int i = 0; i < snake.size(); i++) { //draw the snake
            snake.get(i).draw(g);
	}
        
        for(int i = 0; i < foods.size(); i++) { //draw the foods
            foods.get(i).draw(g);
	}
        
        for(int i = 0; i < block.size(); i++) { //draw the blocks
            block.get(i).draw(g);
	} 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { //use action listener to active each time the snake move
        update(); //call update
        tracking(); //call tracking
        repaint();  //repaint each time it move
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) { //key pressed overriding method 
        int key = e.getKeyCode(); //assign the signal to key
        if(key == KeyEvent.VK_RIGHT && left == false) { //if user pressed right, up, down, left 
                                                        //and its opposite direction is false
                                                         //set the rest of the buttons to false
            up = false;
            down = false;
            right = true;
            
        }
        if(key == KeyEvent.VK_LEFT && right == false) { 
                up = false;
                down = false;
                left = true;
        }
        if(key == KeyEvent.VK_UP && down == false) {
                left = false;
                right = false;
                up = true;
        }
        if(key == KeyEvent.VK_DOWN && up == false) {
                left = false;
                right = false;
                down = true;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
