package chapter5;

public class Transaction {
    private final Trader trader;
    private final int year;
    private final String currency;
    private final int value;

    public Transaction(Trader trader, int year, String currency, int value) {
        this.trader = trader;
        this.year = year;
        this.currency = currency;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public String getCurrency() {
        return currency;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
