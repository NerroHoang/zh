package model;

import java.io.Serializable;
import java.util.List;

public class Player implements Serializable {

    private String playerId;
    private String fullName;
    private String img;
    private String position;
    private String isCaptain;
    private int appearances;
    private int number;
    private int yearOfBirth;
    private String country;
    private String img_country;
    private int marketValue;

    public Player() {
    }

    public Player(String playerId, String fullName, String img, String position, String isCaptain, int appearances, int number, int yearOfBirth, String country, String img_country, int marketValue) {
        this.playerId = playerId;
        this.fullName = fullName;
        this.img = img;
        this.position = position;
        this.isCaptain = isCaptain;
        this.appearances = appearances;
        this.number = number;
        this.yearOfBirth = yearOfBirth;
        this.country = country;
        this.img_country = img_country;
        this.marketValue = marketValue;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIsCaptain() {
        return isCaptain;
    }

    public void setIsCaptain(String isCaptain) {
        this.isCaptain = isCaptain;
    }

    public int getAppearances() {
        return appearances;
    }

    public void setAppearances(int appearances) {
        this.appearances = appearances;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImg_country() {
        return img_country;
    }

    public void setImg_country(String img_country) {
        this.img_country = img_country;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }

    @Override
    public String toString() {
        return "Player{" + "playerId=" + playerId + ", fullName=" + fullName + ", img=" + img + ", position=" + position + ", isCaptain=" + isCaptain + ", appearances=" + appearances + ", number=" + number + ", yearOfBirth=" + yearOfBirth + ", country=" + country + ", img_country=" + img_country + ", marketValue=" + marketValue + '}';
    }

}
