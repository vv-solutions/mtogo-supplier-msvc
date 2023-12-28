package dk.vv.mtogo.supplier.msvc.facades;

import dk.vv.mtogo.supplier.msvc.repositories.AddressRepository;
import dk.vv.mtogo.supplier.msvc.repositories.SupplierRepository;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


@QuarkusTest
public class AddressFacadeIT {
    @Inject
    protected Flyway flyway;

    @Inject
    protected AddressFacade addressFacade;

    @Inject
    AddressRepository addressRepository;

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
        var address = addressFacade.getAddressById(5);

        //Assert
        Assertions.assertEquals(5, address.getId());
    }
    @Test
    void when_update_address_zipcode_should_be_2770(){
        //Arrange
        var address = addressFacade.getAddressById(5);
        address.setZipCode(2770);

        //Act
        var updatedAddress = addressFacade.updateAddress(address);

        //Assert
        Assertions.assertEquals(2770, updatedAddress.getZipCode());
    }

}
