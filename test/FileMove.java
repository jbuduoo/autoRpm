package jb.com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileMove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path sourcePath      = Paths.get("D:\\testlogs/abc");
		Path destinationPath = Paths.get("D:\\testlogs/def");

		try {
		    Files.move(sourcePath, destinationPath,
		            StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
		    //moving file failed.
		    e.printStackTrace();
		}
		System.out.println("ok");
	}

}
