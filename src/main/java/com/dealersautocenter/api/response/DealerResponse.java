package com.dealersautocenter.api.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DealerResponse {

    private boolean success;
    private String message;
    private int statusCode;
    private UUID id;
    private String tenantId;
    private String name;
    private String email;
    private String subscriptionType;
    private boolean isActive;
    private boolean isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "DealerResponse{" +
                "id=" + id +
                ", tenantId='" + tenantId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", subscriptionType='" + subscriptionType + '\'' +
                ", isActive=" + isActive +
                ", isDeleted=" + isDeleted +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
