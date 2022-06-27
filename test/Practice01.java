package jb.com;
/**
 * 
 * 复制文件夹d:/java下面所有文件和子文件夹内容到d:/java2。
    提示：涉及单个文件复制、目录的创建、递归的使用
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Practice01{
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("From：");
//		String sourcePath = scanner.nextLine();
//		System.out.print("To：");
//		String newPath = scanner.nextLine();
		copyDir("D:\\TestData\\export", "D:\\TestData\\import\\abc");
	}
	
	//文件夹的拷贝
	public static void copyDir(String sourcePath, String newPath) {
		File start = new File(sourcePath);
		File end = new File(newPath);
		String[] filePath = start.list();		//获取该文件夹下的所有文件以及目录的名字
		if(!end.exists()) {
			end.mkdir();
		}
		for(String temp:filePath) {
			//查看其数组中每一个是文件还是文件夹
			if(new File(sourcePath+File.separator+temp).isDirectory()) {
				//为文件夹，进行递归
				copyDir(sourcePath+File.separator+temp, newPath+File.separator+temp);
			}else {
				//为文件则进行拷贝
				copyFile(sourcePath+File.separator+temp, newPath+File.separator+temp);
			}
		}
	}
	
	//文件的拷贝
	public static void copyFile(String sourcePath, String newPath) {
		File start = new File(sourcePath);
		File end = new File(newPath);
		try(BufferedInputStream bis=new BufferedInputStream(new FileInputStream(start));
			BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(end))) {
			int len = 0;
			byte[] flush = new byte[1024];
			while((len=bis.read(flush)) != -1) {
				bos.write(flush, 0, len);
			}
			bos.flush();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}