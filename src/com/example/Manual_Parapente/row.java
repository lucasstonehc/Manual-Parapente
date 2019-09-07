package com.example.Manual_Parapente;

/**
 * Created by Juninho on 5/13/2015.
 */
public class row {
    private String title;
    private int image;
    public row(String title,int image){
        this.setTitle(title);
        this.setImage(image);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
