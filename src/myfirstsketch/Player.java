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
public class Player {
    public int x, y;
    private String name; // name of the person
    private int w; // width and height
    private PImage image;
    private PApplet app;
    private PlayerStats stats;
    
    public Player(PApplet p, int x, int y, String name, int w, String imagePath) {
        this.app = p;
        this.x = x;
        this.y = y;
        this.name = name;
        this.w = w;
        this.stats = new PlayerStats();
        
        this.image = app.loadImage(imagePath);
        this.image.resize(w, 0);
  }

    public void move(int dx, int dy) {
        x += dx * stats.getSpeed();
        y += dy * stats.getSpeed();
    }
    
    public void moveTo(int dx, int dy) {
        x = dx;
        y = dy;
    }
    
    public boolean isCollidingWith(Player other) {
        // Check if the bounding boxes of the two persons intersect
        boolean isLeftOfOtherRight = x < other.x + other.image.width;
        boolean isRightOfOtherLeft = x + image.width > other.x;
        boolean isAboveOtherBottom = y < other.y + other.image.height;
        boolean isBelowOtherTop = y + image.height > other.y;

        return isLeftOfOtherRight && isRightOfOtherLeft
                && isAboveOtherBottom && isBelowOtherTop;

    }
    
    public void draw() {
        app.image(image, x, y);
    }
}
