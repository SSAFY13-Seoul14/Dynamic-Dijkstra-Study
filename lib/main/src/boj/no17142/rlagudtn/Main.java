package boj.no17142.rlagudtn;

import java.util.*;
import java.io.*;

public class Main {
    static int n,k;
    static int answer = Integer.MAX_VALUE;
    static int[][] arr;
    static List<Point> viruses,activeViruses;
    static Set<Point> empties;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        viruses = new ArrayList<>();
        activeViruses = new ArrayList<>();
        empties = new HashSet<>();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==2){
                    viruses.add(new Point(i, j));

                }
                else if(arr[i][j]==0)
                    empties.add(new Point(i, j));
            }
        }

        dfs(-1);
        if(answer==Integer.MAX_VALUE)
            answer=-1;
        System.out.println(answer);

    }

    public static void dfs(int idx) {
        if (activeViruses.size() == k) {
            answer=Math.min(answer,bfs());
            return;
        }

        for (int i = idx + 1; i < viruses.size(); i++) {
            activeViruses.add(viruses.get(i));
            dfs(i);
            activeViruses.remove(activeViruses.size()-1);
        }
    }

    public static int bfs() {
        int ret=0;
        int[][] d=new int[n][n];
        for(int[]a:d)
            Arrays.fill(a,-1);
        Set<Point> remainders = new HashSet<>(empties);

        Queue<Point> q = new ArrayDeque<>();
        for(Point p:activeViruses) {
            q.offer(p);
            d[p.x][p.y]=0;
        }
        while (!q.isEmpty()) {
            Point cur = q.poll();

            if(arr[cur.x][cur.y]==0){
                ret = Math.max(ret, d[cur.x][cur.y]);
                if(remainders.contains(cur))
                    remainders.remove(cur);
            }

            for (int i = 0; i < 4; i++) {
                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];
                int ndist=d[cur.x][cur.y]+1;
                if(0<=nx && nx<n && 0<=ny && ny<n && arr[nx][ny]!=1 && d[nx][ny]==-1){
                    q.offer(new Point(nx, ny));
                    d[nx][ny]=ndist;
                }
            }

        }
        return remainders.size()==0? ret: Integer.MAX_VALUE;
    }
}

class Point{
    int x,y;
    Point (int x,int y,int dist){

    }
    Point(int x, int y) {
        this.x=x;
        this.y=y;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null || getClass()!=obj.getClass()) return false;
        Point o=(Point) obj;
        return x == o.x && y == o.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }
}
