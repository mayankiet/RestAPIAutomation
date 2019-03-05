package com.api.testing;

import entities.request.Category;
import entities.request.CreatePetRequest;
import entities.request.Tags;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import builders.CategoryBuilder;
import builders.CreatePetRequestBuilder;
import builders.TagsBuilder;
import utilities.RequestHelper;
import utilities.ResourceHelper;

public class PostRequestAndResponseValidation extends BaseTest{


    @Test
    public void sendPostRequestAndValidateResponse(){


        Category category = new CategoryBuilder()
                .withID(1)
                .withName("cat")
                .build();

        Tags tags = new TagsBuilder()
                .withID(1)
                .withName("tag1")
                .build();

        Tags[] tagList = new Tags[1];
        tagList[0] = tags;

        String[] photoUrls = {"photoURLs"};

        CreatePetRequest createPetRequest = new CreatePetRequestBuilder()
                .withCategory(category)
                .withTags(tagList)
                .withPhotoUrls(photoUrls)
                .withStatus("available")
                .withId(get3DigitRandomInt())
                .withName("Demo" + get3DigitRandomInt())
                .build();

        String url = configReader.getEndpointURL("create_pet");
        String json = RequestHelper.getJSONString(createPetRequest);
        Response response = ResourceHelper.create(url, json);

        String requestResponse = response.asString();
        System.out.println(requestResponse);

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
