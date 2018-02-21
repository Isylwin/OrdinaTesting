package nl.earthbird;

import org.junit.Assert;
import org.junit.Test;

public class DeveloperTest {
    @Test
    public void testWriteCode() {
        Developer sut = new Developer("Henk");
        Assert.assertEquals("Code, code, code, code, code, code, code", sut.writeCode());
    }
}
