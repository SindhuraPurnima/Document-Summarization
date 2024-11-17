package com.example.document_summarization;
/*import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController 
@Service
public class UploadDocController {
   
        private final RabbitTemplate rabbitTemplate;
    
        public UploadDocController(RabbitTemplate rabbitTemplate) {
            this.rabbitTemplate = rabbitTemplate;
        }
    
        @PostMapping("/upload")
        public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file) {
            // Generate an ID for the document (you can save it to a database if needed)
            String documentId = "generated-document-id"; 
    
            // Store the file locally or in a temporary storage (optional step based on your needs)
            // Use a file storage service or save it to the disk if needed.
    
            // Publish the documentId to RabbitMQ
            rabbitTemplate.convertAndSend("documentQueue", documentId);
    
            return ResponseEntity.ok("File uploaded and message sent to queue");
        }
    }*/

import org.springframework.http.ResponseEntity; // For returning HTTP responses
import org.springframework.web.bind.annotation.PostMapping; // Annotation for POST API
import org.springframework.web.bind.annotation.RequestMapping; // Base URL for the controller
import org.springframework.web.bind.annotation.RequestParam; // To extract the file parameter
import org.springframework.web.bind.annotation.RestController; // Marks this as a REST Controller
import org.springframework.web.multipart.MultipartFile; // Handles uploaded files

@RestController // Marks this class as a REST API controller
@RequestMapping("/api") // All endpoints in this controller will have the base URL '/api'
public class UploadDocController {

    @PostMapping("/upload") // Handles POST requests to '/api/upload'
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file) {
        // Get the name of the uploaded file
        String fileName = file.getOriginalFilename();
        System.out.println("Uploaded file: " + fileName);

        // Return a success message to the user
        return ResponseEntity.ok("Document uploaded successfully: " + fileName);
    }
}

    