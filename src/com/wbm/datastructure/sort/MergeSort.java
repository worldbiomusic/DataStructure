package com.wbm.datastructure.sort;

public class MergeSort extends Sort {

    public MergeSort(int[] a) {
	super("MergeSort", a);
    }

    @Override
    public int[] sort() {
	this.mergeSort(a, 0, a.length - 1);

	return a;
    }

    void mergeSort(int[] a, int x, int y) {
	if (y - x > 0) {
	    int middle = (x + y) / 2;
	    this.mergeSort(a, x, middle);
	    this.mergeSort(a, middle + 1, y);
	    this.merge(a, x, y);
	}
    }

    void merge(int[] a, int start, int end) {
	int[] tmp = new int[a.length];
	int tmpIndex = start;

	int middle = (start + end) / 2;

	int s = start, e = middle + 1;
	while ((s <= middle) && (e <= end)) {
	    int sNum = a[s];
	    int eNum = a[e];

	    if (sNum < eNum) {
		tmp[tmpIndex++] = a[s++];
	    } else {
		tmp[tmpIndex++] = a[e++];
	    }

	}

	while (s <= middle) {
	    tmp[tmpIndex++] = a[s++];
	}

	while (e <= end) {
	    tmp[tmpIndex++] = a[e++];
	}

	this.copySrcToDst(tmp, a, start, end);
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
