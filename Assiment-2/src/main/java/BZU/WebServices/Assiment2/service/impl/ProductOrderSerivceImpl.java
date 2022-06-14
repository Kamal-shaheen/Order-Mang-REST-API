package BZU.WebServices.Assiment2.service.impl;
import BZU.WebServices.Assiment2.DTO.ProductOrderDto;
import BZU.WebServices.Assiment2.entity.ProductOrder;
import BZU.WebServices.Assiment2.exception.ResourceNotFoundException;
import BZU.WebServices.Assiment2.repository.ProductOrderRepository;
import BZU.WebServices.Assiment2.service.ProductOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductOrderSerivceImpl implements ProductOrderService {

    private ProductOrderRepository productOrderRepository;

    public ProductOrderSerivceImpl(ProductOrderRepository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }

    @Override
    public ProductOrderDto createProductOrderRecords(ProductOrderDto productOrderDto) {
        ProductOrder productOrder = mapToEntity(productOrderDto);
        ProductOrder saveDate = productOrderRepository.save(productOrder);

        return mapToDto(saveDate);
    }

    @Override
    public List<ProductOrderDto> getAllproductOrder() {
        List<ProductOrder> list = productOrderRepository.findAll();
        return list.stream().map(productOrder -> mapToDto(productOrder)).collect(Collectors.toList());
    }

    @Override
    public ProductOrderDto getProductOrderById(long id) {
        ProductOrder productOrder =  productOrderRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Stock","Id",id)
        );
        return mapToDto(productOrder);

    }

    @Override
    public ProductOrderDto updateProductOrder(ProductOrderDto productOrderDto, long id) {
        ProductOrder productOrder =  productOrderRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Stock","Id",id)
        );
        productOrder.setPrice(productOrderDto.getPrice());
        productOrder.setVat(productOrderDto.getVat());
        productOrder.setQuantity(productOrderDto.getQuantity());

        ProductOrder saveProductOrder = productOrderRepository.save(productOrder);

        return mapToDto(saveProductOrder);
    }

    @Override
    public void deleteProductOrderById(long id) {
        ProductOrder productOrder =  productOrderRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Stock","Id",id)
        );
        productOrderRepository.delete(productOrder);

    }

    @Override
    public ProductOrderDto createProductOrder(ProductOrderDto productOrderDto) {
        ProductOrder productOrder = mapToEntity(productOrderDto);
        return null;
    }

    @Override
    public Integer findOrder(ProductOrderDto productOrderDto) {
        ProductOrder productOrder = mapToEntity(productOrderDto);
        int count = productOrderRepository.countAllByOrder(productOrder.getOrder());
        return count;
    }

    private ProductOrderDto mapToDto (ProductOrder productOrder){
        ProductOrderDto productOrderDto = new ProductOrderDto();
        productOrderDto.setPrice(productOrder.getPrice());
        productOrderDto.setVat(productOrder.getVat());
        productOrderDto.setQuantity(productOrder.getQuantity());

        return  productOrderDto;

    }
    private ProductOrder mapToEntity (ProductOrderDto productOrderDto){
        ProductOrder productOrder = new ProductOrder();
        productOrder.setPrice(productOrderDto.getPrice());
        productOrder.setVat(productOrderDto.getVat());
        productOrder.setQuantity(productOrderDto.getQuantity());

        return productOrder;
    }
}
