package com.dealersautocenter.model;

import com.dealersautocenter.dto.VehicleDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "vehicles")
@Data
@AllArgsConstructor
@Builder
public class Vehicle implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "tenant_id", nullable = false)
    private String tenantId;

    @Column(name = "dealer_id", nullable = false)
    private UUID dealerId;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "is_active", nullable = false)
    private boolean isDeleted = false;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Vehicle() {
    }

    public Vehicle(VehicleDTO vehicleDTO) {
        this.tenantId = vehicleDTO.getTenantId();
        this.dealerId = vehicleDTO.getDealerId();
        this.model = vehicleDTO.getModel();
        this.price = new BigDecimal(vehicleDTO.getPrice());
        this.status = Status.valueOf(vehicleDTO.getStatus());
        this.isDeleted = vehicleDTO.isDeleted();
        this.createdAt = vehicleDTO.getCreatedAt();
        this.updatedAt = vehicleDTO.getUpdatedAt();
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", tenantId='" + tenantId + '\'' +
                ", dealerId=" + dealerId +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", isDeleted=" + isDeleted +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
