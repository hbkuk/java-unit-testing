package Figure;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void create_rectangle() {
        // given
        List<Point> points = Arrays.asList(new Point(10, 20), new Point(5, 10),
                new Point(5, 20), new Point(10, 10));
        Rectangle rectangle = new Rectangle(points);

        //when
        String actureFigureName = rectangle.getName();
        int actureSize = rectangle.getSize();
        double actureArea = rectangle.getArea();

        //then
        assertThat(actureFigureName).isEqualTo("Rectangle");
        assertThat(actureSize).isEqualTo(4);
        assertThat(actureArea).isEqualTo(50);
    }

    @Test
    void create_failed_rectangle() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Rectangle(
                        Arrays.asList(new Point(10, 20), new Point(5, 9),
                                new Point(5, 20), new Point(10, 10))));
    }

}