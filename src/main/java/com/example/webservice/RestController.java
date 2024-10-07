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

    public Map<Integer, User> users = new HashMap<>();

    @Autowired
    public User user;

    @GetMapping("/getAll")
    public Map<Integer, User> getAll() {
        return users;
    }

    //browser url: http://localhost:8080/get?id=1
    @GetMapping("/getById")
    public User getThis(@RequestParam int id) {
        return users.get(id);
    }

    //Must call from Postman. Browser will not do POST/PUT   http://localhost:8080/post?user=Kiki
    @PostMapping("/post")
    public Map<Integer, User> postThis(@RequestParam String userName) {
        user = new User();
        user.setName(userName);
        users.put(counter.incrementAndGet(), user);

        return users;
    }

    //Must call from Postman. Browser will not do POST/PUT:
    @PutMapping("/put")
    public Map<Integer, User> updateThis(@RequestParam int id, String userName) {
        user = new User();
        user.setName(userName);
        users.put(id, user);

        return users;
    }

    @DeleteMapping("/delete")
    public Map<Integer, User> deleteThis(@RequestParam int id) {
        users.remove(id);

        return users;
    }

}
