package com.java.datatypes.dynamicConnectivity;

public class QuickUnion_Lazy {
	
	private int[] id;
	public QuickUnion_Lazy(int N) {
		id = new int[N];
		for(int i=0;i<N;i++) {
			id[i]=i;
		}
	}
	
	private int root(int i) {
		while(i!=id[i])
			i=id[i];
		return i;
	}
	
	public boolean connected(int p,int q) {
		return root(p)==root(q);
	}
	
	public void union(int p,int q) {
		int proot = root(p);
		int qroot = root(q);
		id[p] = qroot;
	}

	public static void main(String[] args) {
		QuickUnion_Lazy obj = new QuickUnion_Lazy(10);
		obj.union(4, 3);
		obj.union(3, 8);
		obj.union(6, 5);
		obj.union(9, 4);
		obj.union(2, 1);
		obj.union(5, 0);
		obj.union(7, 2);
		obj.union(6, 1);
		//obj.union(7, 3);
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
