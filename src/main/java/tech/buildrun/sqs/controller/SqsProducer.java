package tech.buildrun.sqs.controller;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.buildrun.sqs.consumer.MyMessage;

@RestController
@RequestMapping("sqs/v1/messages")
public class SqsProducer {

    @Autowired
    private SqsTemplate sqsTemplate;


    @PostMapping("/send")
    public void sendMessage(@RequestBody MyMessage message){
        var SQS = "https://localhost.localstack.cloud:4566/000000000000/minha-fila";
        sqsTemplate.send(SQS, message);
    }
}
