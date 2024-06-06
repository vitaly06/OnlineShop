package online.shop.taisman.DAO;

import online.shop.taisman.Mappers.ProductMapper;
import online.shop.taisman.Mappers.UserMapper;
import online.shop.taisman.Models.Product;
import online.shop.taisman.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public UserDAO(){
        jdbcTemplate = null;
    }

    public User getUser(int id){
        return jdbcTemplate.query("SELECT * FROM user WHERE id = ?",  new Object[]{id}, new UserMapper())
                .stream().findAny().orElse(null);

    }

    public void addUser(User user){
        assert jdbcTemplate != null;
        jdbcTemplate.update("INSERT INTO user(firstName, lastName, companyName, country, address, " +
                "city, province, zipCode, phone, email) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                user.getFirstName(), user.getLastName(), user.getCompanyName(), user.getCountry(),
                user.getAddress(), user.getCity(), user.getProvince(), user.getZipCode(),
                user.getPhone(), user.getEmail());
    }
}
