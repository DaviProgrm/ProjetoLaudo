package persistencia;

import dominio.Paciente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteDAO {
    private Conexao con;
    private final String BUSCAR = "select * from paciente where cpf =?";
    //private final String RELATORIONOMES = "select nome from paciente";
    private final String INCLUIR = "insert into paciente (cpf,nome,telefone,endereco,datanasci) values (?, ?, ?, ?, ?)";
    private final String EXCLUIR = "delete from paciente where cpf =?";
    private final String ALTERAR = "update paciente set cpf =?, nome =?, telefone =?, endereco =?, datanasci =? where cpf =?";

    public PacienteDAO() {
        con = new Conexao();
    }

    public Paciente buscar(String cpf) {
        Paciente p = null;
        try {
            con.conectar();
            PreparedStatement instrucao =
                    con.getConexao().prepareStatement(BUSCAR);
            instrucao.setString(1, cpf);
            ResultSet rs = instrucao.executeQuery();
            if (rs.next()) {
                p = new Paciente(rs.getString("cpf"), rs.getString("nome"),
                        rs.getString("telefone"), rs.getString("endereco"), rs.getString("datanasci"));
            }
            con.desconectar();
            return p;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

        public void inclusao (Paciente p){

            try {
                con.conectar();
                PreparedStatement instrucao =
                        con.getConexao().prepareStatement(INCLUIR);
                instrucao.setString(1, p.getCpf());
                instrucao.setString(2, p.getNome());
                instrucao.setString(3, p.getTelefone());
                instrucao.setString(4, p.getEndereco());
                instrucao.setString(5, p.getDatanasci());
                instrucao.execute();
                con.desconectar();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

            public void exclusao (String cpf){
                try {
                    con.conectar();
                    PreparedStatement instrucao =
                            con.getConexao().prepareStatement(EXCLUIR);
                    instrucao.setString(1, cpf);
                    instrucao.execute();
                    con.desconectar();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

                public void alteracao (Paciente p, String cpf){
                    try {
                        con.conectar();
                        PreparedStatement instrucao =
                                con.getConexao().prepareStatement(ALTERAR);
                        instrucao.setString(1, p.getCpf());
                        instrucao.setString(2, p.getNome());
                        instrucao.setString(3, p.getTelefone());
                        instrucao.setString(4, p.getEndereco());
                        instrucao.setString(5, p.getDatanasci());
                        instrucao.execute();
                        con.desconectar();
                    } catch (Exception e) {
                        System.out.println("Erro na alteração: " + e.getMessage());
                    }
                }
            }

