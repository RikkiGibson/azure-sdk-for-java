/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.gallery.implementation;

import com.microsoft.azure.management.resources.fluentcore.collection.InnerSupportsGet;
import com.microsoft.azure.management.resources.fluentcore.collection.InnerSupportsDelete;
import com.microsoft.azure.management.resources.implementation.DeploymentExtendedInner;
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
 * in AlertRules.
 */
public class AlertRulesInner implements InnerSupportsGet<AlertRuleResourceInner>, InnerSupportsDelete<Void> {
    /** The Retrofit service to perform REST calls. */
    private AlertRulesService service;
    /** The service client containing this operation class. */
    private InsightsManagementClientImpl client;

    /**
     * Initializes an instance of AlertRulesInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public AlertRulesInner(Retrofit retrofit, InsightsManagementClientImpl client) {
        this.service = retrofit.create(AlertRulesService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for AlertRules to be
     * used by Retrofit to perform actually REST calls.
     */
    interface AlertRulesService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.gallery.AlertRules createOrUpdate" })
        @PUT("subscriptions/{subscriptionId}/resourcegroups/{resourceGroupName}/providers/microsoft.insights/alertrules/{ruleName}")
        Observable<Response<ResponseBody>> createOrUpdate(@Path("resourceGroupName") String resourceGroupName, @Path("ruleName") String ruleName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Body AlertRuleResourceInner parameters, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.gallery.AlertRules delete" })
        @HTTP(path = "subscriptions/{subscriptionId}/resourcegroups/{resourceGroupName}/providers/microsoft.insights/alertrules/{ruleName}", method = "DELETE", hasBody = true)
        Observable<Response<ResponseBody>> delete(@Path("resourceGroupName") String resourceGroupName, @Path("ruleName") String ruleName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.gallery.AlertRules getByResourceGroup" })
        @GET("subscriptions/{subscriptionId}/resourcegroups/{resourceGroupName}/providers/microsoft.insights/alertrules/{ruleName}")
        Observable<Response<ResponseBody>> getByResourceGroup(@Path("resourceGroupName") String resourceGroupName, @Path("ruleName") String ruleName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.gallery.AlertRules listByResourceGroup" })
        @GET("subscriptions/{subscriptionId}/resourcegroups/{resourceGroupName}/providers/microsoft.insights/alertrules")
        Observable<Response<ResponseBody>> listByResourceGroup(@Path("resourceGroupName") String resourceGroupName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Query("$filter") String filter, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Creates or updates an alert rule.
     Request method: PUT        Request URI: https://management.azure.com/subscriptions/{subscription-id}/resourceGroups/{resource-group-name}/providers/microsoft.insights/alertRules/{alert-rule-name}?api-version={api-version}.
     *
     * @param resourceGroupName The name of the resource group.
     * @param ruleName The name of the rule.
     * @param parameters The parameters of the rule to create or update.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the AlertRuleResourceInner object if successful.
     */
    public AlertRuleResourceInner createOrUpdate(String resourceGroupName, String ruleName, AlertRuleResourceInner parameters) {
        return createOrUpdateWithServiceResponseAsync(resourceGroupName, ruleName, parameters).toBlocking().single().body();
    }

    /**
     * Creates or updates an alert rule.
     Request method: PUT        Request URI: https://management.azure.com/subscriptions/{subscription-id}/resourceGroups/{resource-group-name}/providers/microsoft.insights/alertRules/{alert-rule-name}?api-version={api-version}.
     *
     * @param resourceGroupName The name of the resource group.
     * @param ruleName The name of the rule.
     * @param parameters The parameters of the rule to create or update.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<AlertRuleResourceInner> createOrUpdateAsync(String resourceGroupName, String ruleName, AlertRuleResourceInner parameters, final ServiceCallback<AlertRuleResourceInner> serviceCallback) {
        return ServiceFuture.fromResponse(createOrUpdateWithServiceResponseAsync(resourceGroupName, ruleName, parameters), serviceCallback);
    }

    /**
     * Creates or updates an alert rule.
     Request method: PUT        Request URI: https://management.azure.com/subscriptions/{subscription-id}/resourceGroups/{resource-group-name}/providers/microsoft.insights/alertRules/{alert-rule-name}?api-version={api-version}.
     *
     * @param resourceGroupName The name of the resource group.
     * @param ruleName The name of the rule.
     * @param parameters The parameters of the rule to create or update.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the AlertRuleResourceInner object
     */
    public Observable<AlertRuleResourceInner> createOrUpdateAsync(String resourceGroupName, String ruleName, AlertRuleResourceInner parameters) {
        return createOrUpdateWithServiceResponseAsync(resourceGroupName, ruleName, parameters).map(new Func1<ServiceResponse<AlertRuleResourceInner>, AlertRuleResourceInner>() {
            @Override
            public AlertRuleResourceInner call(ServiceResponse<AlertRuleResourceInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Creates or updates an alert rule.
     Request method: PUT        Request URI: https://management.azure.com/subscriptions/{subscription-id}/resourceGroups/{resource-group-name}/providers/microsoft.insights/alertRules/{alert-rule-name}?api-version={api-version}.
     *
     * @param resourceGroupName The name of the resource group.
     * @param ruleName The name of the rule.
     * @param parameters The parameters of the rule to create or update.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the AlertRuleResourceInner object
     */
    public Observable<ServiceResponse<AlertRuleResourceInner>> createOrUpdateWithServiceResponseAsync(String resourceGroupName, String ruleName, AlertRuleResourceInner parameters) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (ruleName == null) {
            throw new IllegalArgumentException("Parameter ruleName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (parameters == null) {
            throw new IllegalArgumentException("Parameter parameters is required and cannot be null.");
        }
        Validator.validate(parameters);
        final String apiVersion = "2016-03-01";
        return service.createOrUpdate(resourceGroupName, ruleName, this.client.subscriptionId(), apiVersion, parameters, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<AlertRuleResourceInner>>>() {
                @Override
                public Observable<ServiceResponse<AlertRuleResourceInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<AlertRuleResourceInner> clientResponse = createOrUpdateDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<AlertRuleResourceInner> createOrUpdateDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<AlertRuleResourceInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<AlertRuleResourceInner>() { }.getType())
                .register(201, new TypeToken<AlertRuleResourceInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Deletes an alert rule.
     *
     * @param resourceGroupName The name of the resource group.
     * @param ruleName The name of the rule.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    public void delete(String resourceGroupName, String ruleName) {
        deleteWithServiceResponseAsync(resourceGroupName, ruleName).toBlocking().single().body();
    }

    /**
     * Deletes an alert rule.
     *
     * @param resourceGroupName The name of the resource group.
     * @param ruleName The name of the rule.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<Void> deleteAsync(String resourceGroupName, String ruleName, final ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromResponse(deleteWithServiceResponseAsync(resourceGroupName, ruleName), serviceCallback);
    }

    /**
     * Deletes an alert rule.
     *
     * @param resourceGroupName The name of the resource group.
     * @param ruleName The name of the rule.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Single<Void> deleteAsync(String resourceGroupName, String ruleName) {
        return deleteWithServiceResponseAsync(resourceGroupName, ruleName).map(new Func1<ServiceResponse<Void>, Void>() {
            @Override
            public Void call(ServiceResponse<Void> response) {
                return response.body();
            }
        });
    }

    /**
     * Deletes an alert rule.
     *
     * @param resourceGroupName The name of the resource group.
     * @param ruleName The name of the rule.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<ServiceResponse<Void>> deleteWithServiceResponseAsync(String resourceGroupName, String ruleName) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (ruleName == null) {
            throw new IllegalArgumentException("Parameter ruleName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        final String apiVersion = "2016-03-01";
        return service.delete(resourceGroupName, ruleName, this.client.subscriptionId(), apiVersion, this.client.acceptLanguage(), this.client.userAgent())
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
                .register(204, new TypeToken<Void>() { }.getType())
                .register(200, new TypeToken<Void>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets an alert rule.
     *
     * @param resourceGroupName The name of the resource group.
     * @param ruleName The name of the rule.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the AlertRuleResourceInner object if successful.
     */
    public AlertRuleResourceInner getByResourceGroup(String resourceGroupName, String ruleName) {
        return getByResourceGroupWithServiceResponseAsync(resourceGroupName, ruleName).toBlocking().single().body();
    }

    /**
     * Gets an alert rule.
     *
     * @param resourceGroupName The name of the resource group.
     * @param ruleName The name of the rule.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<AlertRuleResourceInner> getByResourceGroupAsync(String resourceGroupName, String ruleName, final ServiceCallback<AlertRuleResourceInner> serviceCallback) {
        return ServiceFuture.fromResponse(getByResourceGroupWithServiceResponseAsync(resourceGroupName, ruleName), serviceCallback);
    }

    /**
     * Gets an alert rule.
     *
     * @param resourceGroupName The name of the resource group.
     * @param ruleName The name of the rule.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the AlertRuleResourceInner object
     */
    public Single<DeploymentExtendedInner> getByResourceGroupAsync(String resourceGroupName, String ruleName) {
        return getByResourceGroupWithServiceResponseAsync(resourceGroupName, ruleName).map(new Func1<ServiceResponse<AlertRuleResourceInner>, AlertRuleResourceInner>() {
            @Override
            public AlertRuleResourceInner call(ServiceResponse<AlertRuleResourceInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Gets an alert rule.
     *
     * @param resourceGroupName The name of the resource group.
     * @param ruleName The name of the rule.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the AlertRuleResourceInner object
     */
    public Observable<ServiceResponse<AlertRuleResourceInner>> getByResourceGroupWithServiceResponseAsync(String resourceGroupName, String ruleName) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (ruleName == null) {
            throw new IllegalArgumentException("Parameter ruleName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        final String apiVersion = "2016-03-01";
        return service.getByResourceGroup(resourceGroupName, ruleName, this.client.subscriptionId(), apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<AlertRuleResourceInner>>>() {
                @Override
                public Observable<ServiceResponse<AlertRuleResourceInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<AlertRuleResourceInner> clientResponse = getByResourceGroupDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<AlertRuleResourceInner> getByResourceGroupDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<AlertRuleResourceInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<AlertRuleResourceInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * List the alert rules within a resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the List&lt;AlertRuleResourceInner&gt; object if successful.
     */
    public List<AlertRuleResourceInner> listByResourceGroup(String resourceGroupName) {
        return listByResourceGroupWithServiceResponseAsync(resourceGroupName).toBlocking().single().body();
    }

    /**
     * List the alert rules within a resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<AlertRuleResourceInner>> listByResourceGroupAsync(String resourceGroupName, final ServiceCallback<List<AlertRuleResourceInner>> serviceCallback) {
        return ServiceFuture.fromResponse(listByResourceGroupWithServiceResponseAsync(resourceGroupName), serviceCallback);
    }

    /**
     * List the alert rules within a resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;AlertRuleResourceInner&gt; object
     */
    public Observable<List<AlertRuleResourceInner>> listByResourceGroupAsync(String resourceGroupName) {
        return listByResourceGroupWithServiceResponseAsync(resourceGroupName).map(new Func1<ServiceResponse<List<AlertRuleResourceInner>>, List<AlertRuleResourceInner>>() {
            @Override
            public List<AlertRuleResourceInner> call(ServiceResponse<List<AlertRuleResourceInner>> response) {
                return response.body();
            }
        });
    }

    /**
     * List the alert rules within a resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;AlertRuleResourceInner&gt; object
     */
    public Observable<ServiceResponse<List<AlertRuleResourceInner>>> listByResourceGroupWithServiceResponseAsync(String resourceGroupName) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        final String apiVersion = "2016-03-01";
        final String filter = null;
        return service.listByResourceGroup(resourceGroupName, this.client.subscriptionId(), apiVersion, filter, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<List<AlertRuleResourceInner>>>>() {
                @Override
                public Observable<ServiceResponse<List<AlertRuleResourceInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl1<AlertRuleResourceInner>> result = listByResourceGroupDelegate(response);
                        ServiceResponse<List<AlertRuleResourceInner>> clientResponse = new ServiceResponse<List<AlertRuleResourceInner>>(result.body().items(), result.response());
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     * List the alert rules within a resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param filter The filter to apply on the operation. For more information please see https://msdn.microsoft.com/en-us/library/azure/dn931934.aspx
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the List&lt;AlertRuleResourceInner&gt; object if successful.
     */
    public List<AlertRuleResourceInner> listByResourceGroup(String resourceGroupName, String filter) {
        return listByResourceGroupWithServiceResponseAsync(resourceGroupName, filter).toBlocking().single().body();
    }

    /**
     * List the alert rules within a resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param filter The filter to apply on the operation. For more information please see https://msdn.microsoft.com/en-us/library/azure/dn931934.aspx
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<AlertRuleResourceInner>> listByResourceGroupAsync(String resourceGroupName, String filter, final ServiceCallback<List<AlertRuleResourceInner>> serviceCallback) {
        return ServiceFuture.fromResponse(listByResourceGroupWithServiceResponseAsync(resourceGroupName, filter), serviceCallback);
    }

    /**
     * List the alert rules within a resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param filter The filter to apply on the operation. For more information please see https://msdn.microsoft.com/en-us/library/azure/dn931934.aspx
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;AlertRuleResourceInner&gt; object
     */
    public Observable<List<AlertRuleResourceInner>> listByResourceGroupAsync(String resourceGroupName, String filter) {
        return listByResourceGroupWithServiceResponseAsync(resourceGroupName, filter).map(new Func1<ServiceResponse<List<AlertRuleResourceInner>>, List<AlertRuleResourceInner>>() {
            @Override
            public List<AlertRuleResourceInner> call(ServiceResponse<List<AlertRuleResourceInner>> response) {
                return response.body();
            }
        });
    }

    /**
     * List the alert rules within a resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param filter The filter to apply on the operation. For more information please see https://msdn.microsoft.com/en-us/library/azure/dn931934.aspx
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;AlertRuleResourceInner&gt; object
     */
    public Observable<ServiceResponse<List<AlertRuleResourceInner>>> listByResourceGroupWithServiceResponseAsync(String resourceGroupName, String filter) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        final String apiVersion = "2016-03-01";
        return service.listByResourceGroup(resourceGroupName, this.client.subscriptionId(), apiVersion, filter, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<List<AlertRuleResourceInner>>>>() {
                @Override
                public Observable<ServiceResponse<List<AlertRuleResourceInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl1<AlertRuleResourceInner>> result = listByResourceGroupDelegate(response);
                        ServiceResponse<List<AlertRuleResourceInner>> clientResponse = new ServiceResponse<List<AlertRuleResourceInner>>(result.body().items(), result.response());
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl1<AlertRuleResourceInner>> listByResourceGroupDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl1<AlertRuleResourceInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl1<AlertRuleResourceInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
