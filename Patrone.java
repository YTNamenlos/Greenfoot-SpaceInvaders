import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Patrone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Patrone extends Mover
{
    private int life = 1;
    private int damage = 1;
    public Patrone(int speed)
    {
        super(new Vector(-speed, 0));
        increaseSpeed(new Vector(90, speed));
        GreenfootImage img = new GreenfootImage("Patrone.png");                                  
        img.scale(img.getWidth(), img.getHeight());
        setImage(img);
    }
    public void act()
    {
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else if(getY()>= getWorld().getHeight()-4){
            getWorld().removeObject(this);
        }
        else {
            move();
            Starship starship = (Starship) getOneIntersectingObject(Starship.class);
            if (starship != null) {
                starship.life--;
                getWorld().removeObject(this);
            }
        }
    }
}
