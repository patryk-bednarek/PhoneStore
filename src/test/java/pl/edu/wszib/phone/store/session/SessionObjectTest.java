package pl.edu.wszib.phone.store.session;

import org.junit.Assert;
import org.junit.Test;

public class SessionObjectTest {

    @Test
    public void getInfoTest() {
        SessionObject sessionObject = new SessionObject();
        String info = "abc";

        Assert.assertNull(sessionObject.getInfo());
        sessionObject.setInfo(info);
        Assert.assertEquals(info, sessionObject.getInfo());
        Assert.assertNull(sessionObject.getInfo());
    }
}
