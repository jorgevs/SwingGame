package com.jvs.swinggame;

import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class JavaGame extends JFrame {
    final static Logger log = Logger.getLogger(JavaGame.class);

    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    StateManager stateManager;

    //private Animator mario;
    //private Animator snake;

    public JavaGame(){
        this.setTitle("JavaGame");
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        init();
    }

    private void init() {
        stateManager = new StateManager(this);
        stateManager.setCurrentState("MenuState");
        stateManager.startCurrentState();

        /*BufferedImageLoader loader = new BufferedImageLoader();

        //Loads Mario ---------------------------------------------------------
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

        //Loads SnakeMan ---------------------------------------------------------
        BufferedImage imgSpriteSheetSnake = null;
        try{
            imgSpriteSheetSnake = loader.loadImage("../../../snake.png");
        } catch (IOException e) {
            log.error("Error while loading the imgSpriteSheet: " + e);
        }

        SpriteSheet spriteSheetSnake = new SpriteSheet(imgSpriteSheetSnake);

        ArrayList<BufferedImage> spritesSnake = new ArrayList<BufferedImage>();
        //spritesSnake.add(spriteSheetSnake.grabSpriteSheet(8, 18, 41, 47));
        spritesSnake.add(spriteSheetSnake.grabSpriteSheet(58, 18, 87, 45));
        spritesSnake.add(spriteSheetSnake.grabSpriteSheet(105, 17, 129, 45));
        spritesSnake.add(spriteSheetSnake.grabSpriteSheet(149, 18, 176, 45));
        spritesSnake.add(spriteSheetSnake.grabSpriteSheet(105, 17, 129, 45));

        snake = new Animator(spritesSnake);
        snake.setSpeed(90);
        snake.play();*/
    }

    //Image dbImage;
    //Graphics dbg;

    @Override
    public void paint(Graphics g){
        /*dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);

        //g.drawString("Hello world!", 250, 250);
        g.drawImage(dbImage, 100, 100, null);*/
    }

    public void paintComponent(Graphics g){
        /*if(mario != null){
            mario.update(System.currentTimeMillis());
            g.drawImage(mario.getSprite(), 100, 100, null);
        }

        if(snake != null){
            snake.update(System.currentTimeMillis());
            g.drawImage(snake.getSprite(), 200, 200, null);
        }

        repaint();*/
    }


    public static void main(String[] args){
        log.info( "Starting JavaGame..." );
        JavaGame game = new JavaGame();
    }

}
