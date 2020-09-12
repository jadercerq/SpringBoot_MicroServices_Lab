/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice.learning.com.core.repository;

import microservice.learning.com.core.model.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author jader
 */
public interface StockRepository extends MongoRepository<Stock, String>{
    
}
