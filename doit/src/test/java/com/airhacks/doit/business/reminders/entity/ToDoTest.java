/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.doit.business.reminders.entity;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hijack
 */
public class ToDoTest {
    
    @Test
    public void validToDo() {
        ToDo valid = new ToDo("", "available", 11);
        assertTrue(valid.isValid());
    }
    @Test
    public void inValidToDo() {
        ToDo valid = new ToDo("", null, 11);
        assertFalse(valid.isValid());
    }
    
    @Test
    public void todoWithoutDescription() {
        ToDo valid = new ToDo("implement", null, 10);
        assertTrue(valid.isValid());
    }
}
