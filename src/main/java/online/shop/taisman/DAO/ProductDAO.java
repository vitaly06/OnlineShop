package online.shop.taisman.DAO;

import online.shop.taisman.Mappers.ProductMapper;
import online.shop.taisman.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public ProductDAO(){
        jdbcTemplate = null;
    }

    public Product getProduct(int id){
        return jdbcTemplate.query("SELECT * FROM products WHERE id = ?",  new Object[]{id}, new ProductMapper())
                .stream().findAny().orElse(null);

    }
}
