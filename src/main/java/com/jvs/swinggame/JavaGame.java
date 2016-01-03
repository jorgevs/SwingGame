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
        stateManager.setCurrentState("MarioState");
        //stateManager.setCurrentState("MenuState");
        stateManager.startCurrentState();
    }

    @Override
    public void paint(Graphics g){

    }

    public static void main(String[] args){
        log.info( "Starting JavaGame..." );
        JavaGame game = new JavaGame();
    }

}
