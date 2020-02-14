package com.skumar.graphqldemo.service;

import com.skumar.graphqldemo.beans.Client;
import com.skumar.graphqldemo.repository.ClientRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllClientsDataFetcher implements DataFetcher<List<Client>> {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return clientRepository.findAll();
    }
}
