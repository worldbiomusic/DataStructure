package com.wbm.datastructure.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class RadixSort extends Sort{

    public RadixSort(int[] array) {
	super("RadixSort", array);
    }

    @Override
    public int[] sort() {
	
	// Queue bucket들 초기화
	List<Queue<Integer>> queues = new ArrayList<>();
	for (int i = 0; i < 10; i++) {
	    queues.add(new LinkedList<>());
	}
	
	// QuickSort에서 가장 큰값 가져오기 (radix설정에 필요)
	int max = new QuickSort(this.a).sort()[this.a.length-1];
	
	int radix = 1;
	while((max / (radix)) != 0) {
	    
	    // radix sort
	    for(int i = 0; i < this.a.length; i++) {
		int e = this.a[i];
		// 먼저 radix자릿수를 1의 자리로 만들기
		int queueIndex = e / radix;
		// 1의자리만 뽑아내기
		queueIndex %= 10;
		queues.get(queueIndex).add(e);
	    }
	    
	    // radix자릿수로 정렬된 bucket에서 꺼내서 배열에 넣기
	    int index=0;
	    for(Queue<Integer> q : queues) {
		for(int e : q) {
		    this.a[index++] = e;
		}
		q.clear();
	    }
	    
	    // 자릿수 증가
	    radix *= 10;
	}
	
	return this.a;
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
