package softing.UBaH4ukDev.HomeWorks.HomeWork7;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork7

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.24
 v1.0
 */
public class HomeWork7 {

    public static void main(String[] args) {
        /*
        Задание 7.1
        Приведите пример графа.
        */

        System.out.println("Задание 7.1");
        System.out.println("\tВ виде графа можно рассмотреть города и дороги между городами, где города являются вершинами, \r\n\tа " +
                "дороги между ними - ребрами. У каждого ребра вес в виде расстояния между двумя " +
                "городами. \r\n\tТак мы можем строить оптимальные маршруты.");

        /*
        Задание 7.2
        Реализуйте базовые методы графа.
        */
        System.out.println("Задание 7.2");
        System.out.println("\tБазовые методы реализованы в классе Graph");
        //Создадим экзепляр класса Graph
        Graph graph = new Graph(7);
        //Добавим вершины
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        //Добавим вершину H, но ни с кем ее связывать не будем,
        //результат увидем при обходе графа
        graph.addVertex('H');
        //Соединим вершины ребрами
        //graph.addEdge(0, 1); //AB
        //graph.addEdge(1, 2); //BC
        //graph.addEdge(0, 3); //AD
        //graph.addEdge(3, 4); //DE
        //Реализовал соединение вершин ребрами через указание меток вершин,
        //так кажется удобнее :) Результат одинаковый.
        graph.addEdgeByLabel('A', 'B'); //AB
        graph.addEdgeByLabel('B', 'C'); //BC
        graph.addEdgeByLabel('A', 'D'); //AD
        graph.addEdgeByLabel('D', 'E'); //DE
        //Выведем вершину
        graph.displayVertex(2);
        System.out.println();
        //Выведем матрицу смежности
        graph.displayAdjMat();
        System.out.println();

        /*
        Задание 7.3
        В программный код из задания 7.2 добавьте реализацию метода обхода в глубину.
        Выполните оценку времени с помощью System.nanoTime().
        */
        System.out.println("Задание 7.3");
        System.out.println("\tОбход графа в глубину:");
        long lStartTime = System.nanoTime();
        graph.dfs();
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println("\tВершины H нету, т.к. она ни с кем не связана ребром");
        System.out.println();

        System.out.println("\tОбход графа в глубину через рекурсивный метод с выбором начальной вершины:");
        lStartTime = System.nanoTime();
        graph.dfsRecursiv(1);
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println();
        //Вызовим метод сброса посещения вершин, т.к. в рекурсивном методе он не вызывается автоматом у нас, как в обычном обходе
        graph.clearVisited();
        /*
        Задание 7.4
        В базовом графе из задания 7.2 реализуйте метод обхода в ширину.
        Выполните оценку времени с помощью System.nanoTime().
        */
        System.out.println("Задание 7.4");
        System.out.println("\tОбход графа в ширину классический:");
        lStartTime = System.nanoTime();
        graph.bfs();
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println();
        System.out.println("\tОбход графа в ширину с выбором начальной вершины:");
        lStartTime = System.nanoTime();
        graph.bfs(0);
        System.out.println("\tПродолжительность операции " + (System.nanoTime() - lStartTime) + " ns");
        System.out.println();
    }
}
