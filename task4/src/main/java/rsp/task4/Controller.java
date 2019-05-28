package rsp.task4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping(value = "/singletest")
    public void singleTest() throws InterruptedException{
        Consumer consumer = new Consumer("1");
        Producer producer = new Producer("2");

        consumer.get();

        producer.put("F");
        consumer.get();

        consumer.get();
    }

    @GetMapping(value = "/multitest/{times}")
    public void multiTest(@PathVariable int times){
        for(int i = 0; i < times; i++){
            Consumer consumer = new Consumer("c" + i);
            Producer producer = new Producer("p" + i);
            consumer.start();
            producer.start();
        }
    }
}
