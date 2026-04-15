package com.dealersautocenter.repositories;

import com.dealersautocenter.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
    Vehicle findByIdAndTenantId(UUID id, UUID dealerId, String tenantId);
    List<Vehicle> findAllByDealerIdAndTenantId(UUID dealerId, String tenantId);
}
