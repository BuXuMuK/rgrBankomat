import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ATMView {
    private final JTextField pinField;
    private final JTextField amountField;
    private final JButton enterButton;
    private final JButton withdrawButton;
    private final JTextArea outputArea;

    public ATMView() {
        JFrame frame = new JFrame("ATM Machine");
        pinField = new JTextField(10);
        amountField = new JTextField(10);
        enterButton = new JButton("Enter PIN");
        withdrawButton = new JButton("Withdraw");
        outputArea = new JTextArea(5, 20);
        outputArea.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("PIN:"));
        panel.add(pinField);
        panel.add(enterButton);
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);
        panel.add(withdrawButton);
        panel.add(new JScrollPane(outputArea));

        frame.getContentPane().add(panel);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public String getPin() {
        return pinField.getText();
    }

    public String getAmount() {
        return amountField.getText();
    }

    public void showMessage(String message) {
        outputArea.setText(message);
    }

    public void addEnterPinListener(ActionListener listener) {
        enterButton.addActionListener(listener);
    }

    public void addWithdrawListener(ActionListener listener) {
        withdrawButton.addActionListener(listener);
    }
}
