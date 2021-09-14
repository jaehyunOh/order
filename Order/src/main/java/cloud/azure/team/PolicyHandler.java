package cloud.azure.team;

import cloud.azure.team.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryStarted_ChangeOrderStatus(@Payload DeliveryStarted deliveryStarted){

        if(!deliveryStarted.validate()) return;

        System.out.println("\n\n##### listener ChangeOrderStatus : " + deliveryStarted.toJson() + "\n\n");



        // Sample Logic //
        // Order order = new Order();
        // orderRepository.save(order);

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryCanceled_ChangeOrderStatus(@Payload DeliveryCanceled deliveryCanceled){

        if(!deliveryCanceled.validate()) return;

        System.out.println("\n\n##### listener ChangeOrderStatus : " + deliveryCanceled.toJson() + "\n\n");



        // Sample Logic //
        // Order order = new Order();
        // orderRepository.save(order);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}