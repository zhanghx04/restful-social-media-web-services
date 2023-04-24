package com.haoxiang.rest.webservices.restfulsocialmediawebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // hello-world

//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    // Path Parameters
    // /users/{id}/todos/{id} -> /users/1/todos/100
    // /hello-world/path-variable/{name}
    // /hello-world/path-variable/Haoxiang
    @GetMapping(path = "hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(
                String.format("Hello World, %s!", name)
        );
    }
}
