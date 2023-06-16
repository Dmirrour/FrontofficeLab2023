package uy.edu.fing.tse.CargaUY.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public final class Login implements Serializable {
    private static final long serialVersionUID = 1L;

    private static Login instancia;
    protected Integer ci;
    protected String pass;
    protected String rol;

    public static Login getInstancia(Integer ci, String pass, String rol) {
        if (instancia == null) {
            instancia = new Login(ci, pass, rol);
        }
        return instancia;
    }

    public Integer getCi() { return this.ci; }
    public void setCi(Integer ci) { this.ci = ci; }

    public String getPass() { return this.pass; }
    public void setPass(String pass) { this.pass = pass; }

    public String getRol() { return this.rol; }
    public void setRol(String rol) { this.rol = rol; }
}
