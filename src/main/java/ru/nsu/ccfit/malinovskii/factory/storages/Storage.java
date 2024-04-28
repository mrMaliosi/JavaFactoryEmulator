package ru.nsu.ccfit.malinovskii.factory.storages;

import ru.nsu.ccfit.malinovskii.Object;

import java.util.LinkedList;

public class Storage {
    protected int maxSize;
    protected int size;
    protected LinkedList <Object> objects;

    public void initialize(int maxSize){
        this.maxSize = maxSize;
        this.size = 0;
        this.objects = new LinkedList <Object>();
    }

    public void push(Object object){
        objects.push(object);
    }

    public Object pop(Object object){
        return objects.removeFirst();
    }
}
