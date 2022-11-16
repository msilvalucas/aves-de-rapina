// package com.sicredipucrs.AvesDeRapina.config;

// import java.util.HashMap;

// import org.apache.kafka.clients.admin.NewTopic;
// import org.apache.kafka.clients.producer.ProducerConfig;
// import org.apache.kafka.common.serialization.StringSerializer;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.kafka.config.TopicBuilder;
// import org.springframework.kafka.core.DefaultKafkaProducerFactory;
// import org.springframework.kafka.core.KafkaAdmin;
// import org.springframework.kafka.core.KafkaTemplate;
// import org.springframework.kafka.core.ProducerFactory;
// import org.springframework.kafka.support.serializer.JsonSerializer;

// import lombok.var;

// @Configuration
// public class KafkaProducerConfig {
    
//     @Autowired
//     private KafkaProperties kafkaProperties;

//     @Bean
//     public ProducerFactory<String, Object> producerFactory() {
//         var configs = new HashMap<String, Object>();
//         configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
//         configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//         configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//         return new DefaultKafkaProducerFactory<>(configs);
//     }

//     @Bean
//     public KafkaTemplate<String, AnnotationDTO> kafkaTemplate() {
//         return new KafkaTemplate<>(producerFactory());
//     }

//     // @Bean
//     // //Permite criar tópicos a partir da aplicação produtora
//     // public KafkaAdmin kafkaAdmin() {
//     //     var configs = new HashMap<String, Object>();
//     //     configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
//     //     return new KafkaAdmin(configs);
//     // }

//     @Bean
//     public NewTopic createAnnotationTopic() {
//         return TopicBuilder.name("annotation").build();
//     }
// }
