package jb.com;

public class ClimbStairs {
	public static void main(String[] args) {
		
		climbStairs(3);
	}
	
	
    public static int climbStairs(int n) {
    	System.out.println("hello");
        if(n==1) return 1;
        if(n==2) return 2;
        
    	int[] type=new int[n];
        type[0]=1;type[1]=2;
        
        for(int i=2;i<n;i++) {
        	type[i]=type[i-1]+type[i-2];
        	System.out.println();
        }
        return type[n-1];
        
    }
}
