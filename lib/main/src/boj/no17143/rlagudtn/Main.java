package boj.no17143.rlagudtn;

import java.util.*;
import java.io.*;

public class Main {
    static int r,c,m;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0,0 , 1, -1};
    static Shark[] sharks;
    static Shark[][] arr;
    static boolean[] alive;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sharks = new Shark[m];
        arr=new Shark[r+1][c+1];
        alive = new boolean[m];
        Arrays.fill(alive,true);

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int dir=Integer.parseInt(st.nextToken());
            int size=Integer.parseInt(st.nextToken());

            if(dir<=2) v %= (r - 1)*2;
            else v %= (c - 1)*2;
            Shark s = new Shark(i,x, y, v, dir, size);
            sharks[i]=s;
            arr[x][y]=s;
        }

        int answer=0;
        for (int i = 1; i <= c; i++) {
            for (int j = 1; j <= r; j++) { //상어 잡이
                if(arr[j][i]!=null){
                    Shark s=arr[j][i];
                    alive[s.idx]=false;
                    arr[j][i]=null;
                    answer+=s.size;
                    break;
                }

            }
            move();
        }

        System.out.println(answer);
    }

    private static void move() {
        Shark[][] after = new Shark[r + 1][c + 1];
        for(int i=0;i<sharks.length;i++){
            if(alive[i]==false) continue;
            Shark s=sharks[i];
            int nx=s.x+dx[s.dir]*s.v;
            int ny=s.y+dy[s.dir]*s.v;

            while (!(1 <= nx && nx <= r && 1 <= ny && ny <= c)) {
                if (nx > r) {
                    nx=2*r-nx;
                    s.dir= 1;
                }
                else if (nx <= 0) {
                    nx=nx*-1+2;
                    s.dir=2;
                }
                if (ny > c) {
                    ny=2*c-ny;
                    s.dir=4;
                } else if (ny <= 0) {
                    ny=ny*-1 +2;
                    s.dir=3;
                }
            }

            if(after[nx][ny]==null){
                after[nx][ny]=s;
                s.x=nx;
                s.y=ny;
            }
            else{ //기존 상어가 존재한다면
                if(s.size> after[nx][ny].size){ //기존 상어보다 큰 경우
                    alive[after[nx][ny].idx] =false;
                    after[nx][ny]=s;
                    s.x=nx;
                    s.y=ny;
                }
                else{ //기존 상어보다 작은경우
                    alive[s.idx] =false;
                }

            }
        }
        arr=after;
    }
}

class Shark{
    int x,y,dir,size, v;
    int idx;
    public Shark(int idx, int x, int y, int v, int dir, int size) {
        this.idx=idx;
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.size=size;
        this.v=v;
    }
}
