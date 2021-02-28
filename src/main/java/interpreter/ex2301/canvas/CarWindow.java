package interpreter.ex2301.canvas;

import interpreter.ex2301.canvas.executor.CarOperationFactory;
import interpreter.ex2301.interpreter.Context;
import interpreter.ex2301.interpreter.Node;
import interpreter.ex2301.interpreter.ParseException;
import interpreter.ex2301.interpreter.ProgramNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarWindow extends JFrame implements ActionListener {

    private final CarCanvas canvas;
    private final JTextField commandTextField;

    public CarWindow(String title) {
        super(title);

        // canvas
        canvas = new CarCanvas(1000, 1000);

        // run button
        JButton runButton = new JButton("run");
        runButton.addActionListener(this);

        // command text field
        commandTextField = new JTextField("command here...");
        commandTextField.addActionListener(this);

        // layout
        Box menuBox = new Box(BoxLayout.LINE_AXIS);
        menuBox.add(commandTextField);
        menuBox.add(runButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(menuBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String programText = getProgramText();
        Node node = parse(programText);
        node.execute();
    }

    private Node parse(String programText) {
        Node node = new ProgramNode();
        CarOperationFactory carOperationFactory = new CarOperationFactory(canvas);
        try {
            Context context = new Context(programText, carOperationFactory);
            node.parse(context);
        } catch (ParseException exception) {
            exception.printStackTrace();
        }
        System.out.println("node = " + node);
        return node;
    }

    private String getProgramText() {
        String command = commandTextField.getText();
        System.out.println("text = \"" + command + "\"");
        return command;
    }

}
