package per.mori.common;

import org.springframework.util.Assert;

import java.util.InputMismatchException;
import java.util.List;

public class SortUtil {

    /**
     * <p>
     * 快速排序：
     * <p>
     * 选取基准值(一般左边第一个值)，
     * 然后先从右边(先从右边，先从右边，先从右边)开始找到小于基准值的值，记录位置j
     * 再然后从左边开始找到大于基准值的值，记录位置为i。然后交换两值的位置(i，j指向位置不变)
     * 继续从右开始上面的动作直到i==j为止，然后基准值与i的值交换位置
     * 然后再将基准值此时位置的左边和右边的数组递归上面的动作直到整个数组都是有序的
     *  不稳定
     * 56 28 45 93 10 32 44 95 60 58
     * 56 28 45 44 10 32 93 95 60 58
       56 28 45 44 10 （） 93 95 60 58


      5 4 3 2 1 i=0  j =4

      1 4 3 2 | 5

      1| 4 3 2 i=0 j=0

      4 3 2  i=2 j=2

      2 3 | 4

      2 3



   */
    public static Integer[] quickSort(Integer[] input,int left,int right) {
        Assert.isTrue(input!=null&&input.length>=2,"请输入非空数组,且长度大于等于2");
        if(left>=right)
            return input;

        int i=left;
        int j=right;
        int temp=input[i];
        int swapTemp;

        while(i!=j){

            while(input[j]>=temp&&j>i){
                j--;
            }

            while (input[i]<=temp&&i<j){
                i++;
            }

            if(i<j){
                swapTemp=input[i];
                input[i]=input[j];
                input[j]=swapTemp;
            }

        }

        input[left]=input[i];
        input[i]=temp;
        quickSort(input,left,i-1);
        quickSort(input,i+1,right);
        return input;
    }

    /**
     * 冒泡排序  稳
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

     最外层循环代表排序趟数：n-1趟即可  最后一趟不需要 就一个数字肯定最大
     内循环每次是size-1-已经冒泡的数目（外循环数目
     */

    //n^2
    public static void bubbleSort(Integer[] numbers)
    {
        int temp = 0;
        int size = numbers.length;
        for(int i = 0 ; i < size-1; i ++)//n-1
        {
            for(int j = 0 ;j < size-1-i ; j++)//(n-1)+(n-2)+...+1  n*(n-1)/2
            {
                if(numbers[j] > numbers[j+1])  //交换两数位置
                {
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
               }
            }
        }
    }

    /***
     * 选择排序
     *  2 5 4 3 1
     *  不稳定
     * */
    public static void chooseSort(Integer[] input){
        Assert.isTrue(input!=null&&input.length>0,"请输入合法数组");
        int temp;
        int length=input.length;
        for(int i=0;i<length-1;i++){
            int minIndex=i;
            for(int j=length-1;j>i;j--){
                if(input[j]<input[minIndex]){
                    minIndex=j;
                }
            }

            if(minIndex!=i){
                temp=input[minIndex];
                input[minIndex]=input[i];
                input[i]=temp;

            }
        }
    }

    /**
     * 插入排序
     *
     *
     */
    public static void insertSort(Integer [] input){
        int length=input.length;
        int temp;
        for(int i=0;i<length-1;i++){

            for(int j=i+1;j>0;j--){

                if(input[j]<input[j-1]){
                    temp=input[j];
                    input[j]=input[j-1];
                    input[j-1]=temp;
                }else {
                    //假设前面都排序好了
                    break;
                }

            }

        }

    }


    public static void shellSort(Integer [] input){
        int length=input.length;
        int temp;
        int incre=length;
        while(true){
             incre=incre/2;
            for(int k=0;k<incre;k++){

                for(int i=k;i<length-incre;i+=incre){

                    for (int j=i+incre;j>k;j-=incre){
                        if(input[j]<input[j-incre]){
                            temp=input[j];
                            input[j]=input[j-incre];
                            input[j-incre]=temp;

                        }else{
                            break;
                        }
                    }

                }
            }
            if(incre==1){
                break;
            }
        }
    }

    public static void mergeSort(Integer[] input,Integer first,Integer last,Integer [] temp){

        if(first<last){
            int middle=(first+last)/2;
            mergeSort(input,first,middle,temp);
            mergeSort(input,middle+1,last,temp);
            mergeArray(input,first,middle,last,temp);
        }
    }

    private static void mergeArray(Integer[] input, Integer first, int middle, Integer last, Integer[] temp) {
        int i=first;
        int i_e=middle;
        int j=middle+1;
        int j_e=last;
        int k=0;

        while(i<=i_e&&j<=j_e){
            if(input[i]<=input[j]){
                temp[k]=input[i];
                i++;
                k++;
            }else{
                temp[k]=input[j];
                j++;
                k++;
            }
        }

        while(i<=i_e){
            temp[k]=input[i];
            i++;
            k++;
        }

        while (j<=j_e){
            temp[k]=input[j];
            j++;
            k++;
        }


        for(int ii=0;ii<k;ii++){
            input[first+ii]=temp[ii];
        }

    }

    //合并数组

    public static void heapSort(Integer[] input,int n){
        int temp=0;
        BuildMinHeap(input,n);

        for(int i=n-1;i>0;i--){
            temp=input[0];
            input[0]=input[i];
            input[i]=temp;
            AdjustHeap(input,0,i);
        }
    }

    private static void AdjustHeap(Integer[] input, int i, int n) {
        int j=2*i+1;
        int temp=0;
        while(j<n){
            if(j+1<n&&input[j+1]<input[j]){
                j++;
            }

            if(input[i]<=input[j])
                break;

            temp=input[i];
            input[i]=input[j];
            input[j]=temp;

            i=j;
            j=2*i+1;
        }
    }

    private static void BuildMinHeap(Integer[] input, int n) {
        for(int i=n/2-1;i>=0;i--){
            AdjustHeap(input,i,n);
        }
    }

    public static void baseSort(){

    }

}
