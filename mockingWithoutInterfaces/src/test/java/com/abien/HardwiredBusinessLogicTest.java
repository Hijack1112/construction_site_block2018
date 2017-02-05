/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abien;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author Hijack
 */
public class HardwiredBusinessLogicTest {

    @Test
    public void mockingWithoutInterfaces() {
        HardwiredBusinessLogic mock = mock(HardwiredBusinessLogic.class);
        final String expected = "Java rocks";
        when(mock.getGreeting()).thenReturn(expected);
        String actual = mock.getGreeting();

        assertThat(actual, is(expected));
    }

}
