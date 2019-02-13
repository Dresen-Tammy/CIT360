package com.company;

import java.util.ArrayList;

public class Response {
    private Integer count;
    private ArrayList<Recipe> recipes;

    public Response() {
    }

    public Response(Integer count, ArrayList<Recipe> recipes) {
        this.count = count;
        this.recipes = recipes;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }
}
