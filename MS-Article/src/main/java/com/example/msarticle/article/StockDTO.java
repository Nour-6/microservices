package com.example.msarticle.article;

import lombok.Builder;

@Builder
public record StockDTO(String stockId, String zone) {
}
