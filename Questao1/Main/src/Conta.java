 class Conta {
        protected String nomeTitular;
        protected double saldo;

        public Conta() {
            this.saldo = 0.0;
        }

        public void setNomeTitular(String nomeTitular) {
            this.nomeTitular = nomeTitular;
        }

        public void depositar(double valor) {
            this.saldo += valor;
        }

        public void sacar(double valor) {
            if (this.saldo >= valor) {
                this.saldo -= valor;
            } else {
                System.out.println("Saldo insuficiente!");
            }
        }

        public void exibirDados() {
            System.out.println("Nome do titular: " + this.nomeTitular);
            System.out.println("Saldo: " + this.saldo);
        }

     public void usarChequeEspecial() {
     }

     public void calcularRendimento() {
     }
 }

    class ContaCorrente extends Conta {
        public void usarChequeEspecial() {
            if (this.saldo + 1000.0 >= 0.0) {
                this.saldo += 1000.0;
                System.out.println("Cheque especial utilizado!");
            } else {
                System.out.println("Saldo insuficiente para usar cheque especial!");
            }
        }
    }

    class ContaPoupanca extends Conta {
        public void calcularRendimento() {
            double selic = 10.0;
            double rendimento;
            if (selic > 8.5) {
                rendimento = 0.005 * this.saldo;
            } else {
                rendimento = 0.007 * selic * this.saldo;
            }
            this.saldo += rendimento;
            System.out.println("Rendimento calculado!");
        }
    }
