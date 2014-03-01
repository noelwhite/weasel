/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package physics;

import javax.swing.JFrame;

/**
 *
 * @author turtlepig
 */
public class GameFrame extends JFrame {
    
    public GameFrame(){
        this.setLayout(null);
        this.setBounds(10, 10, 900, 900);
        this.add(new GameBoard());
        this.setTitle("Weasley Snipe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        this.setVisible(true);
        
    }
    
}
