package org.eyalgenis;

import java.util.HashSet;
import java.util.Set;

public class Graph {

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public Node getNode(Person person) {
        for (Node n : nodes) {
            if(n.getPerson().equals(person)) {
                return n;
            }
        }
        return null;
    }
}