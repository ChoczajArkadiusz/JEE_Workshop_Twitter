package pl.coderslab.spring.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring.domain.model.Tweet;

import java.util.List;


@Repository
@Transactional
public interface TweetRepository extends JpaRepository<Tweet, Long> {

    Tweet findById(Long id);

    List<Tweet> findAllByUserId(Long id);

    @Query("SELECT t FROM Tweet t WHERE t.tweetText LIKE ?1%")
    List<Tweet> findAllStartingWith(String phrase);


}
