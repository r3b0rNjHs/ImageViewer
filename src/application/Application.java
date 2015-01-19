package application;

import control.DictionaryCommand;
import control.NextImageCommand;
import control.PrevImageCommand;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.Image;
import persistence.ImageLoaderFileList;
import swing.ActionListenerFactory;
import swing.AplicationFrame;

public class Application {
 static  final String Path="Ruta del directorio de imágenes";
    public static void main(String[] args) {
        new Application().execute();
    }

    private void execute() {
        final DictionaryCommand commandSet = new DictionaryCommand();
        ImageLoaderFileList imageLoaderFileList=new ImageLoaderFileList(Path);
        List<Image>list = imageLoaderFileList.load();
        ActionListenerFactory actionListenerFactory = new ActionListenerFactory() {
            @Override
            public ActionListener create(final String name) {
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        commandSet.get(name).execute();
                    }
                };
            }
        };
        AplicationFrame frame=new AplicationFrame(actionListenerFactory);
        frame.getImageViewer().setImage(list.get(0));
        commandSet.put("next", new NextImageCommand(frame.getImageViewer()));
        commandSet.put("prev", new PrevImageCommand(frame.getImageViewer()));
        frame.setVisible(true);
    }
}
