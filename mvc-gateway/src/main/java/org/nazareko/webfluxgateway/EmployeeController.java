package org.nazareko.webfluxgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable Long id) {
        return restTemplate
                .getForEntity("http://localhost:9090/employees/" + id, Employee.class)
                .getBody();
    }
}
