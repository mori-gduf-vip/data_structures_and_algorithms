package per.mori.study.offer;

import org.junit.Test;
import per.mori.common.SearchUtil;
import per.mori.common.SortUtil;

import java.util.Arrays;
import java.util.List;

public class DuplicationInArray {
    /**n长度的数组，数字范围0-n-1，
     * 请找数组中任意重复的数字*/
    private Integer[] input={2,1,3,0,2,5,3};
    private Integer[] result={2,3};
    @Test
    //解法1
    private void soluction1(){
        //给定数组和答案
        List<Integer> afterSort= Arrays.asList(SortUtil.quickSort(input,0,input.length-1));
        //Assert判断解法
    }

    //解法2

    //解法3

}
