package com.example.pikapika.poke;

public class Pokemon {
    private String name;
    private int weight;
    private int height;

    public Pokemon(){
        this.name = "nullName";
        this.weight = 0;
        this.height = 0;
    }

    public Pokemon(String name, int weight, int height){
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public void setHeight(int height){
        this.height = height;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nWeight: " + weight + "\nHeight " + height + "\n-----------";
    }
}
