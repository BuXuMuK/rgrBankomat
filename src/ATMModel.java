public class ATMModel {
    private String pinCode = "1234"; // Временный пин-код
    private double balance = 1000.00; // Начальный баланс

    public boolean checkPin(String inputPin) {
        return pinCode.equals(inputPin);
    }

    public boolean hasSufficientFunds(double amount) {
        return balance >= amount;
    }

    public void withdraw(double amount) {
        if (hasSufficientFunds(amount)) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
