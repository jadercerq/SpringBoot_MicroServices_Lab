/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice.learning.com.core.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "usuario")
public class Usuario implements AbstractEntity {
    
    @Id
    private String id;
    private String usuario;
    private String senha;
    private String role = "USER";
    private Date dataCadastro;

    public Usuario(Usuario usuario) {
        this.usuario = usuario.getUsuario();
        this.senha = usuario.getSenha();
        this.role = usuario.getRole();
    }
}
