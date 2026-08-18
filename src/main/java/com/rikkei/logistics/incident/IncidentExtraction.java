package com.rikkei.logistics.incident;

import java.time.LocalDateTime;

public record IncidentExtraction(
        String orderCode,
        String licensePlate,
        String incidentType,
        Urgency urgency,
        String description,
        LocalDateTime occurredAt
) {
}
