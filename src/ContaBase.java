
public abstract class ContaBase {
    private final Cliente titular;
    private final String numeroConta;
    private double saldo;

    public ContaBase(Cliente titular, String numeroConta, double saldo) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public void depositar(double amount) {
        if (amount > 0.0) {
            this.saldo += amount;
            System.out.println("Depósito de R$" + amount + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }

    }

    public void sacar(double amount) {
        if (amount > 0.0 && amount <= this.saldo) {
            this.saldo -= amount;
            System.out.println("Saque de R$" + amount + " realizado com sucesso.");
        } else {
            System.out.println("Saque inválido. Verifique o saldo ou o valor inserido.");
        }

    }

    public void transferir(ContaBase recipient, double amount) {
        if (amount > 0.0 && amount <= this.saldo) {
            this.saldo -= amount;
            recipient.depositar(amount);
            System.out.println("Transferência de R$" + amount + " para " + recipient.getTitular().getNome() + " realizada com sucesso.");
        } else {
            System.out.println("Transferência inválida. Verifique o saldo ou o valor inserido.");
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