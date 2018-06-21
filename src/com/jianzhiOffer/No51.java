package com.jianzhiOffer;

/**
 * 数组中的逆序对
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 *
 * Created by 林智 on 2018/6/21.
 */
public class No51 {

    /**
     * 利用归并排序的思路来解
     * 代码过不了牛客的 OJ, 逻辑是对的, 应该是大数没处理好,
     * 与过了 OJ 的代码用比较器跑了五万组都是没问题的
     */
    public static int InversePairs(int [] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        return mergeSort(array, 0, array.length - 1);
    }

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int index = help.length - 1; // help 数组最后一个位置的下标
        int p1 = m; // 前半段最后一个数字的下标
        int p2 = r;     // 后半段最后一个数字的下标
        int count = 0;
        while (p1 >= l && p2 >= m + 1) {
            if (arr[p1] > arr[p2]) {
                help[index--] = arr[p1--];
                count += p2 - m;
            } else {
                help[index--] = arr[p2--];
            }
        }
        while (p1 >= l) {
            help[index--] = arr[p1--];
        }
        while (p2 >= m + 1) {
            help[index--] = arr[p2--];
        }

        for (int i = 0; i < help.length; i++) {
            arr[i + l] = help[i];
        }

        return count;
    }

    public static int InversePairs2(int [] array) {
        if(array==null||array.length==0)
        {
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i=0;i<array.length;i++)
        {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array,copy,0,array.length-1);//数值过大求余
        return count;

    }

    private  static int InversePairsCore(int[] array,int[] copy,int low,int high)
    {
        if(low==high)
        {
            return 0;
        }
        int mid = (low+high)>>1;
        int leftCount = InversePairsCore(array,copy,low,mid)%1000000007;
        int rightCount = InversePairsCore(array,copy,mid+1,high)%1000000007;
        int count = 0;
        int i=mid;
        int j=high;
        int locCopy = high;
        while(i>=low&&j>mid)
        {
            if(array[i]>array[j])
            {
                count += j-mid;
                copy[locCopy--] = array[i--];
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
            }
            else
            {
                copy[locCopy--] = array[j--];
            }
        }
        for(;i>=low;i--)
        {
            copy[locCopy--]=array[i];
        }
        for(;j>mid;j--)
        {
            copy[locCopy--]=array[j];
        }
        for(int s=low;s<=high;s++)
        {
            array[s] = copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50000; i++) {
            int[] arr1 = generateRandomArray(1000, 1000);
            int[] arr2 = copyArray(arr1);
            if (InversePairs(arr1) != InversePairs2(arr2)) {
                //printArray(arr1);
                //printArray(arr2);
                System.out.println("failed");
            }
        }
    }
}
