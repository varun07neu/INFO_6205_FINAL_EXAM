package java1;

import java.util.*;
class LargestTree {
    static void addEdge(LinkedList<Integer> adj[], int u, int v) {
        adj[u].add(v);
    }

    static int DFS(int u, LinkedList<Integer> adj[], Vector<Boolean> visited) {
        visited.add(u, true);
        int size = 1;

        Iterator<Integer> iterator = adj[u].listIterator();
        while (iterator.hasNext()) {
            int tempU = iterator.next();
            if (!visited.get(tempU))
                size += DFS(tempU, adj, visited);
        }
        return size;
    }

    public int largestTree(LinkedList<Integer> adj[], int V) {

        Vector<Boolean> visited = new Vector<>();
        for(int i = 0; i < V; i++)
        {
            visited.add(false);
        }
        int size = 0;

        for (int i = 0; i < V; i++)
        {
            if (visited.get(i) == false)
            {
                size = Math.max(size,DFS(i, adj, visited));
            }
        }
        return size;

    }
}