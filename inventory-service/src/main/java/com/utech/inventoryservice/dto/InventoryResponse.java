package com.utech.inventoryservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {
    private String skuCode;
    private boolean isInStock;

    /*
    public InventoryResponse(Builder builder) {
        this.skuCode = builder.skuCode;
        this.isInStock = builder.isInStock;
    }

    @Data
    public static class Builder {
        private String skuCode;
        private boolean isInStock;

        public static Builder newInstance() {
            return new Builder();
        }

        private Builder() {

        }


        public InventoryResponse build()
        {
            return new InventoryResponse(this);
        }
    }*/
}
