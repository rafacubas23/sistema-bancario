import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BancoApp extends JFrame {
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;

    public BancoApp() {
        setTitle("Sistema Bancário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new FlowLayout());

        Cliente clienteRafael = new Cliente("Rafael Cubas", "000.000.123-43", "(47)99876-2562");
        contaCorrente = new ContaCorrente(clienteRafael, "16675-2", 1000.0, 700.0);
        Cliente clienteCarlos = new Cliente("Carlos Magno", "000.000.132-58", "(41)99729-0512");
        contaPoupanca = new ContaPoupanca(clienteCarlos, "14567-8", 2000.0);

        JButton btnMostrarInfoCC = new JButton("Mostrar Info CC");
        JButton btnDepositarCC = new JButton("Depositar CC");
        JButton btnSacarCC = new JButton("Sacar CC");

        JButton btnMostrarInfoCP = new JButton("Mostrar Info CP");
        JButton btnDepositarCP = new JButton("Depositar CP");
        JButton btnSacarCP = new JButton("Sacar CP");

        btnMostrarInfoCC.addActionListener(e -> mostrarInfoContaCorrente());
        btnDepositarCC.addActionListener(e -> depositarNaContaCorrente());
        btnSacarCC.addActionListener(e -> sacarDaContaCorrente());

        btnMostrarInfoCP.addActionListener(e -> mostrarInfoContaPoupanca());
        btnDepositarCP.addActionListener(e -> depositarNaContaPoupanca());
        btnSacarCP.addActionListener(e -> sacarDaContaPoupanca());

        add(btnMostrarInfoCC);
        add(btnDepositarCC);
        add(btnSacarCC);

        add(btnMostrarInfoCP);
        add(btnDepositarCP);
        add(btnSacarCP);
    }

    private void mostrarInfoContaCorrente() {
        JOptionPane.showMessageDialog(this, contaCorrente.getInfo());
    }

    private void mostrarInfoContaPoupanca() {
        JOptionPane.showMessageDialog(this, contaPoupanca.getInfo());
    }

    private void depositarNaContaCorrente() {
        String valor = JOptionPane.showInputDialog("Valor para depositar:");
        if (valor != null) {
            contaCorrente.depositar(Double.parseDouble(valor));
        }
    }

    private void depositarNaContaPoupanca() {
        String valor = JOptionPane.showInputDialog("Valor para depositar:");
        if (valor != null) {
            contaPoupanca.depositar(Double.parseDouble(valor));
        }
    }

    private void sacarDaContaCorrente() {
        String valor = JOptionPane.showInputDialog("Valor para sacar:");
        if (valor != null) {
            contaCorrente.sacar(Double.parseDouble(valor));
        }
    }

    private void sacarDaContaPoupanca() {
        String valor = JOptionPane.showInputDialog("Valor para sacar:");
        if (valor != null) {
            contaPoupanca.sacar(Double.parseDouble(valor));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BancoApp app = new BancoApp();
            app.setVisible(true);
        });
    }
}
