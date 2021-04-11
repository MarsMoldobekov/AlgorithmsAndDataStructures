package ru.example.homework;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        addVertices(graph);
        addEdges(graph);
        graph.dfs(0);
        graph.refresh();
        graph.bfs();
    }

    private static void addVertices(Graph graph) {
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('H');
    }

    private static void addEdges(Graph graph) {
        graph.addEdge(0, 1); //AB
        graph.addEdge(1, 2); //BC
        graph.addEdge(0, 3); //AD
        graph.addEdge(3, 4); //DE
        graph.addEdge(0, 5); //AH
    }
}
