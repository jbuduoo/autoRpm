package jb.com;

public class Sqrt {
	
	public static void main(String[] args) {
		mySqrt(2147483647);

	}
    public static int mySqrt(int x) {
        long i=1;
    	while(true) {
        	if((int)i*i==x) {
        		System.out.println(""+i);
        		return (int)i;
        	}else if((int)i*i>x) {
        		System.out.println(""+i);
        		return (int)i-1;
        	}
        	i++;
        }
    }
}
