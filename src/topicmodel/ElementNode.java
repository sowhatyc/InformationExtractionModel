/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package topicmodel;

import java.util.List;

/**
 *
 * @author YangC
 */
public class ElementNode {
    
    private List<Node> nodes;
    private int positionIndex;

    /**
     * @return the nodes
     */
    public List<Node> getNodes() {
        return nodes;
    }

    /**
     * @param nodes the nodes to set
     */
    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    /**
     * @return the positionIndex
     */
    public int getPositionIndex() {
        return positionIndex;
    }

    /**
     * @param positionIndex the positionIndex to set
     */
    public void setPositionIndex(int positionIndex) {
        this.positionIndex = positionIndex;
    }
}
