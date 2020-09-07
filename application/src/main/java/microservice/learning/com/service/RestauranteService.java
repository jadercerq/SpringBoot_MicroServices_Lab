/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice.learning.com.service;

import lombok.extern.slf4j.Slf4j;
import microservice.learning.com.core.model.Restaurante;
import microservice.learning.com.core.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RestauranteService {
    
    @Autowired
    private RestauranteRepository restauranteRepository;
    
    public Iterable<Restaurante> findAll(Pageable pageable) {
        log.info("Listando restaurantes");
       return restauranteRepository.findAll(pageable);
    }
}
