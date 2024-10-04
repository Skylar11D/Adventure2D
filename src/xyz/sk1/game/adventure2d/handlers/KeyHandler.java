package xyz.sk1.game.adventure2d.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean aPressed, wPressed, dPressed, sPressed = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        aPressed = e.getKeyCode() == KeyEvent.VK_A;

        wPressed = e.getKeyCode() == KeyEvent.VK_W;

        dPressed = e.getKeyCode() == KeyEvent.VK_D;

        sPressed = e.getKeyCode() == KeyEvent.VK_S;

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_A){
            aPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_W){
            wPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_D){
            dPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_S){
            sPressed = false;
        }

    }
}
