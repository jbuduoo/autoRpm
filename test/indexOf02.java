package jb.com;

public class indexOf02 {

	public static void main(String[] args) {
		//hls - Apple HLS@/aaaa/B04/hls.ism/playlist.m3u8,hls_live_high - Apple HLS@/aaaa/B04/hls_live_high.ism/playlist.m3u8,hls_live_low - Apple HLS@/aaaa/B04/hls_live_low.ism/playlist.m3u8,DASH - MPEG-DASH @/aaaa/B04/DASH.ism/manifest.mpd,
		String abc=getWordForLastIndexOf("hls - Apple HLS@/aaaa/a02/hls","@","/");
		System.out.println(abc);
	}
	public static String getWordForLastIndexOf(String temp,String word,String lastIndexWord) {
		String str="";
		int indexWord = temp.indexOf(word);
		int indexWord02 = temp.lastIndexOf(lastIndexWord);
		if (indexWord >= 0 && indexWord02 > 0) {
			str = temp.substring(indexWord+word.length(), indexWord02);
		}
		return str;
	}
}
