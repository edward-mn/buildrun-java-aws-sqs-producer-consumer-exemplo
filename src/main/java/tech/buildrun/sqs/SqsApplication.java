package tech.buildrun.sqs;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.buildrun.sqs.pubsub.MyMessage;

import java.time.LocalDateTime;

@SpringBootApplication
public class SqsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SqsApplication.class, args);
	}

	@Autowired
	private SqsTemplate sqsTemplate;

	@Override
	public void run(String... args) throws Exception {
		var SQS = "http://localhost:4566/000000000000/buildrun-demo-pub-sub";
		sqsTemplate.send(SQS, new MyMessage("teste as " + LocalDateTime.now()));
	}
}
