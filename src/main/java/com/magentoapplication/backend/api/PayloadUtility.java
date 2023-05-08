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

    public static String categoryPayload(){
        long timeStamp=System.currentTimeMillis();
        String payload=null;
        CategoryPayload categoryPayload=new CategoryPayload(3,41,0,1,"Xsrkr"+timeStamp);
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            payload=objectMapper.writeValueAsString(categoryPayload());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return payload;

    }
    public  static String categoryPayloadPut(){
        long timeStamp=System.currentTimeMillis();
        String payload=null;
        CategoryPayload categoryPayload1=new CategoryPayload(3,41,0,1,"IWqSUUU"+timeStamp);
        ObjectMapper objectMapper=new ObjectMapper();

        try {
            payload=objectMapper.writeValueAsString(categoryPayload1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return payload;


    }
    public  static String getoneproduct(){
        long timeStamp=System.currentTimeMillis();
        String payload=null;
        ProductPayload productPayload1=new ProductPayload(4,13,"simple"+timeStamp,"msj004"+timeStamp,0,
                0,"2023-03-04","2022-08-03");
        ObjectMapper objectMapper=new ObjectMapper();

        try {
            payload=objectMapper.writeValueAsString(productPayload1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return payload;
    }

















    public static String oneCategoryPayload(){
        String payload=null;
        CategoryPayload oneCategoryPayload1=new CategoryPayload(3,41,0,1,"dhKMb");
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            payload=objectMapper.writeValueAsString(oneCategoryPayload1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return payload;
    }


}
