package com.wbm.datastructure.sort;

public class ShellSort extends Sort {

    public ShellSort(int[] array) {
	super("ShellSort", array);
    }

    @Override
    public int[] sort() {
	int interval = this.a.length / 2;

	while (interval != 0) {
	    this.sortWithInterval(interval);
	    interval /= 2;
	}

	return this.a;
    }

    void sortWithInterval(int interval) {
	for (int i = 0; i < interval; i++) {
	    // 1.interval간격마다 떨어져있는 정렬해야 할 원소를 모두 tmpArray에 넣기
	    int[] tmpArray = new int[this.a.length / interval];
	    int index = 0;
	    for (int j = i; j < a.length; j += interval) {
		tmpArray[index++] = (this.a[j]);
	    }
	    // 2.tmpArray만 기존의 InsertionSort로 삽입정렬
	    InsertionSort is = new InsertionSort(tmpArray);
	    tmpArray = is.sort();

	    // 3.tmpArray에 있었던 원소들을 다시 interval간격만큼 각 위치에 맞게 다시 넣기
	    index = 0;
	    for (int j = i; j < a.length; j += interval) {
		this.a[j] = tmpArray[index++];
	    }
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
