package dk.vv.mtogo.supplier.msvc.facades;

import dk.vv.common.data.transfer.objects.common.AddressDTO;
import dk.vv.mtogo.supplier.msvc.pojos.Address;
import dk.vv.mtogo.supplier.msvc.pojos.Supplier;
import dk.vv.mtogo.supplier.msvc.repositories.AddressRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AddressFacade {


    private final AddressRepository repository;

    public AddressFacade(AddressRepository repository) {
        this.repository = repository;
    }

   public AddressDTO getAddressById(int id){
        return repository.findById((long) id).toDTO();
   }
   public AddressDTO updateAddress(AddressDTO addressDTO){
        var address = repository.findById((long) addressDTO.getId());
        address.setAddress(addressDTO.getAddress());
        address.setCity(addressDTO.getCity());
        address.setZipCode(addressDTO.getZipCode());
        repository.persist(address);
        return address.toDTO();
   }
   public List<AddressDTO> getAll(){
       return repository.findAll().list().stream().map(Address::toDTO).collect(Collectors.toList());
   }
}
