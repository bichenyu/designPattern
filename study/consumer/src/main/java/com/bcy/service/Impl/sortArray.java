package com.bcy.service.Impl;

public class sortArray {
    public static void main(String[] args) {
        int[] arr = {6, 5, 7, 3, 7,10};
        // bubbleSort(arr);
        //switchSort(arr);
        //insertSort(arr);
//        mergeSort(arr);
        heapSort(arr);
        //quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }

    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean change = false;
            for (int j = 1; j < arr.length - i; j++) {//第二次优化
                if (arr[j] <= arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    change = true;
//                    tempposition=j;
                }
                System.out.format("第 %d 趟的第%d 次交换：", i + 1, j);
                for (int count : arr) {
                    System.out.print(count);
                    System.out.print(" ");
                }
            }
            if (!change) {
                break;
            }
            System.out.format("第 %d 趟的最终结果：", i + 1);
            for (int count : arr) {
                System.out.print(count);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    /**
     * 不是稳定排序
     **/
    private static void switchSort(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            int minPosition = j;
            int min = arr[j];
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    minPosition = i;
                }
            }
            int temp = arr[j];
            arr[j] = min;
            arr[minPosition] = temp;
            System.out.println("当前最小的值:" + min);
            System.out.println("当前最小的位置：" + minPosition);
            System.out.format("第 %d 次排序结果：", j);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                System.out.print(" ");
            }
        }
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //与前一个数比较，前面已经是有序的
            int e = arr[i];
            int j;
            for (j = i; j > 0 && e < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    /*归并排序*/
    private static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);

    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if(left == right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(arr, left, mid, temp);
        sort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);

    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid+1;
        int t = 0;
        while (i <= mid && j <=right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];

        }
        while (j <= right) {
            temp[t++] = arr[j++];

        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
        System.out.println("left is"+left);
        for (int m = 0; m < arr.length; m++) {
            System.out.print(arr[m]);
            System.out.print(" ");
        }
        System.out.println("");
    }
    /*快速排序*/
    private static void quickSort(int[] arr){
        actualQuickSort(arr,0,arr.length-1);
    }
    private static void actualQuickSort(int[] arr,int left,int right) {
        if (left < right) {
            int index = partion(arr, left, right);
            actualQuickSort(arr, left, index-1);
            actualQuickSort(arr, index + 1, right);
        }
    }
    private static int partion(int[] arr,int left,int right){
        // 设定基准值（pivot）
        int pivot = arr[left];
        int i=left;
        int j=right;
        int s = 0,e = 0;
        while(i!=j){
            while(i<j && arr[j]>=pivot){
                j--;
            }
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,left,i);
        return i;
        }




//        System.out.println("swap前 ");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//            System.out.print(" ");
//        }
//        swap(arr, pivot, index - 1);
//        System.out.println("swap后 ");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//            System.out.print(" ");
//        }
//        System.out.println(" ");
//        return index - 1;

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 堆排序 非稳定
     */
    public static void heapSort(int[] arr){
        //1.构建堆
        for (int i = arr.length/2-1; i >0; i--) {
            adjust(arr,i,arr.length);
        }
        //2.调整堆
        for (int k = arr.length -1; k >0 ; k--) {
            swap(arr,k,0);
            adjust(arr,0,arr.length);//重新调整

        }
        //3.交换堆顶的堆尾的数
    }
    public static void adjust(int[] arr,int i,int length){
        int temp=arr[i];
        for (int j = 2*i+1; j <length ; j++) {//从左子节点开始
            if(j+1<length && arr[j]<arr[j+1]){
                j++;
            }
            if(arr[j]>temp){
                arr[i]=arr[j];
                i=j;
            }
            else{
                break;
            }
        }
        arr[i]=temp;
    }


}
