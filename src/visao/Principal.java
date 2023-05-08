package visao;

import dominio.Consulta;
import dominio.Medico;
import dominio.Paciente;
import dominio.Laudo;
import persistencia.ConsultaDAO;
import persistencia.LaudoDAO;
import persistencia.MedicoDAO;
import persistencia.PacienteDAO;

import java.util.Scanner;


public class Principal {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int op1, op2, op3,op4;
        String cpfAux;
        String usuario = "admin", senha = "admin1", usu, sen;

        Paciente p;
        Medico m;
        Consulta c;
        Laudo l;

        PacienteDAO pDAO = new PacienteDAO();
        MedicoDAO mDAO = new MedicoDAO();
        ConsultaDAO cDAO = new ConsultaDAO();
        LaudoDAO lDAO = new LaudoDAO();

        //do {
            System.out.println("1- Login");
            System.out.println("2- Sair");
            op3 = ler.nextInt();
            switch (op3) {
                case 1:
                    System.out.println("Bem-Vindo ao Login");
                    System.out.println("-------------------");
                    System.out.println("Digite Usuário:");
                    ler.nextLine();
                    usu = ler.nextLine();
                    System.out.println("Digite a senha:");
                    sen = ler.nextLine();

                    if (usu == usuario && sen == senha) {
                        System.out.println("Usuário ou Senha incorretos!");
                    } else {
                        do {
                            p = null;
                            m = null;
                            System.out.println();
                            System.out.println("    Menu Principal");
                            System.out.println("------------------------");
                            System.out.println("1 - Menu de cadastro");
                            System.out.println("2 - Menu de Busca");
                            System.out.println("3 - Realizar Consulta");
                            System.out.println("4 - Emitir Laudo");
                            System.out.println("3 - Alterar Dados Paciente/Médico");
                            System.out.println("4 - Menu de Exclusão");
                            System.out.println("5 - Login Funcionario");
                            System.out.println("6 - Sair do Sistema");
                            System.out.println("Qual a opção desejada? ");
                            op1 = ler.nextInt();
                            switch (op1) {
                                case 1:
                                    do {
                                        System.out.println("    Menu de Cadastro");
                                        System.out.println("----------------------");
                                        System.out.println("1- Cadastrar Paciente");
                                        System.out.println("2- Cadastrar Medico");
                                        System.out.println("3- Menu Principal");
                                        op2 = ler.nextInt();
                                        switch (op2) {
                                            case 1:
                                                p = new Paciente();
                                                System.out.println("'Cadastro de Paciente'");
                                                System.out.println("------------------");
                                                System.out.println("Digite o cpf do paciente:");
                                                ler.nextLine();
                                                p.setCpf(ler.nextLine());
                                                System.out.println("Digite seu nome:");
                                                p.setNome(ler.nextLine());
                                                System.out.println("Digite seu telefone:");
                                                p.setTelefone(ler.nextLine());
                                                System.out.println("Digite seu endereço completo:");
                                                p.setEndereco(ler.nextLine());
                                                System.out.println("Digite sua data de Nascimento:");
                                                p.setDatanasci(ler.nextLine());
                                                pDAO.inclusao(p);
                                                System.out.println("Cadastro realizado com sucesso...");
                                                break;
                                            case 2:
                                                m = new Medico();
                                                System.out.println("'Cadastro de Médico'");
                                                System.out.println("-------------------");
                                                System.out.println("Digite seu nome:");
                                                ler.nextLine();
                                                m.setNome(ler.nextLine());
                                                System.out.println("Digite sua especialidade:");
                                                m.setEspecialidade(ler.nextLine());
                                                System.out.println("Digite seu CRM:");
                                                m.setCmr(ler.nextInt());
                                                ler.nextLine();
                                                mDAO.inclusao(m);
                                                System.out.println("Cadastro realizado com sucesso...");
                                                break;

                                        }
                                    } while (op2 == 3);
                                    break;
                                case 2:
                                    //do {
                                        System.out.println("    Menu de Busca");
                                        System.out.println("---------------------");
                                        System.out.println("1- Buscar Paciente");
                                        System.out.println("2- Buscar Médico");
                                        System.out.println("3- Menu Principal");
                                        op1 = ler.nextInt();
                                        switch (op1) {

                                            case 1:
                                                do{System.out.println("Buscando Paciente...");
                                                    System.out.println("Digite o CPF do Paciente: ");
                                                    ler.nextLine();
                                                    cpfAux = ler.nextLine();
                                                    // buscar o socio no bd
                                                    p = pDAO.buscar(cpfAux);
                                                    if (p == null)
                                                        System.out.println("Paciente não cadastrado!");
                                                    else {
                                                        System.out.println("Paciente localizado!");
                                                        System.out.println("CPF: " + p.getCpf());
                                                        System.out.println("Nome: " + p.getNome());
                                                        System.out.println("Telefone: " + p.getTelefone());
                                                        System.out.println("Endereço: " + p.getEndereco());
                                                        System.out.println("Data de Nascimento: " + p.getDatanasci());
                                                    }
                                                    System.out.println("");
                                                    System.out.println("Deseja Pesquisar Outro Paciente? 1-sim/2-não");
                                                    op4 = ler.nextInt();
                                                }while(op4 != 2);

                                                break;
                                            case 2:
                                                break;
                                            default:
                                                System.out.println("Opção inválida tente novamente!!!");
                                        }

                                    //} while (op1 != 3);
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    System.out.println("Programa Finalizado!");
                                    break;
                                default:
                                    System.out.println("Opção Inválida tente outra opção!");
                            }
                        } while (op1 != 6);


                    }
            }

        //1
        // }while (op3 != 2) ;
    }
}

