package jb.com;

import java.text.DecimalFormat;

public class GetVidioAudio {
	static String str = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
			+ "<!-- Created with Unified Streaming Platform  (version=1.11.3-24483) -->\r\n"
			+ "<smil xmlns=\"http://www.w3.org/2001/SMIL20/Language\">\r\n" + "  <head>\r\n"
			+ "    <meta name=\"clientManifestRelativePath\" content=\"all.ismc\" />\r\n"
			+ "    <meta name=\"creator\" content=\"Unified Streaming Platform (USP)\" />\r\n" + "  </head>\r\n"
			+ "  <body>\r\n" + "    <switch>\r\n"
			+ "      <audio src=\"BigBuckBunny_320x180.mp4\" systemBitrate=\"160000\">\r\n"
			+ "        <param name=\"trackID\" value=\"2\" valueType=\"data\" />\r\n"
			+ "        <param name=\"TimeScale\" value=\"48000\" valueType=\"data\" />\r\n"
			+ "        <param name=\"SamplingRate\" value=\"48000\" valueType=\"data\" />\r\n"
			+ "        <param name=\"Channels\" value=\"2\" valueType=\"data\" />\r\n"
			+ "        <param name=\"BitsPerSample\" value=\"16\" valueType=\"data\" />\r\n"
			+ "        <param name=\"PacketSize\" value=\"4\" valueType=\"data\" />\r\n"
			+ "        <param name=\"AudioTag\" value=\"255\" valueType=\"data\" />\r\n"
			+ "        <param name=\"FourCC\" value=\"AACL\" valueType=\"data\" />\r\n"
			+ "        <param name=\"CodecPrivateData\" value=\"1190\" valueType=\"data\" />\r\n" + "      </audio>\r\n"
			+ "      <audio src=\"big_buck_bunny_1080p_stereo.mp4\" systemBitrate=\"165417\">\r\n"
			+ "        <param name=\"trackID\" value=\"2\" valueType=\"data\" />\r\n"
			+ "        <param name=\"TimeScale\" value=\"48000\" valueType=\"data\" />\r\n"
			+ "        <param name=\"SamplingRate\" value=\"48000\" valueType=\"data\" />\r\n"
			+ "        <param name=\"Channels\" value=\"2\" valueType=\"data\" />\r\n"
			+ "        <param name=\"BitsPerSample\" value=\"16\" valueType=\"data\" />\r\n"
			+ "        <param name=\"PacketSize\" value=\"4\" valueType=\"data\" />\r\n"
			+ "        <param name=\"AudioTag\" value=\"255\" valueType=\"data\" />\r\n"
			+ "        <param name=\"FourCC\" value=\"AACL\" valueType=\"data\" />\r\n"
			+ "        <param name=\"CodecPrivateData\" value=\"1190\" valueType=\"data\" />\r\n" + "      </audio>\r\n"
			+ "      <audio src=\"big_buck_bunny_720p_stereo.mp4\" systemBitrate=\"165418\">\r\n"
			+ "        <param name=\"trackID\" value=\"2\" valueType=\"data\" />\r\n"
			+ "        <param name=\"TimeScale\" value=\"48000\" valueType=\"data\" />\r\n"
			+ "        <param name=\"SamplingRate\" value=\"48000\" valueType=\"data\" />\r\n"
			+ "        <param name=\"Channels\" value=\"2\" valueType=\"data\" />\r\n"
			+ "        <param name=\"BitsPerSample\" value=\"16\" valueType=\"data\" />\r\n"
			+ "        <param name=\"PacketSize\" value=\"4\" valueType=\"data\" />\r\n"
			+ "        <param name=\"AudioTag\" value=\"255\" valueType=\"data\" />\r\n"
			+ "        <param name=\"FourCC\" value=\"AACL\" valueType=\"data\" />\r\n"
			+ "        <param name=\"CodecPrivateData\" value=\"1190\" valueType=\"data\" />\r\n" + "      </audio>\r\n"
			+ "      <video src=\"BigBuckBunny_320x180.mp4\" systemBitrate=\"703000\">\r\n"
			+ "        <param name=\"trackID\" value=\"1\" valueType=\"data\" />\r\n"
			+ "        <param name=\"TimeScale\" value=\"24\" valueType=\"data\" />\r\n"
			+ "        <param name=\"MaxWidth\" value=\"320\" valueType=\"data\" />\r\n"
			+ "        <param name=\"MaxHeight\" value=\"180\" valueType=\"data\" />\r\n"
			+ "        <param name=\"FourCC\" value=\"AVC1\" valueType=\"data\" />\r\n"
			+ "        <param name=\"CodecPrivateData\" value=\"000000016742C00DAB202833F3E022000003000200000300611E2854900000000168CE3C80\" valueType=\"data\" />\r\n"
			+ "      </video>\r\n"
			+ "      <video src=\"big_buck_bunny_720p_stereo.mp4\" systemBitrate=\"2960000\">\r\n"
			+ "        <param name=\"trackID\" value=\"1\" valueType=\"data\" />\r\n"
			+ "        <param name=\"TimeScale\" value=\"12288\" valueType=\"data\" />\r\n"
			+ "        <param name=\"MaxWidth\" value=\"1280\" valueType=\"data\" />\r\n"
			+ "        <param name=\"MaxHeight\" value=\"720\" valueType=\"data\" />\r\n"
			+ "        <param name=\"FourCC\" value=\"AVC1\" valueType=\"data\" />\r\n"
			+ "        <param name=\"CodecPrivateData\" value=\"00000001674D401FDA014016EC0440000003004000000C03C60CA80000000168EF3C80\" valueType=\"data\" />\r\n"
			+ "      </video>\r\n"
			+ "      <video src=\"big_buck_bunny_1080p_stereo.mp4\" systemBitrate=\"4434000\">\r\n"
			+ "        <param name=\"trackID\" value=\"1\" valueType=\"data\" />\r\n"
			+ "        <param name=\"TimeScale\" value=\"12288\" valueType=\"data\" />\r\n"
			+ "        <param name=\"MaxWidth\" value=\"1920\" valueType=\"data\" />\r\n"
			+ "        <param name=\"MaxHeight\" value=\"1080\" valueType=\"data\" />\r\n"
			+ "        <param name=\"FourCC\" value=\"AVC1\" valueType=\"data\" />\r\n"
			+ "        <param name=\"CodecPrivateData\" value=\"00000001674D4028DA01E0089F97011000000300100000030300F1832A0000000168EF3C80\" valueType=\"data\" />\r\n"
			+ "      </video>\r\n" + "    </switch>\r\n" + "  </body>\r\n" + "</smil>";

