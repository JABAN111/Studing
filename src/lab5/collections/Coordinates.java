package lab5.collections;

/**
 * This class stores information about two coordinates in space
 */
public class Coordinates {

    private double x; //Значение поля >-485
    private int y; //Макс значение поля:914


    public Coordinates(double x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x coordinate of the point
     *
     * @return the value of the x coordinate
     */
    public double getX(){
        return x;
    }

    /**
     * Get the y coordinate of the point
     *
     * @return the value of the y coordinate
     */
    public int getY(){
        return y;
    }
    public String getCoordinates(){
        return x + "," + y;
    }

}
