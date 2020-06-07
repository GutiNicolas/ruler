package com.github.gutinicolas.ruler.graphql;

import com.github.gutinicolas.ruler.graphql.dataFetchers.DefaultDataFetcher;
import com.github.gutinicolas.ruler.graphql.dataFetchers.LoginDataFetcher;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

@Component
public class GraphQLProvider {

    Logger logger = LoggerFactory.getLogger(GraphQLProvider.class);

    @Autowired
    LoginDataFetcher loginDataFetcher;

    @Autowired
    DefaultDataFetcher defaultDataFetcher;

    private GraphQL graphQL;

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @PostConstruct
    public void init() throws IOException {
        logger.info("Initializing GraphQL API");
        URL url = Resources.getResource("schema.graphqls");
        String schemaStr = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema schema = buildSchema(schemaStr);
        logger.info("BuildSchema successfully completed");
        graphQL = GraphQL.newGraphQL(schema).build();
        logger.info("GraphQL API successfully initialized");
    }

    private GraphQLSchema buildSchema(String schemaStr) {
        logger.info("BuildSchema for GraphQL API started");
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemaStr);
        RuntimeWiring runtimeWiring = buildWirings();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);

    }

    private RuntimeWiring buildWirings() {
        return RuntimeWiring.newRuntimeWiring()
                .type(queryBuilder())
                .build();
    }

    private TypeRuntimeWiring.Builder queryBuilder() {
        return TypeRuntimeWiring.newTypeWiring("Query")
                .dataFetcher("login", loginDataFetcher.login())
                .dataFetcher("isAlive", defaultDataFetcher.isAlive());
    }
}
