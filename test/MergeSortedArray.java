package jb.com;

public class MergeSortedArray {

	
	public static void main(String[] args) {
		int[]a= {6,2,0,0,0};
		int[]b={3,3,9};
		merge(a,2,b,3);
//		addBinary("10101","1111111");
	}
	
	
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	System.out.println("hello");
        for(int i=m;i<m+n;i++) {
        	nums1[i]=nums2[i-m];
        }
        sort(nums1);
    }
    
	//排序法
    static int[] sort(int[] input){
		
		int length = input.length;//要排列的數字長度
	    int temp;//前面數字>後面數字時兩個會互換位置,此時需要此變數
	    
        //每個數字都要比對
	    for(int i=0;i<length;i++){
	    	
	    	for(int j=0;j<length-1;j++){
	    	   
	    	   //比大小,if 前>後 換位
	    	   if(input[j]>input[j+1]){
	    		   
	    		  temp = input[j];//前面數字先存到變數
	    		  input[j] = input[j+1];//後面數字取代前面數字
	    		  input[j+1] = temp; //將變數(前面數字)存到後面變數
	    		
	    	   }

	    	}
	    	
	    }
		return input;
     }
}
