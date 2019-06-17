package com.vikhi.dao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vikhi.pojo.MobileNumber;

public class MobileNumberDao {

	public List<MobileNumber> getAllMobileNumbers () {
		return Arrays.asList(
				new MobileNumber("91", "9698347616"), 
				new MobileNumber("91", "9443990380"), 
				new MobileNumber("85", "13698346167"), 
				new MobileNumber("65", "6035478"), 
				new MobileNumber("44", "4682361234"), 
				new MobileNumber("44", "4688479654"));
	}
	
	public MobileNumber getMobileNumber(String countryCode, String mobileNumber) {
		Optional<MobileNumber> mnOpt = getAllMobileNumbers()
			.stream()
			.filter(mn -> countryCode.equals(mn.getCountryCode()) && mobileNumber.equals(mn.getMobileNumber()))
			.findFirst();
		
		return mnOpt.isPresent() ? mnOpt.get() : null;
	}
	
	public List<MobileNumber> getMobileNumberByCountry(String countryCode) {
		return getAllMobileNumbers()
				.stream()
				.filter(mn -> countryCode.equals(mn.getCountryCode()))
				.sorted(Comparator.comparing(MobileNumber::getMobileNumber))
				.collect(Collectors.toList());
	}
}
