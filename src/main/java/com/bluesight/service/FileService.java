package com.bluesight.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
@Service
public class FileService {
	
	public List<String> getLinesOfFile(String file) throws IOException {
		File f = new File(file);
		List<String> lines = FileUtils.readLines(f, StandardCharsets.UTF_8);
		return lines;
	}
}
