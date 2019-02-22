package com.acompany.inheritance;

public class RegularEmployee extends Employee {
    private int transportationAllowance;

    public RegularEmployee(String name, long salary, int transportationAllowance) {
        super(name, salary);
        this.transportationAllowance = transportationAllowance;
    }

    public int getTransportationAllowance() {
        return transportationAllowance;
    }

    @Override
    public String toString() {
        return "RegularEmployee{" +
                "transportationAllowance=" + transportationAllowance +
                '}';

    }
}
