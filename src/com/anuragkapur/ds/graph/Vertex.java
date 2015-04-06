package com.anuragkapur.ds.graph;

/**
 * @author: anuragkapur
 * @since: 09/05/2014
 */

public class Vertex {

    private int label;

    public Vertex(int label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        if (label != vertex.label) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return label;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label=" + label +
                '}';
    }
}
