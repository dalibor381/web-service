package com.example.webservice;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//With @RestController no need for @Controller+@ResponseBody
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    public AtomicInteger counter ;

    public List<User> users = new ArrayList<>();

    @Autowired
    public User user;


    @GetMapping("/getAll")
    public List<User> getAll() {

        return users;
    }

    //browser url: http://localhost:8080/get?id=1
    @GetMapping("/getById")
    public Optional<User> getThis(@RequestParam int id) {

        return users.stream()
                .filter(n -> n.id == id)
                .findFirst();
    }

    //Must call from Postman. Browser will not do POST/PUT:
    // http://localhost:8080/post?user=Kiki
    @PostMapping("/post")
    public List<User> postThis(@RequestParam String userName) {
        user.setId(counter.incrementAndGet());
        user.setName(userName);
        users.add(user);

        return users;
    }

    //Must call from Postman. Browser will not do POST/PUT:
    @PutMapping("/put")
    public List<User> updateThis(@RequestParam int id, String userName) {
        user.setId(id);
        user.setName(userName);
        users.add(user);

        return users;
    }

    @DeleteMapping("/delete")
    public List<User> deleteThis(@RequestParam int id) {
        users.remove(id);
        System.out.println(users);

        return users;
    }

}
