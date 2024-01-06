package tech.buildrun.sqs.pubsub;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @SqsListener("buildrun-demo-pub-sub")
    public void listen(MyMessage body) {
        System.out.println("Message received: " + body.content());
    }
}
