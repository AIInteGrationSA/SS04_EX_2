package com.rikkei.logistics.incident;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "incident_reports")
public class IncidentReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String orderCode;

    @Column(nullable = false, length = 20)
    private String licensePlate;

    @Column(nullable = false, length = 80)
    private String incidentType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Urgency urgency;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private LocalDateTime occurredAt;

    protected IncidentReport() {
        // Required by Hibernate.
    }

    private IncidentReport(
            String orderCode,
            String licensePlate,
            String incidentType,
            Urgency urgency,
            String description,
            LocalDateTime occurredAt
    ) {
        this.orderCode = orderCode;
        this.licensePlate = licensePlate;
        this.incidentType = incidentType;
        this.urgency = urgency;
        this.description = description;
        this.occurredAt = occurredAt;
    }

    public static IncidentReport fromValidatedExtraction(IncidentExtraction extraction) {
        return new IncidentReport(
                extraction.orderCode(),
                extraction.licensePlate(),
                extraction.incidentType(),
                extraction.urgency(),
                extraction.description(),
                extraction.occurredAt()
        );
    }

    public Long getId() {
        return id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Urgency getUrgency() {
        return urgency;
    }
}
