/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.resources.implementation;

import com.google.common.reflect.TypeToken;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.annotations.ExpectedResponses;
import com.microsoft.rest.annotations.GET;
import com.microsoft.rest.annotations.HeaderParam;
import com.microsoft.rest.annotations.Headers;
import com.microsoft.rest.annotations.Host;
import com.microsoft.rest.annotations.PathParam;
import com.microsoft.rest.annotations.POST;
import com.microsoft.rest.annotations.QueryParam;
import com.microsoft.rest.annotations.UnexpectedResponseExceptionType;
import com.microsoft.rest.http.HttpClient;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import java.io.IOException;
import java.util.List;
import rx.functions.Func1;
import rx.Observable;
import rx.Single;
import com.microsoft.azure.AzureProxy;

/**
 * An instance of this class provides access to all the operations defined
 * in Features.
 */
public class FeaturesInner {
    /** The RestProxy service to perform REST calls. */
    private FeaturesService service;
    /** The service client containing this operation class. */
    private FeatureClientImpl client;

    /**
     * Initializes an instance of FeaturesInner.
     *
     * @param client the instance of the service client containing this operation class.
     */
    public FeaturesInner(FeatureClientImpl client) {
        this.service = AzureProxy.create(FeaturesService.class, client.restClient().baseURL(), client.httpClient(), client.serializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for Features to be
     * used by RestProxy to perform REST calls.
     */
    @Host("https://management.azure.com")
    interface FeaturesService {
        @Headers({ "x-ms-logging-context: com.microsoft.azure.management.resources.Features list" })
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.Features/features")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudException.class)
        Single<PageImpl<FeatureResultInner>> list(@PathParam("subscriptionId") String subscriptionId, @QueryParam("api-version") String apiVersion, @HeaderParam("accept-language") String acceptLanguage, @HeaderParam("User-Agent") String userAgent);

        @Headers({ "x-ms-logging-context: com.microsoft.azure.management.resources.Features list1" })
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.Features/providers/{resourceProviderNamespace}/features")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudException.class)
        Single<PageImpl<FeatureResultInner>> list1(@PathParam("resourceProviderNamespace") String resourceProviderNamespace, @PathParam("subscriptionId") String subscriptionId, @QueryParam("api-version") String apiVersion, @HeaderParam("accept-language") String acceptLanguage, @HeaderParam("User-Agent") String userAgent);

        @Headers({ "x-ms-logging-context: com.microsoft.azure.management.resources.Features get" })
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.Features/providers/{resourceProviderNamespace}/features/{featureName}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudException.class)
        Single<FeatureResultInner> get(@PathParam("resourceProviderNamespace") String resourceProviderNamespace, @PathParam("featureName") String featureName, @PathParam("subscriptionId") String subscriptionId, @QueryParam("api-version") String apiVersion, @HeaderParam("accept-language") String acceptLanguage, @HeaderParam("User-Agent") String userAgent);

        @Headers({ "x-ms-logging-context: com.microsoft.azure.management.resources.Features register" })
        @POST("subscriptions/{subscriptionId}/providers/Microsoft.Features/providers/{resourceProviderNamespace}/features/{featureName}/register")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudException.class)
        Single<FeatureResultInner> register(@PathParam("resourceProviderNamespace") String resourceProviderNamespace, @PathParam("featureName") String featureName, @PathParam("subscriptionId") String subscriptionId, @QueryParam("api-version") String apiVersion, @HeaderParam("accept-language") String acceptLanguage, @HeaderParam("User-Agent") String userAgent);

        @Headers({ "x-ms-logging-context: com.microsoft.azure.management.resources.Features listNext" })
        @GET("{nextUrl}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudException.class)
        Single<PageImpl<FeatureResultInner>> listNext(@PathParam(value = "nextUrl", encoded = true) String nextUrl, @HeaderParam("accept-language") String acceptLanguage, @HeaderParam("User-Agent") String userAgent);

        @Headers({ "x-ms-logging-context: com.microsoft.azure.management.resources.Features list1Next" })
        @GET("{nextUrl}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudException.class)
        Single<PageImpl<FeatureResultInner>> list1Next(@PathParam(value = "nextUrl", encoded = true) String nextUrl, @HeaderParam("accept-language") String acceptLanguage, @HeaderParam("User-Agent") String userAgent);

    }

    /**
     * Gets all the preview features that are available through AFEC for the subscription.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;FeatureResultInner&gt; object if successful.
     */
    public PagedList<FeatureResultInner> list() {
        Page<FeatureResultInner> response = listSinglePageAsync().toBlocking().value();
        return new PagedList<FeatureResultInner>(response) {
            @Override
            public Page<FeatureResultInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().value();
            }
        };
    }

    /**
     * Gets all the preview features that are available through AFEC for the subscription.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList<FeatureResultInner> object
     */
    public Observable<Page<FeatureResultInner>> listAsync() {
        return listSinglePageAsync()
            .toObservable()
            .concatMap(new Func1<Page<FeatureResultInner>, Observable<Page<FeatureResultInner>>>() {
                @Override
                public Observable<Page<FeatureResultInner>> call(Page<FeatureResultInner> page) {
                    String nextPageLink = page.nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets all the preview features that are available through AFEC for the subscription.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList<FeatureResultInner> object if successful.
     */
    public Single<Page<FeatureResultInner>> listSinglePageAsync() {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.list(this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent()).map(new Func1<PageImpl<FeatureResultInner>, Page<FeatureResultInner>>() {
                @Override
                public Page<FeatureResultInner> call(PageImpl<FeatureResultInner> productPage) {
                    return productPage;
                }
            });
    }


    /**
     * Gets all the preview features in a provider namespace that are available through AFEC for the subscription.
     *
     * @param resourceProviderNamespace The namespace of the resource provider for getting features.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;FeatureResultInner&gt; object if successful.
     */
    public PagedList<FeatureResultInner> list1(final String resourceProviderNamespace) {
        Page<FeatureResultInner> response = list1SinglePageAsync(resourceProviderNamespace).toBlocking().value();
        return new PagedList<FeatureResultInner>(response) {
            @Override
            public Page<FeatureResultInner> nextPage(String nextPageLink) {
                return list1NextSinglePageAsync(nextPageLink).toBlocking().value();
            }
        };
    }

    /**
     * Gets all the preview features in a provider namespace that are available through AFEC for the subscription.
     *
     * @param resourceProviderNamespace The namespace of the resource provider for getting features.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList<FeatureResultInner> object
     */
    public Observable<Page<FeatureResultInner>> list1Async(final String resourceProviderNamespace) {
        return list1SinglePageAsync(resourceProviderNamespace)
            .toObservable()
            .concatMap(new Func1<Page<FeatureResultInner>, Observable<Page<FeatureResultInner>>>() {
                @Override
                public Observable<Page<FeatureResultInner>> call(Page<FeatureResultInner> page) {
                    String nextPageLink = page.nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(list1NextAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets all the preview features in a provider namespace that are available through AFEC for the subscription.
     *
    PageImpl<FeatureResultInner> * @param resourceProviderNamespace The namespace of the resource provider for getting features.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList<FeatureResultInner> object if successful.
     */
    public Single<Page<FeatureResultInner>> list1SinglePageAsync(final String resourceProviderNamespace) {
        if (resourceProviderNamespace == null) {
            throw new IllegalArgumentException("Parameter resourceProviderNamespace is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.list1(resourceProviderNamespace, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent()).map(new Func1<PageImpl<FeatureResultInner>, Page<FeatureResultInner>>() {
                @Override
                public Page<FeatureResultInner> call(PageImpl<FeatureResultInner> productPage) {
                    return productPage;
                }
            });
    }


    /**
     * Gets the preview feature with the specified name.
     *
     * @param resourceProviderNamespace The resource provider namespace for the feature.
     * @param featureName The name of the feature to get.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the FeatureResultInner object if successful.
     */
    public FeatureResultInner get(String resourceProviderNamespace, String featureName) {
        return getAsync(resourceProviderNamespace, featureName).toBlocking().value();
    }

    /**
     * Gets the preview feature with the specified name.
     *
     * @param resourceProviderNamespace The resource provider namespace for the feature.
     * @param featureName The name of the feature to get.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<FeatureResultInner> getAsync(String resourceProviderNamespace, String featureName, final ServiceCallback<FeatureResultInner> serviceCallback) {
        return ServiceFuture.fromBody(getAsync(resourceProviderNamespace, featureName), serviceCallback);
    }

    /**
     * Gets the preview feature with the specified name.
     *
     * @param resourceProviderNamespace The resource provider namespace for the feature.
     * @param featureName The name of the feature to get.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the FeatureResultInner object
     */
    public Single<FeatureResultInner> getAsync(String resourceProviderNamespace, String featureName) {
        if (resourceProviderNamespace == null) {
            throw new IllegalArgumentException("Parameter resourceProviderNamespace is required and cannot be null.");
        }
        if (featureName == null) {
            throw new IllegalArgumentException("Parameter featureName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.get(resourceProviderNamespace, featureName, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
    }


    /**
     * Registers the preview feature for the subscription.
     *
     * @param resourceProviderNamespace The namespace of the resource provider.
     * @param featureName The name of the feature to register.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the FeatureResultInner object if successful.
     */
    public FeatureResultInner register(String resourceProviderNamespace, String featureName) {
        return registerAsync(resourceProviderNamespace, featureName).toBlocking().value();
    }

    /**
     * Registers the preview feature for the subscription.
     *
     * @param resourceProviderNamespace The namespace of the resource provider.
     * @param featureName The name of the feature to register.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<FeatureResultInner> registerAsync(String resourceProviderNamespace, String featureName, final ServiceCallback<FeatureResultInner> serviceCallback) {
        return ServiceFuture.fromBody(registerAsync(resourceProviderNamespace, featureName), serviceCallback);
    }

    /**
     * Registers the preview feature for the subscription.
     *
     * @param resourceProviderNamespace The namespace of the resource provider.
     * @param featureName The name of the feature to register.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the FeatureResultInner object
     */
    public Single<FeatureResultInner> registerAsync(String resourceProviderNamespace, String featureName) {
        if (resourceProviderNamespace == null) {
            throw new IllegalArgumentException("Parameter resourceProviderNamespace is required and cannot be null.");
        }
        if (featureName == null) {
            throw new IllegalArgumentException("Parameter featureName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.register(resourceProviderNamespace, featureName, this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent());
    }


    /**
     * Gets all the preview features that are available through AFEC for the subscription.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;FeatureResultInner&gt; object if successful.
     */
    public PagedList<FeatureResultInner> listNext(final String nextPageLink) {
        Page<FeatureResultInner> response = listNextSinglePageAsync(nextPageLink).toBlocking().value();
        return new PagedList<FeatureResultInner>(response) {
            @Override
            public Page<FeatureResultInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().value();
            }
        };
    }

    /**
     * Gets all the preview features that are available through AFEC for the subscription.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList<FeatureResultInner> object
     */
    public Observable<Page<FeatureResultInner>> listNextAsync(final String nextPageLink) {
        return listNextSinglePageAsync(nextPageLink)
            .toObservable()
            .concatMap(new Func1<Page<FeatureResultInner>, Observable<Page<FeatureResultInner>>>() {
                @Override
                public Observable<Page<FeatureResultInner>> call(Page<FeatureResultInner> page) {
                    String nextPageLink = page.nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets all the preview features that are available through AFEC for the subscription.
     *
    PageImpl<FeatureResultInner> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList<FeatureResultInner> object if successful.
     */
    public Single<Page<FeatureResultInner>> listNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.listNext(nextUrl, this.client.acceptLanguage(), this.client.userAgent()).map(new Func1<PageImpl<FeatureResultInner>, Page<FeatureResultInner>>() {
                @Override
                public Page<FeatureResultInner> call(PageImpl<FeatureResultInner> productPage) {
                    return productPage;
                }
            });
    }


    /**
     * Gets all the preview features in a provider namespace that are available through AFEC for the subscription.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;FeatureResultInner&gt; object if successful.
     */
    public PagedList<FeatureResultInner> list1Next(final String nextPageLink) {
        Page<FeatureResultInner> response = list1NextSinglePageAsync(nextPageLink).toBlocking().value();
        return new PagedList<FeatureResultInner>(response) {
            @Override
            public Page<FeatureResultInner> nextPage(String nextPageLink) {
                return list1NextSinglePageAsync(nextPageLink).toBlocking().value();
            }
        };
    }

    /**
     * Gets all the preview features in a provider namespace that are available through AFEC for the subscription.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList<FeatureResultInner> object
     */
    public Observable<Page<FeatureResultInner>> list1NextAsync(final String nextPageLink) {
        return list1NextSinglePageAsync(nextPageLink)
            .toObservable()
            .concatMap(new Func1<Page<FeatureResultInner>, Observable<Page<FeatureResultInner>>>() {
                @Override
                public Observable<Page<FeatureResultInner>> call(Page<FeatureResultInner> page) {
                    String nextPageLink = page.nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(list1NextAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets all the preview features in a provider namespace that are available through AFEC for the subscription.
     *
    PageImpl<FeatureResultInner> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList<FeatureResultInner> object if successful.
     */
    public Single<Page<FeatureResultInner>> list1NextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.list1Next(nextUrl, this.client.acceptLanguage(), this.client.userAgent()).map(new Func1<PageImpl<FeatureResultInner>, Page<FeatureResultInner>>() {
                @Override
                public Page<FeatureResultInner> call(PageImpl<FeatureResultInner> productPage) {
                    return productPage;
                }
            });
    }


}
