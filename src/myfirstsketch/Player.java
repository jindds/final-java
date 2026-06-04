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
    private int x, y;
    private String name; // name of the person
    private int age; // age of the person
    private PImage image;
    private PApplet app;
    private PlayerStats stats;
    
    public Player(PApplet p, int x, int y, String name, int age, String imagePath) {
        this.app = p;
        this.x = x;
        this.y = y;
        this.name = name;
        this.age = age;
        this.stats = new PlayerStats();
        
        this.image = app.loadImage(imagePath);
  }

    public void move(int dx, int dy) {
        x += dx * stats.getSpeed();
        y += dy * stats.getSpeed();
    }
    
    public void moveTo(int dx, int dy) {
        x = dx;
        y = dy;
    }
    
    public void draw() {
        app.image(image, x, y);
    }
}
