package com.wbm.datastructure.sort;

public class InsertionSort extends Sort {
    public InsertionSort(int[] a) {
	super("InsertionSort", a);
    }

    @Override
    public int[] sort() {
	/*
	 * 배열 1개만 사용
	 * 
	 * 0 ~ i-1까지는 정렬된 부분
	 * 
	 * i부터 length-1까지는 정렬할 부분
	 */
	for (int i = 0; i < a.length; i++) {
	    this.sortNumberFromStart(a, i);
	}

	return a;
    }

    void sortNumberFromStart(int[] a, int index) {
	int target = a[index];
	for (int j = 0; j < index; j++) {
	    // target보다 큰 수 만났으면 한칸씩 오른쪽으로 옮기고 큰 수 자리에 target삽입
	    if (target < a[j]) {
		this.shiftToRight(a, 1, j, index - 1);
		a[j] = target;
		break;
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
//
//
