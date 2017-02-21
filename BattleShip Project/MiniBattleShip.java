/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author KaChi
 */
public class MiniBattleShip extends JFrame implements ActionListener {
    
    JFrame f; //declare a window
    JPanel lp, rp, cp, bp; //declare left, right, center, bottem panel
    JButton b1, b2, b3, b4, b5;//b1: start button // b2 - b5: decoration
    
    JButton[][] left = new JButton[5][5]; //declare 2D array for left panel
    int[][] ileft = new int[5][5]; //declare 2D array for value

    JButton[][] right = new JButton[5][5]; //declare 2D array for right panel
    int[][] iright = new int[5][5]; //declare 2D array for value
    
    String[] characters = {"A", "B", "C", "D", "E"}; //declare array of characters
    String[] ship = {"ShipA", "shipB", "shipC", "shipD", "shipE"}; //declare array of shipname
    int[] shipSize = {1, 2, 1, 2, 2}; //declare array of shipsize
    
    int enemyhp = shipSize[0] + shipSize[1] + shipSize[2]; // declare a integer of enemy health point
    int myhp = shipSize[0] + shipSize[1] + shipSize[2]; //declare a integer of the user health point
    int totalships = 3; //declare a integer of total ship
    
    public static void main(String[] args) {
        new MiniBattleShip(); //call default constructor
    }
    
    public MiniBattleShip() {
         gui(); //call the gui method
    }
    
    public void gui(){
        f = new JFrame("BattleShip"); //intitize a window name BattleShip
        f.setVisible(true); //make the window visible
        f.setSize(1000,1000); //set size
        f.setLocationRelativeTo(null); //set the window location to default(center)
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Press x to EXIT

        lp = new JPanel(new GridLayout(6,6)); //intitize left panel have 6 row and 6 column
        lp.setBackground(Color.CYAN);//set panel color
        
        rp = new JPanel(new GridLayout(6,6)); //intitize right panel have 6 row and 6 column
        rp.setBackground(Color.CYAN); //set panel color

        bp = new JPanel(new GridLayout(2,2)); //intitize bot panel have 2 row and 2 column
        bp.setBackground(Color.CYAN); //set panel color
        
        cp = new JPanel(new GridLayout(1,1)); //intitize a center panel 1 row and 1 column
        cp.setBackground(Color.ORANGE); //set panel color
        
        b4 = new JButton("x"); //intitize a button
        b4.setContentAreaFilled(true); 
        b4.setPreferredSize(new Dimension(77, 77));//set the button size
        b4.setFocusPainted(false);
        b4.setEnabled(false);//disable the button
        lp.add(b4);//insert the button into left panel
        b5 = new JButton("x");
        b5.setContentAreaFilled(true);
        b5.setPreferredSize(new Dimension(77, 77));
        b5.setFocusPainted(false);
        b5.setEnabled(false);
        rp.add(b5);
        
        for(int row = 0; row < left.length; row++) {//for loop to make x decoration in horizontal
            b2 = new JButton(String.valueOf((row)));
            b2.setContentAreaFilled(true);
            b2.setPreferredSize(new Dimension(77, 77));
            b2.setFocusPainted(false);
            b2.setEnabled(false);
            lp.add(b2); //insert button into left panel
            
            b3 = new JButton(String.valueOf((row)));
            b3.setContentAreaFilled(true);
            b3.setPreferredSize(new Dimension(77, 77));
            b3.setFocusPainted(false);
            b3.setEnabled(false);
            rp.add(b3);//insert button into right panel
        }
        for(int col = 0; col < left.length; col++) { //create buttons
            b2 = new JButton(String.valueOf((col)));
            b2.setContentAreaFilled(true);
            b2.setPreferredSize(new Dimension(77, 77));
            b2.setFocusPainted(false);
            b2.setEnabled(false);  
            lp.add(b2); //insert button into left panel
                
            b3 = new JButton(String.valueOf((col)));
            b3.setContentAreaFilled(true);
            b3.setPreferredSize(new Dimension(77, 77));
            b3.setFocusPainted(false);
            b3.setEnabled(false);  
            rp.add(b3); //insert button into right panel
            for(int row = 0; row < left.length; row++) { //for loop to initize the 2d array of button
                left[row][col] = new JButton(row + ", " + col);
                left[row][col].setContentAreaFilled(false);
                left[row][col].setPreferredSize(new Dimension(77, 77));
                left[row][col].setFocusPainted(false);
                left[row][col].setEnabled(false);
                left[row][col].addActionListener(this); //add actionlistener
                ileft[row][col] = 99; //assign the value of 99 in the buttons
                                        //99: ocean, 1: shipsize of 1, 2:shipsize of 2
                lp.add(left[row][col]); //insert button into left panel
                
                //Do the same thing on the Right
                right[row][col] = new JButton(row + ", " + col);
                right[row][col].setContentAreaFilled(false);
                right[row][col].setPreferredSize(new Dimension(77, 77));
                right[row][col].setFocusPainted(false);
                right[row][col].setEnabled(false);
                right[row][col].addActionListener(this);
                iright[row][col] = 99;
                rp.add(right[row][col]);
            }
        }
        
        b1 = new JButton("Start"); //declare a start button
        b1.addActionListener(this);//add actionlistner
        
        bp.add(b1, BorderLayout.CENTER);//insert button in bottom panel
        cp.add(b1, BorderLayout.CENTER);//insert button in center panel
        
        f.add(lp, BorderLayout.LINE_START);//insert left panel in to window
        f.add(rp, BorderLayout.LINE_END);//insert right panel in to window
        f.add(cp, BorderLayout.PAGE_END);//insert center panel in to window
        f.add(bp, BorderLayout.CENTER);//insert bottom panel in to window
    }
    
