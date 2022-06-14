package BZU.WebServices.Assiment2.service;

import BZU.WebServices.Assiment2.DTO.ProductOrderDto;

import java.util.List;

public interface ProductOrderService {
    ProductOrderDto createProductOrderRecords (ProductOrderDto productOrderDto);
    List<ProductOrderDto> getAllproductOrder ();
    ProductOrderDto getProductOrderById (long id);
    ProductOrderDto updateProductOrder (ProductOrderDto productOrderDto , long id);
    void deleteProductOrderById (long id);
    ProductOrderDto createProductOrder (ProductOrderDto productOrderDto);
     Integer findOrder(ProductOrderDto productOrderDto);




}
