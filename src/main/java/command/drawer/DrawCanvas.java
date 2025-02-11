package command.drawer;

import command.command.MacroCommand;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {

    private final Color color = Color.red;

    private final int radius = 6;

    private final MacroCommand history;

    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        history.execute();
    }

    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

}
