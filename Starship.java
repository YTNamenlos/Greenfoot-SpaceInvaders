import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Starship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Starship extends Mover
{
    private int gunReloadTime; // minimum delay before shooting again
    private int reloadDelayCount; // How long ago fired the gun the last time
    public int score = 0;
    public int life = 3;
    public Starship()
    {
        gunReloadTime = 30;
        reloadDelayCount = 0;
        GreenfootImage img = new GreenfootImage("Starship.png");
        img.scale(50,50);
        setImage(img);
    }
    public void prepareActor()
    {
        
    }
    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+4, getY());
        }
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-4, getY());
        }
        if(Greenfoot.isKeyDown("space")){
            fire();
        }
    }
    private void fire()
    {
        if (reloadDelayCount >= gunReloadTime){
            Projectile p = new Projectile(7);
            getWorld().addObject(p, getX(), getY());
            p.move();
            reloadDelayCount = 0;
        }
    }
    public void act()
    {
        move();
        checkKeyPress();
        checkCollision();
        reloadDelayCount++;
        // Score Anzeigen
        if (getWorld()!=null){
            this.getWorld().showText("Score: " + score, getWorld().getWidth()/2, 10);
        }
    }
    public void setGunReloadTime(int reloadTime)
    {
        gunReloadTime = reloadTime;
    }
    private void checkCollision()
    {
        // Tod oder nicht Tod?
        Enemy e = (Enemy) getOneIntersectingObject(Enemy.class);
        if (e != null) {
            getWorld().removeObject(this);
        }
    }
}
