class ContaCorrente extends ContaBase {
    private double Limite_Credito;
    private double Fatura;

    public ContaCorrente(Cliente Titular, String Numero_Conta, double SaldoInicial, double Limite_Credito) {
        super(Titular, Numero_Conta, SaldoInicial);
        this.Limite_Credito = Limite_Credito;
        this.Fatura = 0.0;
    }

    public void usarCredito(double amount) {
        if (amount > 0.0 && amount <= this.Limite_Credito) {
            this.depositar(amount);
            this.Limite_Credito -= amount;
            this.Fatura += amount;
            System.out.println("Crédito de R$" + amount + " utilizado com sucesso.");
        } else {
            System.out.println("Crédito inválido. Verifique o limite disponível.");
        }

    }

    public void pagarFatura(double amount) {
        if (amount > 0.0 && amount <= this.Fatura && amount <= this.getSaldo()) {
            this.sacar(amount);
            this.Limite_Credito += amount;
            this.Fatura -= amount;
            System.out.println("Fatura no valor de R$" + amount + " paga com sucesso.");
        } else {
            System.out.println("Falha no pagamento da Fatura.");
        }

    }

    public void ShowInfo() {
        super.ShowInfo();
        System.out.println("Limite de Crédito Disponível: R$" + this.Limite_Credito);
    }
}