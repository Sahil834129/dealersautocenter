package com.dealersautocenter.services;

import com.dealersautocenter.dto.DealerDTO;
import com.dealersautocenter.model.Dealer;

import java.util.List;
import java.util.UUID;


public interface DealerService {
    DealerDTO createDealerDTO(Dealer dealer);
    Dealer findByDealerId(UUID dealerId);
    List<Dealer> getAllDealersByTenantId(String tenantId);
}

