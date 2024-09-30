import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione o tipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        int tipoConta = scanner.nextInt();

        Conta conta;
        if (tipoConta == 1) {
            conta = new ContaCorrente();
        } else {
            conta = new ContaPoupanca();
        }

        System.out.println("Informe o nome do titular:");
        String nomeTitular = scanner.next();
        conta.setNomeTitular(nomeTitular);

        while (true) {
            System.out.println("Menu de opções:");
            if (conta instanceof ContaCorrente) {
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Usar cheque especial");
                System.out.println("4. Exibir dados da conta");
            } else {
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Calcular rendimento");
                System.out.println("4. Exibir dados da conta");
            }
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Informe o valor do depósito:");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.println("Informe o valor do saque:");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    if (conta instanceof ContaCorrente) {
                        conta.usarChequeEspecial();
                    } else {
                        conta.calcularRendimento();
                    }
                    break;
                case 4:
                    conta.exibirDados();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}