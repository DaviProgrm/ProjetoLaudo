package dominio;

public class Medico {
    private int id_medico;
    private String nome;
    private String especialidade;
    private int crm;

    public Medico(){

    }
    public Medico(int id_medico, String nome, String especialidade, int crm){
        this.id_medico = id_medico;
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
    }
    public Medico(String nome, String especialidade, int crm){
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public void setId_medico(int id_medico){
        this.id_medico = id_medico;
    }
    public int getId_medico(){
        return id_medico;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }
    public String getEspecialidade(){
        return especialidade;
    }
    public void setCmr(int cmr){
        this.crm = crm;
    }
    public int getCrm(){
        return crm;
    }

}