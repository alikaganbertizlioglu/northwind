package alikagan.northwind.business;

import alikagan.northwind.core.results.DataResult;
import alikagan.northwind.core.results.Result;
import alikagan.northwind.core.results.SuccessDataResult;
import alikagan.northwind.dto.ProductWithCategoryDto;
import alikagan.northwind.entity.Product;

import java.util.List;


public interface ProductService {

    DataResult<List<Product>> getAll();

    SuccessDataResult<List<Product>> getAll(int pageNo, int pageSize);

    DataResult<List<Product>> getAllSorted();

    Result add(Product product);

    DataResult<Product> getByProductName(String productName);
    DataResult<Product> getByProductNameAndCategory(String productName, int categoryId);

    DataResult<List<Product>>getByProductNameOrCategory(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

    DataResult<List<ProductWithCategoryDto>> getProductsWithCategoryDetails();


}
