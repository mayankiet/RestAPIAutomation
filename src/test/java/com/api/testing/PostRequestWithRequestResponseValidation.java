package com.api.testing;

import entities.request.Category;
import entities.request.CreatePetRequest;
import entities.request.Tags;
import entities.response.CreatePetResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import builders.CategoryBuilder;
import builders.CreatePetRequestBuilder;
import builders.TagsBuilder;
import utilities.RequestHelper;
import utilities.ResourceHelper;
import utilities.ResponseHelper;

import java.io.IOException;

public class PostRequestWithRequestResponseValidation extends BaseTest{


    @Test
    public void PostRequestWithValidationOfRequestAndResponseValidation() throws IOException {

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

        CreatePetResponse createPetResponse = (CreatePetResponse)
                ResponseHelper.getResponseAsObject(response.asString(), CreatePetResponse.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(createPetRequest.getName(), createPetResponse.getName());
        Assert.assertEquals(createPetRequest.getStatus(), createPetResponse.getStatus());
        Assert.assertEquals(createPetRequest.getTags()[0].getName(), createPetResponse.getTags()[0].getName());
    }
}
