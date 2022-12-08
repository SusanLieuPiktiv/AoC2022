package org.example.day_8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class Day8Test {
    @InjectMocks
    Day8 mDay8;

    final private String exampleInput =
            "30373\n" +
            "25512\n" +
            "65332\n" +
            "33549\n" +
            "35390\n";

    @Test
    void should_solve_a() throws IOException {
        final int actual = mDay8.solveA(new StringReader(exampleInput), 5);

        assertEquals(21, actual);
    }

    @Test
    void should_find_all_visible_in_small_forest() throws IOException {
        final String grid =
                "111\n" +
                "121\n" +
                "111\n";

        final int actual = mDay8.solveA(new StringReader(grid),3);
        assertEquals(9, actual);
    }

    @Test
    void should_parse_input_to_grid() throws IOException {
        final String input =
            "10372\n" +
            "25512\n" +
            "65532\n" +
            "33549\n" +
            "35394\n";

        final int[][] actual = mDay8.parseIntoGrid(new StringReader(input), 5);

        assertEquals(1, actual[0][0]);
        assertEquals(2, actual[0][4]);
        assertEquals(3, actual[4][0]);
        assertEquals(4, actual[4][4]);
        assertEquals(5, actual[2][2]);
    }

    @Test
    void should_not_find_middle_in_small_forest() throws IOException {
        final String grid =
                "111\n" +
                "101\n" +
                "111\n";

        final int actual = mDay8.solveA(new StringReader(grid),3);
        assertEquals(8, actual);
    }

    @Test
    void should_solve_b() throws IOException {
        final int actual = mDay8.solveB(new StringReader(exampleInput), 5);

        assertEquals(8, actual);
    }
}