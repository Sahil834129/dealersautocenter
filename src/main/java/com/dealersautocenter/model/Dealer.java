package com.dealersautocenter.model;


import com.dealersautocenter.dto.DealerDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "dealers")
@Data
@AllArgsConstructor
@Builder
public class Dealer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "tenant_id", nullable = false)
    private String tenantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubscriptionType subscriptionType;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Dealer(){
    }

    public Dealer(DealerDTO dealerDTO){

        this.tenantId = dealerDTO.getTenantId();
        this.name = dealerDTO.getName();
        this.email = dealerDTO.getEmail();
        this.subscriptionType = SubscriptionType.valueOf(dealerDTO.getSubscriptionType());
        this.isActive = dealerDTO.isActive();
        this.isDeleted = dealerDTO.isDeleted();
        this.createdAt = dealerDTO.getCreatedAt();
        this.updatedAt = dealerDTO.getUpdatedAt();
    }

     @Override
    public String toString() {
        return "Dealer{" +
                "id=" + id +
                ", tenantId='" + tenantId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", subscriptionType=" + subscriptionType +
                ", isActive=" + isActive +
                ", isDeleted=" + isDeleted +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
