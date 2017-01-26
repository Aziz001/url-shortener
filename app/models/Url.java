package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Url extends Model  {


    @Id
    @Constraints.Min(10)
    public Long id;

    @Constraints.Required
    public String url;

    public static Finder<Long, Url> find = new Finder<Long,Url>(Url.class);



}