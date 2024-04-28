package ru.nsu.ccfit.malinovskii;

public class Object {
    int id;
    String type;

    public Object(String typeName, int id) {
        this.type = typeName;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }
}
