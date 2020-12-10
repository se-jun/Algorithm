package com.ssafy.day13;

public class Archer implements Fightable, Comparable<Archer> {
    int age;
    String name;

    public Archer() {};

    public Archer(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }


    @Override
    public void fight() {
        System.out.println("shoot!");
    }

    @Override
    public void move() {
        System.out.println("walking...");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Archer [age=").append(age).append(", name=").append(name).append("]");
        return builder.toString();
    }

    // @Override
    // public int compareTo(Archer o) {
    // return this.name.compareTo(o.name)*-1;
    // }
    // @Override
    // public int compareTo(Archer o) {
    // return Integer.compare(this.age, o.age);
    // }
    @Override
    public int compareTo(Archer o) {
        if (this.age != o.age) {
            return Integer.compare(this.age, o.age) * -1;
        } else {
            return this.name.compareTo(o.name) * -1;
        }
    }
}
