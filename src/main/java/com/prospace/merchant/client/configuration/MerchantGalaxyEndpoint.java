package com.prospace.merchant.client.configuration;

import com.prospace.merchant.client.model.request.CurrencyConverterRequest;
import com.prospace.merchant.client.model.response.ResponseEntity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MerchantGalaxyEndpoint {

    @POST("/api/v1/currency/convert")
    Call<ResponseEntity> convertGalaxyCurrency(@Body CurrencyConverterRequest request);
}
