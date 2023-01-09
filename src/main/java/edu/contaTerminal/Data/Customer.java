package main.java.edu.contaTerminal.Data;

public class Customer {
    private final String agency;
    private Integer account;
    private String client;
    private Double balance;
    private String bank;

    protected Customer(final String agency, final Integer account, final String client, final Double balance) {
        this.agency = agency;
        this.account = account;
        this.client = client;
        this.balance = balance;
    }

    protected Customer(final String agency, final String bank) {
        this.agency = agency;
        this.bank = bank;
    }

    protected String getAgency() {
        return this.agency;
    }

    protected Integer getAccount() {
        return account;
    }

    protected String getClient() {
        return client;
    }

    protected Double getBalance() {
        return balance;
    }

    protected String getBank() {
        return bank;
    }

    protected void setAccount(final Integer account) {
        this.account = account;
    }

    protected void setClient(final String client) {
        this.client = client;
    }

    protected void setBalance(final Double balance) {
        this.balance = balance;
    }
}
