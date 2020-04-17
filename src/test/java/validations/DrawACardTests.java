package validations;

import convertors.ResponseToObjConvertor;
import io.restassured.response.Response;
import models.CreateDeckResponse;
import models.DrawCardResponse;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestEngine;

public class DrawACardTests {
    RestEngine restEngine=null;
    Response response=null;
    CreateDeckResponse createDeckResponse;
    DrawCardResponse drawCardResponse;

    public DrawACardTests(){
        restEngine=new RestEngine();
    }

    @Test
    public void validateSuccessResponseCodeWithOutJokers(){
        response=restEngine.getCreateDeckResponse("false");
        Assert.assertTrue(response.getStatusCode()==200,"Status Code is not 200"+response.getStatusCode());
    }

    @Test
    public void validateSuccessResponseCodeWithJokers(){
        response=restEngine.getCreateDeckResponse("true");
        Assert.assertTrue(response.getStatusCode()==200,"Status Code is not 200"+response.getStatusCode());
    }
    /*
     * Current create deck is working even though wrong header key/value is passed
     *
    @Test
    public void validateFailureResponseCodeWithInvalidHeaderValue(){
        response=restEngine.getCreateDeckResponse("test");
        Assert.assertTrue("Status Code is 200"+response.getStatusCode(),response.getStatusCode()!=200);
    }*/

    @Test
    public void validateSuccessResponseContentWithOutJokers(){
        createDeckResponse=ResponseToObjConvertor.getCreateDeckResponse(restEngine.getCreateDeckResponse("false").prettyPrint());
        Assert.assertTrue(createDeckResponse.isSuccess(),"Invalid success in dock response"+createDeckResponse.toString());
        Assert.assertTrue(createDeckResponse.getDeckId()!=null && !createDeckResponse.getDeckId().isEmpty(),"Invalid deckid in dock response"+createDeckResponse.toString());
        Assert.assertTrue(createDeckResponse.getRemaining().equals("52"),"Invalid remaining in dock response"+createDeckResponse.toString());
        Assert.assertTrue(!createDeckResponse.isShuffled(),"Invalid shuffled in dock response"+createDeckResponse.toString());
    }

    @Test
    public void validateSuccessResponseContentWithJokers(){
        createDeckResponse=ResponseToObjConvertor.getCreateDeckResponse(restEngine.getCreateDeckResponse("true").prettyPrint());
        Assert.assertTrue(createDeckResponse.isSuccess(),"Invalid success in dock response"+createDeckResponse.toString());
        Assert.assertTrue(createDeckResponse.getDeckId()!=null && !createDeckResponse.getDeckId().isEmpty(),"Invalid deckid in dock response"+createDeckResponse.toString());
        Assert.assertTrue(createDeckResponse.getRemaining().equals("54"),"Invalid remaining in dock response"+createDeckResponse.toString());
        Assert.assertTrue(!createDeckResponse.isShuffled(),"Invalid shuffled in dock response"+createDeckResponse.toString());
    }
}
