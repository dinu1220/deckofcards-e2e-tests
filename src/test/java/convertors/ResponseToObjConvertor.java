package convertors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.CreateDeckResponse;
import models.DrawCardResponse;
import org.testng.Assert;

public class ResponseToObjConvertor {
    static ObjectMapper objectMapper=new ObjectMapper();

    public static CreateDeckResponse getCreateDeckResponse(String json){
        CreateDeckResponse createDeckResponse=null;
        try {
                createDeckResponse=objectMapper.readValue(json, CreateDeckResponse.class);
        }catch (JsonProcessingException exp){
            Assert.fail("Unable to convert json into model object\n"+json);
        }
        return createDeckResponse;
    }

    public static DrawCardResponse getCardWithdrawn(String json){
        objectMapper=new ObjectMapper();
        DrawCardResponse drawCardResponse=null;
        try {
            drawCardResponse=objectMapper.readValue(json, DrawCardResponse.class);
        }catch (JsonProcessingException exp){
            Assert.fail("Unable to convert json into model object\n"+json);
        }
        return drawCardResponse;
    }
}
