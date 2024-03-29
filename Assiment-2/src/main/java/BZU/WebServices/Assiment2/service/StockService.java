package BZU.WebServices.Assiment2.service;


import BZU.WebServices.Assiment2.DTO.StockDto;

import java.util.List;

public interface StockService {
    StockDto createStockRecords (StockDto StockDto);
    List<StockDto> getAllStocks ();
    StockDto getStockById (long id);
    StockDto updateStock (StockDto StockDto , long id);
    void deleteStockById (long id);

    StockDto createStock (long productId , StockDto stockDto);
    List<StockDto> getStockByProductId (long productId);
    StockDto getStockById (long productId , long stockId );

    StockDto updateStock (long productId , long stockId ,StockDto stockDto);
    void deleteStock (long productId , long stockId);




}
