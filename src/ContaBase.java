
public class ContaBase {
    private final String Titular;
    private final String Numero_Conta;
    private double Saldo;

    public ContaBase(String Titular, String Numero_Conta, double SaldoInicial) {
        this.Titular = Titular;
        this.Numero_Conta = Numero_Conta;
        this.Saldo = SaldoInicial;
    }

    public void depositar(double amount) {
        if (amount > 0.0) {
            this.Saldo += amount;
            System.out.println("Depósito de R$" + amount + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }

    }

    public void sacar(double amount) {
        if (amount > 0.0 && amount <= this.Saldo) {
            this.Saldo -= amount;
            System.out.println("Saque de R$" + amount + " realizado com sucesso.");
        } else {
            System.out.println("Saque inválido. Verifique o saldo ou o valor inserido.");
        }

    }

    public void transferir(ContaBase recipient, double amount) {
        if (amount > 0.0 && amount <= this.Saldo) {
            this.Saldo -= amount;
            recipient.depositar(amount);
            System.out.println("Transferência de R$" + amount + " para " + recipient.getTitular() + " realizada com sucesso.");
        } else {
            System.out.println("Transferência inválida. Verifique o saldo ou o valor inserido.");
        }

    }

    public void ShowInfo() {
        System.out.println("Nome do Titular: " + this.Titular);
        System.out.println("Número da Conta: " + this.Numero_Conta);
        System.out.println("Saldo: R$" + this.Saldo);
    }

    public String getTitular() {
        return this.Titular;
    }

    public String getNumero_Conta() {
        return this.Numero_Conta;
    }

    public double getSaldo() {
        return this.Saldo;
    }
}
