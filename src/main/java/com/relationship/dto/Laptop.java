package com.relationship.dto;

        import lombok.Data;

        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.GenerationType;
        import javax.persistence.Id;
        import javax.persistence.ManyToMany;
        import java.util.ArrayList;
        import java.util.Collection;

@Entity
@Data
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int laptopId;
    private String laptopName;
    @ManyToMany(mappedBy = "laptops")
    private Collection<UserDetails> userList = new ArrayList<UserDetails>();
}
