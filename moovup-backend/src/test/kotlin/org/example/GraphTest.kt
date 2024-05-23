package org.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class GraphTest {

    private val graph = Graph<String>()

    @BeforeEach
    fun init() {
        // Add nodes
        graph.addNode("A")
        graph.addNode("B")
        graph.addNode("C")
        graph.addNode("D")
        graph.addNode("E")
        graph.addNode("F")
        graph.addNode("G")
        graph.addNode("H")

        graph.addEdge("A", "B")
        graph.addEdge("A", "D")
        graph.addEdge("A", "H")

        graph.addEdge("B", "A")
        graph.addEdge("B", "D")
        graph.addEdge("B", "C")

        graph.addEdge("C", "B")
        graph.addEdge("C", "F")

        graph.addEdge("D", "A")
        graph.addEdge("D", "B")
        graph.addEdge("D", "C")
        graph.addEdge("D", "E")

        graph.addEdge("E", "F")
        graph.addEdge("E", "D")
        graph.addEdge("E", "H")

        graph.addEdge("G", "F")
        graph.addEdge("G", "H")

        graph.addEdge("H", "A")
        graph.addEdge("H", "G")
    }

    @ParameterizedTest
    @CsvSource("A,H",
        "A,D,E,H",
        "A,B,C,F,G,H",
        delimiter = ';')
    fun testAllPossiblePaths(expectedPathsStr: String) {
        // Given:
        // When:
        val res = graph.findAllPath("A", "H")

        val expectedPaths = expectedPathsStr.split(",").map { it.trim() }.toCollection(ArrayList())
        var containsExpectedResult = false

        for (resPath in res) {
            if(resPath == expectedPaths) {
                containsExpectedResult = true
                break
            }
        }

        assertTrue(containsExpectedResult)
    }

    @Test
    fun testShortestPath() {
        // Given:
        // When:
        val res = graph.shortestPath("A", "H")

        // Then:
        val expectedPaths = listOf("A", "H")
        assertEquals(expectedPaths, res)
    }

}