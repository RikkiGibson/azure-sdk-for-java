/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cdn;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for EndpointResourceState.
 */
public final class EndpointResourceState {
    /** Static value Creating for EndpointResourceState. */
    public static final EndpointResourceState CREATING = new EndpointResourceState("Creating");

    /** Static value Deleting for EndpointResourceState. */
    public static final EndpointResourceState DELETING = new EndpointResourceState("Deleting");

    /** Static value Running for EndpointResourceState. */
    public static final EndpointResourceState RUNNING = new EndpointResourceState("Running");

    /** Static value Starting for EndpointResourceState. */
    public static final EndpointResourceState STARTING = new EndpointResourceState("Starting");

    /** Static value Stopped for EndpointResourceState. */
    public static final EndpointResourceState STOPPED = new EndpointResourceState("Stopped");

    /** Static value Stopping for EndpointResourceState. */
    public static final EndpointResourceState STOPPING = new EndpointResourceState("Stopping");

    private String value;

    /**
     * Creates a custom value for EndpointResourceState.
     * @param value the custom value
     */
    public EndpointResourceState(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EndpointResourceState)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        EndpointResourceState rhs = (EndpointResourceState) obj;
        if (value == null) {
            return rhs.value == null;
        } else {
            return value.equals(rhs.value);
        }
    }
}
