package jb.com;

import java.util.HashMap;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class mapTest {

	public static void main(String[] args) {
		//1.3.6.1.4.1.57659.1.1008.1.3.1.2.3 = CH3]
		String str ="org.snmp4j.util.TableEvent[index=2.1,vbs=[1.3.6.1.4.1.57659.1.1008.1.3.1.2.1 = CH1],status=0,exception=null,report=null]\r\n"
				+ "org.snmp4j.util.TableEvent[index=2.2,vbs=[1.3.6.1.4.1.57659.1.1008.1.3.1.2.2 = CH2],status=0,exception=null,report=null]\r\n"
				+ "org.snmp4j.util.TableEvent[index=2.3,vbs=[1.3.6.1.4.1.57659.1.1008.1.3.1.2.3 = CH3],status=0,exception=null,report=null]\r\n"
				+ "org.snmp4j.util.TableEvent[index=2.4,vbs=[1.3.6.1.4.1.57659.1.1008.1.3.1.2.4 = CH4],status=0,exception=null,report=null]\r\n"
				+ "org.snmp4j.util.TableEvent[index=2.5,vbs=[1.3.6.1.4.1.57659.1.1008.1.3.1.2.5 = CH5],status=0,exception=null,report=null]";
		String[] strArray=str.split("\r\n");
		
		int index=str.indexOf("1008.1.3.1.")+11;
		int indexEnd=str.indexOf("],");
		String str2=str.substring(index,indexEnd);
	
		
		String str="2.1 = CH1@"
				+ "2.2 = CH2\r\n"
				+ "2.3 = CH3\r\n"
				+ "2.4 = CH4\r\n"
				+ "2.5 = CH5\r\n"
				+ "2.6 = CH6\r\n"
				+ "3.1 = 19200\r\n"
				+ "3.2 = 19210\r\n"
				+ "3.3 = 19220\r\n"
				+ "3.4 = 19230\r\n"
				+ "3.5 = 19240\r\n"
				+ "5.1 = 1";
		str=str.replaceAll("\\.", ",");
		str=str.replaceAll("=", ",");
		str=str.replaceAll(" ", "");
		//2,1,CH1 \r\n
		//2,2,CH2
		
		String[] strArray=str.split("\r\n");
		
		HashMap<String,HashMap> map=new HashMap<>();
		
		//存入名字與數字對應
		HashMap<String,String> map2=new HashMap<>();
		for(int i=0;i<strArray.length;i++){
			String[] strArray2=strArray[i].split(",");
			//System.out.println("111"+strArray2[0]);
			if(strArray2[0].equals("2")) {
				//存入名字與數字
				map2.put(strArray2[1],strArray2[2]);
				
				//將map3放入到map中。(存入名字和map3)
				HashMap<String,String> map3=new HashMap<>();
				map.put(strArray2[2],map3);
			}
		}
		
		
		for(int i=0;i<strArray.length;i++){
			String[] strArray2=strArray[i].split(",");
			if(!strArray2[0].equals("2")){
				//取得map中的名字對應
				String name=map2.get(strArray2[1]);
				//取得該map
				HashMap<String,String> map3=map.get(name);

					if(strArray2[0].equals("3")){
						map3.put("ITUWavelength",strArray2[2]);
					}else if(strArray2[0].equals("4")){
						map3.put("ChannelEnable",strArray2[2]);	
					}
			}
		}
		
		System.out.println(map.toString());

	}

}
