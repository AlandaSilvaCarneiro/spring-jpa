package alandev.com.projeto01.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_users")
public class Usua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private Double salary;          
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Usua(Long id, String email, Double salay) {
        this.id = id;
        this.email = email;
        this.salary = salay;
    }

    public String getEmail() {
        return email;
    }

    public Usua() {
    }

    public Usua(Long id, String email, Double salary, String name) {
        this.id = id;
        this.email = email;
        this.salary = salary;
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalay() {
        return salary;
    }

    public void setSalay(Double salay) {
        this.salary = salay;
    }

}
