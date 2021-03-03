package pl.edu.wszib.phone.store.model;

import org.junit.Assert;
import org.junit.Test;

public class PhoneTest {

    @Test
    public void cloneTest() {
        Phone phone = new Phone();
        phone.setId(10);
        phone.setBrand("Motorolla");
        phone.setModel("Z3");
        phone.setPrice(1233);
        phone.setPieces(32);
        phone.setSoftware("Android");

        Phone clone = phone.clone();

        Assert.assertEquals(phone.getId(), clone.getId());
        Assert.assertEquals(phone.getBrand(), clone.getBrand());
        Assert.assertEquals(phone.getModel(), clone.getModel());
        Assert.assertEquals(phone.getPrice(), clone.getPrice(), 0.0001);
        Assert.assertEquals(phone.getPieces(), clone.getPieces());
        Assert.assertEquals(phone.getSoftware(), clone.getSoftware());

        Assert.assertNotSame(phone, clone);
    }
}
