package sklep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sklep.model.Product;
import sklep.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String readAll(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "/WEB-INF/templates/products.jsp";
    }

    @GetMapping("/products/{numer}")
    public String readOne(Model model, @PathVariable Integer numer) {
        Optional<Product> product = productRepository.findById(numer);

        if (product.isPresent()) {
            model.addAttribute("products", product.get());
            return "/WEB-INF/templates/product.jsp";
        } else {
            model.addAttribute("productId", numer);
            return "/WEB-INF/templates/missing_product.jsp";

        }

    }
}
