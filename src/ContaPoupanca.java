class ContaPoupanca extends ContaBase {
    public ContaPoupanca(Cliente titular, String numeroConta, double saldoInicial) {
        super(titular, numeroConta, saldoInicial);
    }

    public void aplicarRendimentoMensal() {
        double rendimento = this.getSaldo() * 0.01;
        this.depositar(rendimento);
        System.out.println("Rendimento de 1% aplicado. Novo saldo: R$" + this.getSaldo());
    }
}