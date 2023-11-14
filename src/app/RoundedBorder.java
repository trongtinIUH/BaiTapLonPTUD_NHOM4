package app;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.Border;

public class RoundedBorder implements Border {
    private int radius;
    private int thickness;
    private int pointerSize;
    private int strokePad;
    private double radii;
    private Color color;
    private Stroke stroke;

    public RoundedBorder(int radius) {
        this.radius = radius;
        this.thickness = 1; // Khởi tạo thickness
        this.pointerSize = 1; // Khởi tạo pointerSize
        this.strokePad = 1; // Khởi tạo strokePad
        this.radii = 10.0; // Khởi tạo radii
        this.color = new Color(0, 0, 0, 0); // Khởi tạo color
        this.stroke = new BasicStroke(1); // Khởi tạo stroke
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;

        RoundRectangle2D.Double bubble = new RoundRectangle2D.Double(
            0 + strokePad,
            0 + strokePad,
            width - thickness,
            height - thickness,
            radii,
            radii
        );

        RenderingHints hints = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        Area area = new Area(bubble);
        g2.setRenderingHints(hints);

        Area spareSpace = new Area(new Rectangle(0, 0, width, height));
        spareSpace.subtract(area);
        g2.setClip(spareSpace);
        g2.clearRect(0, 0, width, height);
        g2.setClip(null);

        g2.setColor(color);
        g2.setStroke(stroke);
        g2.draw(area);
    }

}
