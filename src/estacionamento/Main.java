package estacionamento;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        estacionamento.adicionarVaga(1, "p");
        estacionamento.adicionarVaga(2, "m");
        estacionamento.adicionarVaga(3, "g");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Registrar entrada de veículo");
            System.out.println("2. Registrar saída de veículo");
            System.out.println("3. Exibir vagas ocupadas");
            System.out.println("4. Exibir histórico de permanência");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    System.out.print("Digite a placa do veículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Digite o modelo do veículo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Digite o tamanho do veículo (p/m/g): ");
                    String tamanho = scanner.nextLine();
                    System.out.print("Digite a hora de entrada (HH:mm): ");
                    String horaEntrada = scanner.nextLine();
                    Veiculo veiculo = new Veiculo(placa, modelo, tamanho);
                    estacionamento.registrarEntradaVeiculo(veiculo, horaEntrada);
                    break;
                case 2:
                    System.out.print("Digite a placa do veículo: ");
                    placa = scanner.nextLine();
                    System.out.print("Digite a hora de saída (HH:mm): ");
                    String horaSaida = scanner.nextLine();
                    estacionamento.registrarSaidaVeiculo(placa, horaSaida);
                    break;
                case 3:
                    estacionamento.exibirVagasOcupadas();
                    break;
                case 4:
                    estacionamento.exibirHistorico();
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
