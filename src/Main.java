public class Main {
    public static void main(String[] args) {
        ATMModel model = new ATMModel();
        ATMView view = new ATMView();
        ATMController controller = new ATMController(view, model);
    }
}
