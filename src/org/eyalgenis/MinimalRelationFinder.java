package org.eyalgenis;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MinimalRelationFinder {
    Person[] people;
    Graph graph;

    public void Init(Person[] people) {
        this.people = people;
    }

    public int FindMinRelationLevel(Person personA, Person personB) {
        CreateGraph();
        Node source = graph.getNode(personA);
        calculateShortestPathFromSource(graph, source);
        Node destination = graph.getNode(personB);

        if (destination == null) return 0;
        return destination.getDistance();
    }

    private void CreateGraph() {
        int vertices = people.length; // assume ppl.length >= 2
        graph = new Graph();

        boolean isDirectRelation;
        for (int i=0; i<vertices; i++) {
            for (int j=0; j<vertices; j++) {
                if (i==j) continue;
                isDirectRelation = checkDirectRelation(people[i], people[j]);

                Node node1 = graph.getNode(people[i]);
                Node node2 = graph.getNode(people[j]);
                if (node1 == null) {
                    node1 = new Node(people[i]);
                    graph.addNode(node1);
                }
                if (node2 == null) {
                    node2 = new Node(people[j]);
                    graph.addNode(node2);
                }

                if (isDirectRelation) {
                    node1.addDestination(node2, 1);
                    node2.addDestination(node1, 1);
                }

            }
        }
    }

    private boolean checkDirectRelation(Person person, Person person1) {
        return person.related(person1);
    }

    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    private static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> adjacencyPair:
                    currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static Node getLowestDistanceNode(Set < Node > unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    public Person[] getPeople() {
        return people;
    }
}
