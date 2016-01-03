package com.jvs.swinggame.animators;

import com.jvs.swinggame.Animator;
import com.jvs.swinggame.BufferedImageLoader;
import com.jvs.swinggame.SpriteSheet;
import com.jvs.swinggame.State;
import org.apache.log4j.Logger;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class MarioState extends State {
    final static Logger log = Logger.getLogger(MarioState.class);

    private Animator mario;

    int x = 50;
    int y = 50;
    int width = 10;
    int height = 10;


    public MarioState(){
        super("MarioState");
        inputManager.addMappings("Up", KeyEvent.VK_UP);
        inputManager.addMappings("Down", KeyEvent.VK_DOWN);
        inputManager.addMappings("Left", KeyEvent.VK_LEFT);
        inputManager.addMappings("Right", KeyEvent.VK_RIGHT);

        init();
    }

    public void init(){
        try{
            BufferedImageLoader loader = new BufferedImageLoader();

            //Loads MarioState ---------------------------------------------------------
            BufferedImage imgSpriteSheetMario = null;
            try{
                imgSpriteSheetMario = loader.loadImage("../../../mario2.gif");
            } catch (IOException e) {
                log.error("Error while loading the imgSpriteSheet: " + e);
            }
            SpriteSheet spriteSheetMario = new SpriteSheet(imgSpriteSheetMario);

            ArrayList<BufferedImage> spritesMario = new ArrayList<BufferedImage>();
            spritesMario.add(spriteSheetMario.grabSpriteSheet(22, 52, 49, 105));
            spritesMario.add(spriteSheetMario.grabSpriteSheet(232, 54, 263, 107));

            mario = new Animator(spritesMario);
            mario.setSpeed(100);
            mario.play();
        } catch (Exception e) {
            log.error("Error in init() method: " + e);
        }
    }

    @Override
    public void render(){
        Graphics2D graphics2D = getGraphics2D();
        graphics2D.fillRect(x, y, width, height);
        graphics2D.drawString("This is the MarioState", 120, 120);

        if(mario != null){
            mario.update(System.currentTimeMillis());
            graphics2D.drawImage(mario.getSprite(), x, y, null);
        }

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
        }
        if(inputManager.isPressed("Right")){
            x++;
        }

        super.update();
    }

}
