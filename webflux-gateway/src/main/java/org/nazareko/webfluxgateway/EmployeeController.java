package org.nazareko.webfluxgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    WebClient webClient = WebClient.create("http://localhost:9090");

    @GetMapping("/{id}")
    public Mono<Employee> getOne(@PathVariable Long id) {
        return webClient.get()
                .uri("/employees/{id}", id)
                .retrieve()
                .bodyToMono(Employee.class);
    }
}
