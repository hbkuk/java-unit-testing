package figure;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Rectangle {
    private List<Point> points;

    public Rectangle(List<Point> points) {
        if( !isRectangle(points) ) {
            throw new IllegalArgumentException();
        }
        this.points = points;
    }

    String getName() {
        return "Rectangle";
    }

    int getSize() {
        return 4;
    }

    double getArea() {
        return calculatorArea(points);
    }

    private double calculatorArea(List<Point> points) {
        Set<Integer> xValues = getUniqueXValue(points);
        Set<Integer> yValues = getUniqueYValue(points);

        return getWidth(xValues) * getHeight(yValues);
    }

    private static int getHeight(Set<Integer> yValues) {
        return Math.abs(getMaxValue(yValues) - getMinValue(yValues));
    }

    private static int getWidth(Set<Integer> xValues) {
        return Math.abs(getMaxValue(xValues) - getMinValue(xValues));
    }

    private static Integer getMinValue(Set<Integer> xValues) {
        return Collections.min(xValues);
    }

    private static Integer getMaxValue(Set<Integer> xValues) {
        return Collections.max(xValues);
    }

    private static Set<Integer> getUniqueYValue(List<Point> points) {
        Set<Integer> yValues = points.stream()
                .map(Point::getY)
                .collect(Collectors.toSet());
        return yValues;
    }

    private static Set<Integer> getUniqueXValue(List<Point> points) {
        Set<Integer> xValues = points.stream()
                .map(Point::getX)
                .collect(Collectors.toSet());
        return xValues;
    }

    public static boolean isRectangle(List<Point> points) {
        Set<Integer> xValues = getUniqueXValue(points);
        Set<Integer> yValues = getUniqueYValue(points);

        if (!isHorizontal(xValues) || !isHorizontal(yValues)) {
            throw new IllegalArgumentException("직사각형 모양이 아닙니다.");
        }

        if (getWidth(xValues) == 0 && getHeight(yValues) == 0) {
            throw new IllegalArgumentException("높이 또는 너비가 0이 될순 없습니다.");
        }

        return true;
    }

    private static boolean isHorizontal(Set<Integer> Values) {
        return Values.size() == 2;
    }
}
