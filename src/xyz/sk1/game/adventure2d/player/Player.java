package xyz.sk1.game.adventure2d.player;

import xyz.sk1.game.adventure2d.handlers.KeyHandler;
import xyz.sk1.game.adventure2d.player.utilities.Location;

public class Player extends Entity {

    private int size = 16, scalar, velocity, borderX, borderY;

    private KeyHandler control;

    private Location location;

    @Override
    public void setDefaults() {
        this.size = 16;//pxs
        this.scalar = 3;

        this.control = new KeyHandler();

        this.location = new Location();

        this.location.setX(100);
        this.location.setY(100);


        this.velocity = 4;

    }

    @Override
    public void navigate() {

        int x = this.location.getX();
        int y = this.location.getY();

        if((x >= 0 && y >= 0) && (x < borderX && y < borderY)){

            if(control.aPressed) {
                this.location.setX(x -= velocity);
            }

            if(control.dPressed) {
                this.location.setX(x += velocity);
            }

            if(control.wPressed) {
                this.location.setY(y -= velocity);
            }

            if(control.sPressed) {
                this.location.setY(y += velocity);
            }


        } else {

            if(x >= borderX){
                this.location.setX(x -= velocity);
            }

            if(x <= 0){
                this.location.setX(x += velocity);
            }

            if(y >= borderY){
                this.location.setY(y -= velocity);
            }

            if(y <= 0){
                this.location.setY(y += velocity);
            }

        }

    }

    @Override
    public int getVelocity() {
        return this.velocity;
    }

    @Override
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public Location getPosition() {
        return this.location;
    }

    @Override
    public void setPosition(Location location) {
        this.location = location;
    }

    @Override
    public KeyHandler getControl() {
        return this.control;
    }

    public void setControl(KeyHandler control){
        this.control = control;
    }

    public void setBorderLimit(int boarderX, int boarderY){
        this.borderX = boarderX;
        this.borderY = boarderY;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setScalar(int scalar){
        this.scalar = scalar;
    }

    public int getScaledSize(){
        return this.scalar * this.size;
    }

}
