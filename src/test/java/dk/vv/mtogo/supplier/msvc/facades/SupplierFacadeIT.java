package dk.vv.mtogo.supplier.msvc.facades;

import dk.vv.common.data.transfer.objects.common.AddressDTO;
import dk.vv.mtogo.supplier.msvc.dtos.SupplierDTO;
import dk.vv.mtogo.supplier.msvc.repositories.SupplierRepository;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@QuarkusTest
class SupplierFacadeIT {
    @Inject
    protected Flyway flyway;

    @Inject
    protected SupplierFacade supplierFacade;

    @Inject
    SupplierRepository supplierRepository;

    @BeforeEach
    public void before() {
        flyway.migrate();
    }


    @AfterEach
    public void restoreDatabase() {
        flyway.clean();
    }


    @Test
    void when_get_by_id_5_address_id_should_be_5(){
        //Act
        var supplier = supplierFacade.getSupplierById(5);

        //Assert
        Assertions.assertEquals(5, supplier.getAddress().getId());
    }

    @Test
    @Transactional
    void when_create_new_supplier_the_id_should_be_8(){
        //Arrange
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setZipCode(2770);
        addressDTO.setCity("Kastrup");
        addressDTO.setAddress("Skottegården 37");

        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setName("Test");
        supplierDTO.setAddress(addressDTO);

        //Act
        var createdSupplier = supplierFacade.createNew(supplierDTO);

        //Assert
        Assertions.assertEquals(8, createdSupplier.getId());
        Assertions.assertEquals(2770, createdSupplier.getAddress().getZipCode());
    }

    @Test
    @Transactional
    void when_create_new_supplier_without_address_error_should_be_thrown(){
        //Arrange
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setName("Test");

        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            supplierFacade.createNew(supplierDTO);
        });
    }

    @Test
    @Transactional
    void when_update_supplier_name_should_be_updated(){
        //Arrange
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setId(1);
        supplierDTO.setName("Tasty Bites TEST");


        //Act
        var updatedSupplier = supplierFacade.update(supplierDTO);

        //Assert
        Assertions.assertEquals("Tasty Bites TEST", updatedSupplier.getName());
    }

    @Test
    @Transactional
    void when_delete_supplier_should_be_inactive(){
        //Arrange
        int id = 1;

        //Act
        supplierFacade.delete(id);

        //Assert
        Assertions.assertFalse(supplierRepository.findById((long) id).isActive());
    }

    @Test
    void when_get_all_active_should_return_6(){
        //Arrange
        int size = 6;

        //Act
        var suppliers = supplierFacade.getAllActive();

        //Assert
        Assertions.assertEquals(size, suppliers.size());
    }
    @Test
    void when_get_address_by_supplier_id_5_zipcode_should_be_2770(){
        //Arrange
        int id = 5;
        int zipcode = 87654;

        //Act
        var address = supplierFacade.getAddressBySupplierId(id);

        //Assert
        Assertions.assertEquals(zipcode, address.getZipCode());
    }


}