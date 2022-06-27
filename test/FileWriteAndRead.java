package jb.com;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileWriteAndRead {

	public static void main(String[] args) {
    	String content="abcdefg\r\nadfasdfasdf\r\nadfasf";
    	String path="d:/target.txt";
    	//將檔案寫入到…
		writeTxt(path,content);
		//讀出檔案
		readTxt(path);
		
		
		
	}
	
	/**
	 * 寫入檔案成功
	 */
	public static void writeTxt(String path,String content) {
        try {

            FileWriter fw = new FileWriter(path);
            fw.write(content);
 
            fw.flush();
            System.out.println("Write Complete!");
            fw.close();
        } catch (Exception e) {
            System.out.println("Something Error");
        }
		
	}
	/**
	 * 讀出檔案成功
	 */
	public static void readTxt(String path) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                String content = br.readLine();
                System.out.println(content);
            }
             System.out.println("Read Complete!");
            // After used close.
            fr.close();
        } catch (Exception e) {
            System.out.println("Read Error");
        }	
	}	
	

}
