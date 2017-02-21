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

public class bt extends JFrame implements ActionListener {

    JFrame f;
    JPanel lp, rp, cp, bp;
    JButton b1, b2, b3, b4, b5;
    JLabel l1, r1;
    JLabel s;
    

    JButton[][] left = new JButton[5][5];
    int[][] ileft = new int[5][5];

    JButton[][] right = new JButton[5][5];
    int[][] iright = new int[5][5];
    
    String[] characters = {"A", "B", "C", "D", "E"};
    String[] ship = {"ShipA", "shipB", "shipC", "shipD", "shipE"};
    int[] shipSize = {1, 2, 3, 4, 5};
    
    int enemyhp;
    int myhp;
    int hitrightsize;

    public bt() {
         gui();
    }

    public void gui(){
        f = new JFrame("BattleShip");
        f.setVisible(true);
        f.setSize(1000,1000);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Press x to EXIT

        lp = new JPanel(new GridLayout(6,6));
        lp.setBackground(Color.CYAN);
        
        rp = new JPanel(new GridLayout(6,6));
        rp.setBackground(Color.CYAN);

        bp = new JPanel(new GridLayout(2,2));
        bp.setBackground(Color.CYAN);
        
        cp = new JPanel(new GridLayout(1,1));
        cp.setBackground(Color.ORANGE);
        
        
        b4 = new JButton("x");
        b4.setContentAreaFilled(true);
        b4.setPreferredSize(new Dimension(77, 77));
        b4.setFocusPainted(false);
        b4.setEnabled(false);
        lp.add(b4);
        b5 = new JButton("x");
        b5.setContentAreaFilled(true);
        b5.setPreferredSize(new Dimension(77, 77));
        b5.setFocusPainted(false);
        b5.setEnabled(false);
        rp.add(b5);
        
        for(int x = 0; x < left.length; x++) {
            b2 = new JButton(String.valueOf((x)));
            b2.setContentAreaFilled(true);
            b2.setPreferredSize(new Dimension(77, 77));
            b2.setFocusPainted(false);
            b2.setEnabled(false);
            lp.add(b2);
            
            b3 = new JButton(String.valueOf((x)));
            b3.setContentAreaFilled(true);
            b3.setPreferredSize(new Dimension(77, 77));
            b3.setFocusPainted(false);
            b3.setEnabled(false);
            rp.add(b3);
       }
        
        
        for(int y = 0; y < left.length; y++) { //create buttons
            b2 = new JButton(String.valueOf((y)));
            b2.setContentAreaFilled(true);
            b2.setPreferredSize(new Dimension(77, 77));
            b2.setFocusPainted(false);
            b2.setEnabled(false);  
            lp.add(b2);
                
            b3 = new JButton(String.valueOf((y)));
            b3.setContentAreaFilled(true);
            b3.setPreferredSize(new Dimension(77, 77));
            b3.setFocusPainted(false);
            b3.setEnabled(false);  
            rp.add(b3);            
            for(int x = 0; x < left.length; x++) {

                
                left[x][y] = new JButton(x + ", " + y);
                left[x][y].setContentAreaFilled(false);
                left[x][y].setPreferredSize(new Dimension(77, 77));
                left[x][y].setFocusPainted(false);
                left[x][y].setEnabled(false);
                left[x][y].addActionListener(this);
                ileft[x][y] = 99;
                lp.add(left[x][y]);
                

                right[x][y] = new JButton(x + ", " + y);
                right[x][y].setContentAreaFilled(false);
                right[x][y].setPreferredSize(new Dimension(77, 77));
                right[x][y].setFocusPainted(false);
                right[x][y].setEnabled(false);
                right[x][y].addActionListener(this);
                iright[x][y] = 99;
                rp.add(right[x][y]);
            }
        }
        
        //99 = ocean
        //1,2,3 = ship
        //0 = ship sinked

        
        /*
        ileft[0][1] = 1;
        left[0][1].setText("A");
        
        ileft[0][2] = 1;
        left[0][2].setText("B");
        */
        
        b1 = new JButton("Start");
        b1.addActionListener(this);
        
        bp.add(b1, BorderLayout.CENTER);
        cp.add(b1, BorderLayout.CENTER);
       // p.add(b2, c);
        
        f.add(lp, BorderLayout.LINE_START);
        f.add(rp, BorderLayout.LINE_END);
        f.add(cp, BorderLayout.PAGE_END);
        f.add(bp, BorderLayout.CENTER);

    }

    
    public void actionPerformed(ActionEvent e) { //use for (this)
        //settext = change label
        
        String cmd = e.getActionCommand();
        if(cmd == "Start") {
            
             for(int x = 0; x < left.length; x++) { //create buttons
                for(int y = 0; y < left.length; y++) {
                    left[x][y].setEnabled(true);
                    right[x][y].setEnabled(true);
                }
             }
            setTurn(e);
            opponentsetup(e);
        }
        
        //turns(e);
        
        
        if(opponetTurn() == 1) {
            myhp--;
            System.out.println("my hp: " + myhp);
        }

        System.out.println("");
            
        if(myTurn(e) == 1) {
            enemyhp--;
            System.out.println("Enemy hp: " + enemyhp);
        }
        
        if(myhp == 0) {
            JOptionPane.showMessageDialog(null, "AI WIN", "WINNDER",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
        } else if (enemyhp == 0) {
            JOptionPane.showMessageDialog(null, "YOU WIN", "WINNDER",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
        }
            
           
        

    }
    
    public void opponentsetup(ActionEvent e) {
        int turn = enemyhp;
        int row, column;
        int i = 0;
        while(turn > 0) {
            
            if(shipSize[i] > 2) {
                
            }
            
            row = (int)(Math.random() * 5);
            column = (int)(Math.random() * 5);
            ileft[row][column] = 1;
            //left[row][column].setText(character[i]);
            turn--;
            i++;
        }
       
        
    }
    
    public void setTurn(ActionEvent e){ //initiate buttons
        int shipA = 1;
        int shipB = 2;
        
        enemyhp = shipA + shipB;
        myhp = shipA + shipB;
        
        //int shipC = 3;
        int row, column;
        String compass;
        int east, south, west, north;
        
        
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Row:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Column:"));
        myPanel.add(yField);
        
        //right you //left AI
        
        Scanner input = new Scanner(System.in);
        row = 0;
        column = 0;
        
        /*
        while(shipA != 0) {
            System.out.println("Ship A ----------------");
            System.out.print("Row: ");
            row = input.nextInt();
            System.out.print("Column: ");
            column = input.nextInt();
            
            iright[row][column] = 1;
            right[row][column].setText("SHIP A");
            shipA--;
        }
        
        while(shipB != 0) {
            System.out.println("Ship B ----------------");
            System.out.print("Row: ");
            row = input.nextInt();
            System.out.print("Column: ");
            column = input.nextInt();
            
            iright[row][column] = 1;
            right[row][column].setText("SHIP B");
            shipB--;
        }
        */
        
        /*
        while(shipA != 0) {
            
            int result = JOptionPane.showConfirmDialog(null, myPanel, 
                   "Please Enter Row and Column", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                System.out.println("Row: " + xField.getText());
                row = Integer.parseInt(xField.getText());
                System.out.println("Column: " + yField.getText());
                column = Integer.parseInt(yField.getText());
            }

            iright[row][column] = 1;
            right[row][column].setText("SHIP A");
            shipA--;
        }
        
        row = 0;
        column = 0;
        while(shipB != 0) {
            int result = JOptionPane.showConfirmDialog(null, myPanel, 
                   "Please Enter Row and Column", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                System.out.println("Row: " + xField.getText());
                row = Integer.parseInt(xField.getText());
                System.out.println("Column: " + yField.getText());
                column = Integer.parseInt(yField.getText());
            }
            iright[row][column] = 2;
            right[row][column].setText("SHIP B");
            shipB--;
        }
          */     
        
        
        int ts = 2;
        
        for(int i =0; i < ts; i++) {
            System.out.print("Enter row: ");
            row = input.nextInt();
            System.out.print("Enter column: ");
            column = input.nextInt();
            if(shipSize[i] > 1) {
                System.out.println("THE SHIP has more than 1 size");
                east = count(row + 1, column, "E");
                System.out.println("East: " + east);
                south = count(row, column + 1, "S");
                System.out.println("South: " + south);
                west = count(row - 1, column, "W");
                System.out.println("West: " + west);
                north = count(row, column - 1, "N");
                System.out.println("North: " + north);
                
                System.out.println("Which Direction you want to insert"
                        + "you ship which has the size " + shipSize[i] 
                        + "? You have: ");
                if((iright.length - east) <= shipSize[i]) {
                    System.out.println("Captial E for East");
                }
                if((iright.length - south) <= shipSize[i]) {
                    System.out.println("Captial S for South");
                }
                if((iright.length - west) <= shipSize[i]) {
                    System.out.println("Captial W for West");
                }
                if((iright.length - north) <= shipSize[i]) {
                    System.out.println("Captial N for North");
                }
                
                compass = input.next();
                switch(compass) {
                    case "E":
                        System.out.println("You inserted East");
                        insertion(row + 1, column, "E", east, shipSize[i], i);
                        break;
                    case "S":
                        System.out.println("You inserted South");
                        insertion(row, column + 1, "S", south, shipSize[i], i);
                        break;
                    case "W":
                        System.out.println("You inserted West");
                        insertion(row - 1, column, "W", west, shipSize[i], i);
                        break;
                    case "N":
                        System.out.println("You inserted North");
                        insertion(row, column - 1, "N", north, shipSize[i], i);
                        break;
                    default:
                    System.out.println("Invalid direction");
                }
                
            }
            iright[row][column] = shipSize[i];
            right[row][column].setText(ship[i]);
        }
        
        b1.setEnabled(false);
        

        System.out.println();
        
        
    }
    
    
    public int count(int x, int y, String compass){
        int counter = 0;
        
        if(compass == "E" ) {
            for(int i = x; i < iright.length; i++) {
                counter++;
            }
        } else if(compass == "S" ) {
            for(int i = y; i < iright.length; i++) {
                counter++;
            }
        } else if(compass == "W" ) {
            for(int i = x; i >= 0; i--) {
                counter++;
            }
        } else if(compass == "N" ) {
            for(int i = y; i >= 0; i--) {
                counter++;
            }
        }
        return counter;
    }
    
    public void insertion(int x, int y, String compass, int compasssize, int shipsize, int character){
        System.out.println("Called insertion");
        int check = 0;
        if(compass == "E" ) {
            for(int i = x; i < right.length; i++) {
                iright[i][y] = shipsize;
                right[i][y].setText(ship[character]);
                check++;
                if(check == shipsize - 1) {
                    i = right.length;
                }
            }
        } else if(compass == "S" ) {
            for(int i = y; i < right.length; i++) {
                iright[x][i] = shipsize;
                right[x][i].setText(ship[character]);
                check++;
                if(check == shipsize - 1) {
                    i = right.length;
                }
                
            }
        } else if(compass == "W" ) {
            for(int i = x; i >= 0; i--) {
                System.out.println("W called");
                iright[i][y] = shipsize;
                right[i][y].setText(ship[character]);
                check++;
                if(check == shipsize - 1) {
                    i = 0;
                }
                
            }
        } else if(compass == "N" ) {
            for(int i = y; i >= 0; i--) {
                iright[x][y] = shipsize;
                right[x][y].setText(ship[character]);
                check++;
                if(check == shipsize - 1) {
                    i = 0;
                }
            }
        }
    }
    
    
    
    public int opponetTurn() {
        //aim right
            int row, column, check, hit;
            hit = 0;
            check = 1;
            while(check != 0) {
                row = (int)(Math.random() * 5);
                column = (int)(Math.random() * 5);

                if(iright[row][column] != 0) {
                    System.out.println("Enemy clicked: " + "\nRow: " +
                            row + "\ncolumn: " + column);
                    right[row][column].setEnabled(false);
                    if((iright[row][column] >= 1) && (iright[row][column] != 99)) {
                        right[row][column].setText("HIT");
                        hit = 1;
                        //System.out.println("my hp: " + myhp);
                    } else {
                        right[row][column].setText("X");
                    }
                    iright[row][column] = 0;
                    check = 0;
                }
            }
            
            System.out.print("enemy hit: ");
            for(int x = 0; x < right.length; x++) {
                for(int y = 0; y < right.length; y++) {
                    System.out.print(iright[x][y] + " ");
            }
        }
        return hit;
    }
    
    public int myTurn(ActionEvent e) {
        int hit = 0;
        
        for(int x = 0; x < left.length; x++) { //create buttons
            for(int y = 0; y < left.length; y++) {
                    right[x][y].setEnabled(false);
            }
        }
        
        for(int x = 0; x < left.length; x++) {
            for(int y = 0; y < left.length; y++) {
                if(e.getSource() == left[x][y]) {
                    //left[x][y].setBackground(Color.BLACK);
                    System.out.println("I clicked: " + ileft[x][y]);
                    left[x][y].setEnabled(false);
                    if(ileft[x][y] == 1) {
                        left[x][y].setText("HIT");
                        hit = 1;
                        //System.out.println("Enemy hp: " + enemyhp);
                    } else {
                        left[x][y].setText("X");
                    }
                    ileft[x][y] = 0;
                    
                }
            }
        }
          
        System.out.print("you hit: ");
        for(int x = 0; x < left.length; x++) {
            for(int y = 0; y < left.length; y++) {
                System.out.print(ileft[x][y] + " ");
            }
        }
        
        
        System.out.println();

        return hit;
    }
    
 
    public static void main(String[] args) {
        new bt();
    }
    
    
}
