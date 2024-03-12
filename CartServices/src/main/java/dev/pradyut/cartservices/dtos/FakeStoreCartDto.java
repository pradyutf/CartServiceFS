package dev.pradyut.cartservices.dtos;

import dev.pradyut.cartservices.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FakeStoreCartDto {
    private Long id;
    private Long userId;
    private String date;
    private List<Product> products;
}
