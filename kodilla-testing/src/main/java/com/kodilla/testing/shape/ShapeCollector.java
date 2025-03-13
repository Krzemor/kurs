package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> figures = new ArrayList<>();

    public int getFiguresQuantity(){
        return figures.size();
    }

    public void addFigure(Shape shape) {
        figures.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (figures.contains(shape)) {
            figures.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n) {
        if (n >= 0 && n < figures.size()){
            return figures.get(n);
        }
        return null;
    }

    public String showFigures() {
        String result = "";
        for (int i = 0; i < figures.size(); i++) {
            result += figures.get(i).getShapeName();
            if (i < figures.size() - 1) {
                result += ", ";
            }
        }
        return result;
    }
}
