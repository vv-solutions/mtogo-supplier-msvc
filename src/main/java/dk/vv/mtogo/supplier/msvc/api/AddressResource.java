package dk.vv.mtogo.supplier.msvc.api;

import dk.vv.common.data.transfer.objects.common.AddressDTO;
import dk.vv.mtogo.supplier.msvc.facades.AddressFacade;
import dk.vv.mtogo.supplier.msvc.facades.SupplierFacade;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
@ApplicationScoped
public class AddressResource {

    private final AddressFacade facade;

    @Inject
    public AddressResource(AddressFacade facade) {
        this.facade = facade;
    }

    @Query("getAllAddresses")
    public List<AddressDTO> getAllAddresses() {
        return facade.getAll();
    }
    @Query("getAddressById")
    public AddressDTO getAddressById(@Name("addressId") int id) {
        return facade.getAddressById(id);
    }

    @Query("updateAddress")
    public AddressDTO updateAddress(AddressDTO addressDTO) {
        return facade.updateAddress(addressDTO);
    }


}
