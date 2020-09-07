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
@Document(collection = "restaurante")
public class Restaurante implements AbstractEntity {
    
    @Id
    private String id;
    
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private Date dataCadastro;
}
