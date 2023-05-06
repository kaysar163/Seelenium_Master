package com.magentoapplication.backend.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerPayload {

    @JsonProperty("entity_type_id")
    private int entityTypeId;

    @JsonProperty("attribute_id")
    private int attributeId;

    @JsonProperty("entity_id")
    private int entityId;

    @JsonProperty("value")
    private String value;

    public CustomerPayload(int entityTypeId, int attributeId, int entityId, String value) {
        this.entityTypeId = entityTypeId;
        this.attributeId = attributeId;
        this.entityId = entityId;
        this.value = value;
    }


}
