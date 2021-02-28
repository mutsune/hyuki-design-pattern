package interpreter.ex2301.canvas;

import interpreter.ex2301.canvas.car.CarPosition;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CarCanvas extends Canvas {

    private CarPosition position;
    private final Image carImage;
    private final int CAR_IMAGE_SIZE = 50;

    public CarCanvas(int width, int height) {
        Point location = new Point(width / 2, height / 2);
        position = new CarPosition(location);

        carImage = getCarImage().getScaledInstance(CAR_IMAGE_SIZE, CAR_IMAGE_SIZE, Image.SCALE_SMOOTH);

        setSize(width, height);
        setBackground(Color.WHITE);

        repaint();
    }

    public CarPosition getPosition() {
        return position;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        AffineTransform transform = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        double radian = Math.toRadians(position.getDirection().getAngle());
        transform.rotate(radian, CAR_IMAGE_SIZE / 2., CAR_IMAGE_SIZE / 2.);
        g2.drawImage(carImage, transform, null);
    }

//    @Override
//    public void update(Graphics g) {
//        paint(g);
//    }

    public void move(CarPosition current) {
        this.position = current;
    }

    private BufferedImage getCarImage() {
        try {
            return ImageIO.read(getClass().getResource("car.jpg"));
        } catch (IOException e) {
            throw new RuntimeException("Car image is not found");
        }
    }

}
