class ContaPoupanca extends ContaBase {
    public ContaPoupanca(Cliente Titular, String Numero_Conta, double SaldoInicial) {
        super(Titular, Numero_Conta, SaldoInicial);
    }

    public void aplicarRendimentoMensal() {
        double rendimento = this.getSaldo() * 0.01;
        this.depositar(rendimento);
        System.out.println("Rendimento de 1% aplicado. Novo saldo: R$" + this.getSaldo());
    }
}