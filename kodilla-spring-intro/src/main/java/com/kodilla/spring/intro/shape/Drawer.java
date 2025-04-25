package com.kodilla.spring.intro.shape;

import java.awt.*;

public class Drawer {

    final Shape shape;

    public Drawer(final Shape shape) {
        this.shape = shape;
    }

    public String doDrawing() {
        return shape.draw();
    }
}
