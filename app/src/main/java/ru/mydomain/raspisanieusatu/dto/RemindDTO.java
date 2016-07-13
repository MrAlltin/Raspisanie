package ru.mydomain.raspisanieusatu.dto;

public class RemindDTO {
    private String title;
    private String rooms;
    private String prepods;

    public RemindDTO(String title,String rooms, String prepods) {
        this.title = title;
        this.rooms = rooms;
        this.prepods = prepods;

    }

    public String getTitle() {
        return title;
    }

    public String getRooms() {return rooms;}
    public String getPrepods() {return prepods;}

    public void setTitle(String title) {
        this.title = title;
    }
}
