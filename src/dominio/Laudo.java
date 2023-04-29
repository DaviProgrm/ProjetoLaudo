package dominio;

public class Laudo {
    private int id_laudo;
    private int fk_consulta;
    private String resultado;

    public Laudo(){

    }

    public int getId_laudo() {
        return id_laudo;
    }

    public int getFk_consulta() {
        return fk_consulta;
    }

    public String getResultado() {
        return resultado;
    }

    public void setId_laudo(int id_laudo) {
        this.id_laudo = id_laudo;
    }

    public void setFk_consulta(int fk_consulta) {
        this.fk_consulta = fk_consulta;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
