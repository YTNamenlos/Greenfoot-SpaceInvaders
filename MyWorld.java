import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    List<Enemy> enemies = new ArrayList<Enemy>();
    
    public Starship starship;
    public String direction = "";
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground(new GreenfootImage("Background.jpg"));
        prepare();
        // Starship erstellen
        starship = new Starship();
        addObject(starship, 300, 375); 
    }
    public void prepare()
    {
        // 4 Reihen Gegner mit jeweils 8 Gegnern
        for(int z = 0; z < 4; z++){
            for (int i = 1; i <= 8; i++){
                Enemy enemy = new Enemy();
                // Alle Gegner in Liste einfügen
                enemies.add(enemy);
                addObject(enemy,enemy.getImage().getWidth()*i + (i*25), z * enemy.getImage().getHeight() + (enemy.getImage().getHeight() + 20) + (z*15));
            }
        }
    }
    public int getHighestX()
    {
        int highestX = 0;
        for (Enemy e : enemies){
            if(e.getWorld() != null){
              if (e.getX() > highestX){
                highestX = e.getX();
              }
            }
        }
        return highestX;
    }
        public int getLowestX()
    {
        int lowestX = 100000000;
        for (Enemy e : enemies){
            if(e.getWorld() != null){
              if (e.getX() < lowestX){
                lowestX = e.getX();
              }
            }
        }
        return lowestX;
    }
    public void act(){
        // Gegner bewegen
        if(getLowestX()<=0){
            for (Enemy e : enemies){
                if (e.getWorld() != null){
                    e.moveDown();
                    e.moveRight();
                    direction = "right";
                }
            }
        } else if(getHighestX()>=getWidth()-1){
            for (Enemy e : enemies){
                if (e.getWorld() != null){
                    e.moveDown();
                    e.moveLeft();
                    direction = "left";
                }
            }
        }
        if(direction == "left"){
            for (Enemy e: enemies){
                if (e.getWorld() != null){
                    e.moveLeft();
                }
            }
        } else{
            for (Enemy e: enemies){
                if (e.getWorld() != null){
                    e.moveRight();
                }
            }
        }
        for (Enemy e: enemies){
            if (e.getWorld() != null){
                if(e.getY()>=getHeight()-e.getImage().getHeight()-10){
                    removeObject(starship);
                }
            }
        }
        // sterbe Screen
        if(getObjects(Starship.class).size()==0){
            this.showText("Game Over, starte das Spiel neu!", getWidth()/2, getHeight()/2);
        }
        // sieges Screen
        if(starship.score == 320){
            this.showText("You saved the Universe! Congrats!", getWidth()/2, getHeight()/2);
        }
    }
}
