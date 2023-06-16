package uy.edu.fing.tse.CargaUY.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uy.edu.fing.tse.CargaUY.entity.Empresa;
import uy.edu.fing.tse.CargaUY.entity.TipoUsuario;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements Serializable {
    protected Long id;
    protected Integer ci;
    protected String nombre;
    protected String apellido;
    protected String email;
    protected String pass;
    protected TipoUsuario tipoUsuario;
    protected EmpresaDTO empresa;

    /*public UsuarioDTO(Usuario u){
        this.id = u.getId();
        this.ci = u.getCi();
        this.nombre = u.getNombre();
        this.apellido = u.getApellido();
        this.email = u.getEmail();
        this.pass = u.getPass();
    }*/

    public long getId() { return this.id; }
    public void setId(long id) { this.id = id; }

    public Integer getCi() { return this.ci; }
    public void setCi(Integer ci) { this.ci = ci; }

    public String getNombre() { return this.nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return this.apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }

    public String getPass() { return this.pass; }
    public void setPass(String pass) { this.pass = pass; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UsuarioDTO other = (UsuarioDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
