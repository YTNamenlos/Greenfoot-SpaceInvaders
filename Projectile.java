import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Mover
{
    private int life = 1;
    private int damage = 1;
    public Projectile(int speed)
    {
        super(new Vector(-speed, 0));
        increaseSpeed(new Vector(-90, speed));
        GreenfootImage img = new GreenfootImage("Projectile.png");                                  
        img.scale(img.getWidth()/3, img.getHeight()/3);
        setImage(img);
    }
    public void act()
    {
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else if(getY()<= 4){
            getWorld().removeObject(this);
        }
        else {
            move();
            Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
            if (enemy != null) {
                enemy.life--;
                ((MyWorld)getWorld()).starship.score += 10;
                getWorld().removeObject(this);
            }
        }
    }
}
