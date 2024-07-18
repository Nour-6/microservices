package com.example.msstock.stock;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "stock")
public class Stock {
    @Id
    private String id;
    private String zone;

}

