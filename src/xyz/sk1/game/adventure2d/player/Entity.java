package xyz.sk1.game.adventure2d.player;

import xyz.sk1.game.adventure2d.handlers.KeyHandler;
import xyz.sk1.game.adventure2d.player.utilities.Location;

public abstract class Entity {

    public abstract void setDefaults();

    public abstract void navigate();

    public abstract int getVelocity();

    public abstract void setVelocity(int velocity);

    public abstract Location getPosition();

    public abstract void setPosition(Location location);


    public abstract KeyHandler getControl();
}
