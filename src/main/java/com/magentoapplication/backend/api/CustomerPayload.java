package com.magentoapplication.backend.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerPayload {
    @JsonProperty("id")
    private int Id;

    @JsonProperty("entity_type_id")
    private int entityTypeId;

    @JsonProperty("attribute_id")
    private int attributeId;

    @JsonProperty("entity_id")
    private int entityId;

    @JsonProperty("value")
    private String value;

    @JsonProperty("customerGroupCode")
    private String groupCode;
    @JsonProperty("taxClassId")
    private int taxId;




    public CustomerPayload(int entityTypeId, int attributeId, int entityId, String value) {
        this.entityTypeId = entityTypeId;
        this.attributeId = attributeId;
        this.entityId = entityId;
        this.value = value;
    }
    public CustomerPayload(String groupCode,int taxId){
        this.groupCode=groupCode;
        this.taxId=taxId;
    }

    public CustomerPayload(int id, int entityTypeId, int attributeId, int entityId, String value) {
        this.Id = id;
        this.entityTypeId = entityTypeId;
        this.attributeId = attributeId;
        this.entityId = entityId;
        this.value = value;
    }
}
