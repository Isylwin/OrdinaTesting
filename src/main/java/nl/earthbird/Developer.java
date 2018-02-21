package nl.earthbird;

import java.io.Serializable;

public class Developer implements Serializable {

    private String name;

    public Developer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String writeCode() {
        return "Code, code, code, code, code, code, code";
    }
}
