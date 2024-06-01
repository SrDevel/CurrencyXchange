import controller.CurrencyController;
import controller.HistoryController;
import validators.Validators;

import javax.swing.JOptionPane;
public class Main {

    public static void main(String[] args) {

        CurrencyController currencyController = new CurrencyController();
        HistoryController historyController = new HistoryController();

        while (true) {
            String option = JOptionPane.showInputDialog("""
                    Seleccione una opción:
                    1. Convertir Pesos Colombianos a Dólares
                    2. Convertir Dólares a Pesos Colombianos
                    3. Convertir Euros a Dólares
                    4. Convertir Dólares a Euros
                    5. Convertir Pesos Argentinos a Dólares
                    6. Convertir Dólares a Pesos Argentinos
                    7. Ver historial
                    8. Salir
                    """);
            while (!(Validators.isPositiveInteger(option) && Validators.isIntegerOutOfRange(option, 1, 8))){
                option = JOptionPane.showInputDialog("""
                        Seleccione una opción válida:
                        1. Convertir Pesos Colombianos a Dólares
                        2. Convertir Dólares a Pesos Colombianos
                        3. Convertir Euros a Dólares
                        4. Convertir Dólares a Euros
                        5. Convertir Pesos Argentinos a Dólares
                        6. Convertir Dólares a Pesos Argentinos
                        7. Ver historial
                        8. Salir
                        """);
            }

            switch (Integer.parseInt(option)) {
                case 1 -> {
                    Double amount = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad de Pesos Colombianos a convertir a Dólares"));
                    Double result = currencyController.convertCurrency("COP", "USD", amount);

                    JOptionPane.showMessageDialog(null, "El resultado de la conversión es: "
                            + String.format("%.2f", result) + " USD" + ", de " + amount + " COP");

                    historyController.saveHistoryMovement("COP", "USD", amount, result);
                }
                case 2 -> {
                    Double amount = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad de Dólares a convertir a Pesos Colombianos"));

                    Double result = currencyController.convertCurrency("USD", "COP", amount);
                    JOptionPane.showMessageDialog(null, "El resultado de la conversión es: "
                            + String.format("%.2f", result) + " COP" + ", de " + amount + " USD");

                    historyController.saveHistoryMovement("USD", "COP", amount, result);
                }
                case 3 -> {
                    Double amount = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad de Euros a convertir a Dólares"));
                    Double result = currencyController.convertCurrency("EUR", "USD", amount);

                    JOptionPane.showMessageDialog(null, "El resultado de la conversión es: "
                            + String.format("%.2f", result) + " USD" + ", de " + amount + " EUR");

                    historyController.saveHistoryMovement("EUR", "USD", amount, result);
                }
                case 4 -> {
                    Double amount = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad de Dólares a convertir a Euros"));
                    Double result = currencyController.convertCurrency("USD", "EUR", amount);

                    JOptionPane.showMessageDialog(null, "El resultado de la conversión es: "
                            + String.format("%.2f", result) + " EUR" + ", de " + amount + " USD");

                    historyController.saveHistoryMovement("USD", "EUR", amount, result);
                }
                case 5 -> {
                    Double amount = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad de Pesos Argentinos a convertir a Dólares"));
                    Double result = currencyController.convertCurrency("ARS", "USD", amount);

                    JOptionPane.showMessageDialog(null, "El resultado de la conversión es: "
                            + String.format("%.2f", result) + " USD" + ", de " + amount + " ARS");

                    historyController.saveHistoryMovement("ARS", "USD", amount, result);
                }
                case 6 -> {
                    Double amount = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad de Dólares a convertir a Pesos Argentinos"));
                    Double result = currencyController.convertCurrency("USD", "ARS", amount);

                    JOptionPane.showMessageDialog(null, "El resultado de la conversión es: "
                            + String.format("%.2f", result) + " ARS" + ", de " + amount + " USD");

                    historyController.saveHistoryMovement("USD", "ARS", amount, result);
                }
                case 7 -> historyController.printHistory();
                case 8 -> {
                    System.out.println("Gracias por usar nuestra aplicación");
                    System.exit(0);
                }
            }
        }
    }
}