package jb.com;

public class SubString {

	public static void main(String[] args) {
		String str="ffprobe version 4.2.1-static https://johnvansickle.com/ffmpeg/  Copyright (c) 2007-2019 the FFmpeg developers\r\n"
				+ "  built with gcc 6.3.0 (Debian 6.3.0-18+deb9u1) 20170516\r\n"
				+ "  configuration: --enable-gpl --enable-version3 --enable-static --disable-debug --disable-ffplay --disable-indev=sndio --disable-outdev=sndio --cc=gcc-6 --enable-fontconfig --enable-frei0r --enable-gnutls --enable-gmp --enable-libgme --enable-gray --enable-libfribidi --enable-libass --enable-libfreetype --enable-libmp3lame --enable-libopencore-amrnb --enable-libopencore-amrwb --enable-libopenjpeg --enable-librubberband --enable-libsoxr --enable-libspeex --enable-libsrt --enable-libvorbis --enable-libopus --enable-libtheora --enable-libvidstab --enable-libvo-amrwbenc --enable-libvpx --enable-libwebp --enable-libx264 --enable-libx265 --enable-libxml2 --enable-libxvid --enable-libzimg\r\n"
				+ "  libavutil      56. 31.100 / 56. 31.100\r\n"
				+ "  libavcodec     58. 54.100 / 58. 54.100\r\n"
				+ "  libavformat    58. 29.100 / 58. 29.100\r\n"
				+ "  libavdevice    58.  8.100 / 58.  8.100\r\n"
				+ "  libavfilter     7. 57.100 /  7. 57.100\r\n"
				+ "  libswscale      5.  5.100 /  5.  5.100\r\n"
				+ "  libswresample   3.  5.100 /  3.  5.100\r\n"
				+ "  libpostproc    55.  5.100 / 55.  5.100\r\n"
				+ "Input #0, mov,mp4,m4a,3gp,3g2,mj2, from '/opt/csorigin/content/aaaa/A1/big_buck_bunny_1080p_stereo.mp4':\r\n"
				+ "  Metadata:\r\n"
				+ "    major_brand     : isom\r\n"
				+ "    minor_version   : 512\r\n"
				+ "    compatible_brands: isomiso2avc1mp41\r\n"
				+ "    encoder         : Lavf54.63.104\r\n"
				+ "  Duration: 00:09:56.50, start: 0.000000, bitrate: 4603 kb/s\r\n"
				+ "    Stream #0:0(und): Video: h264 (Main) (avc1 / 0x31637661), yuv420p, 1920x1080 [SAR 1:1 DAR 16:9], 4433 kb/s, 24 fps, 24 tbr, 12288 tbn, 48 tbc (default)\r\n"
				+ "    Metadata:\r\n"
				+ "      handler_name    : VideoHandler\r\n"
				+ "    Stream #0:1(und): Audio: aac (LC) (mp4a / 0x6134706D), 48000 Hz, stereo, fltp, 165 kb/s (default)\r\n"
				+ "    Metadata:\r\n"
				+ "      handler_name    : SoundHandler";
	
		
		int index=str.indexOf("Duration:");
		if(index >0) {
			int index02=str.indexOf(",",index);
			if(index02>0) {
			String mes=str.substring(index+10,index02);
			System.out.println(index+":" +index02);
			System.out.println(mes);
			}
		}
	}

}
