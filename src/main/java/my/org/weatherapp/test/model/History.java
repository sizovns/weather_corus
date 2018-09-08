package my.org.weatherapp.test.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "history", schema = "weather")
public class History {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, unique = true)
    private long id;

    @Column(name = "history", updatable = false, nullable = false)
    private String history;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof History)) return false;
        History history1 = (History) o;
        return id == history1.id &&
                Objects.equals(history, history1.history);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, history);
    }
}
