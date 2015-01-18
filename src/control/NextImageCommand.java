package control;

import swing.ImageViewer;

public class NextImageCommand implements Command {

    ImageViewer imageViewer;

    public NextImageCommand(ImageViewer imageViewer) {
        this.imageViewer = imageViewer;
    }

    @Override
    public void execute() {
        imageViewer.setImage(imageViewer.getImage().getNext());  
    }
}