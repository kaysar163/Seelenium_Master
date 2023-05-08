package com.magentoapplication.backend.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryPayload {
    @JsonProperty("entity_type_id")
    private int entityTypeId;

    @JsonProperty("attribute_id")
    private int attributeId;

    @JsonProperty("store_id")
    private int entityId;

    @JsonProperty("value_id")
    private int valueId;

    @JsonProperty("value")
    private String value;

    public CategoryPayload(int entityTypeId, int attributeId, int entityId, int valueId, String value) {
        this.entityTypeId = entityTypeId;
        this.attributeId = attributeId;
        this.entityId = entityId;
        this.valueId = valueId;
        this.value = value;
    }
}



