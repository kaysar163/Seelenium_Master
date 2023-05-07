package com.magentoapplication.backend.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PayloadUtility {

    public static String createCustomerPayload(){
        long timeStamp=System.currentTimeMillis();
        String payload=null;
        CustomerPayload customerPayload=new CustomerPayload(1,2,3,"English"+timeStamp);
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            payload=objectMapper.writeValueAsString(customerPayload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return payload;
    }
    public static String createProductPayload(){
        long timeStamp=System.currentTimeMillis();
        String payload=null;
        ProductPayload productPayload=new ProductPayload(3,13,"simpssxkscmle"+timeStamp,"run"+timeStamp,0,
                0,"2024-03-04","2025-08-16");
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            payload=objectMapper.writeValueAsString(productPayload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return payload;
    }

}
