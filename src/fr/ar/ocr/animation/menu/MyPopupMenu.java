package fr.ar.ocr.animation.menu;

import com.sun.istack.internal.NotNull;
import fr.ar.ocr.animation.utils.MyColor;
import fr.ar.ocr.animation.utils.MyShape;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MyPopupMenu extends JPopupMenu implements MyMenu {

    private final MyMenuListener menuListener;

    private JMenuItem stop, start;
    private List<JRadioButtonMenuItem> foregroundColorBtns, backgroundColorBtns;
    private List<JRadioButtonMenuItem> shapeBtns;

    public MyPopupMenu(@NotNull MyMenuListener menuListener) {
        this.menuListener = menuListener;
        init();
    }

    private void init(){
        JMenu menu;
        JRadioButtonMenuItem item;
        ButtonGroup bg;

        // Start animation
        start = new JMenuItem("Start");
        start.addActionListener(e -> menuListener.startAnimation());
        this.add(start);

        // Stop animation
        stop = new JMenuItem("Stop");
        stop.addActionListener(e -> menuListener.stopAnimation());
        this.add(stop);

        this.addSeparator();

        // Background color
        backgroundColorBtns = new ArrayList<>();
        bg = new ButtonGroup();
        menu = new JMenu("Background color");
        for (MyColor c : MyColor.values()){
            item = new JRadioButtonMenuItem(c.name());
            menu.add(item);
            backgroundColorBtns.add(item);
            bg.add(item);
            item.addActionListener(e -> menuListener.setBackgroundColor(c));
        }
        this.add(menu);

        // Foreground color
        foregroundColorBtns = new ArrayList<>();
        bg = new ButtonGroup();
        menu = new JMenu("Foreground color");
        for (MyColor c : MyColor.values()){
            item = new JRadioButtonMenuItem(c.name());
            menu.add(item);
            foregroundColorBtns.add(item);
            bg.add(item);
            item.addActionListener(e -> menuListener.setForegroundColor(c));
        }
        this.add(menu);

        this.addSeparator();

        // Shape
        shapeBtns = new ArrayList<>();
        bg = new ButtonGroup();
        menu = new JMenu("Shape");
        for (MyShape s : MyShape.values()){
            item = new JRadioButtonMenuItem(s.name());
            menu.add(item);
            shapeBtns.add(item);
            bg.add(item);
            item.addActionListener(e -> menuListener.setShape(s));
        }
        this.add(menu);
    }

    @Override
    public JMenuItem getStartButton() {
        return start;
    }

    @Override
    public JMenuItem getStopButton() {
        return stop;
    }

    @Override
    public List<JRadioButtonMenuItem> getForegroundColorButtons() {
        return this.foregroundColorBtns;
    }

    @Override
    public List<? extends AbstractButton> getBackgroundColorButtons() {
        return this.backgroundColorBtns;
    }

    @Override
    public List<? extends AbstractButton> getShapeButtons() {
        return this.shapeBtns;
    }
}
