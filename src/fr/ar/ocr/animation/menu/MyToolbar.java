package fr.ar.ocr.animation.menu;

import com.sun.istack.internal.NotNull;
import fr.ar.ocr.animation.utils.MyShape;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MyToolbar extends JToolBar implements MyMenu {

    private final MyMenuListener menuListener;

    private JButton start, stop;
    private List<JButton> shapeListBtn;

    public MyToolbar(@NotNull MyMenuListener menuListener) {
        this.menuListener = menuListener;
        init();
    }

    private void init(){
        start = new JButton(new ImageIcon("img/play.png"));
        start.addActionListener(e -> menuListener.startAnimation());
        this.add(start);

        stop = new JButton(new ImageIcon("img/stop.png"));
        stop.addActionListener(e -> menuListener.stopAnimation());
        this.add(stop);

        this.addSeparator();

        JButton btn;
        shapeListBtn = new ArrayList<>();
        btn = new JButton(new ImageIcon("img/circle.png"));
        btn.setName(MyShape.Circle.name());
        btn.addActionListener(e -> menuListener.setShape(MyShape.Circle));
        shapeListBtn.add(btn);
        this.add(btn);

        btn = new JButton(new ImageIcon("img/square.png"));
        btn.setName(MyShape.Square.name());
        btn.addActionListener(e -> menuListener.setShape(MyShape.Square));
        shapeListBtn.add(btn);
        this.add(btn);


        btn = new JButton(new ImageIcon("img/triangle.png"));
        btn.setName(MyShape.Triangle.name());
        btn.addActionListener(e -> menuListener.setShape(MyShape.Triangle));
        shapeListBtn.add(btn);
        this.add(btn);

        btn = new JButton(new ImageIcon("img/star.png"));
        btn.setName(MyShape.Star.name());
        btn.addActionListener(e -> menuListener.setShape(MyShape.Star));
        shapeListBtn.add(btn);
        this.add(btn);
    }

    @Override
    public JButton getStartButton() {
        return start;
    }

    @Override
    public JButton getStopButton() {
        return stop;
    }

    @Override
    public List<? extends AbstractButton> getForegroundColorButtons() {
        return null;
    }

    @Override
    public List<? extends AbstractButton> getBackgroundColorButtons() {
        return null;
    }

    @Override
    public List<JButton> getShapeButtons() {
        return this.shapeListBtn;
    }

    @Override
    public void updateShapeOption(MyShape shape) {
        getShapeButtons().forEach(b -> b.setSelected(b.getName().equals(shape.name())));
    }
}
