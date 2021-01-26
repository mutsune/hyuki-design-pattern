package observer.ex1702;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FrameObserver extends JFrame implements Observer {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    private final DisplayPanel displayPanel;
    private final JLabel numberDisplayLabel;

    public FrameObserver(String title) throws HeadlessException {
        super(title);
        setTitle(title);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayPanel = new DisplayPanel(WIDTH, HEIGHT);

        numberDisplayLabel = new JLabel("N/A");
        displayPanel.add(numberDisplayLabel);


        Container contentPane = getContentPane();
        contentPane.add(displayPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void update(NumberGenerator generator) {
        numberDisplayLabel.setText(Integer.toString(generator.getNumber()));
        displayPanel.update(generator);

        try {
            Thread.sleep(200);
        } catch (InterruptedException ignored) {
        }
    }

}

class DisplayPanel extends JPanel implements Observer {

    private final int width;
    private final int height;

    private int number;
    private final Random random;

    public DisplayPanel(int width, int height) {
        this.width = width;
        this.height = height;
        random = new Random();
        setSize(width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        int padding = 15;
        for (int i = 0; i < number; i++) {
            g2.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            int width = padding + random.nextInt(this.width - padding * 4);
            int height = padding + random.nextInt(this.height - padding * 4);
            g2.fillOval(width, height, 10, 10);
            g2.setColor(Color.BLACK);
            g2.drawOval(width, height, 10, 10);
        }
    }

    @Override
    public void update(NumberGenerator generator) {
        number = generator.getNumber();
        repaint();
    }

}
