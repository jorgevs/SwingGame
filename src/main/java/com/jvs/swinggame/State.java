package com.jvs.swinggame;

import org.apache.log4j.Logger;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class State extends Canvas implements Runnable {
    final static Logger log = Logger.getLogger(State.class);

    public String name;
    private boolean running = false;
    private long ticks = 0;

    public InputManager inputManager;
    private BufferedImage screen;
    private Graphics2D graphics2D;

    public int CANVAS_WIDTH = 400;
    public int CANVAS_HEIGHT = 300;

    public State(String name){
        this.name = name;
        this.inputManager = new InputManager(this);
        screen = new BufferedImage(CANVAS_WIDTH, CANVAS_HEIGHT, BufferedImage.TYPE_INT_RGB);
        this.setMaximumSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        this.setMinimumSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        this.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        this.setBackground(Color.DARK_GRAY);
        this.setVisible(true);
    }

    public void start(){
        if(!running) {
            running = true;
            new Thread(this).start();
            log.debug(name + " started!");
        }
    }

    public void stop(){
        if(running) {
            running = false;
            log.debug(name + " stop!");
        }
    }

    public void update(){
        ticks++;
    }

    public void render(){
        if(this.isDisplayable()){
            BufferStrategy bufferStrategy = getBufferStrategy();
            if(bufferStrategy == null){
                createBufferStrategy(3);
                return;
            }
            Graphics g = bufferStrategy.getDrawGraphics();
            g.setColor(Color.MAGENTA);
            g.drawImage(screen, 0, 0, CANVAS_WIDTH, CANVAS_HEIGHT, this);
            g.drawString("Ticks: " + getTicks(), 10, 10);
            g.dispose();
            bufferStrategy.show();
        }
    }

    public void run(){
        while(running){
            update();
            render();
        }
    }

    public Graphics2D getGraphics2D(){
        screen = new BufferedImage(CANVAS_WIDTH, CANVAS_HEIGHT, BufferedImage.TYPE_INT_RGB);
        graphics2D = screen.createGraphics();
        return graphics2D;
    }

    public boolean isRunning(){
        return running;
    }

    public long getTicks(){
        return ticks;
    }

}

