package org.example

typealias AdjacencyList<T> = MutableMap<T, MutableList<T>>

class Graph<T> {
    private val adjacencyList: AdjacencyList<T> = mutableMapOf()

    fun addNode(node: T) {
        adjacencyList.putIfAbsent(node, mutableListOf())
    }

    /**
     *  Function to add an edge
     *  Because it is undirected graph, we have to add at both side
     *  Avoid duplication of adding source and destination twice
     */
    fun addEdge(source: T, destination: T) {
        if (source?.equals(destination) == true) {return}
        val sourceNeighbors = adjacencyList.computeIfAbsent(source) { mutableListOf() }
        val destinationNeighbors = adjacencyList.computeIfAbsent(destination) { mutableListOf() }

        if (!sourceNeighbors.contains(destination)) {
            sourceNeighbors.add(destination)
        }

        if (!destinationNeighbors.contains(source)) {
            destinationNeighbors.add(source)
        }
    }

    /**
     * Function to display the graph
     */
    fun display() {
        for (node in adjacencyList.keys) {
            println("$node -> ${adjacencyList[node]}")
        }
    }

    /**
     * If multiple shortest path is found, return only one of those
     */
    fun shortestPath(start: T, end: T) : List<T> {
        var shortestPathList = emptyList<T>()
        var size = Int.MAX_VALUE
        val allPaths =  findAllPath(start, end)
        for (path in allPaths) {
           if (path.size < size) {
              size = path.size
              shortestPathList = path.toList()
           }
        }
        return shortestPathList
    }

    fun findAllPath(start: T, end: T) : List<List<T>> {
        val allPaths = mutableListOf<List<T>>()
        val visitedNodes = mutableListOf<T>()
        val currentPath = mutableListOf<T>()

        backtrack(start, end, visitedNodes, currentPath, allPaths)

        return allPaths.toList()
    }

    private fun backtrack(currentNode: T, endNode: T, visitedNodes: MutableList<T>, currentPath: MutableList<T>, allPaths: MutableList<List<T>>) {
        // Avoid repeat visit
        if (visitedNodes.contains(currentNode)) {
            return
        }
        visitedNodes.add(currentNode)
        currentPath.add(currentNode)

        // It means you find the path if current node equals to end node, else find all the path for the neighbour node
        if (currentNode?.equals(endNode) == true) {
            // Create new mutableList
            allPaths.add(currentPath.toList())
        } else {
            if (adjacencyList[currentNode] != null) {
                for (neighbor in adjacencyList[currentNode]!!) {
                    backtrack(neighbor, endNode, visitedNodes, currentPath, allPaths)
                }
            }
        }

        // backtrack
        currentPath.remove(currentNode)
        visitedNodes.remove(currentNode)
    }

}

fun main() {
    val graph = Graph<String>()

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

    val allPaths = graph.findAllPath("A","H")

    println(allPaths)

    val shortTestPath = graph.shortestPath("A","H")
    println(shortTestPath)
}