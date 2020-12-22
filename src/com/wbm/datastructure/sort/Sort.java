package com.wbm.datastructure.sort;

public abstract class Sort {
    protected String sortName;
    protected int[] a;

    public Sort(String sortName, int[] array) {
	this.sortName = sortName;
	this.a = array.clone();
    }

    public abstract int[] sort();

    public void printArray(int[] a) {
	System.out.println("[ " + this.sortName + " ]");
	for (int i = 0; i < a.length; i++) {
	    if (i == a.length - 1) {
		System.out.print(a[i]);
	    } else {
		System.out.print(a[i] + ", ");
	    }
	}
	System.out.println();
    }

    public void swap(int[] a, int x, int y) {
	int xValue = a[x];
	a[x] = a[y];
	a[y] = xValue;
    }

    public void shiftToRight(int[] a, int amount, int x, int y) {
	/*
	 * 배열의 x~y까지를 amount만큼 오른쪽으로 이동
	 */
	int length = y - x + 1;
	for (int i = 0; i < length; i++) {
	    int index = y - i;
	    a[index + amount] = a[index];
	}

	/*
	 * 예) 2 4까지 오른쪽으로 2 옮김 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 4 7 8 9 0 1 2 3 4 3 4 7 8
	 * 9 0 1 2 3 2 3 4 7 8 9
	 */
    }

    public void copySrcToDst(int[] src, int[] dst, int start, int end) {
	for (int i = start; i <= end; i++) {
	    dst[i] = src[i];
	}
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
