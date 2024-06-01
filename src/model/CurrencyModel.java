package model;

public class CurrencyModel {
    private String USD;
    private String COP;
    private String EUR;
    private String ARS;

    public CurrencyModel(CurrencyDto currencyDto) {
        System.out.println(currencyDto.toString());
        this.USD = currencyDto.USD();
        this.COP = currencyDto.COP();
        this.EUR = currencyDto.EUR();
        this.ARS = currencyDto.ARS();
    }

    public float getCurrenciesValue(String currency) {
        switch (currency) {
            case "USD":
                return Float.parseFloat(USD);
            case "COP":
                return Float.parseFloat(COP);
            case "EUR":
                return Float.parseFloat(EUR);
            case "ARS":
                return Float.parseFloat(ARS);
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Datos de la moneda: " +
                "USD: " + USD +
                ", COP: " + COP +
                ", EUR: " + EUR +
                ", ARS: " + ARS;
    }
}