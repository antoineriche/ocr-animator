package fr.ar.ocr.animation.views;

import fr.ar.ocr.animation.menu.MyMenuListener;
import fr.ar.ocr.animation.menu.MyPopupMenu;
import fr.ar.ocr.animation.menu.MyToolbar;
import fr.ar.ocr.animation.utils.MyColor;
import fr.ar.ocr.animation.utils.MyShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AnimationPanel extends JFrame implements MyMenuListener {

    private JLabel label;
    private MyPopupMenu myPopupMenu;
    private MyToolbar myToolbar;

    private boolean isAnimated = false;
    private MyShape currentShape = MyShape.Circle;

    public AnimationPanel() {
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        label = new JLabel("Test");
        label.setOpaque(true);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton() == MouseEvent.BUTTON3) {
                    myPopupMenu.show(label, e.getX(), e.getY());
                }
            }
        });

        myPopupMenu = new MyPopupMenu(this);
        myToolbar = new MyToolbar(this);
        updateAnimationButtons();
        updateShapeButtons(currentShape);

        JPanel container = new JPanel(new BorderLayout());
        container.add(myToolbar, BorderLayout.NORTH);
        container.add(label, BorderLayout.CENTER);
        this.getContentPane().add(container);
        this.setVisible(true);
    }

    @Override
    public void startAnimation() {
        isAnimated = true;
        updateAnimationButtons();
    }

    @Override
    public void stopAnimation() {
        isAnimated = false;
        updateAnimationButtons();
    }

    @Override
    public Color getBackgroundColor() {
        return label.getBackground();
    }

    @Override
    public void setBackgroundColor(MyColor color) {
        label.setBackground(Color.decode(color.getHexCode()));
        label.repaint();
        updateBackgroundColorButtons(color);
    }

    @Override
    public Color getForegroundColor() {
        return label.getForeground();
    }

    @Override
    public void setForegroundColor(MyColor color) {
        label.setForeground(Color.decode(color.getHexCode()));
        label.repaint();
        updateForegroundColorButtons(color);
    }

    @Override
    public MyShape getCurrentShape() {
        return this.currentShape;
    }

    @Override
    public void setShape(MyShape shape) {
        currentShape = shape;
        label.setText(shape.name());
        updateShapeButtons(shape);
    }

    /**
     * Update the different menus animation options
     */
    private void updateAnimationButtons() {
        myPopupMenu.updateAnimationOptions(isAnimated);
        myToolbar.updateAnimationOptions(isAnimated);
        //TODO JMenuBar, JToolBar
    }

    /**
     * Update the different menus background color options
     */
    private void updateBackgroundColorButtons(MyColor color){
        myPopupMenu.updateBackgroundColorOption(color);
    }

    /**
     * Update the different menus foreground color options
     */
    private void updateForegroundColorButtons(MyColor color){
        myPopupMenu.updateForegroundColorOption(color);
    }

    /**
     * Update the different menus foreground color options
     */
    private void updateShapeButtons(MyShape shape){
        myPopupMenu.updateShapeOption(shape);
        myToolbar.updateShapeOption(shape);
    }

}
