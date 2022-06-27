package jb.com;

//主管說沒有要用，就做一半吧!!沒有研究透徹。
public class VaildHttp {

	public static void main(String[] args) {
		validHttp("http://www.wretch.cc/blog/attz");	
		validHttp("http://www.yahoo.com.tw/aa");
		validHttp("http://www.wretch.cc/blog/attz");	
		
	}
	public static boolean validHttp(String httpstr) {

		String regex = "^((http[s]?|ftp):\\/)?\\/?([^:\\/\\s]+)((\\/\\w+)*\\/)([\\w\\-\\.]+[^#?\\s]+)(.*)?(#[\\w\\-]+)?$";
		if (httpstr == null) {
			System.out.println("不得為null");
			return false;
		} else if (!httpstr.matches(regex)) {
			System.out.println(httpstr + ": 不是網址");
			return false;
		}else {
			System.out.println(httpstr + ": 是網址");
			return true;			
		}

	}
}
