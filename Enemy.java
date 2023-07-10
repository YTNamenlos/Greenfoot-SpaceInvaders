import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Mover
{
    public int life;
    public int speed = 1;
    public Enemy()
    {
        life = 1;
        GreenfootImage img = new GreenfootImage("Enemy-1.png");
        img.scale(img.getWidth()/5,img.getHeight()/5);
        setImage(img);
    }
    private void fire()
    {
        Patrone p = new Patrone(7);
        getWorld().addObject(p, getX(), getY());
        p.move();
    }
    public void act()
    {
        if (life <= 0){
            if(getWorld() != null){
                getWorld().removeObject(this);
            }
        }
    }
    public void moveRight()
    {
        setLocation(getX()+speed, getY());
    }
    public void moveLeft()
    {
        setLocation(getX()-speed, getY());
    }
    public void moveDown()
    {
        setLocation(getX(), getY()+getImage().getHeight());
    }
}
