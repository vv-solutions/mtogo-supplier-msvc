package dk.vv.mtogo.supplier.msvc;
import dk.vv.mtogo.supplier.msvc.repositories.AddressRepository;
import dk.vv.mtogo.supplier.msvc.repositories.SupplierRepository;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
public class producers {

    @Produces
    SupplierRepository getSupplierRepository(){
        return new SupplierRepository();
    }

    @Produces
    AddressRepository getAddressRepository(){
        return new AddressRepository();
    }

}
