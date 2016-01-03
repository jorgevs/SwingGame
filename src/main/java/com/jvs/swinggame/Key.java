package com.jvs.swinggame;

public class Key {

    private String name;
    private int keyCode;

    private boolean pressed;
    private int pressCount;

    public Key(String name, int keyCode) {
        this.name = name;
        this.keyCode = keyCode;
        this.pressed = false;
    }

    public String getName() {
        return name;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public boolean getPressed() {
        return this.pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;

        if (this.pressed == true) {
            pressCount++;
        }
    }

    public int getPressCount(){
        return this.pressCount;
    }

}
