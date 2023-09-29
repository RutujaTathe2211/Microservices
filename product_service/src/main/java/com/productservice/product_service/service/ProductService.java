package com.microserviceproject2.product_service.service;

import com.microserviceproject2.product_service.Model.Product;
import com.microserviceproject2.product_service.Repository.ProductRepository;
import com.microserviceproject2.product_service.dto.ProductRequest;
import com.microserviceproject2.product_service.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
//to create constructor at run time
//to perform business logic
public class ProductService {

    @Autowired //to save data in database
    private final ProductRepository productRepository;
//    @Autowired
//    private Logger log;
//

    public void createProduct(ProductRequest productRequest){
        Product product= Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription()).
                 price(productRequest.getPrice())
                .build();
        productRepository.save(product);
//        //get product id place in laceholder
//        log.info("product {} is saved",product.getId());
    }
    public List<ProductResponse> getAllProduct(){
        List<Product> products=productRepository.findAll();

         return products.stream().map(product -> mapToProductResponse(product)).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).
                build();
    }
}
