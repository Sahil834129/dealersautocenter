package com.dealersautocenter.dto;

import com.dealersautocenter.model.Vehicle;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class VehicleDTO {

    private String tenantId;
    private UUID dealerId;
    private String model;
    private String price;
    private String status;
    private boolean isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public VehicleDTO() {
    }

    public VehicleDTO(Vehicle vehicle) {
        this.tenantId = vehicle.getTenantId();
        this.dealerId = vehicle.getDealerId();
        this.model = vehicle.getModel();
        this.price = vehicle.getPrice().toString();
        this.status = vehicle.getStatus().name();
        this.isDeleted = vehicle.isDeleted();
        this.createdAt = vehicle.getCreatedAt();
        this.updatedAt = vehicle.getUpdatedAt();
    }

    @Override
    public String toString() {
        return "VehicleDTO{" +
                "tenantId='" + tenantId + '\'' +
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
