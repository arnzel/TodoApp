package models;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import play.data.validation.Email;
import play.data.validation.Max;
import play.data.validation.MaxSize;
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
    @MaxSize(255)
    public String name;

    @Unique
    @Required
    @Email
    @MaxSize(255)
    public String email;

    @Required
    @MaxSize(255)
    public String password;
    
    public String toString(){
        return ReflectionToStringBuilder.toString(this);
    }
}
