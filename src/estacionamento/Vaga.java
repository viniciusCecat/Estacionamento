package estacionamento;

public class Vaga {
    private int numero;
    private String tamanho; 
    private boolean disponivel;
    private Veiculo veiculoAtual;

    public Vaga(int numero, String tamanho) {
        this.numero = numero;
        this.tamanho = tamanho;
        this.disponivel = true;
    }
    public boolean ocuparVaga(Veiculo veiculo) {
        if (disponivel && (veiculo.getTamanho().equals(tamanho) || tamanho.equals("g"))) {
            this.veiculoAtual = veiculo;
            this.disponivel = false;
            return true;
        }
        return false;
    }
    public void liberarVaga() {
        this.disponivel = true;
        this.veiculoAtual = null;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public int getNumero() {
        return numero;
    }
    public String getTamanho() {
        return tamanho;
    }
    public Veiculo getVeiculoAtual() {
        return veiculoAtual;
    }
}