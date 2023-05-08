package persistencia;

import dominio.Medico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MedicoDAO {
    private Conexao con;
    private final String BUSCAR = "select * from medico where crm =?";
    private final String RELATORIONOMES = "select nome from medico";
    private final String INCLUIR = "insert into medico (nome_medico,especialidade,crm) values (?, ?, ?)";
    private final String EXCLUIR = "delete from medico where crm =?";
    private final String ALTERAR = "update medico set nome =?, especialidade =?, crm =? where crm =?";

    public MedicoDAO() {
        con = new Conexao();
    }
    public Medico buscar(int crm){
        Medico m = null;
        try{
            con.conectar();
            PreparedStatement instrucao =
                    con.getConexao().prepareStatement(BUSCAR);
            instrucao.setInt(1, crm);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()){
                m = new Medico(rs.getString("nome_medico"),rs.getString("especialidade"),
                        rs.getInt("cmr"));
            }
            con.desconectar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return m;
    }

    public void inclusao(Medico m){
        try{
            con.conectar();
            PreparedStatement instrucao =
                    con.getConexao().prepareStatement(INCLUIR);
            instrucao.setString(1, m.getNome());
            instrucao.setString(2, m.getEspecialidade());
            instrucao.setInt(3, m.getCrm());
            instrucao.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: "+e.getMessage());
        }
    }

    public void exclusao(int crm){
        try{
            con.conectar();
            PreparedStatement instrucao =
                    con.getConexao().prepareStatement(EXCLUIR);
            instrucao.setLong(1, crm);
            instrucao.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na exclusão: "+e.getMessage());
        }
    }

    public void alteracao(Medico m, int crm){
        try{
            con.conectar();
            PreparedStatement instrucao =
                    con.getConexao().prepareStatement(ALTERAR);
            instrucao.setString(1, m.getNome());
            instrucao.setString(2, m.getEspecialidade());
            instrucao.setLong(3, m.getCrm());
            instrucao.execute();
            con.desconectar();
        }catch(Exception e){
            System.out.println("Erro na alteração: "+e.getMessage());
        }
    }
    public ArrayList<String> relatorioPorNome(){
        ArrayList<String> lista = new ArrayList<>();
        try{
            con.conectar();
            Statement instrucao = con.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(RELATORIONOMES);
            while(rs.next()){
                lista.add(rs.getString("nome"));
            }
            con.desconectar();
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Erro na busca: "+e.getMessage());
        }
        return lista;
    }
}
