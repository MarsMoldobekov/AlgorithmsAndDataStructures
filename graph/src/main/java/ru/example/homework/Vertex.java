package ru.example.homework;

public class Vertex {
    private final char label;
    private boolean visited;

    public Vertex(char label) {
        this.label = label;
        visited = false;
    }

    public char getLabel() {
        return label;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
