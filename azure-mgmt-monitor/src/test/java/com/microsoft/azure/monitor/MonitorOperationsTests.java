package com.microsoft.azure.monitor;

import com.microsoft.azure.Page;
import com.microsoft.azure.management.monitor.implementation.EventDataInner;
import com.microsoft.azure.management.monitor.implementation.MonitorManager;
import com.microsoft.azure.management.resources.core.TestBase;
import com.microsoft.azure.management.resources.implementation.ResourceManager;
import com.microsoft.rest.RestClient;
import com.microsoft.rest.ServiceResponse;
import org.junit.Assert;
import org.junit.Test;

public class MonitorOperationsTests extends TestBase {
    protected MonitorManager monitorManager;
    protected ResourceManager resourceManager;

    @Override
    protected void initializeClients(RestClient restClient, String defaultSubscription, String domain) {
        monitorManager = MonitorManager.authenticate(restClient, defaultSubscription);
        resourceManager = ResourceManager
                .authenticate(restClient)
                .withSubscription(defaultSubscription);
    }

    @Override
    protected void cleanUpResources() {

    }

    @Test
    public void testActivityLogs() {
        ServiceResponse<Page<EventDataInner>> res = monitorManager.innerEx()
                .activityLogs()
                .listSinglePageAsync(
                        "eventTimestamp ge '2017-07-21T20:00:00Z' and eventTimestamp le '2017-08-23T20:00:00Z'", "")
                .toBlocking()
                .last();
        Assert.assertNotNull(res.body().nextPageLink());
    }
}
