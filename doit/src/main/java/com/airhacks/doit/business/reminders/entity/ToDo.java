package com.airhacks.doit.business.reminders.entity;

import com.airhacks.doit.business.validation.CrossCheck;
import com.airhacks.doit.business.validation.ValidEntity;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hijack
 */
@Entity
@NamedQuery(name = ToDo.findAll, query = "SELECT t FROM ToDo t")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@CrossCheck
@EntityListeners(ToDoAuditor.class)
public class ToDo implements ValidEntity {

    @Id
    @GeneratedValue
    private long id;

    public static final String PREFIX = "reminders.entity.ToDo.";
    public static final String findAll = PREFIX + "findAll";

    @NotNull
    @Size(min = 2, max = 256)
    private String caption;
    private String description;
    private int priority;

    private boolean done;

    /*
    JPA Runtime will change the value of the field on each update and will compare the value in der database 
    with the version of the incoming value. The update will only be successful in case the versions match!
    Otherwise OptimisticLockException will be raised bei JPA Runtime
     */
    @Version
    private long version;

    public ToDo() {
    }

    public ToDo(String caption, String description, int priority) {
        this.caption = caption;
        this.description = description;
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean isValid() {
        if (this.priority <= 10) {
            return true;
        }
        return (this.description != null && !this.description.isEmpty());
    }

    @Override
    public String toString() {
        return "ToDo{" + "id=" + id + ", caption=" + caption + ", description=" + description + ", priority=" + priority + ", done=" + done + ", version=" + version + '}';
    }

}
