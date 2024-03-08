package com.bluesight.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessPhoneNumber {
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private PhoneNumberVanityService phoneNumberVanityService;
	
	public List<String> procesPhoneNumber(String phoneNumber, String filePath) throws IOException {
		HashMap<Character, Set<Character>> vanity = phoneNumberVanityService.getPhoneNumberVanity();
		List<String> dictionary = fileService.getLinesOfFile(filePath);
		
		List<String> result = new ArrayList<>();
		
		phoneNumber = phoneNumber.replace("-", "");
		phoneNumber = phoneNumber.replace("(", "");
		phoneNumber = phoneNumber.replace(")", "");
		
		dictionary.sort(Comparator.comparingInt(String::length));
		
		List<Set<Character>> sets = new ArrayList<>();
		
		for (Character c: phoneNumber.toCharArray()) {
			sets.add(vanity.get(c));
		}
		
		int lenght = phoneNumber.length();
		
		List<String> onlyPossible = dictionary.stream().filter(name -> name.length() == lenght).collect(Collectors.toList());
		
		for (String name: onlyPossible) {
			boolean include = true;
			int x = 0;
			for (Character c: name.toCharArray()) {
				include &= sets.get(x).contains(c);
				x++;
			}
			if (include) {
				result.add(name);
			}
		}
	
		return result;
	}
}
