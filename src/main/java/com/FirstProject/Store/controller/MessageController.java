package com.FirstProject.Store.controller;

import com.FirstProject.Store.entities.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @RequestMapping("/hello")
    public Message hello() {
        return new Message("Hello World from controller");
    }
}
