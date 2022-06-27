package jb.com;

import java.io.File;

public class DelDir {

	public static boolean main(String[] args) {
		String sourceFolder = "d:/abc/def/ghi";
		
		File delDir = new File(sourceFolder);
		//刪除資料夾內的東西
        if(delDir.isDirectory() == true) {
	        File[] listFiles = delDir.listFiles();
	        for(File file : listFiles){
	        	if(file.toString().contains("txt") || file.toString().contains("ism")  ) {
	        		file.delete();
    	        	System.out.println("delfile:"+file);
	        	}    	            
	        }
	        delDir.delete();
        }
        //刪除空的資料夾
		while (true) {
			int index01 = sourceFolder.lastIndexOf("/");
			sourceFolder = sourceFolder.substring(0, index01);
			System.out.println(sourceFolder);
			File dir = new File(sourceFolder);
			if (dir.isDirectory() == true) {

				File[] listFiles = dir.listFiles();
				if (listFiles.length == 0) {
					dir.delete();
				} else {
					return true;
				}
			}
		}

	}

}
