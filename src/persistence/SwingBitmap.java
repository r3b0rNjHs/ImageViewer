package persistence;

import java.awt.image.BufferedImage;
import model.BitMap;

public class SwingBitmap implements BitMap {

    BufferedImage bufferdImage;

    public SwingBitmap(BufferedImage bufferdImage) {
        this.bufferdImage = bufferdImage;
    }

    public BufferedImage getBufferdImage() {
        return bufferdImage;
    }
    
    @Override
    public double getWidth() {
        return bufferdImage.getWidth();
    }

    @Override
    public double getHeight() {
        return bufferdImage.getHeight();
    }
}
