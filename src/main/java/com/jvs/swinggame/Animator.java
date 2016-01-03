package com.jvs.swinggame;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animator {
    private ArrayList<BufferedImage> frames = null;
    private BufferedImage sprite = null;

    private volatile boolean running = false;
    private long previousTime;
    private long speed;

    private int currentFrame;
    private int frameAtPause;


    public Animator(ArrayList<BufferedImage> frames){
        this.frames = frames;
    }

    public void update(long time){
        if(running){
            if(time - previousTime >= speed) {
                //Update the animation
                currentFrame++;

                if (currentFrame >= frames.size()) {
                    currentFrame = 0;
                }

                sprite = frames.get(currentFrame);
                previousTime = time;
            }
        }
    }

    public void play(){
        running = true;
        previousTime = 0;
        frameAtPause = 0;
        currentFrame = 0;
    }
    public void stop(){
        running = false;
        previousTime = 0;
        frameAtPause = 0;
        currentFrame = 0;
    }
    public void pause(){
        frameAtPause = currentFrame;
        running = false;
    }
    public void resume(){
        currentFrame = frameAtPause;
        running = true;
    }


    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public long getSpeed(){
        return this.speed;
    }

    public void setSpeed(long speed){
        this.speed = speed;
    }
}
