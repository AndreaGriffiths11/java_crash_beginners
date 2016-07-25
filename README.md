# java-crash-course-beginners
### Link To This Page
You can get to this page via:http://tinyurl.com/TIY-JAVA

And this is a fun learning tool we will use, it's called [Greenfoot](http://www.greenfoot.org/download).  Download and install it as well.

##Introduction
The best way to learn any new language is to jump in and start building. Today's lesson will set the stage for the next two weeks. Don't worry if you don't understand everything we are doing today. All of this will be explained in more detail over the next few days. The important part is that you go through all the exercises. The understanding of what you are doing will come from the lectures, your questions, and doing the exercises.

##Topics
* Object Oriented Programming
* Objects
* Inheritance
* Classes
* Methods
* Variables

##Explanation
Start by downloading [Greenfoot](http://www.greenfoot.org/download). Open Greenfoot and start the Lunar Lander application. Play the game for a few minutes.
On the right side you will see all the classes. Lets go through them...
* Click on World. World is an object of type Class. Its actually an abstract parent class. More on this later.
* Click on Moon. Moon is also and object of type class. Moon is a child of World. This means Moon inherits from World.
* The Moon class and it's inheritance from World are defined in the line "public class Moon extends World".
* Inside Moon we have Variables and Methods.
* Look for "gravity", "landingColor", and "spaceColor". These are variables.
* Now look for the Methods, such as "public Moon()" and "public double getGravity()".
* lets talk about what they do and why their signatures are important.


![lander1.jpg](https://tiy-learn-content.s3.amazonaws.com/b8c11f59-lander1.jpg)

<br><br>
##Exercise
Notice there are "World Classes" and "Actor Classes". What do you think the differences are? Open the "Lander", "Explosion", and "Flag" classes. These are all class objects and they are all children that inherit from the parent class "Actor". Lets walk through the variables and methods of the "Lander" class.

The second variable is "MAX_LANDING_SPEED". Based on what we just went through, this is the variable we use to decide if the lander will crash or land. Change the variable "MAX_LANDING_SPEED" to 1000, save, and play again. Notice you can't crash the lander. Now change "MAX_LANDING_SPEED" to 1, save, and play again. This time it's almost impossible to win. Regardless of the "MAX_LANDING_SPEED", we don't know how fast the lander is ever moving, we can only guess. So lets to an exercise to show the speed of the lander on the game.

* Right-click on "Actor" and make a new Sub-Class called "Counter".
* Open Counter.
* Notice the class signature "public class Counter extends Actor".
* Notice the open and closed brackets.
* Lets add a constructor.

```java
    public Counter()
    {
        this("");
    }
```
* Now lets add an overloaded constructor, right below the first constructor.

```java
    public Counter(String prefix)
    {
        value = 0;
        text = prefix;
        stringLength = (text.length() + 2) * 16;

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));  // use larger font

        updateImage();
    }
```
* Notice all the red underscores. This means we are missing important parts.
* Our overloaded constructor uses some variables, but we have not initialized them yet.
* Notice "value", "text", and "stringLength". See how they are underscored in red?
* Lets declare these variables at the class level. Above the constructor, add the following.

```java
    protected int value = 0;
    private String text;
    private int stringLength;
    protected Color color = java.awt.Color.WHITE;
```
* We still have some underscores. "Color", "Font", and "updateImage".
* Color and Font are classes in the awt package. If we import these classes, we will be able to access their public methods.
* Right below "import greenfoot.*;", add the following.

```java
    import java.awt.Font;
    import java.awt.Color;
```
* The only thing let underscored is "updateImage()" which is a method we will create in just a minute.
* Now lets add a getter and setter for the variable "value". Add the following after the "act()" method.

```java
    public int getValue()
    {
        return value;
    }
    protected void updateValue()
    {
        // override in subclasses
    }
```
* What do you think that means? "// override in subclasses"
* Two forward slashes are one way to put comments in Java code.
* Now lets add the method that allows the magic to happen. Add the following method right before the closing bracket.

```java
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
```
* Notice the /** and */. This is another way to put comments in code. This particular style of comments is used in JavaDocs.
* Now lets tell the "act()" method to actuate our "updateValue()" and "updateImage" methods. Add these two lines to the "act()" method.

```java
    updateValue();
    updateImage();
```
* Save. Lets talk about what we just did.
* We are halfway done with this exercise. We just created a child class of Actor that will become a parent class for any kind of counters we want to add to the game.
* Lets now add our speedometer so we will know how fast our lander is moving. The speedometer will be a type of counter, so it will be a child of the "Counter" class and inherit variables and methods from the "Counter" class.
* Right-click on the "Counter" class and create a new sub-class called "Speedometer".
* Open the class "Speedometer".
* Notice the class signature.
* Before we add any code, lets remove the "act()" method. As this is a subclass of Count, Speedometer will inherit the act() method from the Count class.
* In order for the speedometer to know how fast the lander is going, it will need to access the lander.
* Lets add a variable named "lander" that is type "Lander".

```java
    private Lander lander;
```
* Lets review the signature of this variable.
* Now lets add a constructor.

```java
    public Speedometer()
    {
        this(new Lander());
    }
```
* What do you think the "this(new Lander());" means?
* Lets add an overloaded constructor.

```java
    public Speedometer(Lander l)
    {
        super("Speed: ");
        lander = l;
        color = java.awt.Color.WHITE;
        updateValue();
    }
```
* What does overloaded mean?
* What do you think super means?
* Where are we getting the variable color from?
* Remember when we added the comment in the parent class that looked like this, "// override in subclasses"?
* This is the subclass. A subclass is a child of a parent class. So Speedometer is a subclass of Counter.
* Lets override the method "updateValue()".

```java
    protected final void updateValue()
    {
        value = (int) Math.abs(lander.getVelocity());
    }
```
* What do you think override means?
* What does protected, final, and void mean?
* Notice we get a red underscore at lander.getVelocity(). That means the class "Lander" does not have a method with the signature "getVelocity()".
* open the class Lander and add the following method.

```java
    /**
     * Current speed
     */
    public double getVelocity()
    {
        return speed;
    }
```
* Now we have a lander with a speedometer. The last thing left to do is display the speedometer in the world.
* Open the Moon class and add the following line in the constructor.

```java
    addObject(new Speedometer(lander), 135, 80);
```
* Notice the red underscore under lander. Lets move the lander into a class level variable.

```java
    /** Lander **/
    private Lander lander;
```
* See the /** and */? This is another way to put in comments.
* finally we want to make sure the Lander object that displays on the screen is the same Lander object that our speedometer is tracking.
* Lets initialize the Lander object in the constructor.

```java
      lander = new Lander();
```
* And change the ```java
addObject(new Lander(), 326, 100); ``` to ```java
addObject(lander, 326, 100); ```.  
* Save, reset, and play game.

![lander2.jpg](https://tiy-learn-content.s3.amazonaws.com/6331bf93-lander2.jpg)
