package pl.sda.elevatorex.model;

import jakarta.persistence.*;

@Entity
@Table(name ="officer")
public class OfficerJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Rank rank;

    private String name;

    public OfficerJpa(Integer id, Rank rank, String name) {
        this.id = id;
        this.rank = rank;
        this.name = name;
    }

    public OfficerJpa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OfficerJpa{" +
                "id=" + id +
                ", rank=" + rank +
                ", name='" + name + '\'' +
                '}';
    }


}
