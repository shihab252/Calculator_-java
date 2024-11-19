import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator_372 {

    private JFrame frame;
    private JTextField textField;
    private double num1, num2, result;
    private String operator;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Calculator_372 window = new Calculator_372();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Calculator_372() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Calculator");
        frame.setBounds(100, 100, 300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        frame.getContentPane().add(textField, BorderLayout.NORTH);
        textField.setColumns(10);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    handleButtonClick(text);
                }
            });
            panel.add(button);
        }
    }

    private void handleButtonClick(String text) {
        if (text.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textField.setText("Error");
                        return;
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
            operator = null;
        } else if (text.equals("/") || text.equals("*") || text.equals("-") || text.equals("+")) {
            operator = text;
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
        } else {
            textField.setText(textField.getText() + text);
        }
    }
}
