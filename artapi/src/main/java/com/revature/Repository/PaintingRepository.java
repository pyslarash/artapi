package com.revature.Repository;

import com.revature.Model.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaintingRepository extends JpaRepository<Painting, Long> {

    List<Painting> findPaintingsByGenre(String genres);

    List<Painting> findPaintingsByTitle(String title);

    @Query("FROM Painting WHERE title = :title AND genre = :genre")
    List<Painting> findPaintingsByGenre(@Param("title") String title, @Param("genre") String genre);

}
