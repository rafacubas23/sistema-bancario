import java.util.List;
import java.util.ArrayList;

public abstract class ContaBase {
    private final Cliente titular;
    private final String numeroConta;
    private double saldo;
    private final List<Transacao> transacoes;

    public ContaBase(Cliente titular, String numeroConta, double saldo) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.transacoes = new ArrayList<>();
    }

    public void depositar(double amount) {
        if (amount > 0.0) {
            this.saldo += amount;
            this.transacoes.add(new Transacao("Depósito",amount));
            System.out.println("Depósito de R$" + amount + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }

    }

    public void sacar(double amount) {
        if (amount > 0.0 && amount <= this.saldo) {
            this.saldo -= amount;
            this.transacoes.add(new Transacao("Saque",amount));
            System.out.println("Saque de R$" + amount + " realizado com sucesso.");
        } else {
            System.out.println("Saque inválido. Verifique o saldo ou o valor inserido.");
        }

    }

    public void transferir(ContaBase recipient, double amount) {
        if (amount > 0.0 && amount <= this.saldo) {
            this.saldo -= amount;
            recipient.depositar(amount);
            recipient.transacoes.add(new Transacao("Transferência recebida de "+this.titular.getNome(),amount));
            this.transacoes.add(new Transacao("Transferência enviada para "+recipient.titular.getNome(),amount));
            System.out.println("Transferência de R$" + amount + " para " + recipient.getTitular().getNome() + " realizada com sucesso.");

        } else {
            System.out.println("Transferência inválida. Verifique o saldo ou o valor inserido.");
        }

    }

    public void showTransacoes() {
        System.out.println("Histórico de Transações: ");
        for (Transacao transacao : this.transacoes) {
            System.out.println(transacao.getTransacao());
        }
    }

    public void showInfo() {
        this.titular.showInfo();
        System.out.println("Número da Conta: " + this.numeroConta);
        System.out.println("Saldo: R$" + this.saldo);
    }

    public Cliente getTitular() {
        return this.titular;
    }

    public String getNumeroConta() {
        return this.numeroConta;
    }

    public double getSaldo() {
        return this.saldo;
    }
}