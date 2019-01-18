package customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class CustomerController {

    @GetMapping("/allshops")
    public ResponseEntity<String> allShops(){
        try {
            final String uri = "http://10.0.2.15:8080/allshops";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity(null, httpHeaders), String.class);
            ObjectMapper mapper = new ObjectMapper();
            String response = mapper.writeValueAsString(result);
            return new ResponseEntity<String>(response, new HttpHeaders(), result.getStatusCode());
        }catch (Exception e){

        }
        return null;
    }
}