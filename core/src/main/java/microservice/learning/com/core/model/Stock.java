/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice.learning.com.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stock")
public class Stock implements AbstractEntity {
    
    @Id
    private String id;
    
    private String ticker;
    private String setor;
    private String descricao;

    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getTicker() {
        return ticker;
    }
    
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
    
    public String getSetor() {
        return setor;
    }
    
    public void setSetor(String setor) {
        this.setor = setor;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
//</editor-fold>
}
