/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package topicmodel;

import java.util.List;
import org.jsoup.nodes.Attributes;
import org.jsoup.parser.Tag;

/**
 *
 * @author YangC
 */
public class Node {
    
    private TextNodeUnit textNodeUnit;
    private List<Node> childNode;
    private boolean isAllHave;
    private Node parentNode;
    private boolean hasOwnIndividualChild;

    
    /**
     * @return the childNode
     */
    public List<Node> getChildNode() {
        return childNode;
    }

    /**
     * @param childNode the childNode to set
     */
    public void setChildNode(List<Node> childNode) {
        this.childNode = childNode;
    }

    /**
     * @return the isAllHave
     */
    public boolean isIsAllHave() {
        return isAllHave;
    }

    /**
     * @param isAllHave the isAllHave to set
     */
    public void setIsAllHave(boolean isAllHave) {
        this.isAllHave = isAllHave;
    }

    /**
     * @return the textNodeUnit
     */
    public TextNodeUnit getTextNodeUnit() {
        return textNodeUnit;
    }

    /**
     * @param textNodeUnit the textNodeUnit to set
     */
    public void setTextNodeUnit(TextNodeUnit textNodeUnit) {
        this.textNodeUnit = textNodeUnit;
    }

    /**
     * @return the parentNode
     */
    public Node getParentNode() {
        return parentNode;
    }

    /**
     * @param parentNode the parentNode to set
     */
    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    /**
     * @return the hasOwnIndividualChild
     */
    public boolean isHasOwnIndividualChild() {
        return hasOwnIndividualChild;
    }

    /**
     * @param hasOwnIndividualChild the hasOwnIndividualChild to set
     */
    public void setHasOwnIndividualChild(boolean hasOwnIndividualChild) {
        this.hasOwnIndividualChild = hasOwnIndividualChild;
    }

    
}
