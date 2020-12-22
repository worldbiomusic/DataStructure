package com.wbm.datastructure.sort;

public class SelectionSort extends Sort{

    public SelectionSort(int[] a) {
	super("SelectionSort", a);
    }

    @Override
    public int[] sort() {
	for (int i = 0; i < a.length - 1; i++) {
	    int minIndex = i;
	    for (int j = i; j < a.length; j++) {
		if(a[j] < a[minIndex]) {
		    minIndex = j;
		}
	    }
	    this.swap(a, i, minIndex);
	}
	return a;
    }
}
