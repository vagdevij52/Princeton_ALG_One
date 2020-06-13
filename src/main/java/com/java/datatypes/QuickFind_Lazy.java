package com.java.datatypes;

public class QuickFind_Lazy {

	private int[] id;
	public QuickFind_Lazy(int N) {
		id = new int[N];
		for(int i=0;i<N;i++) {
			id[i] = i;
		}
	}
	public boolean connected(int p,int q) {
		return id[p]==id[q];
	}
	
	public void union(int p,int q) {
		int pid=id[p];
		int qid=id[q];
		if(pid!=qid) {
			for(int i=0;i<id.length-1;i++) {
				if(id[i]==pid)
					id[i]=qid;
			}
		}
	}
	public static void main(String[] args) {
		QuickFind_Lazy obj= new QuickFind_Lazy(10);
		obj.union(4, 3);
		obj.union(3, 8);
		obj.union(6, 5);
		obj.union(9, 4);
		obj.union(2, 1);
		obj.union(5, 0);
		obj.union(7, 2);
		obj.union(6, 1);
		if(obj.connected(8, 9))
		System.out.println("They are connected");
		else
			System.out.println("They are not connected");
		if(obj.connected(5, 0))
			System.out.println("They are connected");
			else
				System.out.println("They are not connected");
	}

}

