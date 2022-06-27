package jb.com;

public class Substring02 {
	static String str="ffprobe version 4.2.1-static https://johnvansickle.com/ffmpeg/  Copyright (c) 2007-2019 the FFmpeg developers@  built with gcc 6.3.0 (Debian 6.3.0-18+deb9u1) 20170516@  configuration: --enable-gpl --enable-version3 --enable-static --disable-debug --disable-ffplay --disable-indev=sndio --disable-outdev=sndio --cc=gcc-6 --enable-fontconfig --enable-frei0r --enable-gnutls --enable-gmp --enable-libgme --enable-gray --enable-libfribidi --enable-libass --enable-libfreetype --enable-libmp3lame --enable-libopencore-amrnb --enable-libopencore-amrwb --enable-libopenjpeg --enable-librubberband --enable-libsoxr --enable-libspeex --enable-libsrt --enable-libvorbis --enable-libopus --enable-libtheora --enable-libvidstab --enable-libvo-amrwbenc --enable-libvpx --enable-libwebp --enable-libx264 --enable-libx265 --enable-libxml2 --enable-libxvid --enable-libzimg@  libavutil      56. 31.100 / 56. 31.100@  libavcodec     58. 54.100 / 58. 54.100@  libavformat    58. 29.100 / 58. 29.100@  libavdevice    58.  8.100 / 58.  8.100@  libavfilter     7. 57.100 /  7. 57.100@  libswscale      5.  5.100 /  5.  5.100@  libswresample   3.  5.100 /  3.  5.100@  libpostproc    55.  5.100 / 55.  5.100@Input #0, mov,mp4,m4a,3gp,3g2,mj2, from '/opt/csorigin/content/aaaa/g04/big_buck_bunny_720p_stereo.mp4':@  Metadata:@    major_brand     : isom@    minor_version   : 512@    compatible_brands: isomiso2avc1mp41@    encoder         : Lavf54.63.104@  Duration: 00:09:56.50, start: 0.000000, bitrate: 3128 kb/s@    Stream #0:0(und): Video: h264 (Main) (avc1 / 0x31637661), yuv420p, 1280x720 [SAR 1:1 DAR 16:9], 2959 kb/s, 24 fps, 24 tbr, 12288 tbn, 48 tbc (default)@    Metadata:@      handler_name    : VideoHandler@    Stream #0:1(und): Audio: aac (LC) (mp4a / 0x6134706D), 48000 Hz, stereo, fltp, 165 kb/s (default)@    Metadata:@      handler_name    : SoundHandler@\r\n";
	public static void main(String[] args) {


		String[] getWordArray=str.split(",");
		for(String temp:getWordArray) {
			System.out.println("temp :"+temp);
			if(temp.contains("fps")) {
				System.out.println("fps"+temp);
				break;
			}
		}
	}
	/**
	 * 利用indexof及substring取值。
	 * @param temp 文件
	 * @param word 開始字
	 * @param endWord 結束字元
	 * @return String
	 */
	public static String getWord(String temp,String word,String endWord) {
		String str="";
		int indexWord = temp.indexOf(word);
		int indexWord02 = temp.indexOf(endWord, indexWord+word.length());
		if (indexWord >= 0 && indexWord02 > 0) {
			str = temp.substring(indexWord+word.length(), indexWord02);
//			System.out.println(word+ ":" + str);
		}
		return str;
	}
}
