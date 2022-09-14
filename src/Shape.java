import java.awt.*;

public class Shape {
    private final int x1;
    private final int x2;
    private final int y1;
    private final int y2;

    private final Color color;
    private Color fillColor;
    private final BasicStroke stroke;

    private final int shape;
    private int group;


    public Shape(int x1, int y1, int x2, int y2, Color color, BasicStroke stroke, int shape) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color = color;
        this.stroke = stroke;
        this.shape = shape;
    }
    public Shape(int x1, int y1, int x2, int y2, Color color, BasicStroke stroke, int shape, int group) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color = color;
        this.stroke = stroke;
        this.shape = shape;
        this.group = group;
    }


    public int getShape() {
        return this.shape;
    }

    public int getx1() {
        return this.x1;
    }

    public int getx2() {
        return this.x2;
    }

    public int gety1() {
        return this.y1;
    }

    public int gety2() {
        return this.y2;
    }

    public Color getColor() {
        return this.color;
    }

    public BasicStroke getStroke() {
        return this.stroke;
    }

    public int getGroup() {
        return group;
    }
}
