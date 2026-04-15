package com.dealersautocenter.services.impl;

import com.dealersautocenter.dto.DealerDTO;
import com.dealersautocenter.model.Dealer;
import com.dealersautocenter.repositories.DealerRepository;
import com.dealersautocenter.services.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DealerServiceImpl implements DealerService {

    @Autowired
    private DealerRepository dealerRepository;

    @Override
    public DealerDTO createDealerDTO(Dealer dealer) {

        Dealer newDealer = new Dealer();
        newDealer.setTenantId(dealer.getTenantId());
        newDealer.setName(dealer.getName());
        newDealer.setEmail(dealer.getEmail());
        newDealer.setSubscriptionType(dealer.getSubscriptionType());
        newDealer.setActive(true);
        newDealer.setDeleted(false);
        newDealer.setCreatedAt(LocalDateTime.now());
        newDealer.setUpdatedAt(LocalDateTime.now());
        Dealer saveDealer = dealerRepository.save(newDealer);
        return new DealerDTO(saveDealer);
    }

    @Override
    public Dealer findByDealerId(UUID dealerId) {
        return dealerRepository.findById(dealerId).orElse(null);
    }

    @Override
    public List<Dealer> getAllDealersByTenantId(String tenantId) {
        return dealerRepository.findAllByTenantId(tenantId);
    }
}

