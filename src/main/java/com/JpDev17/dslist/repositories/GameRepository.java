package com.JpDev17.dslist.repositories;

import com.JpDev17.dslist.entities.Game;
import com.JpDev17.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
            SELECT tb_game.game_id AS id, tb_game.game_title AS title, tb_game.game_year AS gameYear, tb_game.game_img AS imgUrl,
            tb_game.game_short_description AS shortDescription, tb_game_belonging.game_belonging_position
            FROM tb_game
            INNER JOIN tb_game_belonging ON tb_game.game_id = tb_game_belonging.game_belonging_pk_id
            WHERE tb_game_belonging.game_belonging_pk_list_id = :listId
            ORDER BY tb_game_belonging.game_belonging_position
			    """)
    List<GameMinProjection> searchByList(Long listId);

}
