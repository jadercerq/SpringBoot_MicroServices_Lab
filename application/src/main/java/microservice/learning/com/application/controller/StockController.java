/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice.learning.com.application.controller;

import lombok.extern.slf4j.Slf4j;
import microservice.learning.com.application.service.StockService;
import microservice.learning.com.core.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@RestController
@RequestMapping("admin/stock")
public class StockController {
    
    @Autowired
    private StockService stockService;
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Stock>> list(Pageable pageable) {
        return new ResponseEntity<>(stockService.findAll(pageable), HttpStatus.OK);
    }
    
    @GetMapping(path = {"/{ticker}"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Stock> findByTicker(@PathVariable String ticker) {
        return new ResponseEntity<>(stockService.findById(ticker), HttpStatus.OK);
    }
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Stock> save(@RequestBody Stock stock) {
        return new ResponseEntity<>(stockService.save(stock), HttpStatus.CREATED);
    }
}
