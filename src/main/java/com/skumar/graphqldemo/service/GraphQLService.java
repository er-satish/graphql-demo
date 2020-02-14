package com.skumar.graphqldemo.service;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.io.File;
import java.io.IOException;

@Service
public class GraphQLService {

    @Value("classpath:clients.graphql")
    private Resource resource;

    private GraphQL graphQL;

    @Autowired
    private AllClientsDataFetcher allClientsDataFetcher;

    @Autowired
    private ClientDataFetcher clientDataFetcher;

    @PostConstruct
    private void loadSchema() throws IOException {
        //Get the graphql file
        File file = resource.getFile();
        //Parse SchemaF
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(file);
        RuntimeWiring runtimeWiring = buildRuntimeWiring();
        GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
        graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allClients", allClientsDataFetcher)
                        .dataFetcher("client", clientDataFetcher)).
                        build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }

}
