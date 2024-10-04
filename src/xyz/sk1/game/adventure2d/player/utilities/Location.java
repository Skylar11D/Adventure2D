package xyz.sk1.game.adventure2d.player.utilities;

public class Location {

    private int x;
    private int y;
    //private int z;


    public Location(){
        //default values
    }

    public Location(int positionX, int positionY){
        this.x = positionX;
        this.y = positionY;
        //this.z = positionZ;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
