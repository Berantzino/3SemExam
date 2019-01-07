package designPatterns.flyweight;

public class FlyweightPatternDemo
{
    private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };

    public static void main(String[] args)
    {
        for(int i=0; i < 20; ++i)
        {
            Circle circle = (Circle)ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    // 0-0.19x = 0 (Red), 0.2-0.39x = 1 (Green), 0.4-0.59x = 2 (Blue), 0.6-0.79x = 3 (White), 0.8-0.99x = 4 (Black)
    private static String getRandomColor()
    {
        return colors[(int)(Math.random()*colors.length)];
    }

    private static int getRandomX()
    {
        return (int)(Math.random()*100 );
    }

    private static int getRandomY()
    {
        return (int)(Math.random()*100);
    }
}


