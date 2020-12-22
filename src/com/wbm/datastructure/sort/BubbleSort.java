package com.wbm.datastructure.sort;

public class BubbleSort extends Sort{
    public BubbleSort(int[] a) {
	super("BubbleSort", a);
    }

    @Override
    public int[] sort() {
	// i역할: 최대 검사 범위
	for (int i = a.length - 1; i >= 0; i--) {
	    // j역할: 차례대로 검사 순서
	    for (int j = 0; j < i; j++) {
		if(a[j] > a[j+1]) {
		    this.swap(a, j, j+1);
		}
	    }
	}
	return a;
    }
}
