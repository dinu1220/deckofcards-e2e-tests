package validations;

import convertors.ResponseToObjConvertor;
import io.restassured.response.Response;
import models.CreateDeckResponse;
import models.DrawCardResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestEngine;

public class GetDeckOfCardsTests {
    RestEngine restEngine=null;
    Response response=null;
    CreateDeckResponse createDeckResponse;
    DrawCardResponse drawCardResponse;

    public GetDeckOfCardsTests(){
        restEngine=new RestEngine();
    }

    @Test
    public void validateSuccessResponseCodeFromDrawCard(){
        createDeckResponse=ResponseToObjConvertor.getCreateDeckResponse(restEngine.getCreateDeckResponse("false").prettyPrint());
        response=restEngine.drawACardFromDeckResponse(createDeckResponse.getDeckId());
        Assert.assertTrue(response.getStatusCode()==200,"Status Code is not 200"+response.getStatusCode());
    }

    @Test
    public void validateFailureResponseCodeForDraw(){
        response=restEngine.drawACardFromDeckResponse("test");
        Assert.assertTrue(response.getStatusCode()==500,"Status Code is not 500"+response.getStatusCode());
    }

    @Test
    public void validateSuccessResponseForWithDrawFromDeckOf52(){
        createDeckResponse=ResponseToObjConvertor.getCreateDeckResponse(restEngine.getCreateDeckResponse("false").prettyPrint());
        for(int i=52;i>0;i--){
            drawCardResponse=ResponseToObjConvertor.getCardWithdrawn(restEngine.drawACardFromDeckResponse(createDeckResponse.getDeckId()).prettyPrint());

            Assert.assertTrue(drawCardResponse.getSuccess(),"Invalid success in draw card response"+drawCardResponse.toString());
            Assert.assertTrue(drawCardResponse.getDeck_id().equals(createDeckResponse.getDeckId()),"Invalid deckid in draw card response"+drawCardResponse.toString());
            Assert.assertTrue(drawCardResponse.getRemaining()==(i-1),"Invalid remaining in draw card response"+createDeckResponse.toString());
        }
    }

    @Test
    public void validateSuccessResponseForWithDrawFromDeckOf54(){
        createDeckResponse=ResponseToObjConvertor.getCreateDeckResponse(restEngine.getCreateDeckResponse("true").prettyPrint());
        for(int i=54;i>0;i--){
            drawCardResponse=ResponseToObjConvertor.getCardWithdrawn(restEngine.drawACardFromDeckResponse(createDeckResponse.getDeckId()).prettyPrint());

            Assert.assertTrue(drawCardResponse.getSuccess(),"Invalid success in draw card response"+drawCardResponse.toString());
            Assert.assertTrue(drawCardResponse.getDeck_id().equals(createDeckResponse.getDeckId()),"Invalid deckid in draw card response"+drawCardResponse.toString());
            Assert.assertTrue(drawCardResponse.getRemaining()==(i-1),"Invalid remaining in draw card response"+createDeckResponse.toString());
        }
    }
}
