package com.example.msstock.stock;

import lombok.Builder;

@Builder
public record StockDTO(String stockId, String zone) {

    // Static method to map from Stock entity to StockDTO
    public static StockDTO mapFromEntity(Stock stock) {
        return StockMapper.INSTANCE.toDto(stock);
    }

    // Static method to map from StockDTO to Stock entity
    public static Stock mapToEntity(StockDTO stockDTO) {
        return StockMapper.INSTANCE.toEntity(stockDTO);
    }

}
