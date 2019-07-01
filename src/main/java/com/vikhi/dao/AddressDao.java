package com.vikhi.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.vikhi.pojo.Address;

public class AddressDao {
	
	public List<Address> getAllAddresses() {
		return Arrays.asList(
				new Address("Chennai", "600100"), 
				new Address("Coimbatore", "641005"), 
				new Address("Hong Kong", "56748"), 
				new Address("Singapore", "78541"), 
				new Address("Mexico City", "114526"));
	}
	
	public Address getAddressByZipCode(final String zipCode) {
		Optional<Address> optionalAddress = getAllAddresses()
				.stream()
				.filter(address -> zipCode.equals(address.getZipCode()))
				.findFirst();
		return optionalAddress.isPresent() ? optionalAddress.get() : new Address();
	}

}
