package Graph;
import java.util.*;
import java.util.ArrayList;

public class BFS_DFS {

    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<Edge>(); //empty arraylist
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));


        graph[1].add(new Edge(1,3));
        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }

    public static void BFS(int startNode , ArrayList<Edge> graph[]){
        Queue<Integer> q= new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
//        for(int i=0;i<vis.length;i++){
//            vis[i]=false;
//        }
        q.add(startNode);
        while (!q.isEmpty()){
            int curr = q.poll();
            if(vis[curr]==false){
                System.out.print(curr+" ");
                vis[curr]=true;

                //add the neighbours of curr node to queue
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }

            }
        }


    }

    public static void DFS(ArrayList<Edge> graph[], int curr, boolean vis[]){
        System.out.print(curr+" ");
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest]==false){
                DFS(graph,e.dest,vis);
            }
        }
    }

    public static void main(String[] args) {
        int V =7;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println("BFS Traversal ");
        BFS(0,graph);
        System.out.println();
        System.out.println("DFS Traversal ");

        boolean vis[]= new boolean[V];
        DFS(graph,0,vis);

    }
}
