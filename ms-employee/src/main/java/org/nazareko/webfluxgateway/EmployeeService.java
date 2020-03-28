package org.nazareko.webfluxgateway;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EmployeeService {

    private static final ConcurrentHashMap<Long, Employee> employees;

    static {
        employees = new ConcurrentHashMap<>();
        employees.put(1L, new Employee("Fedr", 20));
        employees.put(2L, new Employee("Petr", 23));
    }

    public Employee getOne(Long id) {
        System.out.println("NEW REQUEST");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return employees.get(id);
    }
}
