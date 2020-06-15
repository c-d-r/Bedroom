package com.company;

public class Lamp {
    private String style;
    private boolean battery;
    private boolean onOff;
    private int globalRating;

    public Lamp(String style, boolean battery, int globalRating) {
        this.style = style;
        this.battery = battery;
        this.globalRating = globalRating;
    }

    public void turnOn() {
        onOff = true;
        System.out.println("the lamp is currently on");
    }

    public void turnOff() {
        onOff = false;
        System.out.println("the lamp is off");
    }

    public boolean isOnOff() {
        return onOff;
    }

    public String getStyle() {
        return style;
    }

    public boolean isBattery() {
        return battery;
    }

    public int getGlobalRating() {
        return globalRating;
    }
}
