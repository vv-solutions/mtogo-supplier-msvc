package dk.vv.mtogo.supplier.msvc.api;

import dk.vv.common.data.transfer.objects.common.AddressDTO;
import dk.vv.mtogo.supplier.msvc.dtos.SupplierDTO;
import dk.vv.mtogo.supplier.msvc.facades.SupplierFacade;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.graphql.*;
import org.jetbrains.annotations.NonBlocking;

import java.util.List;

@GraphQLApi
@ApplicationScoped

public class DomainResource {

    private final SupplierFacade facade;

    @Inject
    public DomainResource(SupplierFacade facade) {
        this.facade = facade;
    }
    @Query("allActiveSuppliers")
    @Description("Get all active suppliers")
    public List<SupplierDTO> getAllActiveSuppliers() {
        return facade.getAllActive();
    }

    @Query("getSupplier")
    @Description("Get supplier by id")
    @NonBlocking
    public SupplierDTO getSupplier(@Name("supplierId") int id) {
        return facade.getSupplierById(id);
    }

    @Query("createSupplier")
    @Description("Create supplier")
    @Mutation
    @Transactional
    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
        return facade.createNew(supplierDTO);
    }

    @Query("updateSupplier")
    @Description("Update supplier")
    @Mutation
    @Transactional
    public SupplierDTO updateSupplier(SupplierDTO supplierDTO) {
        return facade.update(supplierDTO);
    }

    @Query("deleteSupplier")
    @Description("Delete supplier")
    @Mutation
    @Transactional
    public SupplierDTO deleteSupplier(@Name("supplierId") int id) {
        return facade.delete(id);
    }

    @Query("getAddressBySupplierId")
    @Description("Get address by supplier id")
    @NonBlocking
    public AddressDTO getAddressBySupplierId(@Name("supplierId") int id) {
        return facade.getAddressBySupplierId(id);
    }


}
