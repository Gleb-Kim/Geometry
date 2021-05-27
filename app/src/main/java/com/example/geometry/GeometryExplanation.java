package com.example.geometry;

public class GeometryExplanation {
    private String name;
    private String explanation;

    public GeometryExplanation(String name, String explanation) {
        this.name = name;
        this.explanation = explanation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
