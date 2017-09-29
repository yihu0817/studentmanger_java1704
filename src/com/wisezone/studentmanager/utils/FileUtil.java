package com.wisezone.studentmanager.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * �ļ����� RandomAccessFile
 * 
 * @author viktor.zhou
 *
 */
public class FileUtil {
	/**
	 * 
	 * �����༶�ļ�Ŀ¼ ָ���ļ� ��: e:/liu/hai/bing.txt
	 */
	public static boolean createFile(File file) {
		try {
			String fileDir = file.getPath();
			int lastIndex = fileDir.lastIndexOf(File.separator);
			String dir = fileDir.substring(0, lastIndex);
			File dirFile = new File(dir);
			dirFile.mkdirs();
			if (file.createNewFile()) {
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * e:/liu/hai/bing.txt
	 * 
	 * @param path
	 * @return
	 */
	public static boolean createFile(String path) {
		File file = new File(path);
		boolean f = createFile(file);
		return f;
	}

	public static File createNewFile(String path) {
		File file = new File(path);
		createFile(file);
		return file;
	}

	public static boolean deleteFile(String path) throws FileNotFoundException {
		return deleteFile(new File(path));
	}

	/**
	 * ɾ��ָ���ļ�
	 * 
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
	public static boolean deleteFile(File file) throws FileNotFoundException {
		if (file == null) {
			throw new NullPointerException("ɾ���ļ�����Ϊ��!");
		}

		if (!file.exists()) {
			throw new FileNotFoundException("�ļ�������!");
		}

		if (file.isFile()) {
			file.delete(); // ɾ���ļ�
			return true;
		}

		if (file.isDirectory()) {
			File[] fileLists = file.listFiles();
			for (File f : fileLists) {
				deleteFile(f);
			}
			file.delete(); // ɾ����Ŀ¼
		}

		return true;

	}

	/**
	 * �����ļ�·����ȡ�ļ��� �ļ���:������չ���� ��: E:\studetnall\hello.java hello.java
	 * 
	 * @param fileDir
	 * @return
	 */
	public static String getFileName(String fileDir) {
		File file = new File(fileDir);
		String fileName = file.getName();
		return fileName;
	}

	/**
	 * �����ļ�·����ȡ�ļ��� �ļ�����������չ���� ��: E:\studetnall\hello.java hello
	 * 
	 * @param fileDir
	 * @return
	 */
	public static String getFileNames(String fileDir) {
		File file = new File(fileDir);
		String fileName = file.getName();
		int lastIndex = fileName.lastIndexOf(".");
		fileName = fileName.substring(0, lastIndex);
		return fileName;
	}

	/**
	 * �����̷� e:/zip_demo.zip
	 * 
	 * @param zipPath
	 *            ѹ���ļ� e:/zip_demo.zip
	 * @param zipDirPath
	 *            ��ѹ�ı�Ŀ¼ e:/zip_demo/
	 */
	public static void deZipFile(String zipPath, String zipDirPath) {
		File zipFile = new File(zipPath);
		File zipDir = new File(zipDirPath);
		deZipFile(zipFile, zipDir);
	}

	/**
	 * ��ѹѹ���ļ� e:/zip_demo.zip ���ļ�Ŀ¼e:/zip_demo
	 * 
	 * @param zipFile
	 *            ѹ���ļ� e:/zip_demo.zip
	 * @param zipDir
	 *            ��ѹ�ı�Ŀ¼ e:/zip_demo/
	 */
	public static void deZipFile(File zipFile, File zipDir) {
		try {
			FileInputStream fis = new FileInputStream(zipFile);
			ZipInputStream zis = new ZipInputStream(fis);

			ZipEntry zipEntry = null; // �ļ���Ŀ
			while ((zipEntry = zis.getNextEntry()) != null) {
				File itemFile = new File(zipDir, zipEntry.getName());
				FileUtil.createFile(itemFile);

				System.out.println(itemFile.getPath()); // e:\zip_demo\hello.txt
				FileOutputStream fos = new FileOutputStream(itemFile);
				int c;
				while ((c = zis.read()) != -1) {
					fos.write(c);
				}

				fos.close();
			}

			zis.close();
			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param filePaths
	 *            �̷�������� ��: String[] filePaths = {"e:/java.txt","e:/test.txt};
	 * @param zipPath
	 *            ѹ��Ŀ¼�ļ� ��: String zipPath = e:/demo.zip
	 */
	public static void zipFile(String[] filePaths, String zipPath) {
		int length = filePaths.length;
		File[] files = new File[length];
		for (int i = 0; i < length; i++) {
			files[i] = new File(filePaths[i]);
		}
		File zipFile = new File(zipPath);

		zipFile(files, zipFile);
	}

	/**
	 * 
	 * @param files
	 *            ��Ҫѹ���������ļ�
	 * @param zipFile
	 *            ѹ������Ŀ���ļ�
	 */
	public static void zipFile(File[] files, File zipFile) {
		int fileLength = files.length;
		String[] entryNames = new String[fileLength];
		for (int j = 0; j < fileLength; j++) {
			entryNames[j] = files[j].getName();
		}
		try {
			/*
			 * ѹ���ļ� ��e:/hello10.txt�ļ�ѹ���� e:/zip_demo.zip�ļ�
			 */
			// ��һ�� :����ѹ���ļ������
			FileOutputStream fos = new FileOutputStream(zipFile);
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (int i = 0; i < fileLength; i++) {
				ZipEntry testEntry = new ZipEntry(entryNames[i]);
				zos.putNextEntry(testEntry); // д�ļ���Ŀ

				FileInputStream fis = new FileInputStream(files[i]);
				int c;
				while ((c = fis.read()) != -1) {
					zos.write((char) c); // д�ļ�����
				}

				fis.close();
			}

			System.out.println("ѹ���ɹ�!");
			// ���ر���
			zos.close();
			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
