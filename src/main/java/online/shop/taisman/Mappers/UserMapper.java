package online.shop.taisman.Mappers;

import online.shop.taisman.Models.Product;
import online.shop.taisman.Models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        try {
            user.setId(resultSet.getInt("id"));
            user.setFirstName(resultSet.getString("firstName"));
            user.setLastName(resultSet.getString("lastName"));
            user.setCompanyName(resultSet.getString("companyName"));
            user.setCountry(resultSet.getString("country"));
            user.setAddress(resultSet.getString("address"));
            user.setCity(resultSet.getString("city"));
            user.setProvince(resultSet.getString("province"));
            user.setZipCode(resultSet.getString("zipCode"));
            user.setPhone(resultSet.getString("phone"));
            user.setEmail(resultSet.getString("email"));
        } catch (Exception e) {
            return new User();
        }
        return user;
    }
}
