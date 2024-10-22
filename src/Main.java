import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cliente clienteRafael = new Cliente("Rafael Cubas","000.000.123-43","(47)99876-2562");
        Cliente clienteCarlos = new Cliente("Carlos Magno","000.000.132-58","(41)99729-0512");
        ContaCorrente contaCorrente = new ContaCorrente(clienteRafael,"16675-2",1000.0,700.0);
        ContaPoupanca contaPoupanca = new ContaPoupanca(clienteCarlos, "14567-8", 2000.0);

        int opcao;
        do {
            System.out.println("\n--- Menu Bancário ---");
            System.out.println("1. Mostrar informações da conta corrente");
            System.out.println("2. Mostrar informações da conta poupança");
            System.out.println("3. Depositar na conta corrente");
            System.out.println("4. Depositar na conta poupança");
            System.out.println("5. Sacar da conta corrente");
            System.out.println("6. Sacar da conta poupança");
            System.out.println("7. Transferir entre contas");
            System.out.println("8. Utilizar crédito na conta corrente");
            System.out.println("9. Pagar a Fatura na conta corrente");
            System.out.println("10. Aplicar rendimento na conta poupança");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    contaCorrente.showInfo();
                    break;
                case 2:
                    contaPoupanca.showInfo();
                    break;
                case 3:
                    System.out.print("Valor para depositar na conta corrente: R$");
                    double depositoCC = scanner.nextDouble();
                    contaCorrente.depositar(depositoCC);
                    break;
                case 4:
                    System.out.print("Valor para depositar na conta poupança: R$");
                    double depositoCP = scanner.nextDouble();
                    contaPoupanca.depositar(depositoCP);
                    break;
                case 5:
                    System.out.print("Valor para sacar da conta corrente: R$");
                    double saqueCC = scanner.nextDouble();
                    contaCorrente.sacar(saqueCC);
                    break;
                case 6:
                    System.out.print("Valor para sacar da conta poupança: R$");
                    double saqueCP = scanner.nextDouble();
                    contaPoupanca.sacar(saqueCP);
                    break;
                case 7:
                    System.out.print("Valor para transferir da conta corrente para poupança: R$");
                    double valorTransferencia = scanner.nextDouble();
                    contaCorrente.transferir(contaPoupanca, valorTransferencia);
                    break;
                case 8:
                    System.out.print("Valor de crédito a utilizar na conta corrente: R$");
                    double valorCredito = scanner.nextDouble();
                    contaCorrente.usarCredito(valorCredito);
                    break;
                case 9:
                    System.out.print("Valor a pagar da sua Fatura na conta corrente: R$");
                    double valorFatura = scanner.nextDouble();
                    contaCorrente.pagarFatura(valorFatura);
                    break;
                case 10:
                    contaPoupanca.aplicarRendimentoMensal();
                    break;
                case 0:
                    System.out.println("Saindo do sistema bancário.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}