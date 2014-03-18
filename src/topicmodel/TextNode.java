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
    public List<TextNodeUnit> getTextNodeUnit() {
        return textNode;
    }

    /**
     * @param textNode the textNode to set
     */
    public void setTextNodeUnit(List<TextNodeUnit> textNode) {
        this.textNode = textNode;
    }
}
