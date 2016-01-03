package com.jvs.swinggame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class MenuState extends State {

    Color color;
    Random r = new Random();

    int x = 50;
    int y = 50;
    int width = 10;
    int height = 10;


    public MenuState(){
        super("MenuState");
        inputManager.addMappings("Up", KeyEvent.VK_UP);
        inputManager.addMappings("Down", KeyEvent.VK_DOWN);
        inputManager.addMappings("Left", KeyEvent.VK_LEFT);
        inputManager.addMappings("Right", KeyEvent.VK_RIGHT);

    }

    @Override
    public void render(){
        Graphics2D graphics2D = getGraphics2D();
        graphics2D.setColor(color);
        graphics2D.fillRect(x, y, width, height);
        graphics2D.drawString("This is the MenuState", 120, 120);

        super.render();
    }

    @Override
    public void update(){
        if(inputManager.isPressed("Up")){
            y--;
        }
        if(inputManager.isPressed("Down")){
            y++;
        }
        if(inputManager.isPressed("Left")){
            x--;
            color = Color.BLUE;
        }
        if(inputManager.isPressed("Right")){
            x++;
            color = Color.RED;
        }

        super.update();
    }
}
