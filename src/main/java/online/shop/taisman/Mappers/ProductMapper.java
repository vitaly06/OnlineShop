package online.shop.taisman.Mappers;

import online.shop.taisman.Models.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        try{
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setImage(resultSet.getString("image"));
            product.setPrice(resultSet.getInt("price"));
        }
        catch (Exception e){
            return new Product();
        }
        return product;
    }
}
