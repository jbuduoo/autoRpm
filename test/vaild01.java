package jb.com;

public class vaild01 {

	public static void main(String[] args) {
		valid16Bit30Char(null);
		valid16Bit30Char("");
		valid16Bit30Char("123bffffffffffffffffffffffffa");
		valid16Bit30Char("111111111111111111111111111111");
		valid16Bit30Char("11111111111111111111111111111t");
		valid16Bit30Char("abcdef123456789011121231123412");

	}

	/**
	 * 檢核16位元，30個字元
	 * 
	 * @param str
	 * @return
	 */
	public static boolean valid16Bit30Char(String str) {

		String regex = "^[A-Fa-f0-9]+$";
		if (str == null) {
			System.out.println("不得為null");
			return false;
		} else if (str.length() != 30) {
			System.out.println(str.toUpperCase() + ": 必須為30個字");
			return false;
		} else if (!str.matches(regex)) {
			System.out.println(str.toUpperCase() + ": 不是16進制數");
			return false;
		}else {
			System.out.println(str.toUpperCase() + ": 是16進制數");
			return true;			
		}

	}

}
