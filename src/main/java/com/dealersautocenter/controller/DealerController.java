package com.dealersautocenter.controller;


import com.dealersautocenter.api.ApiResponse;
import com.dealersautocenter.api.response.DealerResponse;
import com.dealersautocenter.dto.DealerDTO;
import com.dealersautocenter.model.Dealer;
import com.dealersautocenter.services.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/dealers")
public class DealerController {

    @Autowired
    private DealerService dealerService;


    @PostMapping("/create")
    public DealerResponse createDealer(@RequestBody Dealer dealer) {
        DealerResponse dealerResponse = new DealerResponse();

        Dealer existingDealer = dealerService.findByDealerId(dealer.getId());

        if (existingDealer != null && existingDealer.getId() != null) {
            dealerResponse.setSuccess(false);
            dealerResponse.setMessage("Dealer already exists for tenant");
            dealerResponse.setStatusCode(0);
            return dealerResponse;
        }

        if (dealer.getId() != null) {
            dealerResponse.setSuccess(false);
            dealerResponse.setMessage("Something went wrong, when creating dealer, please try again");
            dealerResponse.setStatusCode(0);
            return dealerResponse;
        }

        if (dealer.getTenantId() == null || dealer.getTenantId().isEmpty()) {
            dealerResponse.setSuccess(false);
            dealerResponse.setMessage("Tenant ID is required");
            dealerResponse.setStatusCode(0);
            return dealerResponse;
        }

        if (dealer.getName() == null || dealer.getName().isEmpty()) {
            dealerResponse.setSuccess(false);
            dealerResponse.setMessage("Dealer name is required");
            dealerResponse.setStatusCode(0);
            return dealerResponse;
        }

        if (dealer.getEmail() == null || dealer.getEmail().isEmpty()){
            dealerResponse.setSuccess(false);
            dealerResponse.setMessage("Dealer email is required");
            dealerResponse.setStatusCode(0);
            return dealerResponse;
        }

        if (dealer.getSubscriptionType() == null ) {
            dealerResponse.setSuccess(false);
            dealerResponse.setMessage("Subscription type is required");
            dealerResponse.setStatusCode(0);
            return dealerResponse;
        }

        try {
            DealerDTO dealerDTO = dealerService.createDealerDTO(dealer);

            if (dealerDTO == null) {
                dealerResponse.setSuccess(false);
                dealerResponse.setMessage("Failed to create dealer");
                dealerResponse.setStatusCode(0);
                return dealerResponse;
            }else {
                dealerResponse.setSuccess(true);
                dealerResponse.setMessage("Dealer created successfully");
                dealerResponse.setStatusCode(1);
                dealerResponse.setId(dealerDTO.getId());
                dealerResponse.setTenantId(dealerDTO.getTenantId());
                dealerResponse.setName(dealerDTO.getName());
                dealerResponse.setEmail(dealerDTO.getEmail());
                dealerResponse.setSubscriptionType(dealerDTO.getSubscriptionType());
                dealerResponse.setActive(dealerDTO.isActive());
                dealerResponse.setDeleted(dealerDTO.isDeleted());
                dealerResponse.setCreatedAt(dealerDTO.getCreatedAt());
                dealerResponse.setUpdatedAt(dealerDTO.getUpdatedAt());
                return dealerResponse;
            }
        } catch (Exception e) {
            dealerResponse.setSuccess(false);
            dealerResponse.setMessage("An error occurred while creating the dealer: " + e.getMessage());
            dealerResponse.setStatusCode(0);
             return dealerResponse;
        }
    }


    @GetMapping("/{dealerId}")
    public DealerResponse getDealerByDealerId(@RequestParam("dealerId") UUID dealerId) {
        DealerResponse dealerResponse = new DealerResponse();

        if (dealerId == null || dealerId.toString().isEmpty()) {
            dealerResponse.setSuccess(false);
            dealerResponse.setMessage("Dealer is required");
            dealerResponse.setStatusCode(0);
            return dealerResponse;
        }

        try {
            Dealer dealer = dealerService.findByDealerId(dealerId);

            if (dealer == null) {
                dealerResponse.setSuccess(false);
                dealerResponse.setMessage("Dealer not found for the provided data");
                dealerResponse.setStatusCode(0);
            } else {
                dealerResponse.setSuccess(true);
                dealerResponse.setMessage("Dealer retrieved successfully");
                dealerResponse.setStatusCode(1);
                dealerResponse.setId(dealer.getId());
                dealerResponse.setTenantId(dealer.getTenantId());
                dealerResponse.setName(dealer.getName());
                dealerResponse.setEmail(dealer.getEmail());
                dealerResponse.setSubscriptionType(String.valueOf(dealer.getSubscriptionType()));
                dealerResponse.setActive(dealer.isActive());
                dealerResponse.setDeleted(dealer.isDeleted());
                dealerResponse.setCreatedAt(dealer.getCreatedAt());
                dealerResponse.setUpdatedAt(dealer.getUpdatedAt());
            }
            return dealerResponse;
        } catch (Exception e) {
            dealerResponse.setSuccess(false);
            dealerResponse.setMessage("An error occurred while retrieving the dealer: " + e.getMessage());
            dealerResponse.setStatusCode(0);
             return dealerResponse;
        }
    }


    @GetMapping("/get-all-dealers")
    public ApiResponse<Dealer> getAllDealersByTenantId(@RequestParam("tenantId") String tenantId) {
        ApiResponse<Dealer> response = new ApiResponse<>();

            if (tenantId == null || tenantId.isEmpty()) {
                response.setSuccess(false);
                response.setMessage("Tenant ID is required");
                response.setStatusCode(0);
                return response;
            }
        try {

            List<Dealer> dealers = dealerService.getAllDealersByTenantId(tenantId);

             if (dealers == null || dealers.isEmpty()) {
                response.setSuccess(false);
                response.setMessage("No dealers found for the provided tenant ID");
                response.setStatusCode(0);
            } else {
                 response.setData(dealers);
                 response.setSuccess(true);
                 response.setMessage("Dealers retrieved successfully");
                 response.setStatusCode(1);
             }
             return response;
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("An error occurred while retrieving dealers: " + e.getMessage());
            response.setStatusCode(0);
             return response;
        }
    }

}
