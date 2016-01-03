package com.jvs.swinggame;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class InputManager implements KeyListener {

    public ArrayList<Key> keys = new ArrayList<Key>();

    public InputManager(Canvas canvas) {
        canvas.addKeyListener(this);
    }

    public void addMappings(String name, int keyCode) {
        keys.add(new Key(name, keyCode));
    }

    public boolean isPressed(String keyName) {
        for (int i = 0; i < keys.size(); i++) {
            if (keyName.equals(keys.get(i).getName())) {
                return keys.get(i).getPressed();
            }
        }
        return false;
    }

    public void keyPressed(KeyEvent e) {
        for (int i = 0; i < keys.size(); i++) {
            if (e.getKeyCode() == keys.get(i).getKeyCode()) {
                keys.get(i).setPressed(true);
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        for (int i = 0; i < keys.size(); i++) {
            if (e.getKeyCode() == keys.get(i).getKeyCode()) {
                keys.get(i).setPressed(false);
            }
        }
    }

    public void keyTyped(KeyEvent e) {
    }

}
