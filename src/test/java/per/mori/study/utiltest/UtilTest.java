package per.mori.study.utiltest;

import org.junit.Test;
import per.mori.common.SortUtil;

import java.util.Arrays;
import java.util.List;

public class UtilTest {
    private Integer[] input={2,1,3,0,2,5,3};
    private Integer[] input1={10,9,8,7,6,5,4,3,2,1};
    private Integer[] input2={1,2,3,4,5,6,7,8,9,10};
    private Integer[] input4={5,4,3,2,1};


    @Test
    //解法1
    public void testSort(){
//      SortUtil.bubbleSort(input);
//      SortUtil.quickSort(input,0,input.length-1);
//      SortUtil.quickSort(input4,0,input4.length-1);
//      SortUtil.quickSort(input4,0,input4.length-1);
//      SortUtil.shellSort(input);
//        SortUtil.shellSort(input1);
        Integer[] temp=new Integer[10];
//        SortUtil.mergeSort(input,0,input.length-1,temp);
//        SortUtil.mergeSort(input1,0,input1.length-1,temp);
            SortUtil.heapSort(input,input.length);
            SortUtil.heapSort(input1,input1.length);
      System.out.println("-");
    }

    //解法2

    //解法3

}
