package com.nextyu.demo.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2017-10-28 16:22
 *
 * @author nextyu
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object sayHello(String name) {
        System.out.println("name: " + name);
        return "hello " + name;
    }

}
