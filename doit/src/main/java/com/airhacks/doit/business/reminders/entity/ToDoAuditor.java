package com.airhacks.doit.business.reminders.entity;

import com.airhacks.doit.business.reminders.boundary.ChangeEvent;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

/**
 *
 * @author Hijack
 */
public class ToDoAuditor {

    //ATTENTION: THIS INJECTION DOES NOT WORK WITH WILDFLY, ONLY WITH 'PAYARA'
    @Inject
    @ChangeEvent(ChangeEvent.Type.CREATION)
    Event<ToDo> create;

    @Inject
    @ChangeEvent(ChangeEvent.Type.UPDATE)
    Event<ToDo> update;

    @PostPersist
    public void onPersist(ToDo toDo) {
        this.create.fire(toDo);
//        System.out.println("----------toDo = " + toDo);
    }

    @PostUpdate
    public void onUpdate(ToDo toDo) {
        this.update.fire(toDo);
//        System.out.println("----------toDo = " + toDo);
    }
}
