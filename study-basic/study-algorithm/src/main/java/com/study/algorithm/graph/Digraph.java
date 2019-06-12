package com.study.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <strong>visited</strong>是用来记录已经被访问的顶点，用来避免顶点被重复访问。如果顶点 q 被访问，那相应的 visited[q] 会被
 * 设置为 true。
 * <p></p>
 * <strong>queue</strong>是一个队列，用来存储已经被访问、但相连的顶点还没有被访问的顶点。
 * 因为广度优先搜索是逐层访问的，也就是说，我们只有把第 k 层的顶点都访问完成之后，才能访问第 k+1 层的顶点。 当我们访问到第 k 层的顶点的时候，我们需要把第 k 层的顶点记录下来，稍后才能通过第 k 层的顶点来找第 k+1
 * 层的顶点。 所以，我们用这个队列来实现记录的功能。
 * <p></p>
 * <strong>prev</strong>用来记录搜索路径。当我们从顶点 s 开始，广度优先搜索到顶点 t 后，prev 数组中存储的就是搜索的路径。
 * 不过，这个路径是反向存储的。prev[w] 存储的是，顶点 w 是从哪个前驱顶点遍历过来的。 比如，我们通过顶点 2 的邻接表访问到顶点 3，那 prev[3] 就等于 2。 为了正向打印出路径，我们需要递归地来打印，你可以看下
 * print() 函数的实现方式。
 *
 * 图片: docs/广度优先遍历.png docs/深度优先遍历.png
 *
 * @author dranawhite 2019/04/12
 */
public class Digraph {

    /**
     * 顶点的个数
     */
    private int vertex;

    /**
     * 邻接表
     */
    private LinkedList<Integer>[] adj;

    public Digraph(int vertex) {
        this.vertex = vertex;
        adj = new LinkedList[vertex];
        for (int i = 0; i < vertex; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int target) {
        adj[source].add(target);
    }

    /**
     * 广度优先遍历
     *
     * @param source source
     * @param target target
     */
    public void bfs(int source, int target) {
        if (source == target) {
            return;
        }
        boolean[] visited = new boolean[vertex];
        visited[source] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        int[] prev = new int[vertex];
        for (int i = 0; i < vertex; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == target) {
                        print(prev, source, target);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    /**
     * 全局变量或者类成员变量
     */
    boolean found = false;

    /**
     * 深度优先遍历
     *
     * @param source source
     * @param target target
     */
    public void dfs(int source, int target) {
        found = false;
        boolean[] visited = new boolean[vertex];
        int[] prev = new int[vertex];
        for (int i = 0; i < vertex; ++i) {
            prev[i] = -1;
        }
        recurDfs(source, target, visited, prev);
        print(prev, source, target);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        // 递归打印 s->t 的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

}
