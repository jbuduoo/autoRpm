package jb.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class WinScript {

	public static void main(String[] args) {
        String cmd = "C:\\Windows\\System32\\netstat.exe -ano";
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            InputStream is = (InputStream) process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String content = br.readLine();
            String pidStr="";
            while (content != null) {
                content = br.readLine();
                if(content !=null && content.contains("[::]:8080")) {
                	pidStr=content;
                    System.out.println(content);
                    break;
                }
            }
            String[] pidArray=pidStr.split(" ");
            String pid=pidArray[pidArray.length-1];
            process = Runtime.getRuntime().exec("taskkill -f -pid "+pid);
            is = (InputStream) process.getInputStream();
            isr = new InputStreamReader(is);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
