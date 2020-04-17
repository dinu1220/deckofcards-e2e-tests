package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateDeckResponse {
    @JsonProperty("success")
    boolean success;
    @JsonProperty("deck_id")
    String deckId;
    @JsonProperty("remaining")
    String remaining;
    @JsonProperty("shuffled")
    boolean shuffled;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDeckId() {
        return deckId;
    }

    public void setDeckId(String deckId) {
        this.deckId = deckId;
    }

    public String getRemaining() {
        return remaining;
    }

    public void setRemaining(String remaining) {
        this.remaining = remaining;
    }

    public boolean isShuffled() {
        return shuffled;
    }

    public void setShuffled(boolean shuffled) {
        this.shuffled = shuffled;
    }

    @Override
    public String toString() {
        return "CreateDeckResponse{" +
                "success=" + success +
                ", deckId='" + deckId + '\'' +
                ", remaining='" + remaining + '\'' +
                ", shuffled=" + shuffled +
                '}';
    }
}
