package test.game.model.player;

import test.game.model.interfaces.IGamer;

public abstract class Gamer implements IGamer {

    private String name;
    private int age;
    private int experienceInDays;
    private double luckyLevel;

    public Gamer(String name, int age, int experienceIdDays, double luckyLevel) {
        this.name = name;
        this.age = age;
        this.experienceInDays = experienceIdDays;
        this.luckyLevel = luckyLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperienceInDays() {
        return experienceInDays;
    }

    public void setExperienceInDays(int experienceInDays) {
        this.experienceInDays = experienceInDays;
    }

    public double getLuckyLevel() {
        return luckyLevel;
    }

    public void setLuckyLevel(double luckyLevel) {
        this.luckyLevel = luckyLevel;
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", experienceIdDays=" + experienceInDays +
                ", luckyLevel=" + luckyLevel +
                '}';
    }
}
