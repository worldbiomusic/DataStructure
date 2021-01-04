package com.wbm.datastructure.Tree;

import com.wbm.datastructure.Tree.interfaces.Heap;
import com.wbm.datastructure.sort.Sort;

public class HeapWithArrayApp implements Heap {
    int[] arr; // [0]은 인덱스 계산이 안되므로 사용안함
    int increment;
    int count;
    int size;

    public HeapWithArrayApp() {
	this.size = 10;
	this.arr = new int[this.size];
	this.increment = 10;
	this.count = 0;
    }

    @Override
    public void insert(int key) {
	this.count++;
	if (this.count == this.size) {
	    this.increaseArraySize();
	}

	int countCopy = this.count;
	while (countCopy > 1) {
	    int parentKey = this.arr[countCopy / 2];

	    if (key > parentKey) {
		this.arr[countCopy] = parentKey;
	    } else {
		break;
	    }

	    countCopy /= 2;
	}

	this.arr[countCopy] = key;
    }

    @Override
    public int delete() {
	if (this.count == 0) {
	    // 비어있을때
	    return -999;
	}
	int rootKey = this.arr[1];
	int travelKey = this.arr[this.count];
	this.count--;

	int index = 2;
	int lastIndex = 1;
	while (index <= this.count) {
	    if ((index + 1 <= this.count) && (this.arr[index] < this.arr[index + 1])) {
		index++;
	    }

	    if (travelKey >= arr[index]) {
		break;
	    }
	    this.arr[lastIndex] = arr[index];
	    lastIndex = index;
	    index *= 2;
	}

	this.arr[lastIndex] = travelKey;

	return rootKey;
    }

    private void increaseArraySize() {
	int[] tmpArr = new int[this.size + this.increment];
	this.size += this.increment;

	for (int i = 1; i < this.arr.length; i++) {
	    tmpArr[i] = this.arr[i];
	}

	this.arr = tmpArr;
    }

    public void inorderTraversal() {
	this.inorder(1);
    }

    private void inorder(int index) {
	if (index <= this.count) {
	    this.inorder(index * 2);
	    System.out.print(this.arr[index] + " ");
	    this.inorder((index * 2) + 1);
	}
    }

    public void heapify() {
	/*
	 * 내부 힙 정렬
	 */

//	int targetNode = 1;
//
//	for (int i = this.count / 2; i >= 1; i--) {
//	    for (int j = i*2; i <= count; ) {
//		if(this.arr[i] < this.arr[j]) {
//		    Sort.swap(this.arr, i, j*2);
//		    j *= 2;
//		} else if(this.arr[i] < this.arr[j+1]) {
//		    Sort.swap(this.arr, i, (j*2)+1);
//		    j = (j * 2) + 1;
//		} 
//	    }
//	}

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
