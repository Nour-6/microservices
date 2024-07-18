package com.example.msstock.stock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/stocks")
@Slf4j
@RequiredArgsConstructor
public class StockController {
    private final IStockService stockService;

    @GetMapping
    public List<StockDTO> getAllStocks() {
        return stockService.findAll();
    }

    @GetMapping("/{id}")
    public StockDTO getStockById(@PathVariable String id) {
        return stockService.getStockById(id);
    }

    @PostMapping
    public StockDTO createStock(@RequestBody StockDTO stockDTO) {
        return stockService.save(stockDTO);
    }

    @PutMapping("/{id}")
    public StockDTO updateStock(@PathVariable String id, @RequestBody StockDTO stockDTO) {
        return stockService.save(stockDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable String id) {
            stockService.deleteById(id);
    }

}
