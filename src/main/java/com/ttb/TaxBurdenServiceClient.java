package com.ttb;

import org.springframework.cloud.openfeign.FeignClient;

import com.ttb.service.taxburden.TaxBurdenServiceREST;

@FeignClient(name = "tax-burden-service")
public interface TaxBurdenServiceClient extends TaxBurdenServiceREST {

}
