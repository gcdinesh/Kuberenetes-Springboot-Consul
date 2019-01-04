package Shop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShopController {

    @GetMapping("/allshops")
    public String allShops(){
        return "allsdshops";
    }
}
