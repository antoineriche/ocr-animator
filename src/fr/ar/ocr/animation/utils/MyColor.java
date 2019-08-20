package fr.ar.ocr.animation.utils;

public enum MyColor {
    Red("#ff0000"),
    Green("#00ff00"),
    Blue("#0000ff");

    private String hexCode;

    MyColor(String hexCode) {
        this.hexCode = hexCode;
    }

    public String getHexCode() {
        return hexCode;
    }
}
