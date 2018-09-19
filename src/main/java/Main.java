import com.sbt.spring.orm.model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sbt.spring.orm.service.*;
import org.springframework.dao.DataAccessException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        ProductService productService = context.getBean(ProductService.class);

        try {
            productService.addAll(Arrays.asList(new Product(1, "Computer")));
        } catch (DataAccessException dataAccessException) {
        }

        productService.allProducts().forEach(System.out::println);
    }
}
