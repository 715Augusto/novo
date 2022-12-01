package AgenciaBancaria;
import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Contacorrente> contasBancarias;
    private static int numerodaConta;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Contacorrente>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("                                   ");
        System.out.println("              Banco APK            ");
        System.out.println("                                   ");
        System.out.println("   Que operação deseja realizar ?  ");
        System.out.println("                                   ");
        System.out.println(" 1 -  Abrir minha conta corrente   ");
        System.out.println(" 2 -     Efetuar um depósito       ");
        System.out.println(" 3 -        Realizar saque         ");
        System.out.println(" 4 -   Efetuar uma transferência   ");
        System.out.println(" 5 -    Encontar conta corrente    ");
        System.out.println(" 6 -             Sair              ");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                criarContacorrente();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                encontrarconta();
                break;
            case 6:
                System.out.println("Obrigado usar nossa agência, volte sempre!!");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
        }
    }

    public static void criarContacorrente() {
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Cliente cliente = new Cliente(nome, cpf, email);
        Contacorrente contacorrente = new Contacorrente(cliente);

        contasBancarias.add(contacorrente);
        System.out.println("Sua conta foi criada com sucesso seu número de conta é " + contacorrente);

        operacoes();
    }

    private static Contacorrente encontrarConta() {
        Contacorrente contacorrente = null;
        if (contasBancarias.size() > 0) {
            for (Contacorrente a : contasBancarias) {
                if (a.getNumerodaConta() == numerodaConta) ;
                contacorrente = a;
            }
        }
        return contacorrente;
    }

    public static void depositar() {
        System.out.println("Informe o número da conta: ");
        int numeroDaConta = input.nextInt();

        Contacorrente contacorrente = encontrarConta();

        if (contacorrente != null) {
            System.out.println("Informe o valor para depósito: ");
            Double valorDeposito = input.nextDouble();
            contacorrente.depositar(valorDeposito);
            System.out.println("Valor foi depositado com sucesso, confira seu saldo!");
        } else {
            System.out.println("Conta não encontrada");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Informe o número da conta: ");
        int numeroDaConta = input.nextInt();

        Contacorrente contacorrente = encontrarConta();

        if (contacorrente != null) {
            System.out.println("Informe o valor que deseja sacar: ");
            Double valorSaque = input.nextDouble();
            contacorrente.sacar(valorSaque);
            System.out.println("Valor foi retirado com sucesso, retire no local indicado e confira seu saldo!");
        } else {
            System.out.println("Conta não encontrada, revise as informaçõe se tente novamente");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Informe a conta que fará a transferência: ");
        int numeroContaEnvia = input.nextInt();

        Contacorrente contaEnvia = encontrarConta();
        if (contaEnvia != null) {
            System.out.println("Informe a conta que receberá a transferência: ");
            int numeroContaRecebe = input.nextInt();

            Contacorrente contarecebe = encontrarConta();
            if (contarecebe != null) {
                System.out.println("Valor da transferência: ");
                Double valor = input.nextDouble();

                contarecebe.transferir(contarecebe, valor);
            }else{
                System.out.println("Conta para deposito não foi encontrada");
            }
        }
        operacoes();
    }
    public static void encontrarconta(){
        if(contasBancarias.size() > 0) {
            for(Contacorrente contacorrente: contasBancarias){
                System.out.println(contacorrente);
            }
        }else{
                System.out.println("Não existem contas cadastradas");
            }
        operacoes();

        }

    public static void sair(){
    }
    }
