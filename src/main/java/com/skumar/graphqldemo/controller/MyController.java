package com.skumar.graphqldemo.controller;

import com.skumar.graphqldemo.service.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {


    @Autowired
    private GraphQLService graphQLService;

    @PostMapping("client")
    public ResponseEntity<Object> getClient(@RequestBody String query) {
        ExecutionResult execute = graphQLService.getGraphQL().execute(query);
        return new ResponseEntity<>(execute,HttpStatus.OK);
    }

}
