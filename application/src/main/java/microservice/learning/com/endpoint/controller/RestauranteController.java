/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice.learning.com.endpoint.controller;

import lombok.extern.slf4j.Slf4j;
import microservice.learning.com.cardapio.endpoint.service.RestauranteService;
import microservice.learning.com.core.model.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@RestController
@RequestMapping("admin/restaurante")
public class RestauranteController {
    
    @Autowired
    private RestauranteService restauranteService;
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Restaurante>> list(Pageable pageable) {
        return new ResponseEntity<>(restauranteService.findAll(pageable), HttpStatus.OK);
    }
}
