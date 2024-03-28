package alikagan.northwind.business;

import alikagan.northwind.core.results.DataResult;
import alikagan.northwind.core.results.Result;
import alikagan.northwind.core.results.SuccessDataResult;
import alikagan.northwind.core.results.SuccessResult;
import alikagan.northwind.dto.ProductWithCategoryDto;
import alikagan.northwind.entity.Product;
import alikagan.northwind.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    //constructor injection yaptığımız için @Autowired yapmadık
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(this.productRepository.findAll(),"Data was listed succesfully");
    }

    @Override
    public SuccessDataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<Product>>(this.productRepository.findAll(pageable).getContent(),"Data was listed succesfully");
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<List<Product>>(this.productRepository.findAll(sort),"Data was listed in descending order succesfully");
    }

    @Override
    public Result add(Product product) {
        this.productRepository.save(product);
        return new SuccessResult("Product succesfully added");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productRepository.getByProductName(productName),
                "Product listed succesfully");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this.productRepository.getByProductNameAndCategory_CategoryId(productName,categoryId),
                "Products listed succesfully");    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByProductNameOrCategory_CategoryId(productName,categoryId),
                "Products listed succesfully");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByCategoryIn(categories),
                "Products listed succesfully");    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByProductNameContains(productName),
                "Products listed succesfully");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByProductNameStartsWith(productName),
                "Products listed succesfully");       }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByNameAndCategory(productName,categoryId),
                "Products listed succesfully");       }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductsWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productRepository.getProductWithCategoryDetails(),
                "ProductWithCategoryDto Data listed succesfully");
    }
}
