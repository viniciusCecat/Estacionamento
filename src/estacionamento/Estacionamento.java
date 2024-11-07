package estacionamento;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Vaga> vagas;
    private List<String> historico;

    public Estacionamento() {
        this.vagas = new ArrayList<>();
        this.historico = new ArrayList<>();
    }
    public void adicionarVaga(int numero, String tamanho) {
        vagas.add(new Vaga(numero, tamanho));
    }
    public boolean registrarEntradaVeiculo(Veiculo veiculo, String horaEntrada) {
        for (Vaga vaga : vagas) {
            if (vaga.isDisponivel() && (vaga.getTamanho().equals(veiculo.getTamanho()) || vaga.getTamanho().equals("g"))) {
                if (vaga.ocuparVaga(veiculo)) {
                    veiculo.registrarEntrada(horaEntrada);
                    System.out.println("Veículo " + veiculo.getPlaca() + " registrado na vaga " + vaga.getNumero());
                    return true;
                }
            }
        }
        System.out.println("Não há vagas disponíveis para o tamanho do veículo.");
        return false;
    }
    public void registrarSaidaVeiculo(String placa, String horaSaida) {
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel() && vaga.getVeiculoAtual().getPlaca().equals(placa)) {
                Veiculo veiculo = vaga.getVeiculoAtual();
                veiculo.registrarSaida(horaSaida);
                long tempoPermanencia = veiculo.calcularTempoPermanencia();
                double valorPago = calcularValor(tempoPermanencia);

                historico.add("Placa: " + veiculo.getPlaca() +
                        ", Entrada: " + veiculo.getHoraEntrada() +
                        ", Saída: " + veiculo.getHoraSaida() +
                        ", Valor pago: R$ " + String.format("%.2f", valorPago));

                vaga.liberarVaga();
                System.out.println("Veículo " + placa + " saiu. Tempo de permanência: " + tempoPermanencia + " horas. Valor pago: R$ " + String.format("%.2f", valorPago));
                return;
            }
        }
        System.out.println("Veículo não encontrado.");
    }
    private double calcularValor(long tempoPermanencia) {
        if (tempoPermanencia <= 1) {
            return 5.00;
        } else if (tempoPermanencia <= 3) {
            return 10.00;
        } else {
            return 15.00;
        }
    }
    public void exibirVagasOcupadas() {
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel()) {
                System.out.println("Vaga " + vaga.getNumero() + " - " + vaga.getTamanho() + " - Veículo: " + vaga.getVeiculoAtual().getPlaca());
            }
        }
    }
    public void exibirHistorico() {
        for (String registro : historico) {
            System.out.println(registro);
        }
    }
}