package alikagan.northwind.controller;

import alikagan.northwind.business.ProductService;
import alikagan.northwind.core.results.DataResult;
import alikagan.northwind.core.results.Result;
import alikagan.northwind.dto.ProductWithCategoryDto;
import alikagan.northwind.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll() {
        return this.productService.getAll();
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        return this.productService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllSorted")
    public DataResult<List<Product>> getAllSorted() {
        return this.productService.getAllSorted();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(String productName) {
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return this.productService.getByProductNameAndCategory(productName, categoryId);
    }

    @GetMapping("/getByProductNameOrCategoryId")
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return this.productService.getByProductNameOrCategory(productName, categoryId);
    }

    @GetMapping("/getByCategoryIn")
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return this.productService.getByCategoryIn(categories);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByNameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return this.productService.getByNameAndCategory(productName, categoryId);
    }

    @GetMapping("/getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return this.productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductsWithCategoryDetails() {
        return this.productService.getProductsWithCategoryDetails();
    }



}