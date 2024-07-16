import javax.swing.*;

public class Calculator  {
    private static JTextField firstNumber, secondNumber, result;
    private static JButton addButton, subtractButton, multiplyButton, divideButton, modulusButton, clearButton;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel firstLabel = new JLabel("First Number:");
        firstLabel.setBounds(20, 20, 100, 30);
        frame.add(firstLabel);
        firstNumber = new JTextField();
        firstNumber.setBounds(150, 20, 200, 30);
        frame.add(firstNumber);

        JLabel secondLabel = new JLabel("Second Number:");
        secondLabel.setBounds(20, 70, 100, 30);
        frame.add(secondLabel);
        secondNumber = new JTextField();
        secondNumber.setBounds(150, 70, 200, 30);
        frame.add(secondNumber);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(20, 120, 100, 30);
        frame.add(resultLabel);
        result = new JTextField();
        result.setBounds(150, 120, 200, 30);
        result.setEditable(false);
        frame.add(result);

        addButton = new JButton("+");
        addButton.setBounds(20, 170, 50, 30);
        frame.add(addButton);

        subtractButton = new JButton("-");
        subtractButton.setBounds(80, 170, 50, 30);
        frame.add(subtractButton);

        multiplyButton = new JButton("*");
        multiplyButton.setBounds(140, 170, 50, 30);
        frame.add(multiplyButton);

        divideButton = new JButton("/");
        divideButton.setBounds(200, 170, 50, 30);
        frame.add(divideButton);

        modulusButton = new JButton("%");
        modulusButton.setBounds(260, 170, 50, 30);
        frame.add(modulusButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(320, 170, 70, 30);
        frame.add(clearButton);

        addButton.addActionListener(e -> performOperation('+'));
        subtractButton.addActionListener(e -> performOperation('-'));
        multiplyButton.addActionListener(e -> performOperation('*'));
        divideButton.addActionListener(e -> performOperation('/'));
        modulusButton.addActionListener(e -> performOperation('%'));
        clearButton.addActionListener(e -> clearFields());

        frame.setVisible(true);
    }

    private static void performOperation(char operator) {
        try {
            double num1 = Double.parseDouble(firstNumber.getText());
            double num2 = Double.parseDouble(secondNumber.getText());
            double res = 0;

            switch (operator) {
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num1 - num2;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    res = num1 / num2;
                    break;
                case '%':
                    res = num1 % num2;
                    break;
            }
            result.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            result.setText("Invalid Input");
        }
    }

    private static void clearFields() {
        firstNumber.setText("");
        secondNumber.setText("");
        result.setText("");
    }
}
