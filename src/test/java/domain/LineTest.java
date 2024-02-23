package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

import domain.line.Line;
import domain.line.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
    @Test
    @DisplayName("가로 라인은 겹치지 않아야 한다.")
    void isLineCannotNextToLine() {
        int personCount = 5;
        Line line = new Line(personCount, new FixedBooleanGenerator());
        List<Point> points = line.getPoints();
        int isInvalidLine = Collections.indexOfSubList(points, List.of(Point.CONNECTED, Point.CONNECTED));

        assertEquals(-1, isInvalidLine);
    }
}

class FixedBooleanGenerator implements BooleanGenerator {
    @Override
    public Boolean generate() {
        return true;
    }
}
