package com.toy.week04.service;

import com.toy.week04.models.ItemDto;
import com.toy.week04.models.Product;
import com.toy.week04.models.ProductMypriceRequestDto;
import com.toy.week04.models.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public void update(Long id, ProductMypriceRequestDto mypriceRequestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당하는 상품이 없습니다.")
        );
        product.update(mypriceRequestDto);
    }

    @Transactional
    public void updateBySearch(Long id, ItemDto itemDto){
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당하는 상품이 없습니다.")
        );
        product.updateByItemDto(itemDto);

    }

}
