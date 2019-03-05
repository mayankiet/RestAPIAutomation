package com.api.testing;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ResourceHelper;

public class EnhancingGetPetInformation extends BaseTest{

    @Test
    public void abstractingTheGetRequestForMoreReadability(){

        Response response = ResourceHelper.get(configReader.getEndpointURL("get_animals"));
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
