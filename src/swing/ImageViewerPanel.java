package swing;

import model.Image;
import java.awt.Graphics;
import javax.swing.JPanel;
import persistence.SwingBitmap;

public class ImageViewerPanel extends JPanel implements ImageViewer {

    private Image image;
    private int initialX;
    private int offset;
  

    public ImageViewerPanel() {
        offset = 0;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image2) {
        image = image2;
        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        if (image == null) {
            return;
        }
        super.paint(graphics);
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        if (image.getBitMap() instanceof SwingBitmap) {
            graphics.drawImage(getBufferedImage((SwingBitmap) image.getBitMap()), offset, 0, null);
            putImage(graphics);
        }

    }

    private java.awt.Image getBufferedImage(SwingBitmap swingBitmap) {
        return swingBitmap.getBufferdImage();
    }

    private void putImage(Graphics graphics) {
        if (offset == 0) {
            return;
        }
        if (offset < 0) {
            graphics.drawImage(getBufferedImage((SwingBitmap) image.getNext().getBitMap()), 
                                                (int) (image.getBitMap().getWidth()+ offset), 
                                                0, null);
        } else {
            graphics.drawImage(getBufferedImage((SwingBitmap) image.getPrev().getBitMap()), 
                              (int) (offset-image.getBitMap().getWidth()), 
                               0, null);
        }
    }
}
