package com.tim.application.firstApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {

    @Autowired
    MyFirstService myFirstService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Product doSomething(@RequestParam String message) {

        Product result =  myFirstService.doSomeBigBusinessStuff(message);

        System.out.print("Result:"+result);

        return result;
    }
}
