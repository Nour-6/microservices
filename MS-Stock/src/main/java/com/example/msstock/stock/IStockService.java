package com.example.msstock.stock;

import java.util.List;

public interface IStockService {
    List<StockDTO> findAll();
    StockDTO getStockById(String stockId);
    StockDTO save(StockDTO stockDTO);
    void deleteById(String id);
}

