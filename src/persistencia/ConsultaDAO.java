package persistencia;

import dominio.Consulta;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultaDAO {

    private Conexao con;
    private final String BUSCAR = "select * from paciente where cpf =?";
    private final String INCLUIR = "insert into consulta (fk_paciente,fk_medico,data_consulta) values (?, ?, ?)";
    private final String EXCLUIR = "delete from consulta where id =?";

    public ConsultaDAO(){
        con = new Conexao();
    }
    public void inclusao (Consulta c){

        try {
            con.conectar();
            PreparedStatement instrucao =
                    con.getConexao().prepareStatement(INCLUIR);
            instrucao.setInt(1, c.getFk_paciente());
            instrucao.setInt(2, c.getFk_medico());
            instrucao.setString(3, c.getData_consulta());
            instrucao.execute();
            con.desconectar();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void exclusao (int id_consulta){
        try {
            con.conectar();
            PreparedStatement instrucao =
                    con.getConexao().prepareStatement(EXCLUIR);
            instrucao.setInt(1, id_consulta);
            instrucao.execute();
            con.desconectar();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
