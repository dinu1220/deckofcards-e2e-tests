package models;


public class Cards {
    private String code;

    private String image;

    private Images images;

    private String value;

    private String suit;

    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
    public void setImage(String image){
        this.image = image;
    }
    public String getImage(){
        return this.image;
    }
    public void setImages(Images images){
        this.images = images;
    }
    public Images getImages(){
        return this.images;
    }
    public void setValue(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
    public void setSuit(String suit){
        this.suit = suit;
    }
    public String getSuit(){
        return this.suit;
    }
}