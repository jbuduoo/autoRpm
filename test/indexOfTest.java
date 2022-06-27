package jb.com;

public class indexOfTest {

	public static void main(String[] args) {
		
		String note="I0.244 Manifest\r\n"
				+ "I0.244 Track 1:\r\n"
				+ "I0.244 src=big_buck_bunny_720p_stereo.mp4\r\n"
				+ "I0.244 video bitrate=2960000 name=video\r\n"
				+ "I0.244 id=1 timescale=12288 lang=und\r\n"
				+ "I0.244 vide/avc1 dref=1 bitrate=2960000/0 size=1280x720 sar=1:1 dar=16:9 codecs=avc1.4D401F\r\n"
				+ "I0.244 Track 2:\r\n"
				+ "I0.244 src=big_buck_bunny_720p_stereo.mp4\r\n"
				+ "I0.244 audio bitrate=165418/192000 name=audio\r\n"
				+ "I0.244 id=2 timescale=48000 lang=und\r\n"
				+ "I0.244 soun/mp4a dref=1 bitrate=165418/192000 tag=255 samplerate=48000 channels=2 sample_size=16 packet_size=4\r\n"
				+ "I0.274 Preprocessing...\r\n"
				+ "Status: 400 FMP4_400\r\n"
				+ "";
		
		int indexAudio=note.indexOf("audio bitrate=")+14;
		int indexName=note.indexOf(" name=audio");
		String bitrate = note.substring(indexAudio,indexName);
		if(bitrate.indexOf('/')>0) {
			bitrate=bitrate.substring(0,bitrate.indexOf('/'));
		}
		System.out.println("bitrate:"+bitrate);
	}

}
