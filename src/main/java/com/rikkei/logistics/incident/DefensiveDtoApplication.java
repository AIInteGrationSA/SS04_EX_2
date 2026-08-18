package com.rikkei.logistics.incident;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DefensiveDtoApplication {

    private static final Logger log = LoggerFactory.getLogger(DefensiveDtoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DefensiveDtoApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(IncidentReportRepository repository) {
        return args -> {
            IncidentExtraction dto = new IncidentExtraction(
                    "ORD-SS04-0001",
                    "51C-12345",
                    "TRAFFIC_ACCIDENT",
                    Urgency.HIGH,
                    "Xe gap su co tren tuyen giao hang.",
                    LocalDateTime.now()
            );
            IncidentReport saved = repository.save(IncidentReport.fromValidatedExtraction(dto));
            log.info(
                    "SS04_EX2 JPA entity saved successfully id={}, orderCode={}, licensePlate={}, urgency={}",
                    saved.getId(),
                    saved.getOrderCode(),
                    saved.getLicensePlate(),
                    saved.getUrgency()
            );
        };
    }
}
