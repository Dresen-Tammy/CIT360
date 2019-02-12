package servlets;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UserInput implements Serializable {
    private String name = "&lt;name&gt;";
    private String animal= "&lt;animal&gt;";
    private String day = "&lt;day&gt;";
    private int number = 0;
    private String food = "&lt;food&gt;";
    private String homework = "&lt;homework&gt;";
    private LocalDate date;

    public UserInput() {

    }

    public UserInput(String name, String animal, String day, int number, String food, String homework, LocalDate date) {
        this.name = name;
        this.animal = animal;
        this.day = day;
        this.number = number;
        this.food = food;
        this.homework = homework;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
