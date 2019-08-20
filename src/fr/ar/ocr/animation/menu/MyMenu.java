package fr.ar.ocr.animation.menu;

import fr.ar.ocr.animation.utils.MyColor;
import fr.ar.ocr.animation.utils.MyShape;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public interface MyMenu {

    AbstractButton getStartButton();
    AbstractButton getStopButton();
    List<? extends AbstractButton> getForegroundColorButtons();
    List<? extends AbstractButton> getBackgroundColorButtons();
    List<? extends AbstractButton> getShapeButtons();

    default void updateShapeOption(MyShape shape){
        Optional<? extends AbstractButton> btn =
                getShapeButtons().stream().filter(r -> r.getText().equals(shape.name())).findFirst();
        btn.ifPresent(abstractButton -> abstractButton.setSelected(true));
    }

    default void updateForegroundColorOption(MyColor color){
        updateColor(getForegroundColorButtons(), color);
    }

    default void updateBackgroundColorOption(MyColor color){
        updateColor(getBackgroundColorButtons(), color);
    }

    default void updateColor(List<? extends AbstractButton> btns, MyColor color){
        Optional<? extends AbstractButton> btn =
                btns.stream().filter(r -> r.getText().equals(color.name())).findFirst();
        btn.ifPresent(abstractButton -> abstractButton.setSelected(true));
    }

    default void updateAnimationOptions(boolean isAnimated){
        getStartButton().setEnabled(!isAnimated);
        getStopButton().setEnabled(isAnimated);
    }
}