	public static void main(String[] args) {
		System.out.println(getVideoAudioText(str));

	}
	
	public static String getVideoAudioText(String msg) {
		StringBuffer videoSb=new StringBuffer();
		StringBuffer audioSb=new StringBuffer();
		videoSb.append("Video:");
		audioSb.append("Audio:");
		// 先取出<switch>裡的內容
		int switchIndex = msg.indexOf("<switch>");
		int switchEndIndex = msg.indexOf("</switch>");
		String msg2 = msg.substring(switchIndex + 8, switchEndIndex);

		String[] strArray = msg2.split("o>");
		for (String temp : strArray) {
			//video
			if (temp.contains("video")) {
				System.out.println("+++++++++++++++++video+++++++++++++++");
				String systemBitrate = getWord(temp,"systemBitrate=\"");
				String TimeScale = getWord(temp,"TimeScale\" value=\"");
				String MaxWidth = getWord(temp,"MaxWidth\" value=\"");
				String MaxHeight = getWord(temp,"MaxHeight\" value=\"");
				String FourCC = getWord(temp,"FourCC\" value=\"");
				videoSb.append(FormetFileSize( Long.parseLong(systemBitrate)) +" - "+MaxHeight +" x "+ MaxWidth+" - "+ FourCC + " - " + FormetHZ(Long.parseLong(TimeScale))+",");
//				System.out.println(FormetFileSize( Long.parseLong(systemBitrate)) +" - "+MaxHeight +" x "+ MaxWidth+" - "+ FourCC + " - " + FormetHZ(Long.parseLong(TimeScale)));
			}
			//audio
			else if(temp.contains("audio")){
				System.out.println("+++++++++++++++++audio+++++++++++++++");
				String systemBitrate = getWord(temp,"systemBitrate=\"");
				String TimeScale = getWord(temp,"TimeScale\" value=\"");				
				String FourCC = getWord(temp,"FourCC\" value=\"");	
				String systemLanguage = getWord(temp,"systemLanguage=\"");
				if(systemLanguage.equals("")) {
					systemLanguage="Language not specified";
				}
				audioSb.append(FormetFileSize( Long.parseLong(systemBitrate)) +" - "+ systemLanguage +" - "+ FourCC +" - "+ FormetHZ(Long.parseLong(TimeScale) )+",");
//				System.out.println(FormetFileSize( Long.parseLong(systemBitrate)) +" - "+ systemLanguage +" - "+ FourCC +" - "+ FormetHZ(Long.parseLong(TimeScale)));
			}
		}
		return videoSb.toString()+"\r\n"+audioSb.toString();
	}
	
	/**
	 * 利用indexof及substring取值。
	 * @param temp
	 * @param word
	 * @return
	 */
	public static String getWord(String temp,String word) {
		String str="";
		int indexWord = temp.indexOf(word);
		int indexWord02 = temp.indexOf("\"", indexWord+word.length());
		if (indexWord > 0 && indexWord02 > 0) {
			str = temp.substring(indexWord+word.length(), indexWord02);
//			System.out.println(word+ ":" + str);
		}
		return str;
	}
	
	/**
	 * 轉換赫茲大小1024 
	 *
	 * @param fileS
	 * @return
	 */
	private static String FormetHZ(long fileS) {
		DecimalFormat df = null;
		String fileSizeString = "";
		String wrongSize = "0Hz";
		if (fileS == 0) {
			return wrongSize;
		}
		if (fileS < 1000) {
			df = new DecimalFormat("#");
			fileSizeString = df.format((double) fileS) + "Hz";
		} else {
			df = new DecimalFormat("#.00");
			fileSizeString = df.format((double) fileS / 1000) + "kHz";
		}
		return fileSizeString;
	}

	/**
	 * 轉換檔案大小1000 赫茲
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
