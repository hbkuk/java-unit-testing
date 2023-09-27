package builder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoardTest {

    @Test
    void create_board() {
        Board board = new Board
                .Builder("제목 1", "자바국")
                .content("내용 1")
                .hit(1)
                .builder();

        assertThat(board.getTitle()).isEqualTo("제목 1");
        assertThat(board.getWriter()).isEqualTo("자바국");
        assertThat(board.getContent()).isEqualTo("내용 1");
        assertThat(board.getHit()).isEqualTo(1);

    }
}