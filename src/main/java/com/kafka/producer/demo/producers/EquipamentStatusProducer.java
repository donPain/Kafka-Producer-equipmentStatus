package com.kafka.producer.demo.producers;

import com.kafka.producer.demo.DemoApplication;
import com.kafka.producer.demo.model.EquipamentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class EquipamentStatusProducer {

        @Autowired
        private KafkaTemplate<String, EquipamentStatus> kafkaTemplate;

        @EventListener(ApplicationReadyEvent.class)
        public void sendStatus(){
        String topic = "EQUIPMENT_STATUS_2";
        String clientId = "";
        for(var i=0;i<14000;i++){
                if (i<=100){
                        clientId = "VictorVargas";
                } else {
                        clientId = "donzelitos";
                }
                String equipamentId = UUID.randomUUID().toString();
                String Key = clientId + "_" + equipamentId;
                kafkaTemplate.send(topic, Key, new EquipamentStatus(clientId,equipamentId,"online", LocalDate.now().toString()));
                 }
        }
}
