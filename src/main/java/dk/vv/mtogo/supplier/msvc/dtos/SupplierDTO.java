package dk.vv.mtogo.supplier.msvc.dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dk.vv.common.data.transfer.objects.common.AddressDTO;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "Supplier")
@RegisterForReflection
public class SupplierDTO {
    private Integer id;
    private String name;

    @JsonManagedReference
    private AddressDTO address;

    public SupplierDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

}
