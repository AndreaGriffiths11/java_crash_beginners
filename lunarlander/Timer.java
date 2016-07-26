import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Counter
{
    private Lander lander;
    
    public Timer()
    {
        this(new Lander());
    }
        
    public Timer(Lander l)
    {
        super("Time: ");
        lander = l;
        color = java.awt.Color.WHITE;
        updateValue();
    }
       
    protected final void updateValue()
    {
        value = (int) (System.currentTimeMillis() - lander.getLaunchTime());
        
    }  
}
