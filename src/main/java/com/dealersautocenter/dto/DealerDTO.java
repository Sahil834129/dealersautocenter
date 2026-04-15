package com.dealersautocenter.dto;

import com.dealersautocenter.model.Dealer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class DealerDTO {

    private UUID id;
    private String tenantId;
    private String name;
    private String email;
    private String subscriptionType;
    private boolean isActive;
    private boolean isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public DealerDTO() {
    }

    public DealerDTO(Dealer dealer){

        this.id = dealer.getId();
        this.tenantId = dealer.getTenantId();
        this.name = dealer.getName();
        this.email = dealer.getEmail();
        this.subscriptionType = dealer.getSubscriptionType().name();
        this.isActive = dealer.isActive();
        this.isDeleted = dealer.isDeleted();
        this.createdAt = dealer.getCreatedAt();
        this.updatedAt = dealer.getUpdatedAt();
    }

    @Override
    public String toString() {
        return "DealerDTO{" +
                "id=" + id +
                "tenantId='" + tenantId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", subscriptionType='" + subscriptionType + '\'' +
                ", isActive=" + isActive +
                ", isDeleted=" + isDeleted +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
