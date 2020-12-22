package com.wbm.datastructure.sort;

public class Main {
    public static void main(String[] args) {
	int[] a = new int[10];
	for (int i = 0; i < a.length; i++) {
	    a[i] = (int)(Math.random() * 10 + 1);
	}
	
	// print raw data
	System.out.println("raw data");
	for (int i = 0; i < a.length; i++) {
	    System.out.print(a[i] + ", ");
	}
	System.out.println();
	
	SelectionSort selection = new SelectionSort(a);
	selection.printArray(selection.sort());
	
	BubbleSort bs = new BubbleSort(a);
	bs.printArray(bs.sort());
	
	InsertionSort is = new InsertionSort(a);
	is.printArray(is.sort());
	
	MergeSort mg = new MergeSort(a);
	mg.printArray(mg.sort());
	
    }
}
