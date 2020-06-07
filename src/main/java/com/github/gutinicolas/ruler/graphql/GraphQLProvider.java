package com.github.gutinicolas.ruler.graphql;

import com.github.gutinicolas.ruler.graphql.dataFetchers.LoginDataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GraphQLProvider {

    @Autowired
    LoginDataFetcher loginDataFetcher;

    private GraphQLSchema buildSchema(String schemaStr) {
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
                .dataFetcher("login", loginDataFetcher.login());
    }
}
