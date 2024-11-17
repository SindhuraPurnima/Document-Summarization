/*package com.example.document_summarization;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

@Service
public class DocProcessor {
    @RabbitListener(queues = "documentQueue")
    public void processDoc(String docId) {
        System.out.println("Processing document with ID: " + docId);

    }

    public void processDocumentWithSpark(String documentId) {
        // Initialize SparkSession
        SparkSession spark = SparkSession.builder()
                .appName("Document Summarization")
                .getOrCreate();

        // Load and process the document (e.g., text processing or summarization)
        Dataset<Row> document = spark.read().text("path/to/document.txt");
        document.show();

        // Process your document (e.g., summarization, NER, etc.)
    }

    private final ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    public  DocumentProcessor(ElasticsearchRestTemplate elasticsearchRestTemplate) {
        this.elasticsearchRestTemplate = elasticsearchRestTemplate;
    }

    public void sendToElasticsearch(String documentId, String summary) {
        // Create a document to be stored in Elasticsearch
        Document document = new Document();
        document.setDocumentId(documentId);
        document.setSummary(summary);

        // Save the document to Elasticsearch
        elasticsearchRestTemplate.save(document);

    }

}*/
