/**
 * A class that lets you create a rectangle and do stuff with it.
 * @author Bert
 */
public class Rectangle {

    int width;
    int height;

    /**
     * Creates an empty rectangle object.
     */
    public Rectangle(){}

    /**
     * This will make a square
     * @param side The length of one side of the square
     */
    public Rectangle(int side){
        width = side;
        height = side;
    }

    /**
     * Creates a rectangle by defining it's width and height.
     * @param width
     * @param height
     */
    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    /**
     * Prints the area of the recangle
     * @return Recangle Area
     */
    public int getArea(){
        return width * height;
    }

    /**
     * Gets the perimeter of the rectangle
     * @return Rectangle Perimeter
     */
    public int getPerimeter(){
        return (width * 2) + (height * 2);
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    private String makeRectangle(){
        String rect = "";
        for(int x = 1; x <= height; x++){
            rect += "\n";
            for(int y = 1; y <= width; y++){
                rect += "*";
            }
        }

        return rect;
    }

    public String toString(){
        return makeRectangle();
    }
    
}
