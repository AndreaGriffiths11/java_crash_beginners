import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Speedometer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Speedometer extends Counter
{
    private Lander lander;
    
    public Speedometer()
    {
        this(new Lander());
    }
        
    public Speedometer(Lander l)
    {
        super("Speed: ");
        lander = l;
        color = java.awt.Color.WHITE;
        updateValue();
    }
       
    protected final void updateValue()
    {
        value = (int) Math.abs(lander.getVelocity());
        
        // lets color the text by under or over max speed
    
        if(lander.getVelocity() < lander.MAX_LANDING_SPEED ){
            color = java.awt.Color.GREEN;
        } else {
            color = java.awt.Color.RED;
        }
        
    }
}
