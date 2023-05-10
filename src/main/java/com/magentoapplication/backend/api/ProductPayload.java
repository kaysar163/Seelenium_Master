package com.magentoapplication.backend.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductPayload {
    @JsonProperty("entityTypeId")
    private int entityTypeId;

    @JsonProperty("attributeSetId")
    private int attributeSetId;

    @JsonProperty("typeId")
    private String typeId;

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("hasOptions")
    private int hasOptions;

    @JsonProperty("requiredOptions")
    private int requiredOptions;
    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("updatedAt")
    private String  updatedAt;

    public ProductPayload(int entityTypeId, int attributeSetId,
                          String typeId, String sku, int hasOptions, int requiredOptions) {
        this.entityTypeId = entityTypeId;
        this.attributeSetId = attributeSetId;
        this.typeId = typeId;
        this.sku = sku;
        this.hasOptions = hasOptions;
        this.requiredOptions = requiredOptions;
    }

    public ProductPayload(int entityTypeId, int attributeSetId, String typeId, String sku, int hasOptions, int requiredOptions, String createdAt, String updatedAt) {
        this.entityTypeId = entityTypeId;
        this.attributeSetId = attributeSetId;
        this.typeId = typeId;
        this.sku = sku;
        this.hasOptions = hasOptions;
        this.requiredOptions = requiredOptions;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
