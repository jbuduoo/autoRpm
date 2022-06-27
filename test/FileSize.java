package jb.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;

public class FileSize {

	public static void main(String[] args) {
		try {
			String filesSize = openFileToGetSize("D:\\亞森特文件\\CSOrigin");
			System.out.println(filesSize);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 對文件夾進來遞回，取得每個檔案的大小並加總
	 * 
	 * @throws IOException
	 */
	public static String openFileToGetSize(String sourcePath) throws IOException {

		long size = 0;
		File start = new File(sourcePath);
		String[] filePath = start.list(); // 获取该文件夹下的所有文件以及目录的名字

		for (String temp : filePath) {
			// 查看其数组中每一个是文件还是文件夹
			if (new File(sourcePath + "/" + temp).isDirectory()) {
				// 为文件夹，进行递归
				openFileToGetSize(sourcePath + "/" + temp);
			} else {
				// 取得檔案大小
				size += getFileSize(sourcePath + "/" + temp);
			}
		}

		return FormetFileSize(size);
	}

	/**
	 * 取得檔案大小
	 * 
	 * @param sourcePath
	 * @return
	 * @throws IOException
	 */
	public static long getFileSize(String sourcePath) throws IOException {
		long size = 0;
		FileChannel fc = null;
		try {
			File f = new File(sourcePath);
			if (f.exists() && f.isFile()) {
				FileInputStream fis = new FileInputStream(f);
				fc = fis.getChannel();
				size = fc.size();
				System.out.println(sourcePath + ":" + fc.size());
			} else {
				System.out.println("file doesn't exist or is not a file");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (null != fc) {
				try {
					fc.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
		return size;

	}

	/**
	 * 轉換檔案大小
	 *
	 * @param fileS
	 * @return
	 */
	private static String FormetFileSize(long fileS) {
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		String wrongSize = "0B";
		if (fileS == 0) {
			return wrongSize;
		}
		if (fileS < 1024) {
			fileSizeString = df.format((double) fileS) + "B";
		} else if (fileS < 1048576) {
			fileSizeString = df.format((double) fileS / 1024) + "KB";
		} else if (fileS < 1073741824) {
			fileSizeString = df.format((double) fileS / 1048576) + "MB";
		} else {
			fileSizeString = df.format((double) fileS / 1073741824) + "GB";
		}
		return fileSizeString;
	}

}
