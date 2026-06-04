/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myfirstsketch;

/**
 *
 * @author 348337643
 */
public class PlayerStats {
    private int hp;
    private int dmg;
    private int speed;
    
    public PlayerStats() {
        hp = 10;
        dmg = 2;
        speed = 1;
    }
    
    public PlayerStats(int hp, int dmg, int speed) {
        this.hp = hp;
        this.dmg = dmg;
        this.speed = speed;
    }
    
    public int getHP() {
        return hp;
    }
    
    public int getDMG() {
        return dmg;
    }
    
    public int getSpeed() {
        return speed;
    }
}
