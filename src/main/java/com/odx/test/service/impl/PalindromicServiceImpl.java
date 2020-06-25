package com.odx.test.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.odx.test.entity.Demo;
import com.odx.test.repository.PalindromicRepository;
import com.odx.test.service.PalindromicService;


@Service
public class PalindromicServiceImpl implements PalindromicService {
	
	@Autowired
	PalindromicRepository palindromicRepository;
	
	@Override
	@Transactional
	public String findPalindrome(String text) {
		String palindromic = longestPalSubstr(text);
		Demo demo = new Demo();
		demo.setName(palindromic);
		palindromicRepository.savePalindrome(demo);
		return palindromic;
	}
	private String longestPalSubstr(String str) {
		// The result (length of LPS) 
				int maxLength = 1;
				int start = 0;
				int len = str.length();
				int low, high;

		// One by one consider every 
		// character as center 
		// point of even and length 
		// palindromes 
				for (int i = 1; i < len; ++i) {
		// Find the longest even 
		// length palindrome with 
		// center points as i-1 and i. 
					low = i - 1;
					high = i;
					while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
						if (high - low + 1 > maxLength) {
							start = low;
							maxLength = high - low + 1;
						}
						--low;
						++high;
					}

		// Find the longest odd length 
		// palindrome with center point as i 
					low = i - 1;
					high = i + 1;
					while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
						if (high - low + 1 > maxLength) {
							start = low;
							maxLength = high - low + 1;
						}
						--low;
						++high;
					}
				}

//				System.out.print("Longest palindrome substring is: ");
//				printSubStr(str, start, start + maxLength - 1);

				//return maxLength;
				return str.substring(start, start + maxLength - 1 + 1);
			}
}
