package dominio;

public class Consulta {
    private int id_consulta;
    private int fk_paciente;
    private int fk_medico;
    private String data_consulta;

    private Consulta(){

    }

    public int getId_consulta() {
        return id_consulta;
    }

    public int getFk_paciente() {
        return fk_paciente;
    }

    public int getFk_medico() {
        return fk_medico;
    }

    public String getData_consulta() {
        return data_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    public void setFk_paciente(int fk_paciente) {
        this.fk_paciente = fk_paciente;
    }

    public void setFk_medico(int fk_medico) {
        this.fk_medico = fk_medico;
    }

    public void setData_consulta(String data_consulta) {
        this.data_consulta = data_consulta;
    }
}
