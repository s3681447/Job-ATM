package rmit.job.atm.engine;

import rmit.job.atm.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "users";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Object> objectKafkaTemplate;


    public void sendMessage(String message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }

    private static final String EMPLOYEE_TOPIC ="employees";
    public void sendMessageEmployee(Employee employee){
        logger.info(String.format("#### -> Producing message -> employee name -> %s", employee.getFullName()));
        this.objectKafkaTemplate.send(EMPLOYEE_TOPIC, employee);
    }
}
