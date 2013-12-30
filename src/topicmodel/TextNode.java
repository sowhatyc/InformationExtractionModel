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
public class TextNode {
    private List<TextNodeUnit> textNode = null;

    /**
     * @return the textNode
     */
    public List<TextNodeUnit> getTextNode() {
        return textNode;
    }

    /**
     * @param textNode the textNode to set
     */
    public void setTextNode(List<TextNodeUnit> textNode) {
        this.textNode = textNode;
    }
}
