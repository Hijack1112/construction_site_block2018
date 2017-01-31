package com.airhacks.doit.business.reminders.boundary;

import com.airhacks.doit.business.logging.boundary.BoundaryLogger;
import com.airhacks.doit.business.reminders.entity.ToDo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hijack
 */
@Stateless
@Interceptors(BoundaryLogger.class)
public class TodoManager {

    @PersistenceContext
    EntityManager em;

    public ToDo findById(long id) {
        return this.em.find(ToDo.class, id);
//        return new ToDo("implement REST Endpoint " + id, "...", 100);
    }

    public void delete(long id) {
        try {

            // .getReference deletes the proxy -> nullsafe, delete by findById will eventually throw a NPE
            ToDo reference = this.em.getReference(ToDo.class, id);
            this.em.remove(reference);
        } catch (EntityNotFoundException ex) {
            //we want to remove it
        }
        //        System.out.println("deleted = " + id);
    }

    public List<ToDo> all() {
//        List<ToDo> all = new ArrayList<>();
//        all.add(findById(42));
//        return all;
        return this.em.createNamedQuery(ToDo.findAll).getResultList();
    }

    public ToDo save(ToDo toDo) {
//        System.out.println("Saving = " + toDo);
        return this.em.merge(toDo);
    }

    public ToDo updateStatus(long id, boolean done) {
        ToDo todo = this.findById(id);
        if (todo == null) {
            return null;
        }
        todo.setDone(done);
        return todo;
    }

}
