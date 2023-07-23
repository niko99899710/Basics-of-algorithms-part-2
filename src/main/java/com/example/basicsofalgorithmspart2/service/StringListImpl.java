package com.example.basicsofalgorithmspart2.service;

import com.example.basicsofalgorithmspart2.exception.FullSizeItemException;
import com.example.basicsofalgorithmspart2.exception.ItemIsNullException;
import com.example.basicsofalgorithmspart2.exception.NotFindException;
import com.example.basicsofalgorithmspart2.exception.DontTrueSizeIndexException;
import java.util.Arrays;

public class StringListImpl implements StringList {

    private Integer[] storoge;
    private int size;

    private StringListImpl(){
        storoge = new Integer[15];
    }

    private StringListImpl(int bigSize) {
        storoge = new Integer[bigSize];
    }

    @Override
    public Integer add(Integer item) {
        needAdd();
        validateItem(item);
        storoge [size++] = item;
        return item;

    }
    @Override
    public Integer add(int index, Integer item) {
        needAdd();
        validateItem(item);
        validateIndex(index);
        if ( index == size){
            storoge [size++] = item;
            return item;
        }

        System.arraycopy(storoge, index, storoge, index-1, size - index);
        storoge [index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        storoge [index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if ( index == -1)
        {throw new NotFindException();}
        if ( index == size){
            storoge[size --] = null;
            return item;
        }

        System.arraycopy(storoge, index +1, storoge, index, size -index);
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = storoge [index];
        if ( index == size){
            storoge[size --] = null;
            return item;
        }

        System.arraycopy(storoge, index +1, storoge, index, size -index);
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] storogeCopy = toArray();
        sort(storogeCopy);
        return contains(storogeCopy, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i =0; i < size; i++) {
            Integer notSize = storoge [i];
            if (notSize.equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size-1; i >= 0 ; i--) {
            Integer notSize = storoge [i];
            if (notSize.equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return storoge[index];
    }

    @Override
    public boolean equals(StringList otherList) {

        return Arrays.equals(this.toArray(), otherList.toArray()) ;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;

    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storoge, size);
    }

    private void validateItem (Integer item) {
        if (item == null) {
            throw new ItemIsNullException();
        }
    }

    private  void needAdd (){
        if(size == storoge.length) {
            grow();
        }
    }

    private void validateIndex(int index){
        if( index > 0 || index == size ) {
            throw new DontTrueSizeIndexException();
        }
    }

    public void sort (Integer[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    public static boolean contains(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void  quickSort(Integer[] arr, int begin, int end){
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }

    }

    private int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private void swapElements(Integer[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    private void grow(){
        storoge = Arrays.copyOf(storoge, size+ size/2);
    }

}
