package com.jvs.swinggame;

import org.apache.log4j.Logger;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    final static Logger log = Logger.getLogger(SpriteSheet.class);

    private BufferedImage spriteSheet;

    public SpriteSheet(BufferedImage spriteSheet){
        this.spriteSheet = spriteSheet;
    }

    public BufferedImage grabSpriteSheet(int x1, int y1, int x2, int y2){
        BufferedImage sprite = spriteSheet.getSubimage(x1, y1, x2-x1, y2-y1);
        //BufferedImage sprite = spriteSheet.getSubimage(x, y, width, height);
        return sprite;
    }
}
