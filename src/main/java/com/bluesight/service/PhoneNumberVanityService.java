package com.bluesight.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;
@Service
public class PhoneNumberVanityService {
	
	private HashMap<Character, Set<Character>> map = new HashMap<>();
	
	
	public HashMap<Character, Set<Character>> getPhoneNumberVanity() {		
		map.put('1', new HashSet<Character>());
		map.put('2', new HashSet<Character>(Arrays.asList(new Character[]{'a', 'b', 'c'})));
		map.put('3', new HashSet<Character>(Arrays.asList(new Character[]{'d', 'e', 'f'})));
		map.put('4', new HashSet<Character>(Arrays.asList(new Character[]{'g', 'h', 'i'})));
		map.put('5', new HashSet<Character>(Arrays.asList(new Character[]{'j', 'k', 'l'})));
		map.put('6', new HashSet<Character>(Arrays.asList(new Character[]{'m', 'n', 'o'})));
		map.put('7', new HashSet<Character>(Arrays.asList(new Character[]{'p', 'q', 'r', 's'})));
		map.put('8', new HashSet<Character>(Arrays.asList(new Character[]{'t', 'u', 'v'})));
		map.put('9', new HashSet<Character>(Arrays.asList(new Character[]{'w', 'x', 'y', 'z'})));
		map.put('0', new HashSet<Character>());
		return map;
	}
}
