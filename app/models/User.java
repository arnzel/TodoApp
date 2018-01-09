package models;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import play.data.validation.*;
import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created by arne on 30.06.17.
 */
@Entity
public class User extends Model {

    public User(){
        
    }
    
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Unique
    @Required
    @MaxSize(255)
    public String name;

    @Unique
    @Required
    @Email
    @MaxSize(255)
    public String email;

    @Required
    @MaxSize(255)
    @MinSize(6)
    public String password;
    
    public String toString(){
        return ReflectionToStringBuilder.toString(this);
    }
}
