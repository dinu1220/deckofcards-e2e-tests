package utils;

import constants.Constants;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Header;
import io.restassured.response.Response;
import models.CreateDeckResponse;
import models.DrawCardResponse;



public class RestEngine {
    Response response;
    /*
     * Create Deck Response
     */
    public Response getCreateDeckResponse(String addJokers){
        return RestAssured
                .given()
                    .filter(new RequestLoggingFilter())
                    .filter(new ResponseLoggingFilter())
                    .param(Constants.ADD_JOKER_HEADER,addJokers)
                .when()
                    .get(Constants.GET_DECK_OF_CARDS)
                .thenReturn();
    }
    /*
     * Draw a card response
     */
    public Response drawACardFromDeckResponse(String deckId){
        return  RestAssured
                .given()
                    .filter(new RequestLoggingFilter())
                    .filter(new ResponseLoggingFilter())
                .when()
                    .get(Constants.GET_DRAW_A_CARD_FROM_DECK.replace("<deckId>",deckId))
                .thenReturn();
    }
}
