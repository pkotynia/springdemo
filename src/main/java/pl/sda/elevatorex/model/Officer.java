package pl.sda.elevatorex.model;

import jakarta.persistence.*;

//@Entity
//@Table
public class Officer {

//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Enumerated(EnumType.STRING)
    private Rank rank;

    private String name;

    public Officer(int id, Rank rank, String name) {
        this.id = id;
        this.rank = rank;
        this.name = name;
    }

    public Officer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return "Officer{" +
                "id=" + id +
                ", rank=" + rank +
                ", name='" + name + '\'' +
                '}';
    }


}
