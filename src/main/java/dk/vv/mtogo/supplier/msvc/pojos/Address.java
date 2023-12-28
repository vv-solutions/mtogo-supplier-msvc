package dk.vv.mtogo.supplier.msvc.pojos;

import dk.vv.common.data.transfer.objects.common.AddressDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "zip_code")
    private int zipCode;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @CreationTimestamp
    @Column(name = "create_stamp")
    private LocalDateTime createStamp;

    // ===== Constructors =====
    public Address() {
    }

    public Address(AddressDTO addressDTO) {
        this.zipCode = addressDTO.getZipCode();
        this.city = addressDTO.getCity();
        this.address = addressDTO.getAddress();
    }

    // ===== Methods =====
    public AddressDTO toDTO() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(this.getId());
        addressDTO.setAddress(this.getAddress());
        addressDTO.setCity(this.getCity());
        addressDTO.setZipCode(this.getZipCode());
        return addressDTO;
    }


    // ===== Getters and Setters =====
    public LocalDateTime getCreateStamp() {
        return createStamp;
    }

    public void setCreateStamp(LocalDateTime createStamp) {
        this.createStamp = createStamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipcode) {
        this.zipCode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
