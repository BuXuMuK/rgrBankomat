import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMController {
    private final ATMView view;
    private final ATMModel model;
    private boolean isPinValid = false;

    public ATMController(ATMView view, ATMModel model) {
        this.view = view;
        this.model = model;

        this.view.addEnterPinListener(new EnterPinListener());
        this.view.addWithdrawListener(new WithdrawListener());
    }

    private class EnterPinListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String inputPin = view.getPin();
            if (model.checkPin(inputPin)) {
                isPinValid = true;
                view.showMessage("PIN верный.");
            } else {
                view.showMessage("неверный PIN.");
            }
        }
    }

    private class WithdrawListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!isPinValid) {
                view.showMessage("Пожалуйста введите PIN.");
                return;
            }

            String amountString = view.getAmount();
            try {
                double amount = Double.parseDouble(amountString);

                if (model.hasSufficientFunds(amount)) {
                    model.withdraw(amount);
                    view.showMessage("К выдаче: $" + amount + "\nОсталось на балансе: $" + model.getBalance());
                } else {
                    view.showMessage("Недостаточно средств.");
                }
            } catch (NumberFormatException ex) {
                view.showMessage("Сумма не введена.");
            }
        }
    }
}
