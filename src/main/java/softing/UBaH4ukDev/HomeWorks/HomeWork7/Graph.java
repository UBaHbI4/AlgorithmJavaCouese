package softing.UBaH4ukDev.HomeWorks.HomeWork7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork7

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.24
 v1.0
 */
public class Graph {

    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;
    private Stack stack;

    public Graph(int countVerts) {
        stack = new Stack(countVerts);
        vertexList = new Vertex[countVerts];
        adjMat = new int[countVerts][countVerts];
        size = 0;
        for (int i = 0; i < countVerts; i++) {
            for (int j = 0; j < countVerts; j++) {
                adjMat[i][j] = 0;
            }
        }
    }


    private int getAdjUnvisitedVertex (int ver) {
        for (int i = 0; i < size; i++) {
            if (adjMat[ver][i] == 1 && vertexList[i].isWasVisited() == false) {
                return i;
            }
        }
        return -1;
    }

    //Обход графа в глубину
    public void dfs() {
        vertexList[0].setWasVisited(true);
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].setWasVisited(true);
                displayVertex(v);
                stack.push(v);
            }
        }
        clearVisited();
    }

    //Обход графа в глубину рекурсивный
    public void dfsRecursiv (int startVert) {
        vertexList[startVert].setWasVisited(true);
        for (int i = 0; i < size; i ++) {
            int v = getAdjUnvisitedVertex(startVert);
            if (!vertexList[i].isWasVisited() && v != -1) {
                fullDisplayVertex(startVert, v);
                dfsRecursiv(i);
            }
        }
    }

    //обход графа в ширину классический
    public void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        vertexList[0].setWasVisited(true);
        displayVertex(0);
        queue.add(0);
        int v2;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].setWasVisited(true);
                displayVertex(v2);
                queue.add(v2);
            }
        }

        clearVisited();
    }

    //обход графа в ширину c указанием начальной вершины
    public void bfs(int v) {
        int[] quque = new int[size];
        int qH = 0;
        int qT = 0;

        vertexList[0].setWasVisited(true);
        quque[qT++] = v;
        displayVertex(0);

        int v2;
        while (qH < qT) {
            v = quque[qH++];
            for (int i = 0; i < size; i++) {
                v2 = getAdjUnvisitedVertex(v);
                if (!vertexList[i].isWasVisited() && v2 != -1) {
                    vertexList[i].setWasVisited(true);
                    displayVertex(qT);
                    quque[qT++] = i;
                }
            }
        }
        clearVisited();
    }

    //Метод для сброса посещенных вершин
    public void clearVisited() {
        for (int i = 0; i < size; i ++) {
            vertexList[i].setWasVisited(false);
        }
    }



    public void fullDisplayVertex(int vertex1, int vertex2) {
        System.out.println("\tВершины " + vertexList[vertex1].getLabel() + "-" + vertexList[vertex2].getLabel());
    }

    public void addVertex(char label) {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex) {
        System.out.println("\tВершина с индексом " + vertex + " " +vertexList[vertex].getLabel());
    }

    //Сделаем метод для вывода матрицы смежности
    public void displayAdjMat() {
        System.out.println("\tМатрица смежности:");
        System.out.print("\t  | ");
        for (int i = 0; i < vertexList.length; i++) {
            System.out.print(vertexList[i].getLabel() + " | ");
        }
        System.out.println();
        for (int i = 0; i < vertexList.length; i++) {
            System.out.print("\t" + vertexList[i].getLabel() + " | ");
            for (int j = 0; j < vertexList.length; j++) {
                System.out.print(adjMat[i][j] + " | ");
            }
            System.out.println();
        }
    }

    private int getIndexByLabel (char label) {
        for (int i = 0; i < vertexList.length; i++) {
            if (vertexList[i].getLabel() == label) {
                return i;
            }
        }
        return -1;
    }

    //Сделаем метод для добавления ребер через указание вершин, которые надо соелинить
    public void addEdgeByLabel(char first, char second) {
       int firstIndex = getIndexByLabel(first);
       int secondIndex = getIndexByLabel(second);
       if (firstIndex > -1 && secondIndex > -1) {
           adjMat[firstIndex][secondIndex] = 1;
           adjMat[secondIndex][firstIndex] = 1;
           System.out.println("\tДобавили ребро между вершинами " + first + " и " + second);
       } else {
           System.out.println("\t Ошибка при добавлении ребра для вершин " + first + " и " + second);
       }
    }
}
