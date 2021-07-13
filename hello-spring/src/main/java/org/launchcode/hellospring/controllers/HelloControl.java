package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

/*
    Created by Michael Williams
 */

@Controller
public class HelloControl {

    // Handles request at path /hello
    @GetMapping("")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }

    // Handles request at path /goodbye
    // Lives @ /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Lives @ /hello/hello
    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String message = "Hello, " + name + "!";
        model.addAttribute("greeting", message);
        return "hello";
    }

    // Handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    // Lives @ /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("helloNames")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Mike");
        names.add("Tom");
        names.add("Ed");
        names.add("Steve");
        names.add("Ted");
        model.addAttribute("names", names);
        return "helloList";
    }

}
