package com.example.msstock.stock;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class StockServiceImpl implements IStockService {
    private StockRepository repository;

    public List<StockDTO> findAll() {
        return repository.findAll().stream()
                .map(StockDTO::mapFromEntity)
                .collect(Collectors.toList());
    }

    public StockDTO  getStockById(String id) {
        Stock stock = repository.findById(id).orElse(null);
        return StockDTO.mapFromEntity(stock);
    }

    public StockDTO save(StockDTO stockDTO) {
        Stock stock = StockDTO.mapToEntity(stockDTO);
        stock = repository.save(stock);
        return StockDTO.mapFromEntity(stock);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}

