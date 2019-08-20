package fr.ar.ocr.animation.menu;

import fr.ar.ocr.animation.utils.MyColor;
import fr.ar.ocr.animation.utils.MyShape;

import java.awt.*;

public interface MyMenuListener {

    /**
     * Use to (re)start the animation
     */
    void startAnimation();

    /**
     * Use to stop the animation
     */
    void stopAnimation();

    /**
     * Get the current background color
     * @return color as {@link Color}
     */
    Color getBackgroundColor();

    /**
     * Set the background color
     * @param color the {@link MyColor} to be set
     */
    void setBackgroundColor(MyColor color);

    /**
     * Get the current foreground color
     * @return color as {@link Color}
     */
    Color getForegroundColor();

    /**
     * Set the foreground color
     * @param color the {@link MyColor} to be set
     */
    void setForegroundColor(MyColor color);

    /**
     * Get the current {@link MyShape} of the animation
     * @return the current {@link MyShape}
     */
    MyShape getCurrentShape();

    /**
     * Set the {@link MyShape} for animation
     * @param shape the new {@link MyShape}
     */
    void setShape(MyShape shape);
}
