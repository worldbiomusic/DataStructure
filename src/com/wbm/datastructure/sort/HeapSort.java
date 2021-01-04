package com.wbm.datastructure.sort;

import com.wbm.datastructure.Tree.HeapWithArrayApp;

public class HeapSort extends Sort {

    public HeapSort(int[] array) {
	super("HeapSort", array);
    }

    @Override
    public int[] sort() {
	HeapWithArrayApp heap = new HeapWithArrayApp();
	for (int e : this.a) {
	    heap.insert(e);
	}

	for (int i = a.length - 1; i >= 0; i--) {
	    int max = heap.delete();
	    this.a[i] = max;
	}

	return this.a;
    }

}
