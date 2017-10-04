/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.redis.implementation;

import com.microsoft.azure.management.resources.fluentcore.collection.InnerSupportsDelete;
import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.CloudException;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.Validator;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.HTTP;
import retrofit2.http.Path;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.Single;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in PatchSchedules.
 */
public class PatchSchedulesInner implements InnerSupportsDelete<Void> {
    /** The Retrofit service to perform REST calls. */
    private PatchSchedulesService service;
    /** The service client containing this operation class. */
    private RedisManagementClientImpl client;

    /**
     * Initializes an instance of PatchSchedulesInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public PatchSchedulesInner(Retrofit retrofit, RedisManagementClientImpl client) {
        this.service = retrofit.create(PatchSchedulesService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for PatchSchedules to be
     * used by Retrofit to perform actually REST calls.
     */
    interface PatchSchedulesService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.redis.PatchSchedules createOrUpdate" })
        @PUT("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Cache/Redis/{name}/patchSchedules/default")
        Observable<Response<ResponseBody>> createOrUpdate(@Path("resourceGroupName") String resourceGroupName, @Path("name") String name, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Body RedisPatchScheduleInner parameters, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.redis.PatchSchedules delete" })
        @HTTP(path = "subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Cache/Redis/{name}/patchSchedules/default", method = "DELETE", hasBody = true)
        Observable<Response<ResponseBody>> delete(@Path("resourceGroupName") String resourceGroupName, @Path("name") String name, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.redis.PatchSchedules get" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Cache/Redis/{name}/patchSchedules/default")
        Observable<Response<ResponseBody>> get(@Path("resourceGroupName") String resourceGroupName, @Path("name") String name, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Create or replace the patching schedule for Redis cache (requires Premium SKU).
     *
     * @param resourceGroupName The name of the resource group.
     * @param name The name of the Redis cache.
     * @param scheduleEntries List of patch schedules for a Redis cache.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the RedisPatchScheduleInner object if successful.
     */
    public RedisPatchScheduleInner createOrUpdate(String resourceGroupName, String name, List<ScheduleEntryInner> scheduleEntries) {
        return createOrUpdateWithServiceResponseAsync(resourceGroupName, name, scheduleEntries).toBlocking().single().body();
    }

    /**
     * Create or replace the patching schedule for Redis cache (requires Premium SKU).
     *
     * @param resourceGroupName The name of the resource group.
     * @param name The name of the Redis cache.
     * @param scheduleEntries List of patch schedules for a Redis cache.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<RedisPatchScheduleInner> createOrUpdateAsync(String resourceGroupName, String name, List<ScheduleEntryInner> scheduleEntries, final ServiceCallback<RedisPatchScheduleInner> serviceCallback) {
        return ServiceFuture.fromResponse(createOrUpdateWithServiceResponseAsync(resourceGroupName, name, scheduleEntries), serviceCallback);
    }

    /**
     * Create or replace the patching schedule for Redis cache (requires Premium SKU).
     *
     * @param resourceGroupName The name of the resource group.
     * @param name The name of the Redis cache.
     * @param scheduleEntries List of patch schedules for a Redis cache.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the RedisPatchScheduleInner object
     */
    public Observable<RedisPatchScheduleInner> createOrUpdateAsync(String resourceGroupName, String name, List<ScheduleEntryInner> scheduleEntries) {
        return createOrUpdateWithServiceResponseAsync(resourceGroupName, name, scheduleEntries).map(new Func1<ServiceResponse<RedisPatchScheduleInner>, RedisPatchScheduleInner>() {
            @Override
            public RedisPatchScheduleInner call(ServiceResponse<RedisPatchScheduleInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Create or replace the patching schedule for Redis cache (requires Premium SKU).
     *
     * @param resourceGroupName The name of the resource group.
     * @param name The name of the Redis cache.
     * @param scheduleEntries List of patch schedules for a Redis cache.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the RedisPatchScheduleInner object
     */
    public Observable<ServiceResponse<RedisPatchScheduleInner>> createOrUpdateWithServiceResponseAsync(String resourceGroupName, String name, List<ScheduleEntryInner> scheduleEntries) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (name == null) {
            throw new IllegalArgumentException("Parameter name is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        if (scheduleEntries == null) {
            throw new IllegalArgumentException("Parameter scheduleEntries is required and cannot be null.");
        }
        Validator.validate(scheduleEntries);
        RedisPatchScheduleInner parameters = new RedisPatchScheduleInner();
        parameters.withScheduleEntries(scheduleEntries);
        return service.createOrUpdate(resourceGroupName, name, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), parameters, this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<RedisPatchScheduleInner>>>() {
                @Override
                public Observable<ServiceResponse<RedisPatchScheduleInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<RedisPatchScheduleInner> clientResponse = createOrUpdateDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<RedisPatchScheduleInner> createOrUpdateDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<RedisPatchScheduleInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<RedisPatchScheduleInner>() { }.getType())
                .register(201, new TypeToken<RedisPatchScheduleInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Deletes the patching schedule of a redis cache (requires Premium SKU).
     *
     * @param resourceGroupName The name of the resource group.
     * @param name The name of the redis cache.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    public void delete(String resourceGroupName, String name) {
        deleteWithServiceResponseAsync(resourceGroupName, name).toBlocking().single().body();
    }

    /**
     * Deletes the patching schedule of a redis cache (requires Premium SKU).
     *
     * @param resourceGroupName The name of the resource group.
     * @param name The name of the redis cache.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<Void> deleteAsync(String resourceGroupName, String name, final ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromResponse(deleteWithServiceResponseAsync(resourceGroupName, name), serviceCallback);
    }

    /**
     * Deletes the patching schedule of a redis cache (requires Premium SKU).
     *
     * @param resourceGroupName The name of the resource group.
     * @param name The name of the redis cache.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Single<Void> deleteAsync(String resourceGroupName, String name) {
        return deleteWithServiceResponseAsync(resourceGroupName, name).map(new Func1<ServiceResponse<Void>, Void>() {
            @Override
            public Void call(ServiceResponse<Void> response) {
                return response.body();
            }
        });
    }

    /**
     * Deletes the patching schedule of a redis cache (requires Premium SKU).
     *
     * @param resourceGroupName The name of the resource group.
     * @param name The name of the redis cache.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<ServiceResponse<Void>> deleteWithServiceResponseAsync(String resourceGroupName, String name) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (name == null) {
            throw new IllegalArgumentException("Parameter name is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.delete(resourceGroupName, name, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Void>>>() {
                @Override
                public Observable<ServiceResponse<Void>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<Void> clientResponse = deleteDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<Void> deleteDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<Void, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<Void>() { }.getType())
                .register(204, new TypeToken<Void>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets the patching schedule of a redis cache (requires Premium SKU).
     *
     * @param resourceGroupName The name of the resource group.
     * @param name The name of the redis cache.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the RedisPatchScheduleInner object if successful.
     */
    public RedisPatchScheduleInner get(String resourceGroupName, String name) {
        return getWithServiceResponseAsync(resourceGroupName, name).toBlocking().single().body();
    }

    /**
     * Gets the patching schedule of a redis cache (requires Premium SKU).
     *
     * @param resourceGroupName The name of the resource group.
     * @param name The name of the redis cache.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<RedisPatchScheduleInner> getAsync(String resourceGroupName, String name, final ServiceCallback<RedisPatchScheduleInner> serviceCallback) {
        return ServiceFuture.fromResponse(getWithServiceResponseAsync(resourceGroupName, name), serviceCallback);
    }

    /**
     * Gets the patching schedule of a redis cache (requires Premium SKU).
     *
     * @param resourceGroupName The name of the resource group.
     * @param name The name of the redis cache.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the RedisPatchScheduleInner object
     */
    public Observable<RedisPatchScheduleInner> getAsync(String resourceGroupName, String name) {
        return getWithServiceResponseAsync(resourceGroupName, name).map(new Func1<ServiceResponse<RedisPatchScheduleInner>, RedisPatchScheduleInner>() {
            @Override
            public RedisPatchScheduleInner call(ServiceResponse<RedisPatchScheduleInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Gets the patching schedule of a redis cache (requires Premium SKU).
     *
     * @param resourceGroupName The name of the resource group.
     * @param name The name of the redis cache.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the RedisPatchScheduleInner object
     */
    public Observable<ServiceResponse<RedisPatchScheduleInner>> getWithServiceResponseAsync(String resourceGroupName, String name) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (name == null) {
            throw new IllegalArgumentException("Parameter name is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.get(resourceGroupName, name, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<RedisPatchScheduleInner>>>() {
                @Override
                public Observable<ServiceResponse<RedisPatchScheduleInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<RedisPatchScheduleInner> clientResponse = getDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<RedisPatchScheduleInner> getDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<RedisPatchScheduleInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<RedisPatchScheduleInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
