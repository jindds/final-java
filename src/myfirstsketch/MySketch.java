/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myfirstsketch;

import processing.core.PApplet;

/**
 *
 * @author 348337643
 */
public class MySketch extends PApplet{
    private Player player;
    int stage = 0;
    
    public void settings(){
	//sets the size of the window
        size (400,400);
    }
    
    public void setup(){
	//sets the background colour using R,G,B (https://rgbcolorpicker.com/)
        background(100,100,100);
        textSize(20);
        player = new Player(this, 10, 200, "Player 1", 20, "images/64x64_player.png");
    }
    
    public void draw(){
        background(255);
        
        if (stage ==0) {
            fill(0);
            text("My cultural Story", 20, 50);
            text("Press any key to continue", 20, 100);
        } else if (stage ==1) {
            player.draw();
        }
        
    if (keyPressed) {
        if (keyCode == LEFT) {
          player.move(-5, 0);
        } else if (keyCode == RIGHT) {
          player.move(5, 0);
        } else if (keyCode == UP) {
          player.move(0, -5);
        } else if (keyCode == DOWN) {
          player.move(0, 5);
        }

    }
}
    public void keyPressed() {
        if (stage ==0) {
            if (keyCode == ENTER) {
                stage = 1;
            }
        }
    }

    
    public void mousePressed() {
        player.moveTo(mouseX, mouseY);
    }
        
}
