package bankapplication;
import javax.swing.*;

public class BankApplication {

    private static double balance = 0;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Bank Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JLabel balanceLabel = new JLabel("Balance: $" + balance);
        balanceLabel.setBounds(20, 20, 100, 20);

        JLabel depositLabel = new JLabel("Deposit amount:");
        depositLabel.setBounds(20, 50, 100, 20);

        JTextField depositField = new JTextField();
        depositField.setBounds(130, 50, 100, 20);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(250, 50, 100, 20);
        depositButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(depositField.getText());
                balance += amount;
                balanceLabel.setText("Balance: $" + balance);
                depositField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid deposit amount.");
            }
        });

        JLabel withdrawLabel = new JLabel("Withdraw amount:");
        withdrawLabel.setBounds(20, 80, 100, 20);

        JTextField withdrawField = new JTextField();
        withdrawField.setBounds(130, 80, 100, 20);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(250, 80, 100, 20);
        withdrawButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(withdrawField.getText());
                if (amount > balance) {
                    JOptionPane.showMessageDialog(frame, "Insufficient funds.");
                } else {
                    balance -= amount;
                    balanceLabel.setText("Balance: $" + balance);
                    withdrawField.setText("");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid withdraw amount.");
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(250, 200, 100, 20);
        exitButton.addActionListener(e -> System.exit(0));

        frame.add(balanceLabel);
        frame.add(depositLabel);
        frame.add(depositField);
        frame.add(depositButton);
        frame.add(withdrawLabel);
        frame.add(withdrawField);
        frame.add(withdrawButton);
        frame.add(exitButton);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
