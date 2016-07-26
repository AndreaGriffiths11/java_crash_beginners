import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    import java.awt.Font;
    import java.awt.Color;
    
/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    
    protected int value = 0;
    private String text;
    private int stringLength;
    protected Color color = java.awt.Color.WHITE;
    
    
    public Counter()
    {
        this("");
    }
    
    public Counter(String prefix)
    {
        value = 0;
        text = prefix;
        stringLength = (text.length() + 2) * 20;

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));  // use larger font

        updateImage();
    }
    
    /**
     * Make the image
     */
    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.setColor(color);
        image.drawString(text + value, 1, 18);
    }
    
    public int getValue()
    {
        return value;
    }
    
    protected void updateValue()
    {
        // override in subclasses
    }
    
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
            updateValue();
            updateImage();
    }    
}
