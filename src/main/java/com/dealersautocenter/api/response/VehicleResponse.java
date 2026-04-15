package com.dealersautocenter.api.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleResponse {

    private UUID id;
    private String tenantId;
    private UUID dealerId;
    private String model;
    private String price;
    private String status;
    private boolean isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "VehicleResponse{" +
                "id=" + id +
                ", tenantId='" + tenantId + '\'' +
                ", dealerId=" + dealerId +
                ", model='" + model + '\'' +
                ", price='" + price + '\'' +
                ", status='" + status + '\'' +
                ", isDeleted=" + isDeleted +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
