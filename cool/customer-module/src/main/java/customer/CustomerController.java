package customer;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class CustomerController {

    @GetMapping("/allshops")
    public ResponseEntity<String> allShops(){
        final String uri = "http://localhost:8080/allshops";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity(null, httpHeaders), String.class);
        return result;
    }
}