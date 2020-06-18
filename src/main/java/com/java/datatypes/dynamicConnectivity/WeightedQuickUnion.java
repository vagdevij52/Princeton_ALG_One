package com.java.datatypes.dynamicConnectivity;

//Improvement - 1 - Weighing - To ease up find
public class WeightedQuickUnion {
	
	private int[] id;
	private int[] sz;
	public WeightedQuickUnion(int N) {
		id = new int[N];
		sz = new int[N];
		for(int i=0;i<N;i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	public int root(int r) {
		while(r!=id[r]) {
			r=id[r];
		}
		return r;
	}
	
	public boolean connected(int p,int q) {
		return root(p)==root(q);
	}
	
	public void union(int p,int q) {
		int i = root(p);
		int j = root(q);
		//if(i=j) return;
		if(sz[i]<sz[j]) {
			id[i] = j;
			sz[j]+=sz[i];
		}else {
			id[j] = i;
			sz[i]+=sz[j];
		}
	}

	public static void main(String[] args) {
		WeightedQuickUnion obj = new WeightedQuickUnion(10);
		obj.union(4, 3);
		obj.union(3, 8);
		obj.union(6, 5);
		obj.union(9, 4);
		obj.union(2, 1);
		obj.union(5, 0);
		obj.union(7, 2);
		obj.union(6, 1);
		obj.union(7, 3);
		if(obj.connected(4, 3))
			System.out.println("Connected");
		else
			System.out.println("Not Connected");
		if(obj.connected(9, 2))
			System.out.println("Connected");
		else
			System.out.println("Not Connected");

	}

}
