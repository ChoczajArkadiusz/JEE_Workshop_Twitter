package pl.coderslab.spring.domain.model;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tweeter_tweet")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 50)
    @NotNull
    @NotBlank
    private String title;

    @Size(max = 160)
    @NotNull
    @NotBlank
    private String tweetText;

    private LocalDateTime created;

    @PrePersist
    void prePersist() {
        this.created = LocalDateTime.now();
    }

    @OneToOne
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweet that = (Tweet) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tweetText='" + tweetText + '\'' +
                ", created=" + created +
                ", user=" + user.getFirstName() + " " + user.getLastName() +
                '}';
    }
}
