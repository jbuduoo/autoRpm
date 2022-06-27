package jb.com;

public class Add {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addBinary("100","110010");
//		addBinary("10101","1111111");
	}
	public static String addBinary(String a, String b)
    {
		String c="";
		
		//讓a的長度保持最長的。
		if(b.length()>a.length()) {
			String temp=b;
			b=a;
			a=temp;
		}		
		
		//讓ab一樣長
		if(a.length()>b.length()) {
			int length=a.length()-b.length();			
			for(int i=0;i<length;i++) {
				b="0"+b;
			}

		}
		
		//讓c和他們一樣長
		for(int i=0;i<a.length();i++) {
			c="0"+c;
		}
		System.out.println(a);
		System.out.println(b);	
		System.out.println(c);	
		
		char[] aChar=a.toCharArray();
		char[] bChar=b.toCharArray();
		char[] cChar=c.toCharArray();
		
		c="";

		//相加
		for(int i=a.length()-1;i>=0;i--) {
			if(Character.getNumericValue(aChar[i])
					+Character.getNumericValue(bChar[i])
					+Character.getNumericValue(cChar[i])==3) {
				if(i-1<0) {
					c="1";
				}else{
					cChar[i-1]='1';
				}				
				cChar[i]='1';
			}else if(Character.getNumericValue(aChar[i])
					+Character.getNumericValue(bChar[i])
					+Character.getNumericValue(cChar[i])==2) {
				if(i-1<0) {
					c="1";
				}else{
					cChar[i-1]='1';
				}
				cChar[i]='0';			
			}else if(Character.getNumericValue(aChar[i])
					+Character.getNumericValue(bChar[i])
					+Character.getNumericValue(cChar[i])==1) {
				cChar[i]='1';			
			}else if(Character.getNumericValue(aChar[i])
					+Character.getNumericValue(bChar[i])
					+Character.getNumericValue(cChar[i])==0) {
				cChar[i]='0';
			}			
		}

		c=c+String.valueOf(cChar);
		System.out.println("c:"+c);
        
        return c;
    }
}
