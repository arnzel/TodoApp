package models;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import play.data.validation.Email;
import play.data.validation.Required;
import play.data.validation.Unique;
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
    public String name;

    @Unique
    @Required
    @Email
    public String email;

    @Required
    public String password;
    
    public String toString(){
        return ReflectionToStringBuilder.toString(this);
    }
}