    public void actionPerformed(ActionEvent e) { //use for (this)
        String cmd = e.getActionCommand(); //declare a string and assign the action command
        if(cmd == "Start") {//comparsion
             for(int row = 0; row < left.length; row++) { //create buttons
                for(int col = 0; col < left.length; col++) {
                    left[row][col].setEnabled(true);
                    right[row][col].setEnabled(true);
                }
             }
            setTurn(e); //Call User Turn
            opponentsetup(e); //Call Oppoenet Turn
        }
        
        if(opponetTurn() == 1) { //Comparsion of the health point
                                //if the opponent hit the user ship in its Turn
            myhp--;             //User hp subtract one
        }
        System.out.println("");    
        if(myTurn(e) == 1) { //Comparsion of the health point
                            //if the user hit the opponent ship in its Turn
            enemyhp--;      //opponent ship subtract one
        }
        if(myhp == 0) { //comparsion of if the user hp is 0, it will print then exit
            JOptionPane.showMessageDialog(null, "AI WIN", "WINNDER",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
        } else if (enemyhp == 0) {//comparsion of if the opponent hp is 0, it will print then exit
            JOptionPane.showMessageDialog(null, "YOU WIN", "WINNDER",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
        }
    }
    public void opponentsetup(ActionEvent e) { //opponent set up its ship
        int row, col, check;
        String[] compass = {"E", "S", "W", "N"}; //a array of string
        String compassR = "";
        
        check = 0;
        for(int i = 0; i < totalships; i++) {
            row = (int)(Math.random() * 5); //assign random number into row
            col = (int)(Math.random() * 5); //assign random number into column
            if(shipSize[i] > 1) { //comparsion for ship which has size more than 1
                while(check != 1) {
                    row = (int)(Math.random() * 5);
                    col = (int)(Math.random() * 5);
                    //System.out.println("row: " + row + " \n" + "col: " + col);
                    if(ileft[row][col] == 99) {
                        compassR = compass[(int)(Math.random() * 4)];  //assign random number in to the array
                                                                        //then assign the string in to compassR
                        if (compassR == "E") {
                           //System.out.println("Called E");
                           enemyInsertion(row + 1, col, "E", shipSize[i], i); //call the functions
                           //System.out.println("row: " + (row + 1) + " \n" + "col: " + col);
                        } else if (compassR == "S") {
                            //System.out.println("Called S");
                           enemyInsertion(row, col + 1, "S", shipSize[i], i);
                           //System.out.println("row: " + row + " \n" + "col: " + col + 1);
                        } else if (compassR == "W") {
                            //System.out.println("Called W");
                           enemyInsertion(row - 1, col, "W", shipSize[i], i);
                           //System.out.println("row: " + (row - 1) + " \n" + "col: " + col);
                        } else if (compassR == "N") {
                           // System.out.println("Called N");
                           enemyInsertion(row, col - 1, "N", shipSize[i], i);
                           //System.out.println("row: " + row + " \n" + "col: " + (col - 1));
                        }
                        check = 1;
                    }
                }
            }
            ileft[row][col] = shipSize[i];//asign ship value into ileft array
        }
    }

    public void enemyInsertion(int row, int col, String compass, int shipsize, int character){
        int check = 0;
        if(compass == "E" ) {//comparsion if compass equal E
            for(int i = row; i < left.length; i++) {
                if(ileft[i][col] == 99) { //if the position value is 99(99 is ocean)
                                            //in other words, if it's ocean, set the ship
                    ileft[i][col] = shipsize;
                    check++;
                    if(check == shipsize - 1) {//limit the for loop only run the size of the ship
                        i = right.length;
                    }
                } else {
                    enemyInsertion(row, col, "S", shipsize, character);
                }
            }
        } else if(compass == "S" ) {
            for(int i = col; i < left.length; i++) {
                if(ileft[row][i] == 99) {
                    ileft[row][i] = shipsize;
                    check++;
                    if(check == shipsize - 1) {
                        i = left.length;
                    }
                } else {
                    enemyInsertion(row, col, "W", shipsize, character);
                }
                
            }
        } else if(compass == "W" ) {
            for(int i = row; i >= 0; i--) {
                if(ileft[i][col] == 99) {
                    ileft[i][col] = shipsize;
                    check++;
                    if(check == shipsize - 1) {
                        i = 0;
                    }
                } else {
                    enemyInsertion(row, col, "N", shipsize, character);
                }
            }
        } else if(compass == "N" ) {
            for(int i = col; i >= 0; i--) {
                if(ileft[row][i] == 99) {
                    ileft[row][i] = shipsize;
                    check++;
                    if(check == shipsize - 1) {
                        i = 0;
                    }
                } else {
                    enemyInsertion(row, col, "E", shipsize, character);
                }
            }
        }
    }
    
    public void setTurn(ActionEvent e){ //User set up its ship
        int row, col;
        String compass;
        int east, south, west, north;
      
        JTextField xField = new JTextField(5); //declare a JTextField
        JTextField yField = new JTextField(5);
        JPanel myPanel = new JPanel(); //declare a Jpanel
        myPanel.add(new JLabel("Row:")); //insert label of row
        myPanel.add(xField); //insert the x field
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Column:")); //insert label of column
        myPanel.add(yField); //insert the y field
        
        //right you //left AI
        
        Scanner input = new Scanner(System.in); //Make a scanner of input
        row = 0;
        col = 0;
        
        for(int i =0; i < totalships; i++) { //for loop to the total of ships
            int result = JOptionPane.showConfirmDialog(null, myPanel, 
                   "Please Enter Row and Column", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) { 
                System.out.println("Row: " + xField.getText());
                row = Integer.parseInt(xField.getText()); //assign the user input in to row
                System.out.println("Column: " + yField.getText());
                col = Integer.parseInt(yField.getText()); //assign the user input in to column
            }
            if(shipSize[i] > 1) { //comparsion for ship which has size more than 1
                east = count(row + 1, col, "E");
                south = count(row, col + 1, "S");
                west = count(row - 1, col, "W");
                north = count(row, col - 1, "N");

                compass = JOptionPane.showInputDialog("\nEast: " + east + 
                                                    "\nSouth: " + south +
                                                    "\nWest: " + west +
                                                    "\nNorth: " + north +
                        "\nPlease Type the Capital Letter "
                        + "Of the Direction You Want To Place Your Ships");
                switch(compass) { //a swtich to ask user which direction he/she want to go
                    case "E":
                        System.out.println("You inserted East");
                        myInsertion(row + 1, col, "E", shipSize[i], i);
                        break;
                    case "S":
                        System.out.println("You inserted South");
                        myInsertion(row, col + 1, "S", shipSize[i], i);
                        break;
                    case "W":
                        System.out.println("You inserted West");
                        myInsertion(row - 1, col, "W", shipSize[i], i);
                        break;
                    case "N":
                        System.out.println("You inserted North");
                        myInsertion(row, col - 1, "N", shipSize[i], i);
                        break;
                    default:
                    System.out.println("Invalid direction");
                }
                
            }
            iright[row][col] = shipSize[i];//assign the shipsize into the iright array
            right[row][col].setText(ship[i]);//set the text of the button
        }
        b1.setEnabled(false);//disable the start button
        System.out.println();
    }
    
    public int count(int row, int col, String compass){ //counter to count how many space for
                                                        //the user to enter ship which has size more than 2
        int counter = 0;
        if(compass == "E" ) {
            for(int i = row; i < iright.length; i++) {
                counter++;
            }
        } else if(compass == "S" ) {
            for(int i = col; i < iright.length; i++) {
                counter++;
            }
        } else if(compass == "W" ) {
            for(int i = row; i >= 0; i--) {
                counter++;
            }
        } else if(compass == "N" ) {
            for(int i = col; i >= 0; i--) {
                counter++;
            }
        }
        return counter;
    }
    
    public void myInsertion(int row, int col, String compass, int shipsize, int character){
        int check = 0;
        if(compass == "E" ) { //if the compass equal E
            for(int i = row; i < right.length; i++) { //make a loop and place the second part of the ship
                if(ileft[i][col] == 99) {
                    iright[i][col] = shipsize;
                    right[i][col].setText(ship[character]);
                    check++;
                    if(check == shipsize - 1) {
                        i = right.length;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Some ships are on the same position, "
                            + "Please Re-position ", "ERROR!!",
                        JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
        } else if(compass == "S" ) {
            for(int i = col; i < right.length; i++) {
                if(iright[row][i] == 99) {
                    iright[row][i] = shipsize;
                    right[row][i].setText(ship[character]);
                    check++;
                    if(check == shipsize - 1) {
                        i = right.length;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Some ships are on the same position, "
                            + "Please Re-position ", "ERROR!!",
                        JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                
            }
        } else if(compass == "W" ) {
            for(int i = row; i >= 0; i--) {
                if(iright[i][col] == 99) {
                    iright[i][col] = shipsize;
                    right[i][col].setText(ship[character]);
                    check++;
                    if(check == shipsize - 1) {
                        i = 0;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Some ships are on the same position, "
                            + "Please Re-position ", "ERROR!!",
                        JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
        } else if(compass == "N" ) {
            for(int i = col; i >= 0; i--) {
                if(iright[row][col] == 99) {
                    iright[row][col] = shipsize;
                    right[row][col].setText(ship[character]);
                    check++;
                    if(check == shipsize - 1) {
                        i = 0;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Some ships are on the same position, "
                            + "Please Re-position ", "ERROR!!",
                        JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
        }
    }
    
    public int opponetTurn() { //opponent Turn
        //aim right
        int row, col, check, hit;
        hit = 0;
        check = 1;
        while(check != 0) {
            row = (int)(Math.random() * 5); //assign random number in to row
            col = (int)(Math.random() * 5); //assign random number in to col

            if(iright[row][col] != 0) { //make a comparsion if the position is not 0
                //System.out.println("Enemy clicked: " + "\nRow: " +
                            //row + "\ncolumn: " + column);
                right[row][col].setEnabled(false); //
                if((iright[row][col] >= 1) && (iright[row][col] != 99)) { //make a comparsion for ship which has size more than 2
                    right[row][col].setText("HIT"); //if the opponet hit, the text will shows hit
                    hit = 1;
                        //System.out.println("my hp: " + myhp);
                } else {
                    right[row][col].setText("X");//else it shows x
                }
                iright[row][col] = 0;
                check = 0;
            }
        }
        return hit; //return hit
    }
    
    public int myTurn(ActionEvent e) {//user turn
        int hit = 0;
        
        for(int row = 0; row < left.length; row++) { //enable the button after the user pressed start
            for(int col = 0; col < left.length; col++) {
                    right[row][col].setEnabled(false);
            }
        }
        
        for(int row = 0; row < left.length; row++) {
            for(int col = 0; col < left.length; col++) {
                if(e.getSource() == left[row][col]) { //the program will get something from the user click
                                                      //make a forloop to loop and compare which button the user click
                    //left[x][y].setBackground(Color.BLACK);
                    left[row][col].setEnabled(false);//if it hit, disable the button
                    if(ileft[row][col] >= 1 && (ileft[row][col] != 99)) {
                        left[row][col].setText("HIT"); //if user hit the oppoonet ship, it shows hit
                        hit = 1;
                        //System.out.println("Enemy hp: " + enemyhp);
                    } else {
                        left[row][col].setText("X"); //else show x
                    }
                    ileft[row][col] = 0;
                    
                }
            }
        }
          
        System.out.println();

        return hit;//return x
    }

}
