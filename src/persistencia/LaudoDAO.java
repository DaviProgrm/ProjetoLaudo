package persistencia;


import dominio.Laudo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LaudoDAO {
    private Conexao con;
    private final String BUSCAR = "select * from paciente where cpf =?";
    private final String INCLUIR = "insert into laudo (fk_consulta,resultado) values (?, ?)";
    private final String EXCLUIR = "delete from consulta where id =?";
    private final String RELATORIO = "select * from laudo  ";

    public LaudoDAO(){
        con = new Conexao();
    }
    public void inclusao (Laudo l){

        try {
            con.conectar();
            PreparedStatement instrucao =
                    con.getConexao().prepareStatement(INCLUIR);
            instrucao.setInt(1, l.getFk_consulta());
            instrucao.setString(2, l.getResultado());
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
    /*public ArrayList<Laudo> relatorio(){
        ArrayList<Laudo> lista = new ArrayList<>();
        try{
            con.conectar();
            Statement instrucao = con.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(RELATORIO);
            while(rs.next()){
                Laudo l = new Laudo(rs.getInt("pk_cpf_s"), rs.getString("nome_s"),
                        rs.getString("data_adm"));
                lista.add(l);
            }
            con.desconectar();
        }catch(SQLException e){
            System.out.println("Erro no relat�rio: "+e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }*/
}
