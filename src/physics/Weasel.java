/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package physics;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;

/**
 *
 * @author turtlepig
 */
public class Weasel implements KeyListener{
    Image weasel;
    int x, y, width, height;
    int dx, dy;
    double fallingSpeed;
    boolean moveRight, moveLeft;
    //collision boolean
    boolean canMoveDown;
    GameBoard gameBoard;
    public Weasel(GameBoard gameBoard){
            ImageIcon ii = new ImageIcon("/Users/turtlepig/Documents/flyer/weasel.jpg");
            this.gameBoard = gameBoard;
            width = 80;
            height = 80;
            weasel = ii.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            
            x = 10;
            y = 10;
            dx = 1;
            dy = 1;
            fallingSpeed = 0;
            moveRight = false;
            moveLeft = false;
            canMoveDown = true;
    }
    
    public void move(){
        if(canMoveDown){
            dy = (int) (fallingSpeed+=gameBoard.gravity);
        }
        else{
            fallingSpeed = 0;
            dy = 0;
        }
        
        if(moveRight){
            dx = 2;
        }
        else if (moveLeft){
            dx = -2;
        }
        else{
            dx = 0;
        }
        
        this.x+=dx;
        this.y+=dy;
    }
    
    public Image getImage(){
        return weasel;
    }
    
    public Rectangle getRectangle(){
        return new Rectangle(x,y,width,height);
    }
    
       @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("lasjfa;sdlf");
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_A){
            moveLeft = true;
        }
        if(key == KeyEvent.VK_D){
            moveRight = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_A){
            moveLeft = false;
        }
        if(key == KeyEvent.VK_D){
            moveRight = false;
        }
    }
    
    
}
