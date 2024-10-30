import java.time.LocalDateTime;

public class Transacao {
    private final String tipo;
    private final Double valor;
    private final LocalDateTime data;

    public Transacao(String tipo, Double valor){
        this.tipo = tipo;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    public String getTransacao(){
        return String.format("Tipo: %s\nValor: %s\nData: %s", tipo, valor, data);
    }
}

