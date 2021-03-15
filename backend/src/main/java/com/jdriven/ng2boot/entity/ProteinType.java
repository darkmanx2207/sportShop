package com.jdriven.ng2boot.entity;

public enum ProteinType {

    WHEY("Whey"),
    ISOLATE("Isolate"),
    CASEIN("Casein"),
    BEEF("Beef"),
    COMPLEX("Complex");

    private String type;

    ProteinType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
