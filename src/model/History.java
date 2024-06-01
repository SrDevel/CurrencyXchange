package model;

import java.util.Date;

public class History {
    private Date date;
    private String currency;
    private String currencyTo;
    private Double amount;
    private Double result;

    public History(Date date, String currency, String currencyTo, Double amount, Double result) {
        this.date = date;
        this.currency = currency;
        this.currencyTo = currencyTo;
        this.amount = amount;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Historial de conversión: " +
                "Fecha: " + date +
                ", Moneda: " + currency +
                ", Moneda a convertir: " + currencyTo +
                ", Cantidad: " + amount +
                ", Resultado: " + result;
    }

    private void saveInFile() {
        // Implementación de la lógica para guardar el historial en un archivo
    }
}
