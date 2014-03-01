/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package physics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author turtlepig
 */
public class GameBoard extends JPanel implements ActionListener{

    Rectangle ground;
    Timer timer;
    Weasel weasel;
    double gravity = .02;
    public GameBoard(){
        this.setLayout(null);
        this.setBounds(0, 0, 900, 900);
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        
        weasel = new Weasel(this);
        this.addKeyListener(weasel);
        this.setFocusable(true);
        this.requestFocusInWindow();
        
        ground = new Rectangle();
        ground.setBounds(0, 800, 900, 20);
        
        
        
        timer = new Timer(5,this);
        timer.start();
    }
    
    public void checkCollisions(){
        if(weasel.getRectangle().intersects(ground)){
            weasel.canMoveDown = false;
        }
        else{
            weasel.canMoveDown = true;
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.fillRect(ground.x, ground.y, ground.width, ground.height);
        g2d.drawRect(ground.x, ground.y, ground.width, ground.height);
        g2d.drawImage(weasel.getImage(),weasel.x,weasel.y, null, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.checkCollisions();
        weasel.move();
        this.repaint();
    }



}
