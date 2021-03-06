package com.age.pinterest.bot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileUtill {
	public static void saveToFile(String destination, String name, String content) throws FileNotFoundException {
		File root = new File(destination);
		if (!root.exists() || !root.isDirectory()) {
			root.mkdirs();
		}
		PrintWriter out = null;
		try {
			String path = destination + "\\" + name;
			out = new PrintWriter(path);
			out.println(content);
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	public static void appendToFile(String file, String content) throws IOException {
		FileWriter fw = new FileWriter(file, true);
		fw.write(content + "\n");
		fw.close();
	}

	public static ArrayList<String> getAllFiles(String path) {
		System.out.println("Getting file list for  " + path);
		ArrayList<String> paths = new ArrayList<String>();
		File rootFile = new File(path);
		for (File f : rootFile.listFiles()) {
			paths.add(f.getAbsolutePath());
		}
		return paths;

	}

	public static String getFileContents(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, "UTF-8");
	}

	public static ArrayList<String> getFileListContents(String root) throws IOException {
		File rootFile = new File(root);
		ArrayList<String> list = new ArrayList<String>();
		for (File f : rootFile.listFiles()) {
			list.add(getFileContents(f.getAbsolutePath()));
		}
		return list;
	}

}
