package alikagan.northwind.repository;


import alikagan.northwind.dto.ProductWithCategoryDto;
import alikagan.northwind.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategoryIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);

    @Query("SELECT NEW alikagan.northwind.dto.ProductWithCategoryDto(p.id , p.productName,c.categoryName)" +
            " FROM Category c Inner join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
    //select p.productId,p.productName, c.categoryName from Category c inner join Product p on c.categoryId = p.categoryId


}
