/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice.learning.com.application.service;

import lombok.extern.slf4j.Slf4j;
import microservice.learning.com.core.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import microservice.learning.com.core.repository.StockRepository;

@Service
@Slf4j
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Iterable<Stock> findAll(Pageable pageable) {
        log.info("Listando ações");
        return stockRepository.findAll(pageable);
    }

    public Stock findById(String id) {
        log.info("Obtendo um ação");
        return stockRepository.findById(id).get();
    }
    
    public Stock save(Stock stock) {
        log.info("incluindo uma ação");
        return stockRepository.save(stock);
    }
}
