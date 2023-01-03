package Chapters.Graphs.Assignments.Algorithms;

import java.util.*;
//TIME COMPLEXITY: O(ElogE + ElogV)
//ElogE for sorting E edges in edge_list
//ElogV for applying FIND & UNION operations on E edges having V vertices

public class KruskalsAlgorithm {
    
    static int[][] dsuf; //0->parent 1->rank
    static int[][] mst; //0->src 1->dst 2->wt

    public static int find(int v){
        if(dsuf[v][0] == -1){
            return v;
        }
        return dsuf[v][0] = find(dsuf[v][0]); //Path Compression
    }

    public static void union(int fromP, int toP){
        //Union By Rank
        if(dsuf[fromP][1] > dsuf[toP][1]){
            dsuf[toP][0] = fromP;
        }
        else if(dsuf[toP][1] > dsuf[fromP][1]){
            dsuf[fromP][0] = toP;
        }
        else{
            dsuf[fromP][0] = toP;
            dsuf[toP][1] += 1;
        }
    }


    public static void kruskals(int[][] edgeList, int v, int e){
        Arrays.sort(edgeList, (a,b)->(a[2]-b[2]));
        System.out.println("After sorting");
        for(int i=0; i<e; i++){
            System.out.println(edgeList[i][0]+" "+edgeList[i][1]+" "+edgeList[i][2]);
        }
        System.out.println();
        mst = new int[v][3];
        int i=0, j=0;
        while(i<v-1 && j<e){
            int fromP = find(edgeList[j][0]);
            int toP = find(edgeList[j][1]);

            if(fromP == toP){
                j++;
                continue;
            }

            union(fromP, toP);
            mst[i][0] = edgeList[j][0];
            mst[i][1] = edgeList[j][1];
            mst[i][2] = edgeList[j][2];
            i++;
        }
    }

    public static void printMST(int v){
        System.out.println("U->V  => Weight");
        for(int i=0; i<v-1; i++){
            System.out.println(mst[i][0]+" "+mst[i][1]+" "+mst[i][2]);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        dsuf = new int[v][2];
        for(int i=0; i<v; i++){
            dsuf[i][0] = -1;
            dsuf[i][1] = 0;
        }
        int[][] edgeList = new int[e][3];

        for(int i=0; i<e; i++){
            edgeList[i][0] = sc.nextInt();//src
            edgeList[i][1] = sc.nextInt();//dst
            edgeList[i][2] = sc.nextInt();//wt
        }
        sc.close();
        
        kruskals(edgeList, v, e);
        printMST(v);
    }
}
