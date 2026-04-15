package com.dealersautocenter.repositories;

import com.dealersautocenter.model.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DealerRepository extends JpaRepository<Dealer, UUID> {
        List<Dealer> findAllByTenantId(String tenantId);
}
