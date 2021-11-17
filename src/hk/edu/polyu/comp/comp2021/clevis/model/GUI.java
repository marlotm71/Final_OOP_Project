package hk.edu.polyu.comp.comp2021.clevis.model;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Class Graphic User Interface
 */
public class GUI {
    /**
     * Draw each shape of listShapeAll in a frame
     * @param listShapeAll : List of all the shapes created
     */
    public void drawFinal(List<Shape> listShapeAll){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI 2D SHAPES");
        frame.pack();
        frame.setBounds(100,100,1000,1000);
        frame.setVisible(true);
        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                for (Shape elt : listShapeAll){
                    elt.draw(g);
                }
            }
        };
        panel.setLayout(new GridLayout(0,1));
        frame.add(panel,BorderLayout.CENTER);
    }

    /**
     * New frame
     */
    private JFrame frame = new JFrame();
}
