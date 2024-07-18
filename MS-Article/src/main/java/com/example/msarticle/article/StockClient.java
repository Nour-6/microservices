package com.example.msarticle.article;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "MS-Stock")
public interface StockClient {

    @GetMapping("/stocks/{id}")
   // @CircuitBreaker(name="",fallBackMethod="")
    StockDTO getStockById(@PathVariable("id") String id);

}
