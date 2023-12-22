package dk.vv.mtogo.supplier.msvc.facades;

import dk.vv.common.data.transfer.objects.common.AddressDTO;
import dk.vv.mtogo.supplier.msvc.dtos.SupplierDTO;
import dk.vv.mtogo.supplier.msvc.pojos.Supplier;
import dk.vv.mtogo.supplier.msvc.repositories.SupplierRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class SupplierFacade {

    private final SupplierRepository repository;

    public SupplierFacade(SupplierRepository repository) {
        this.repository = repository;
    }

    public SupplierDTO getSupplierById(int id){
        return repository.findById((long) id).toDTO();
    }

    @Transactional
    public SupplierDTO createNew(SupplierDTO supplierDTO){
        Supplier supplier = new Supplier(supplierDTO);
        if(supplier.getAddress() == null){
            throw new IllegalArgumentException("Address cannot be null");
        }
        repository.persist(supplier);
        return supplier.toDTO();
    }

    @Transactional
    public SupplierDTO update(SupplierDTO supplierDTO){
        Supplier supplier = repository.findById((long) supplierDTO.getId());
        supplier.setName(supplierDTO.getName());
        repository.persist(supplier);
        return supplier.toDTO();
    }

    @Transactional
    public SupplierDTO delete(int id){
        Supplier supplier = repository.findById((long) id);
        supplier.setName(supplier.getName() + " (inactive)");
        supplier.setActive(false);
        repository.persist(supplier);
        return supplier.toDTO();
    }

    public List<SupplierDTO> getAllActive(){
        return repository.findAll().list().stream().filter(Supplier::isActive).map(Supplier::toDTO).toList();
    }

    public AddressDTO getAddressBySupplierId(int id){
        return repository.findById((long) id).getAddress().toDTO();
    }


}
