package com.magentoapplication.backend.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

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
    public static String putCustomerGroupPayload(){
        Faker faker=new Faker();
        String name= faker.name().firstName();
        int randNumber=faker.number().numberBetween(0,10);
        String cusGroupPayload=null;
        CustomerPayload customerGroupPayload=new CustomerPayload(name,randNumber);
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            cusGroupPayload=objectMapper.writeValueAsString(customerGroupPayload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return cusGroupPayload;
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
    public static String putCustomerPaylad(){
        Faker faker=new Faker();
        String name= faker.name().firstName();
        int randNumber=faker.number().numberBetween(0,10);
        String customerPutPayload=null;
        CustomerPayload customerPaylad=new CustomerPayload(1,randNumber,1,1,name);
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            customerPutPayload=objectMapper.writeValueAsString(customerPaylad);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return customerPutPayload;


    }


}
