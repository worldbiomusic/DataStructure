package com.wbm.datastructure.sort;

public class QuickSort extends Sort {

    public QuickSort(int[] a) {
	super("QuickSort", a);
    }

    @Override
    public int[] sort() {
	quickSort(0, this.a.length - 1);

	return this.a;
    }

    private void quickSort(int m, int n) {
	if (n <= m) {
	    return;
	}

	int pivot = partition(m, n);
	this.quickSort(m, pivot - 1);
	this.quickSort(pivot + 1, n);
    }

    private int partition(int m, int n) {
	int pivot = m;
	int j = m;
	int i = m + 1;

	int pivotNum = this.a[pivot];

	while (i <= n) {

	    if (this.a[i] <= pivotNum) {
		j += 1;
		swap(a, j, i);
	    }

	    i += 1;
	}

	swap(this.a, pivot, j);
	return j;
    }

}

//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
