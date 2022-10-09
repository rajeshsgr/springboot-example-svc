package com.springboot.example.requestsvc.web.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.springboot.example.requestsvc.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author rajeshp
 * @Date 10/8/22
 */
@RestController
@RequestMapping("/v1/api")
public class ControllerExample {

    private static final Logger log = LoggerFactory.getLogger(ControllerExample.class);


    @GetMapping("/employee/{id}")
    public String getEmployeeByID(@PathVariable("id") String id) {

        log.info("Recieved Input {}",id);

        String empId=id;
        return "Recieved Employee ID--"+empId;
    }

    @GetMapping("/employee/{name}/{id}")
    public String getEmployeeByID(@PathVariable("name") String name,@PathVariable("id") String id) {
        log.info("Recieved Input {}, {}",name, id);


        String empId=id;
        String empName=name;
        return "Recieved Employee Name--"+name +" Employee ID--"+empId;
    }

    @GetMapping("/listHeaders")
    public ResponseEntity<String> listAllHeaders(
            @RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> {
            log.info(String.format("Header '%s' = %s", key, value));
        });

        return new ResponseEntity<String>(
                String.format("Listed %d headers", headers.size()), HttpStatus.OK);
    }

    @GetMapping(value="/listSpecificHeaders")
    public ResponseEntity<String> listSpecificHeaders(
            @RequestHeader("content-type") String contentType, @RequestHeader("emp-name") String empName) {

        log.info("Header value - Content-Type: {}", contentType);
        log.info("Header value - empName: {}", empName);

        return new ResponseEntity<String>(
                String.format("Recieved %2s & %2s header values", contentType, empName), HttpStatus.OK);
    }

    @PostMapping("/arbitaryJSON")
    public ResponseEntity<String> listSpecificHeaders(@RequestBody JsonNode jsonNode){

        log.info("Recieved Input: {}", jsonNode);
        return new ResponseEntity<String>(
                String.format("Recieved request body %2s ", jsonNode.toString()), HttpStatus.OK);
    }

    @PostMapping("/mapJSON2Object")
    public ResponseEntity<Employee> postEmployeeRequest(@RequestBody Employee employee){

        log.info("Recieved Input: {}", employee);

        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
}
