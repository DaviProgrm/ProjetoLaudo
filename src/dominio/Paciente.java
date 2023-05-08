package dominio;

public class Paciente {

    private int id_paciente;
    private String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String datanasci;

    public Paciente(){

    }
    public Paciente(int id_paciente, String cpf, String nome, String telefone, String endereco, String datanasci){
        this.id_paciente = id_paciente;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.datanasci = datanasci;
    }
    public Paciente(String cpf, String nome, String telefone, String endereco, String datanasci){
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.datanasci = datanasci;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setId_paciente(int id_paciente){
        this.id_paciente = id_paciente;
    }
    public int getId_paciente(){
        return id_paciente;
    }
    public void setDatanasci(String datanasci){
        this.datanasci = datanasci;
    }
    public String getDatanasci(){
        return datanasci;
    }
}
