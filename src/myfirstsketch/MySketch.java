/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myfirstsketch;

import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author 348337643
 */
public class MySketch extends PApplet{
    private Player player;
    private Player npc;
    private PImage bg, bg2;
    private PImage dialog1;
    int stage = 0;
    
    public void settings(){
	//sets the size of the window
        size (600,400);
    }
    
    public void setup(){
        bg = loadImage("images/background.jpg");
        bg2 = loadImage("images/background2.png");
        textSize(20);
        // new Player(PApplet p, x, y, name, w, imagePath)
        player = new Player(this, 10, 200, "Player 1", 30, "images/monster.png");
        npc = new Player(this, 108, 160, "npc 1", 35, "images/npc.png");
        
        // https://deathgenerator.com/#cs
        dialog1 = loadImage("images/dialog1.png");
        dialog1.resize(600, 0);
    }
    
    public void draw(){
        background(255);
        
        if (stage ==0) {
            fill(0);
            text("My cultural Story", 20, 50);
            text("Press any key to continue", 20, 100);
        } else if (stage ==1) {
            image(bg, 0, 0, width, height);
            player.draw();
            npc.draw();
            
            if (player.x > width) {
                stage = 2;
                player.x = 0;
            }

        } else if (stage == 2) {
            image(bg2, 0, 0, width, height);
            player.draw();
            
            if (player.x < 0) {
                stage = 1;
                player.x = width;
            }
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
    
    if (npc.isCollidingWith(player)) {
        image(dialog1, 0, 245);
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
        System.out.println("x: "+ mouseX+ " y: "+ mouseY);
    }
        
}
