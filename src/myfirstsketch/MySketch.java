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
    private Player npc, granny;
    private PImage bg, bg2;
    private PImage dialog1, dialog2, dialog3, dialog4, dialog5;
    public int dialogueOp = -1;
    int stage = 0;
    
    public void settings(){
	//sets the size of the window
        size (600,400);
    }
    
    public void setup(){
        // https://cainos.itch.io/pixel-art-top-down-village
        bg = loadImage("images/background4.png");
        bg2 = loadImage("images/background3.png");
        textSize(20);
        // new Player(PApplet p, x, y, name, w, imagePath)
        player = new Player(this, 369, 218, "Player 1", 35, "images/player.png");
        npc = new Player(this, 108, 160, "npc 1", 35, "images/npc.png");
        granny = new Player(this, 145, 267, "npc 2", 35, "images/grannynpc.png");
        
        // https://deathgenerator.com/#cs
        dialog1 = loadImage("images/dialog1.png");
        dialog2 = loadImage("images/dialog2.png");
        dialog3 = loadImage("images/dialog3.png");
        dialog4 = loadImage("images/dialog4.png");
        dialog5 = loadImage("images/dialog5.png");
        dialog1.resize(600, 0);
        dialog2.resize(600, 0);
        dialog3.resize(600, 0);
        dialog4.resize(600, 0);
        dialog5.resize(600, 0);
    }
    
    public void draw(){
        background(255);
        
        if (stage ==0) {
            fill(0);
            text("My cultural Story", 20, 50);
            text("Press any key to continue", 20, 100);
        } else if (stage == 1) {
            image(bg, 0, 0, width, height);
            player.draw();
            npc.draw();
            
            if (npc.isCollidingWith(player)) {
                if (dialogueOp == -1) {
                    dialogueOp = 0;
                }
                
                if (dialogueOp == 0) {
                    image(dialog1, 0, 245);
                } else if (dialogueOp == 1) {
                    image(dialog3, 0, 245);
                } else if (dialogueOp == 2) {
                    image(dialog4, 0, 245);
                }
            } else {
                dialogueOp = -1;
            }
            
            if (player.y > height) {
                stage = 2;
                player.y = 0;
            }

        } else if (stage == 2) {
            image(bg2, 0, 0, width, height);
            player.draw();
            granny.draw();
            
            if (granny.isCollidingWith(player)) {
                if (dialogueOp == -1) {
                    dialogueOp = 0;
                }

                if (dialogueOp == 0) {
                    image(dialog5, 0, 245);
                } else if (dialogueOp == 1) {
                    image(dialog2, 0, 245);
                }
            } else {
                dialogueOp = -1;
            }
            
            if (player.y < 0) {
                stage = 1;
                player.y = height;
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
    
}
    
    public void keyPressed() {
        if (stage ==0) {
            if (keyCode == ENTER) {
                stage = 1;
            }
        }
        
        if (keyCode == ENTER && npc.isCollidingWith(player)) {
            dialogueOp++;
        } else if (keyCode == ENTER && granny.isCollidingWith(player)) {
            dialogueOp++;
        }
    }

    
    public void mousePressed() {
        // player.moveTo(mouseX, mouseY);
        System.out.println("x: "+ mouseX+ " y: "+ mouseY);
    }
        
}
