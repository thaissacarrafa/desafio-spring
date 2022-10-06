package com.meli.desafiospring.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderEnum {
    ALFABETICO_CRESCENTE(0),
    ALFABETICO_DECRESCENTE (1),
    MAIOR_MENOR(2),
    MENOR_MAIOR (3);

    private Integer Order;
}

