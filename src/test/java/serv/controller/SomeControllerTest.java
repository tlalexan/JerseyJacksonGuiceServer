package serv.controller;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SomeControllerTest {
    @Test
    public void testGetIt() {
        SomeController someController = new SomeController();

        assertThat(someController.getIt(), equalTo("hello"));
    }
}
