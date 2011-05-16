package org.softlang.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.struts2.util.ClassLoaderUtils;

import com.sun.org.apache.xerces.internal.impl.io.MalformedByteSequenceException;

public class FileInputStreamFactory {
	public static FileInputStream createFileInputStream(String fileName) throws MalformedByteSequenceException, IOException {
		return new FileInputStream(ClassLoaderUtils.getResource(fileName, FileInputStreamFactory.class).getFile());	
	}
}
