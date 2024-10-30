class ContaCorrente extends ContaBase {
    private double limiteCredito;
    private double fatura;

    public ContaCorrente(Cliente titular, String numeroConta, double saldoInicial, double limiteCredito) {
        super(titular, numeroConta, saldoInicial);
        this.limiteCredito = limiteCredito;
        this.fatura = 0.0;
    }

    public void usarCredito(double amount) {
        if (amount > 0.0 && amount <= this.limiteCredito) {
            this.depositar(amount);
            this.limiteCredito -= amount;
            this.fatura += amount;
            System.out.println("Crédito de R$" + amount + " utilizado com sucesso.");
        } else {
            System.out.println("Crédito inválido. Verifique o limite disponível.");
        }

    }

    public void pagarFatura(double amount) {
        if (amount > 0.0 && amount <= this.fatura && amount <= this.getSaldo()) {
            this.sacar(amount);
            this.limiteCredito += amount;
            this.fatura -= amount;
            System.out.println("Fatura no valor de R$" + amount + " paga com sucesso.");
        } else {
            System.out.println("Falha no pagamento da Fatura.");
        }

    }

    public String getInfo() {
        return super.getInfo()+String.format("Limite de Crédito Disponível: R$" + this.limiteCredito);
    }
}