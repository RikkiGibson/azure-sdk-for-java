/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.storage;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The SKU of the storage account.
 */
public class Sku {
    /**
     * Gets or sets the sku name. Required for account creation; optional for
     * update. Note that in older versions, sku name was called accountType.
     * Possible values include: 'Standard_LRS', 'Standard_GRS',
     * 'Standard_RAGRS', 'Standard_ZRS', 'Premium_LRS'.
     */
    @JsonProperty(value = "name", required = true)
    private SkuName name;

    /**
     * Gets the sku tier. This is based on the SKU name. Possible values
     * include: 'Standard', 'Premium'.
     */
    @JsonProperty(value = "tier", access = JsonProperty.Access.WRITE_ONLY)
    private SkuTier tier;

    /**
     * Get the name value.
     *
     * @return the name value
     */
    public SkuName name() {
        return this.name;
    }

    /**
     * Set the name value.
     *
     * @param name the name value to set
     * @return the Sku object itself.
     */
    public Sku withName(SkuName name) {
        this.name = name;
        return this;
    }

    /**
     * Get the tier value.
     *
     * @return the tier value
     */
    public SkuTier tier() {
        return this.tier;
    }

}
