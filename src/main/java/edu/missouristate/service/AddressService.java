//Daniel Abbott
package edu.missouristate.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import antlr.collections.List;
import edu.missouristate.domain.Address;
import edu.missouristate.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepo;

	public List<Address> getAddresses() {
		// TODO Auto-generated method stub
		return (List<Address>) addressRepo.findAll();

	}

	@Transactional
	public void saveAddress(Address address) {
		addressRepo.save(address);
	}

	public Address getAddressById(Integer addressId) {
		Optional<Address> addressOptional = addressRepo.findById(addressId);
		return addressOptional.isPresent() ? addressOptional.get() : null;
	}
	
	@Transactional
	public void deleteAddress(Integer addressId) {
		addressRepo.deleteById(addressId);

		
	}

}
