package online.shop.taisman.Controllers;

import online.shop.taisman.DAO.ProductDAO;
import online.shop.taisman.DAO.UserDAO;
import online.shop.taisman.Models.Product;
import online.shop.taisman.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class MainController {
    @Autowired
    ProductDAO productDAO;
    @Autowired
    UserDAO userDAO;
    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable("id") int id){
        return productDAO.getProduct(id);
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") int id){
        return userDAO.getUser(id);
    }

    @PostMapping("/regUser")
    public ResponseEntity<HttpStatus> regUser(@RequestBody User user){
        userDAO.addUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
