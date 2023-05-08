package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private String usuario;
    private String senha;
    private String caminho;
    private Connection con;

    public Conexao(){
        caminho = "jdbc:postgresql://localhost:5432/laudo";
        usuario = "postgres";
        senha = "postgres";
    }
    public void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(caminho, usuario, senha);
    }

    public void desconectar() throws SQLException {
        con.close();
    }
    public Connection getConexao(){
        return con;
    }
}
