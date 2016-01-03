package com.jvs.swinggame;

import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class BufferedImageLoader {
    final static Logger log = Logger.getLogger(BufferedImageLoader.class);

    public BufferedImage loadImage(String pathRelativeToThis) throws IOException {
        BufferedImage image = null;

        URL url = this.getClass().getResource(pathRelativeToThis);
        log.debug("url: " + url);

        image = ImageIO.read(url);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return image;
    }
}