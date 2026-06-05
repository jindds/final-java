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
    private PImage bg;
    int stage = 0;
    
    public void settings(){
	//sets the size of the window
        size (600,400);
    }
    
    public void setup(){
        bg = loadImage("images/background.png");
        textSize(20);
        // new Player(PApplet p, x, y, name, w, imagePath)
        player = new Player(this, 10, 200, "Player 1", 30, "images/monster.png");
        npc = new Player(this, 108, 160, "npc 1", 35, "images/npc.png");
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
        fill(255, 0, 0);
        this.text("oouch! who are you?", npc.x, npc.y);
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
