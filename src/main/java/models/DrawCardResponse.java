package models;

import java.util.ArrayList;
import java.util.List;

public class DrawCardResponse {
    private boolean success;

    private String deck_id;

    private List<Cards> cards;

    private int remaining;

    public void setSuccess(boolean success){
        this.success = success;
    }
    public boolean getSuccess(){
        return this.success;
    }
    public void setDeck_id(String deck_id){
        this.deck_id = deck_id;
    }
    public String getDeck_id(){
        return this.deck_id;
    }
    public void setCards(List<Cards> cards){
        this.cards = cards;
    }
    public List<Cards> getCards(){
        return this.cards;
    }
    public void setRemaining(int remaining){
        this.remaining = remaining;
    }
    public int getRemaining(){
        return this.remaining;
    }
}