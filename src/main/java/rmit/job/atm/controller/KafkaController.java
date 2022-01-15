package rmit.job.atm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rmit.job.atm.engine.Producer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);
    private static final String TOPIC = "users";

    @Autowired
    private Producer producer;

    @PostMapping(value = "/publish")
    public String sendMessageToKafkaTopic(@RequestParam("message") String message) {
        logger.info(String.format("#### -> Producing message -> %s", message));

        this.producer.sendMessage(message);

        return "Success";
    }

    @GetMapping(value = "/hello")
    public void hello() {
        System.out.println("Hello");
    }

}
