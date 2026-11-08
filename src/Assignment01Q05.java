public class Assignment01Q05 {
    private static int[] initilaizeDistanceArray(int n){
        int[] dist = new int[n];
        for(int v =0;v<n;v++){
            dist[v] = -1;
        }
        return dist;
    }
    public static int findShortestPath(int[][] m, int i, int j) {
        if(i==j){
            return 0;
        }
        int n = m.length;
        int[] dist = initilaizeDistanceArray(n);//distance array, -1=not visited,o.w gets assigned based on when it's first met
        int[] queue = new int[n];//enqueues the nodes it sees every level then dequeues the origin to continue traversal
        int head = 0;
        int tail = 0;
        dist[i] = 0;
        queue[tail++] = i;//queue[tail] = i , tail++

        while(head<tail){ //while the queue isn't empty
            int curr = queue[head++];
            for(int next = 0; next<n; next++){ //check all neighbors
                if(m[curr][next] == 1 && dist[next] == -1){ //if there is an edge, and we haven't visited yet
                    dist[next] = dist[curr]+1; //we found it first at layer curr, and we move 1 more layer out
                    if(next == j){
                        return dist[next];
                    }
                    queue[tail++] = next;// we add the new node to the end of the queue to get checked
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}