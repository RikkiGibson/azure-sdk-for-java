/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.resources.fluentcore.collection;

import com.microsoft.azure.management.apigeneration.LangDefinition;
import com.microsoft.azure.management.apigeneration.LangDefinition.MethodConversion;
import com.microsoft.azure.management.resources.fluentcore.model.*;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceCallback;
import rx.Observable;

import java.util.List;

/**
 * Providing access to creating a batch of Azure top level resources of same type.
 * <p>
 * (Note: this interface is not intended to be implemented by user code)
 * @param <ResourceT> the top level Azure resource type
 */
@LangDefinition(ContainerName = "CollectionActions", MethodConversionType = MethodConversion.OnlyMethod)
public interface SupportsBatchUpdate<ResourceT extends Indexable> {
    /**
     * Executes the update requests on a collection (batch) of resources.
     *
     * @param appliables the appliables in the batch
     * @return the batch operation result from which created resources in this batch can be accessed.
     */
    UpdatedResources<ResourceT> apply(Appliable<ResourceT>... appliables);

    /**
     * Executes the update requests on a collection (batch) of resources.
     *
     * @param appliables the list of appliables in the batch
     * @return the batch operation result from which created resources in this batch can be accessed.
     */
    UpdatedResources<ResourceT> apply(List<Appliable<ResourceT>> appliables);

    /**
     * Puts the requests to update a batch of resources into the queue and allow the HTTP client to execute it when
     * system resources are available.
     *
     * @param appliables the appliables in the batch
     * @return an observable for the resources
     */
    Observable<Indexable> applyAsync(Appliable<ResourceT>... appliables);

    /**
     * Puts the requests to update a batch of resources into the queue and allow the HTTP client to execute it when
     * system resources are available.
     *
     * @param appliables the list of appliables in the batch
     * @return an observable for the resources
     */
    Observable<Indexable> applyAsync(List<Appliable<ResourceT>> appliables);

    /**
     * Puts the requests to update a batch of resources into the queue and allow the HTTP client to execute it when
     * system resources are available.
     *
     * @param callback the callback to handle success and failure
     * @param appliables the appliables in the batch
     * @return a handle to cancel the request
     */
    ServiceFuture<UpdatedResources<ResourceT>> applyAsync(ServiceCallback<UpdatedResources<ResourceT>> callback, Appliable<ResourceT>... appliables);

    /**
     * Puts the requests to update a batch of resources into the queue and allow the HTTP client to execute it when
     * system resources are available.
     *
     * @param callback the callback to handle success and failure
     * @param appliables the list of appliables in the batch
     * @return a handle to cancel the request
     */
    ServiceFuture<UpdatedResources<ResourceT>> applyAsync(final ServiceCallback<UpdatedResources<ResourceT>> callback, List<Appliable<ResourceT>> appliables);
}