package com.acompany.inheritance;

public class Manager extends Employee {
    private long bonus;

    public Manager(String name, long salary, long bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public long getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "bonus=" + bonus +
                '}';
    }
}
