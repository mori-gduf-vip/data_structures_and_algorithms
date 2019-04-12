package per.mori.common;

import java.util.List;


/**
 * 五大查找
 */
public class SearchUtil {

    public static int binSearch(int[] input,int key,int start,int end){
        int mid=(start+end)/2;
        if(start<=end){
            if(key ==input[mid]){
                return mid;
            }else if(key<input[mid]){
                return binSearch(input,key,start,mid-1);
            }else{
                return binSearch(input,key,mid+1,end);
            }
        }else{
            return -1;
        }
    }

}
