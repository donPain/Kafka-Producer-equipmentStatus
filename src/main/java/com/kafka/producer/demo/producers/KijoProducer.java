package com.kafka.producer.demo.producers;

import com.kafka.producer.demo.model.EquipamentStatus;
import com.kafka.producer.demo.model.Kijo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class KijoProducer {

    @Autowired
    private KafkaTemplate<String, Kijo> kijoProducerTemplate;

    @EventListener(ApplicationReadyEvent.class)
    public void sendStatus(){

        for(var i=0;i<1000000;i++){
            String[] owners = {" ", "GROWMARK", "RAIZEN","CASA_DO_PAO_DE_ALHO"};
            String clientId = getRandomElement(owners);
            String topic = "KIJO_SRC_" + clientId;
            String equipamentId = UUID.randomUUID().toString();
            String Key = clientId + "_" + equipamentId;
            kijoProducerTemplate.send(topic, Key, new Kijo(clientId,equipamentId,"KIJO2300|AXT,AXAGGGGA@@##!@#@!#!@#@!,125421"));
            System.out.println("Topic:"+ topic +"| Key:"+Key);
        }
    }

    public static <T> T getRandomElement(T[] arr){
        return arr[ThreadLocalRandom.current().nextInt(arr.length)];
    }

}
