import java.util.ArrayList;
import java.util.Arrays;

class LC787 {
    int maxStops;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.maxStops=k;
        ArrayList<ArrayList<Pair>> adjacencyList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjacencyList.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            int sr=flight[0];
            int dest=flight[1];
            int weight=flight[2];
            Pair p=new Pair(dest, weight);
            adjacencyList.get(sr).add(p);
        }
        boolean []visited=new boolean[n];
        Arrays.fill(visited, false);
        int ans=dfs(adjacencyList, src, dst, 0, visited);
        return ans>2147483647?-1:ans;
    }
    public int dfs(ArrayList<ArrayList<Pair>> adjacencyList, int curr, int dest, int stops, boolean[] visited){
        if(curr==dest){
            return 0;
        }
        if(stops>maxStops){
            return Integer.MAX_VALUE/2;
        }
        int minCost=Integer.MAX_VALUE/2;
        visited[curr]=true;
        for(Pair neighbour: adjacencyList.get(curr)){
            if(!visited[neighbour.dest]){
                int nextStop=neighbour.dest;
                int currentCost=neighbour.weight;
                minCost=Math.min(minCost, currentCost+dfs(adjacencyList, nextStop, dest, stops+1,visited));
            }
        }
        visited[curr]=false;
        return minCost;
    }
}


class Pair{
    int dest;
    int weight;
    Pair(int dest, int weight){
        this.dest=dest;
        this.weight=weight;
    }
}