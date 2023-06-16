package uy.edu.fing.tse.CargaUY.dto;

public class LoginDTO {
    private Integer ci;
    private String pass;

    // getters y setters
    public LoginDTO() {}
    public LoginDTO(Integer ci, String pass){

    }
    public Integer getCi() { return this.ci; }
    public void setCi(Integer ci) { this.ci = ci; }

    public String getPass() { return this.pass; }
    public void setPass(String pass) { this.pass = pass; }
}
