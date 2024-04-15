package com.restapi.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.restapi.model.*;

import java.util.ArrayList;


@RestController
@ComponentScan({"/controller.*"})
public class HelloWorldController {
    ArrayList<Employee> listOfEmployees = new ArrayList<>();

    HelloWorldController() {
        for (int i = 0; i <= 10; i++) {
            Employee e = new Employee();
            e.setId(i);
            e.setName("name" + i);
            listOfEmployees.add(e);

        }
    }


    @GetMapping("/names")
    public String hello() {

        return "Names API has been called ";
    }

    @GetMapping("/api/data")
    public Employee getData(@RequestParam(name = "id") int id) {

        return listOfEmployees.stream().filter(s -> s.getId() == id).findAny().get();

    }


    @GetMapping(value = "/hello",
            produces = {MediaType.TEXT_PLAIN_VALUE})
    public String sayPlainTextHello() {
        return "Hello Jersey";
    }


    @GetMapping(value = "/hello",
            produces = {MediaType.APPLICATION_XML_VALUE})
    public String sayXMLHello() {
        return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
    }


    @GetMapping(value = "/hello",
            produces = {MediaType.TEXT_HTML_VALUE})
    public String sayHtmlHello() {
        return "<html> " + "<title>" + "Hello Jersey" + "</title>"
                + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
    }


    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getData2() {
        // Create a sample DataObject
        Employee dataObject = new Employee();
        dataObject.setId(1);
        dataObject.setName("Sample Data");
        return dataObject;
    }

}