package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AplicationFrame extends JFrame {

    private ActionListenerFactory actionListenerFactory;
    private ImageViewer imageViewer;
    private JLabel label;

    public AplicationFrame(ActionListenerFactory actionListenerFactory) {
        super("Image Viewer");
        label = new JLabel("Trabajo Realizado Por: DaniSanJuan93 & r3b0rNjHs");
        label.setForeground(Color.BLUE);
        label.setFont(new Font("Hola", Font.PLAIN, 10));
        this.actionListenerFactory = actionListenerFactory;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 500));
        createComponent();
    }

    public ActionListenerFactory getActionListenerFactory() {
        return actionListenerFactory;
    }

    public ImageViewer getImageViewer() {
        return imageViewer;
    }

    private void createComponent() {
        this.add(createPanel());
        this.add(createToolBar(), BorderLayout.SOUTH);
        this.add(label, BorderLayout.NORTH);
    }

    private JPanel createPanel() {
        imageViewer=new ImageViewerPanel();
        return (JPanel) imageViewer;
    }

    private JPanel createToolBar() {
        JPanel toolbar = new JPanel();
        toolbar.add(createPrev(), BorderLayout.SOUTH);
        toolbar.add(createNext(), BorderLayout.SOUTH);
        return toolbar;
    }

    private JButton createPrev() {
        JButton jButton = new JButton("Prev");
        jButton.addActionListener(actionListenerFactory.create("prev") );
        return jButton;
    }

    private JButton createNext() {
        JButton jButton = new JButton("Next");
        jButton.addActionListener(actionListenerFactory.create("next") );
        return jButton;
    }
}