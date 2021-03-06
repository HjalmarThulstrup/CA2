/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import DTO.AddressDTO;
import entity.Address;
import entity.CityInfo;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juanni420
 */
public class AddressMapperTest {

    AddressMapper addrMapper = new AddressMapper(Persistence.createEntityManagerFactory("jpaputest"));

    public AddressMapperTest() {
    }

    /**
     * Test of createAddress method, of class AddressMapper.
     */
    @Test
    public void testCreateAddress() {
        System.out.println("createAddress");

        Address address = new Address();
        address.setStreet("Tester Road");
        address.setCityInfo(new CityInfo("1000", "Testby"));
        address.setAdditionalInfo("test");

        AddressDTO result = new AddressDTO(addrMapper.createAddress(address));

        assertEquals("Tester Road, test", result.getStreet() + ", " + result.getAddInfo());
        assertEquals("1000 Testby", result.getZip() + " " + result.getCity());
    }

    /**
     * Test of getAddress method, of class AddressMapper.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        AddressDTO aDTO = new AddressDTO(addrMapper.getAddress(2));
        assertEquals("Tester Road, test", aDTO.getStreet() + ", " + aDTO.getAddInfo());
    }

    /**
     * Test of editAddress method, of class AddressMapper.
     */
    @Test
    public void testEditAddress() {
        System.out.println("editAddress");

        Address address = new Address();
        address.setStreet("Tester Edit Road");
        address.setAdditionalInfo("test");
        address.setCityInfo(new CityInfo("1000", "TestEditby"));

        addrMapper.createAddress(address);

        AddressDTO aDTO = new AddressDTO(addrMapper.getAddress(3));
        assertEquals("Tester Edit Road, test", aDTO.getStreet() + ", " + aDTO.getAddInfo());
        
        address.setStreet("Edited Road");
        addrMapper.editAddress(address);
        
        aDTO = new AddressDTO(addrMapper.getAddress(3));
        assertEquals("Edited Road, test", aDTO.getStreet() + ", " + aDTO.getAddInfo());
    }

    /**
     * Test of deleteAddress method, of class AddressMapper.
     */
    @Test
    public void testDeleteAddress() {
        System.out.println("deleteAddress");

        int id = 2;
        AddressDTO aDTO = new AddressDTO(addrMapper.getAddress(id));
        assertEquals("Tester Road, test", aDTO.getStreet() + ", " + aDTO.getAddInfo());
        addrMapper.deleteAddress(id);
        assertEquals(null, addrMapper.getAddress(id));
    }

}
