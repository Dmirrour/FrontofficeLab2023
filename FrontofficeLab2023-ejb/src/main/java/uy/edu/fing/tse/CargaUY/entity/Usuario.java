package uy.edu.fing.tse.CargaUY.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uy.edu.fing.tse.CargaUY.dto.EmpresaDTO;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Column(unique = true)
    protected Integer ci;
    protected String nombre;
    protected String apellido;
    protected String email;
    protected String pass;
    //private String salt = PasswordUtil.generateSalt();
    //private String hash = PasswordUtil.hashPassword(pass, salt);
    private static final int SALT_LENGTH = 16; // Longitud del salt en bytes
    private static final int ITERATIONS = 10000; // Número de iteraciones del algoritmo de hash

    @Enumerated(EnumType.STRING)
    protected TipoUsuario tipoUsuario;
    @ManyToOne
    protected Empresa empresa;

    public EmpresaDTO getEmpresaDTO(){
        if(empresa==null){
            return null;
        }else{
            return EmpresaDTO.builder().nroEmpresa(empresa.getNroEmpresa())
                    .razonSocial(empresa.getRazonSocial())
                    .nombrePublico(empresa.getNombrePublico())
                    .direccion(empresa.getDireccion())
                    .build();
        }

    }

    public static String hashPassword(String password) {
        try {
            // Generar un salt aleatorio
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[SALT_LENGTH];
            random.nextBytes(salt);

            // Calcular el hash con el salt y las iteraciones
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.reset();
            md.update(salt);
            byte[] hashedBytes = md.digest(password.getBytes());

            // Convertir el salt y el hash a representaciones base64
            String saltBase64 = Base64.getEncoder().encodeToString(salt);
            String hashedPasswordBase64 = Base64.getEncoder().encodeToString(hashedBytes);

            // Combinar el salt y el hash en una única cadena
            String hashedPassword = saltBase64 + ":" + hashedPasswordBase64;

            return hashedPassword;
        } catch (NoSuchAlgorithmException e) {
            // Manejo de excepciones en caso de algoritmo no encontrado
            e.printStackTrace();
            return null;
        }
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        try {
            // Separar el salt y el hash de la cadena almacenada
            String[] parts = hashedPassword.split(":");
            String saltBase64 = parts[0];
            String hashedPasswordBase64 = parts[1];

            // Decodificar el salt y el hash desde base64
            byte[] salt = Base64.getDecoder().decode(saltBase64);
            byte[] hashedBytes = Base64.getDecoder().decode(hashedPasswordBase64);

            // Calcular el hash utilizando el salt y las iteraciones almacenadas
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.reset();
            md.update(salt);
            byte[] verifyHashedBytes = md.digest(password.getBytes());

            // Comparar el hash calculado con el hash almacenado
            return MessageDigest.isEqual(hashedBytes, verifyHashedBytes);
        } catch (NoSuchAlgorithmException e) {
            // Manejo de excepciones en caso de algoritmo no encontrado
            e.printStackTrace();
            return false;
        }
    }

/*
    public Usuario(){
    }

    public Usuario(long id, Integer ci, String nombre, String apellido, String email, String pass){
        this.id = id;
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.pass = pass;
    }

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

 */
}
