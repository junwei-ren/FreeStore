package com.example.freestore.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class FileUtils {
	private String SDPATH;

	final private int FILESIZE = 8 * 1024;
	private int length = 0;
	private int downloadSize = 0;
	private Handler mHandler;

	private byte[] buffer;

	public String getSDPATH() {
		return SDPATH;
	}

	public FileUtils(Handler handler) {
		// �õ���ǰ�ⲿ�洢�豸��Ŀ¼( /SDCARD )
		SDPATH = Environment.getExternalStorageDirectory() + "/";
		mHandler = handler;
	}

	/**
	 * ��SD���ϴ����ļ�
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public File createSDFile(String fileName) throws IOException {
		File file = new File(SDPATH + fileName);
		file.createNewFile();
		return file;
	}

	/**
	 * ��SD���ϴ����ļ�
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public boolean removeSDFile(String fileName) throws IOException {
		File file = new File(SDPATH + fileName);
		return file.delete();
	}

	/**
	 * ��SD���ϴ���Ŀ¼
	 * 
	 * @param dirName
	 * @return
	 */
	public File createSDDir(String dirName) {
		File dir = new File(SDPATH + dirName);
		dir.mkdir();
		return dir;
	}

	/**
	 * �ж�SD���ϵ��ļ����Ƿ����
	 * 
	 * @param fileName
	 * @return
	 */
	public boolean isFileExist(String fileName) {
		File file = new File(SDPATH + fileName);
		return file.exists();
	}

	/**
	 * ��һ��InputStream���������д�뵽SD����
	 * 
	 * @param path
	 * @param fileName
	 * @param input
	 * @return
	 */
	public File write2SDFromInput(String path, String fileName,
			InputStream input, int totalSize) {
		File file = null;
		OutputStream output = null;
		try {
			createSDDir(path);
			file = createSDFile(path + fileName);
			output = new FileOutputStream(file);
			byte[] buffer = new byte[FILESIZE];
			// while((input.read(buffer)) != -1){
			// output.write(buffer);
			// }
			while ((length = input.read(buffer)) != -1) {
				output.write(buffer, 0, length);
				downloadSize += length;
				if (downloadSize == totalSize) {
					sendMsg(1, SDPATH + path + fileName);
				}
			}
			output.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	public void sendMsg(int flag, String string) {
		// Looper mainLooper = Looper.getMainLooper ();
		// Handler mHandler = new Handler(mainLooper);
		String str = string;
		Message msg = new Message();
		// Message msg = mHandler .obtainMessage(1, 1, 1, "ok!!!");
		msg.what = flag;
		msg.obj = str;
		mHandler.sendMessage(msg);
	}

}