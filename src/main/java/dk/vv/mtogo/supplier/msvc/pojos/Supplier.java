package dk.vv.mtogo.supplier.msvc.pojos;


import dk.vv.mtogo.supplier.msvc.dtos.SupplierDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    Address address;

    @Column(name = "active")
    private boolean active;


    @CreationTimestamp
    @Column(name = "create_stamp")
    private LocalDateTime createStamp;
    public Supplier() {
    }

    public Supplier(SupplierDTO supplierDTO) {
        this.name = supplierDTO.getName();
        if(supplierDTO.getAddress() !=null){
            Address address = new Address(supplierDTO.getAddress());
            this.address =address;
        }
    }


    public SupplierDTO toDTO() {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setId(this.getId());
        supplierDTO.setName(this.getName());
        if(this.address!=null){
            supplierDTO.setAddress(this.address.toDTO());
        }
        return supplierDTO;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreateStamp() {
        return createStamp;
    }

    public void setCreateStamp(LocalDateTime createStamp) {
        this.createStamp = createStamp;
    }
}
