package online.shop.taisman.Controllers;

import online.shop.taisman.DAO.ProductDAO;
import online.shop.taisman.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MainController {
    @Autowired
    ProductDAO productDAO;
    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable("id") int id){
        return productDAO.getProduct(id);
    }
}
