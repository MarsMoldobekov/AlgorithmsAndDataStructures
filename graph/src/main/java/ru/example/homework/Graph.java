package ru.example.homework;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private final int MAX_COUNT_OF_VERTICES = 32;
    private final Vertex[] vertices;
    private final int[][] adjacencyMatrix;
    private int size;

    public Graph() {
        vertices = new Vertex[MAX_COUNT_OF_VERTICES];
        adjacencyMatrix = new int[MAX_COUNT_OF_VERTICES][MAX_COUNT_OF_VERTICES];
        size = 0;
        initAdjacencyMatrix();
    }

    private void initAdjacencyMatrix() {
        for (int i = 0; i < MAX_COUNT_OF_VERTICES; i++) {
            for (int j = 0; j < MAX_COUNT_OF_VERTICES; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    public void dfs(int startVertex) {
        vertices[startVertex].setVisited(true);

        for (int i = 0; i < size; i++) {
            int vertex = getAdjacencyUnvisitedVertex(startVertex);

            if (!vertices[i].isVisited() && vertex != -1 && i == vertex) {
                fullDisplayVertex(startVertex, vertex);
                dfs(vertex);
            }
        }
    }

    public void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        vertices[0].setVisited(true);
        displayVertex(0);
        queue.add(0);
        int j;

        while (!queue.isEmpty()) {
            int i = queue.remove();

            while ((j = getAdjacencyUnvisitedVertex(i)) != -1) {
                vertices[j].setVisited(true);
                displayVertex(j);
                queue.add(j);
            }
        }

        refresh();
    }

    public void refresh() {
        for (int i = 0; i < size; i++) {
            vertices[i].setVisited(false);
        }
    }

    private int getAdjacencyUnvisitedVertex(int vertex) {
        for (int i = 0; i < size; i++) {
            if (adjacencyMatrix[vertex][i] == 1 && !vertices[i].isVisited()) {
                return i;
            }
        }

        return -1;
    }

    public void addVertex(char label) {
        vertices[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = 1;
        adjacencyMatrix[end][start] = 1;
    }

    public void displayVertex(int vertex) {
        System.out.println(vertices[vertex].getLabel());
    }

    public void fullDisplayVertex(int i, int j) {
        System.out.println("Вершины " + vertices[i].getLabel() + "-" + vertices[j].getLabel());
    }
}
