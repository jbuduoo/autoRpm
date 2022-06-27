package jb.com;

public class IndexOfSomeOne {

	public static void main(String[] args) {
		String note="I0.228 Manifest\r\n"
				+ "I0.228 Track 1:\r\n"
				+ "I0.228 src=BigBuckBunny_320x180.mp4\r\n"
				+ "I0.228 video bitrate=703000 name=video\r\n"
				+ "I0.228 id=1 timescale=24 lang=und\r\n"
				+ "I0.228 vide/avc1 dref=1 bitrate=703000/0 size=320x180 sar=1:1 dar=16:9 codecs=avc1.42C00D\r\n"
				+ "I0.228 Track 2:\r\n"
				+ "I0.228 src=BigBuckBunny_320x180.mp4\r\n"
				+ "I0.228 audio bitrate=160000 name=audio\r\n"
				+ "I0.228 id=2 timescale=48000 lang=und\r\n"
				+ "I0.228 soun/mp4a dref=1 bitrate=160000/160000 tag=255 samplerate=48000 channels=2 sample_size=16 packet_size=4\r\n"
				+ "I0.242 Preprocessing...\r\n"
				+ "Status: 400 FMP4_400\r\n"
				+ "X-USP-Error: [Error] Missing output file";
		
		int indexVideo=note.indexOf("video bitrate=")+14;
		int indexName=note.indexOf(" name=video");
		String size=note.substring(indexVideo,indexName);
		System.out.println("size: "+size);	
		

	}

}
