package estacionamento;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class Veiculo {
    private String placa;
    private String modelo;
    private String tamanho; 
    private LocalTime horaEntrada;
    private LocalTime horaSaida;

    public Veiculo(String placa, String modelo, String tamanho) {
        this.placa = placa;
        this.modelo = modelo;
        this.tamanho = tamanho;
    }
    public void registrarEntrada(String horaEntradaStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.horaEntrada = LocalTime.parse(horaEntradaStr, formatter);
    }
    public void registrarSaida(String horaSaidaStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.horaSaida = LocalTime.parse(horaSaidaStr, formatter);
    }
    public long calcularTempoPermanencia() {
        if (horaEntrada != null && horaSaida != null) {
            Duration duracao = Duration.between(horaEntrada, horaSaida);
            return duracao.toHours();
        }
        return 0;
    }
    public String getPlaca() {
        return placa;
    }
    public String getTamanho() {
        return tamanho;
    }
    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }
    public LocalTime getHoraSaida() {
        return horaSaida;
    }
}
