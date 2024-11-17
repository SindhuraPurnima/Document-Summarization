package com.example.document_summarization;  // Use your appropriate package

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.EnableElasticsearchRepositories;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.RestClients;
import org.springframework.data.elasticsearch.core.ClientConfiguration;
import org.elasticsearch.client.RestHighLevelClient;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.document_summarization") // Adjust package as needed
public class ElasticsearchConfig {

    @Value("${spring.elasticsearch.rest.uris}")
    private String elasticsearchUri;

    @Bean
    public RestHighLevelClient client() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(elasticsearchUri)
                .build();

        return RestClients.create(clientConfiguration).rest();  // Using RestClients
    }

    @Bean
    public ElasticsearchRestTemplate elasticsearchRestTemplate() {
        return new ElasticsearchRestTemplate(client());
    }
}
