/*package persistencia;

import dominio.Paciente;
import dominio.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public class UsuarioDAO {
        private Conexao con;
        private final String BUSCAR = "select * from usuario";
        //private final String RELATORIONOMES = "select nome from paciente";


        public UsuarioDAO() {
            con = new Conexao();
        }

        public Usuario buscar(String cpf) {
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


    }
*/