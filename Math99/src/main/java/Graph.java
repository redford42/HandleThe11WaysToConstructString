import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hanz
 * @date 2020/5/9
 */
public class Graph {

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(1, 2, 60);
        graph.addEdge(1, 3, 10);
        graph.addEdge(1, 5, 50);
        graph.addEdge(2, 4, 35);
        graph.addEdge(3, 4, 30);
        graph.addEdge(3, 5, 25);
        graph.addEdge(4, 6, 15);
        graph.addEdge(5, 2, 30);
        graph.addEdge(5, 6, 105);
        // 计算最短距离
        graph.dijkstra(1, 6);
    }
    // 顶点个数（顶点编号从0开始，在本文例子中，编号为0的顶点不存在）
    private int v;

    // 记录每个顶点的边
    private LinkedList<Edge>[] adj;

    public Graph(int v) {
        this.v = v;
        // 初始化
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    // 添加一条边，从s到达t
    public void addEdge(int s, int t, int weight) {
        Edge edge = new Edge(s, t, weight);
        adj[s].add(edge);
    }

    // 采用迪杰斯特拉算法找出从s到t的最短路径
    public void dijkstra(int s, int t) {
        int[] dist = new int[v];    // 记录s到每个顶点的最小距离，数组下标表示顶点编号，值表示最小距离
        boolean[] flag = new boolean[v];    // 记录遍历过的顶点，数组下标表示顶点编号，值表示是否遍历过该顶点
        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;    // 初始状态下，将顶点s到其他顶点的距离都设置为无穷大
        }
        int[] predecessor = new int[v];     // 记录路径，索引表示顶点编号，值表示到达当前顶点的顶点是哪一个
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        dist[s] = 0;    // s->s的路径为0
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            if (flag[vertex]) {
                continue; // 已经遍历过该顶点，就不再遍历
            }
            flag[vertex] = true;
            for (int i = 0; i < adj[vertex].size(); i++) {
                Edge edge = adj[vertex].get(i);
                if (dist[vertex] < (dist[edge.t] - edge.weight)) {  // 如果出现了比当前路径小的方式，就更新为更小路径
                    dist[edge.t] = dist[vertex] + edge.weight;
                    predecessor[edge.t] = vertex;
                }
                queue.add(edge.t);
            }
        }
        // 打印路径
        System.out.println("最短距离：" + dist[t]);
        System.out.print(s);
        print(s, t, predecessor);
    }

    private void print(int s, int t, int[] predecessor) {
        if (t == s) {
            return;
        }
        print(s, predecessor[t], predecessor);
        System.out.print(" -> " + t);
    }


    private class Edge {
        // 起始定点
        public int s;
        // 终止定点
        public int t;
        // 边的权重
        public int weight;

        Edge(int s, int t, int weight) {
            this.s = s;
            this.t = t;
            this.weight = weight;
        }
    }
}
