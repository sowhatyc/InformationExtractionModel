/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package topicmodel;

import Utils.StaticLib;
import Utils.WebCrawler;
import topicmodel.TextNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

/**
 *
 * @author YangC
 */
public class Test {
    
    public static void main(String args[]){
    	//mop楼主无法抽出,55bbs对齐为一个
    				  boolean isListPage = false;
            //        System.out.println(new WebCrawler().getContent("http://bbs.tianya.cn/list-develop-1.shtml"));
            //        System.out.println(new WebCrawler().getContentMethod2("http://bbs.tianya.cn/list-develop-1.shtml"));
//                    String url = "http://bbs.tianya.cn/list-828-1.shtml";
//                    String url = "http://bbs.tianya.cn/post-828-207037-1.shtml";
//                    String url = "http://tieba.baidu.com/f?ie=utf-8&kw=%B1%F6%B5%C3k5";
//                    String url = "http://tieba.baidu.com/p/2426049054";
//                    String url = "http://bbs.gfan.com/forum-1260-1.html";
//                    String url = "http://bbs.gfan.com/forum.php?mod=viewthread&tid=6273531&extra=page%3D1";
//                    String url = "http://bbs.anzhi.com/thread-6988307-1-1.html";
//                    String url = "http://bbs.anzhi.com/forum-1020-1.html";
//                    String url = "http://www.smzdm.com/";
//                    String url = "http://forum.xitek.com/forum-2-1.html";
//    				String url = "http://forum.xitek.com/thread-1284457-1-1-1.html";
//                    String url = "http://tt.mop.com/topic/list_1_8_0_0.html";
//    				String url = "http://tt.mop.com/read_14764521_1_0.html";
//                    String url = "http://bbs.ifeng.com/forumdisplay.php?fid=218";
//    				String url = "http://bbs.ifeng.com/viewthread.php?tid=17327178&extra=page%3D1";
//                    String url = "http://bbs.news.163.com/list/society.html";
//    				String url = "http://bbs.news.163.com/bbs/society/391930141.html";
//    				String url = "http://club.history.sina.com.cn/forum-51-1.html";
//    				String url = "http://club.history.sina.com.cn/thread-5830958-1-1.html";
//    				String url = "http://club.kdnet.net/list.asp?boardid=1";
//    				String url = "http://club.kdnet.net/dispbbs.asp?id=9945001&boardid=1";
//    	 			String url = "http://pop.pcpop.com/forum-2-1.html";
//    				String url = "http://pop.pcpop.com/thread-6825685-1-1.html";
//    				String url = "http://bbs.taobao.com/catalog/424015----1.htm?spm=0.0.0.0.8TuYtx#ThreadList";
//    				String url = "http://bbs.taobao.com/catalog/thread/154521-266736309.htm?spm=0.0.0.0.AG7wQo";
//    				String url = "http://club.auto.qq.com/f-16-1.htm";
//    				String url = "http://club.auto.qq.com/t-650503-1.htm";
//    				String url = "http://bbs.meizu.cn/forum-22-1.html";
//    				String url = "http://bbs.meizu.cn/thread-4955381-1-1.html";
//    				String url = "http://www.hbvhbv.info/forum/forum-27-1.html";
//    				String url = "http://www.hbvhbv.info/forum/thread-1200391-1-1.html";
//    				String url = "http://bbs.soufun.com/asp/index/focusList.aspx";
//    				String url = "http://guoyuncun.soufun.com/bbs/1010739127~-1/104577646_104577646.htm";
//    				String url = "http://bbs.55bbs.com/forum-7-1.html";
//    				String url = "http://bbs.55bbs.com/thread-9067689-1-1.html";
//    				String url = "http://bbs.1lou.com/forum-index-fid-951.htm";
//    				String url = "http://bbs.1lou.com/thread-index-fid-2-tid-4132678.htm";
//    				String url = "http://newbbs.fengniao.com/forum_65.html";
//    				String url = "http://newbbs.fengniao.com/3198414.html";
//    				String url = "http://bbs.mydrivers.com/forum-92-1.html";
//    				String url = "http://bbs.mydrivers.com/thread-300812-1-1.html";
//    				String url = "http://bbs.rayli.com.cn/forum-19-1.html";
//    				String url = "http://bbs.rayli.com.cn/thread-51899708-1-1.html";
//    				String url = "http://bbs.huanqiu.com/forum-57-1.html";
//    				String url = "http://bbs.huanqiu.com/thread-1511375-1-1.html";
//    				String url = "http://www.19lou.com/forum-9-1.html";
//    				String url = "http://www.19lou.com/forum-9-thread-6181395323795041-1-1.html";
//    				String url = "http://bbs.southcn.com/forum-14-1.html";
//    				String url = "http://bbs.southcn.com/thread-565952-1-1.html";
//    				String url = "http://house.focus.cn/msglist/7366/";
//    				String url = "http://house.focus.cn/msgview/7366/290964942.html";
//    				String urn = "http://bbs.17173.com/forum-1795-1.html";
//    				String url = "http://bbs.17173.com/thread-7920518-1-1.html";
//    				String url = "http://bbs.ikaka.com/showforum-112.aspx";
//    				String url = "http://bbs.ikaka.com/showtopic-9169674.aspx";
//    				String url = "http://bbs.dospy.com/forum-855-1.html";
//    				String url = "http://bbs.dospy.com/thread-16886246-1-855-1.html";
//    				String url = "http://itbbs.pconline.com.cn/notebook/f301622.html";
//    				String url = "http://itbbs.pconline.com.cn/notebook/16499661.html";
//    				String url = "http://bbs.wps.cn/forum-fensileyuan-1.html";
//    				String url = "http://bbs.wps.cn/thread-22392300-1-1.html";
//    				String url = "http://91baby.mama.cn/forum-40-1.html";
//    				String url = "http://91baby.mama.cn/thread-1118421-1-1.html";
//    				String url = "http://club.alipay.com/thread.php?fid=752";
//    				String url = "http://club.alipay.com/read-htm-tid-10760953.html";
//    				String url = "http://bbs.guoxue.com/forumdisplay.php?fid=5074";
//    				String url = "http://bbs.guoxue.com/viewthread.php?tid=765400&extra=page%3D1";
//    				String url = "http://bbs.hupu.com/cba";
//    				String url = "http://bbs.hupu.com/9230926.html";
//    				String url = "http://bbs.xdnice.com/forum-17-1.html";
//    				String url = "http://bbs.xdnice.com/thread-871668-1-1.html";
//    				String url = "http://bbs.uc.cn/forum-366-1.html";
//    				String url = "http://bbs.uc.cn/thread-4769687-1-1.html";
//    				String url = "http://bbs.shangdu.com/f/01001001/";
//    				String url = "http://bbs.shangdu.com/t/20140404/01001001630420/630420-1.htm";
//    				String url = "http://www.admin5.net/forum-310-1.html";
//    				String url = "http://www.admin5.net/thread-14057221-1-1.html";
//    				String url = "http://bbs.8264.com/forum-12-1.html";
//    				String url = "http://bbs.8264.com/thread-1851751-1-1.html";
//    				String url = "http://www.6665.com/forum-4474-1.html";
    				String url = "http://www.6665.com/thread-2997175-1-1.html";
//    				String url = "http://www.abbs.com.cn/bbs/post/page?bid=1&sty=1&age=0";
//    				String url = "http://www.abbs.com.cn/bbs/post/view?bid=1&id=340146296&sty=1&tpg=1&age=0";
                    String retVal[] = new WebCrawler().getContent(url);
                    PageAnalysis pa = new PageAnalysis();
//                    StringBuffer sb = new StringBuffer();
//                    BufferedReader br = null;
//                    try {
//						br = new BufferedReader(new FileReader("Example.txt"));
//						String s;
//	                    while((s = br.readLine()) != null){
//	                    	sb.append(s);
//	                    }
//	                    br.close();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//                    List<Elements> elesList = pa.getAnalysisiElements(sb.toString(), url, true);
                    List<Elements> elesList = pa.getAnalysisiElements(retVal[1], url, isListPage);
//        String content = new WebCrawler().getContentMethod2(url);
//                    long start = System.currentTimeMillis();
//                    Document doc = Jsoup.parse(retVal[1], StaticLib.getBaseUrl(url));
//                    Elements elements = doc.body().getElementsByTag("tbody");
//                    for(Element element : elements){
//                        System.out.println(element.toString());
//                    }
                    
//                    Element element = doc.body();
//                    Element cpyElement = element.clone();
//                    cleanTree(cpyElement);
            //        Map<String, ArrayList<Element>> sequenceMap = getSequenceMap(element, 2);
            //        Map<Element, ArrayList<String>> parentStructualMap = getParentStructualMap(sequenceMap);
            //        parentStructualMap = unionParentStructualMap(parentStructualMap, element);
            //        Iterator<Element> keyIter = parentStructualMap.keySet().iterator();
            //        while(keyIter.hasNext()){
            //            Element ele = keyIter.next();
            //            System.out.println("Parent Sequence : " + getHierarchicalSequence(ele, 2, true));
            //            System.out.println("Son Element Sequence : ");
            //            for(String sequence : parentStructualMap.get(ele)){
            //                System.out.println(sequence + "  " + sequenceMap.get(sequence).size());
            //            }
            //            System.out.println("*********************************");
            //        }
//                    Map<Element, FreqElementAttr> eleInfo = getFreqEleInfo(cpyElement);
            //        Iterator<String> iterLoc = locationMarks.keySet().iterator();
            //        while(iterLoc.hasNext()){
            //            String attrKey = iterLoc.next();
            //            Iterator<String> iterVal = locationMarks.get(attrKey).iterator();
            //            while(iterVal.hasNext()){
            //                System.out.println(attrKey + "=\"" + iterVal.next() + "\"");
            //            }
            //        }
//                    Iterator<Element> iter = eleInfo.keySet().iterator();
//                    while(iter.hasNext()){
//                        Element ele = iter.next();
//                        System.out.println("Element sequence : " + getVerifiedSequence(ele, 1, true, true));
//                        System.out.println("Componet Size : " + eleInfo.get(ele).getComponentSize());
//                        System.out.println("Continual Num : " + eleInfo.get(ele).getContinualNum());
//                        System.out.println("AttrKey : " + eleInfo.get(ele).getAttrKey());
//                        System.out.println("AttrVal : " + eleInfo.get(ele).getAttrVal());
//                        if(eleInfo.get(ele).getStartElementsInfo() != null){
//                            System.out.println("Start Ele Info: ");
//                            for(String startInfo : eleInfo.get(ele).getStartElementsInfo()){
//                                System.out.println(startInfo); 
//                            }
//                        }
//                        System.out.println();
//                        System.out.println("******************************");
//                    }
//                    System.out.println(System.currentTimeMillis() - start);
                    
            //        Iterator<String> keyIter = sequenceMap.keySet().iterator();
            //        while(keyIter.hasNext()){
            //            String key = keyIter.next();
            //            System.out.println(key + "   :  " + sequenceMap.get(key).size());
            //        }
            //        List<Element> sortedEleList = sortElementBySize(element);
            //        for(Element ele: sortedEleList){
            //            printElement(ele, 0, 2);
            //            System.out.println("*************************************");
            //            System.out.println("*************************************");
            //            System.out.println("*************************************");
            //        }
                    
            //        Element elementMax = element;
            //        elementMax = findMaxChildEle(element, elementMax);
            //        printElement(elementMax, 0);
            //        System.out.println("*************************************");
            //        System.out.println("*************************************");
            //        System.out.println("*************************************");
            //        printElement(element, 0);
            //        for(Node node : nodes){
            //            printNode(node, 0);
            //        }
            //        Elements elements = doc.getElementsByTag("a");
            //        for(Element ele : elements){
            //            System.out.print(ele.attr("abs:href") + "    ");
            //            System.out.println(ele.text());
            //        }
//        try {
//            Document doc = Jsoup.parse(new File(StaticLib.extractorRulesPath), "utf-8");
//            Elements elements = doc.getElementsByTag("domainname");
//            for(Element ele : elements){
//                String domainName = ele.ownText();
//                String componentSize = ele.getElementsByTag("componentSize").first().ownText();
//                String continualnum = ele.getElementsByTag("continualnum").first().ownText();
//                String attrkey = ele.getElementsByTag("attrkey").first().ownText();
//                String attrval = ele.getElementsByTag("attrval").first().ownText();
//                Elements startInfoEles = ele.getElementsByTag("eleinfo");
//                System.out.println("domainName : " + domainName);
//                System.out.println("componentSize : " + componentSize);
//                System.out.println("continualnum : " + continualnum);
//                System.out.println("attrkey : " + attrkey);
//                System.out.println("attrval : " + attrval);
//                for(Element infoEle : startInfoEles){
//                    String eleInfo = infoEle.ownText();
//                    System.out.println("eleInfo : " + eleInfo);
//                }
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        List<Elements> elesList = pa.getAnalysisiElements(content, url, true);
        System.out.println(elesList.size());
        List<EntityNode> elementTextList = pa.getElementNode(elesList);
        
//        Map<String, List<EntityNode>> similarEntityNodes = pa.getSimilarEntityNodes(elementTextList);
//        int maxSize = Integer.MIN_VALUE;
//        String maxSeq = "";
//        Iterator<String> iter = similarEntityNodes.keySet().iterator();
//        while(iter.hasNext()){
//        	String seq = iter.next();
//        	if(similarEntityNodes.get(seq).size() > maxSize){
//        		maxSeq = seq;
//        		maxSize = similarEntityNodes.get(seq).size();
//        	}
//        }
//        System.out.println(maxSeq);
        
        
//        List<List<String>> entrys = pa.displayElementTextList(similarEntityNodes.get(maxSeq));
        List<List<String>> entrys = pa.displayElementTextList(elementTextList);
        int count = 0;
        for(List<String> entry : entrys){
        	if(count++ > 30){
        		break;
        	}
            System.out.println("*******************************");
            int num = 0;
            for(String str : entry){
                System.out.println(num + "  :   " + str);
                num++;
            }
        }
        
        System.out.print("\n\n\n");
        if(isListPage){
        	pa.getListFeatures(elementTextList);
        }else{
        	pa.getContentFeatures(elementTextList);
        }
//        pa.getFeatures(elementTextList, false);
        
//        Map<String, ArrayList<Element>> minimalGeneralSeq = pa.getMinimalGeneralizationSeq(elesList);
//        Iterator<String> iter = minimalGeneralSeq.keySet().iterator();
//        while(iter.hasNext()){
//            String str = iter.next();
//            System.out.println(str);
//            System.out.println(minimalGeneralSeq.get(str).size());
//        }
    }
    
    
    public static Map<Element, FreqElementAttr> getFreqEleInfo(Element cleanTreeRoot){
        Map<Element, FreqElementAttr> feMap = getFreqElement(cleanTreeRoot);
        Map<String, ArrayList<Element>> seqEleMap = getSeqEleMap(feMap.keySet(), 2, false, false);
//        Map<String, Set<String>> locationMarks = new HashMap<>();
        Iterator<String> iterStr = seqEleMap.keySet().iterator();
        int maxCount = 0;
        Element maxEle = null;
        while(iterStr.hasNext()){
            ArrayList<Element> eleList = seqEleMap.get(iterStr.next());
            Attributes attrs = eleList.get(0).attributes();
            String attrKey = "";
            String attrVal = "";
            int min = Integer.MAX_VALUE;
            if(attrs.size() != 0){
                for(Attribute attr : attrs){
                    Elements elements = cleanTreeRoot.getElementsByAttributeValue(attr.getKey(), attr.getValue());
                    if(elements.containsAll(eleList) && elements.size() < min){
                        attrKey = attr.getKey();
                        attrVal = attr.getValue();
                        min = elements.size();
                    }
                    elements = cleanTreeRoot.getElementsByAttribute(attr.getKey());
                    if(elements.containsAll(eleList) && elements.size() < min){
                        attrKey = attr.getKey();
                        attrVal = "@OnlyAttrKey";
                        min = elements.size();
                    }
                } 
            }
            Elements elements = cleanTreeRoot.getElementsByTag(eleList.get(0).tagName());
            if(elements.containsAll(eleList) && elements.size() < min){
                attrKey = eleList.get(0).tagName();
                attrVal = "@OnlyTagName";
            }
            feMap.get(eleList.get(0)).setAttrKey(attrKey);
            feMap.get(eleList.get(0)).setAttrVal(attrVal);
            int size = feMap.get(eleList.get(0)).getContinualNum() * eleList.size();
            feMap.get(eleList.get(0)).setContinualNum(size);
            if(size > maxCount){
                maxCount = size;
                maxEle = eleList.get(0);
            }
            for(int i=1; i<eleList.size(); i++){
                feMap.remove(eleList.get(i));
            }
        }
        List<Element> eleList = new ArrayList<>(feMap.keySet());
        for(Element ele : eleList){
            if(ele != maxEle){
                feMap.remove(ele);
            }
        }
        if(feMap.size() != 1){
            System.err.println("Something Wrong!");
        }
        return feMap;
    }
    
    public static Map<String, ArrayList<Element>> getSeqEleMap(Set<Element> elementSet, int level, boolean includeAtt, boolean includeAttVal){
        Map<String, ArrayList<Element>> seqEleMap = new HashMap<>();
        Iterator<Element> iter = elementSet.iterator();
        while(iter.hasNext()){
            Element ele = iter.next();
            String sequence = getVerifiedSequence(ele, level, includeAtt, includeAttVal);
            if(seqEleMap.containsKey(sequence)){
                seqEleMap.get(sequence).add(ele);
            }else{
                ArrayList<Element> eleList = new ArrayList<>();
                eleList.add(ele);
                seqEleMap.put(sequence, eleList);
            }
        }
        return seqEleMap;
    }
    
    public static Map<Element, ArrayList<String>> getParentStructualMap(Map<String, ArrayList<Element>> sequenceMap){
        if(sequenceMap.isEmpty() || sequenceMap == null){
            return null;
        }
        Map<Element, ArrayList<String>> parentStructualMap = new HashMap<>();
        Iterator<String> iter = sequenceMap.keySet().iterator();
        while(iter.hasNext()){
            String sequence = iter.next();
            Element parentEle = getCoownerParent(sequenceMap.get(sequence));
            if(parentStructualMap.containsKey(parentEle)){
                parentStructualMap.get(parentEle).add(sequence);
            }else{
                ArrayList<String> sequenceList = new ArrayList<>();
                sequenceList.add(sequence);
                parentStructualMap.put(parentEle, sequenceList);
            }
        }
        return parentStructualMap;
    }
    
    public static Map<Element, ArrayList<String>> unionParentStructualMap(Map<Element, ArrayList<String>> parentStructualMap, Element root){
        
        while(true){
            Set<Element> eleSet = parentStructualMap.keySet();
            boolean updated = false;
            Iterator<Element> iter = eleSet.iterator();
            while(iter.hasNext()){
                Element ele = iter.next();
                if(ele == root){
                    continue;
                }
                for(Element parentEle : ele.parents()){
                    if(parentEle == root){
                        break;
                    }else if(eleSet.contains(parentEle)){
                        parentStructualMap.get(parentEle).addAll(parentStructualMap.get(ele));
                        parentStructualMap.remove(ele);
                        updated = true;
                        break;
                    }
                }
                if(updated){
                    break;
                }
            }
            if(updated){
                continue;
            }else{
                break;
            }
        }
        return parentStructualMap;
    }
    
    public static Element getCoownerParent(ArrayList<Element> elementList){
        if(elementList.isEmpty() || elementList == null){
            return null;
        }
//        ArrayList<Elements> parentsList = new ArrayList<>();
//        int minParentsCount = Integer.MAX_VALUE;
//        int minIndex = -1;
//        for(int i=0; i<elementList.size(); i++){
//            parentsList.add(elementList.get(i).parents());
//            if(elementList.get(i).parents().size() < minParentsCount){
//                minParentsCount = elementList.get(i).parents().size();
//                minIndex = i;
//            }
//        }
//        Elements minimalParents = parentsList.get(minIndex);
//        Element coownerParent = null;
//        for(Element pEle : minimalParents){
//            boolean isParent = true;
//            for(Elements eles : parentsList){
//                if(!eles.contains(pEle)){
//                    isParent = false;
//                    break;
//                }
//            }
//            if(isParent){
//               coownerParent = pEle;
//               break;
//            }
//        }
//        ****************************method 3**********************
//        int left = 0;
//        int right = minimalParents.size();
//        Element coownerParent = null;
//        while(left < right){
//            int mid = (left + right) / 2;
//            Element pEle = minimalParents.get(mid);
//            boolean isParent = true;
//            for(Elements eles : parentsList){
//                if(!eles.contains(pEle)){
//                    isParent = false;
//                    break;
//                }
//            }
//            if(isParent){
//                coownerParent = pEle;
//                right = mid;
//            }else{
//                left = mid + 1;
//            }
//        }
//        ********************** method 2 ********************
        Elements parentEles = elementList.get(0).parents();
        Element coownerParent = null;
        for(Element parentEle : parentEles){
            boolean isParent = true;
            for(Element ele : elementList){
                if(!ele.parents().contains(parentEle)){
                    isParent = false;
                    break;
                }
            }
            if(isParent){
               coownerParent = parentEle;
               break;
            }
        }
        return coownerParent;
    }
    
    
    public static Map<Element, FreqElementAttr> getLatentFreqElement(Element root){
        Map<Element, FreqElementAttr> feMap = new HashMap<>();
        List<Element> elements = new LinkedList<>();
        elements.add(root);
        while(!elements.isEmpty()){
            Element element = elements.get(0);
//            String sequence = getHierarchicalSequence(element, 1, true, true).replaceAll("@null", "");
            FreqElementAttr lfe = isFreqElement(element, feMap.containsKey(element.parent()));
            Elements childEles = element.children();
            for(Element childEle : childEles){
                elements.add(childEle);
            }
            elements.remove(0);
            if(lfe != null){
                feMap.put(element, lfe);
            }
        }
        return feMap;
    }
    
    public static Map<Element, FreqElementAttr> getFilteredFreqElement(Map<Element, FreqElementAttr> feMap, Element root){
        Map<String, ArrayList<Element>> seqEleMap = getSeqEleMap(feMap.keySet(), 2, false, false);
        Set<String> sequenceDone = new HashSet<>();
        Iterator<String> iterSeq = seqEleMap.keySet().iterator();
        while(iterSeq.hasNext()){
            String sequence = iterSeq.next();
            if(sequenceDone.contains(sequence)){
                continue;
            }
            ArrayList<Element> eleList = seqEleMap.get(sequence);
            Element eleParent = eleList.get(0).parent();
            while(eleParent != root){
                if(feMap.containsKey(eleParent)){
                    if(eleList.size() < feMap.get(eleParent).getContinualNum()){
                        for(Element ele : eleList){
                            feMap.remove(ele);
                        }
                    }else{
                        String parentSeq = getVerifiedSequence(eleParent, 2, false, false);
                        sequenceDone.add(parentSeq);
                        feMap.remove(eleParent);
                    }
                    break;
                }
                eleParent = eleParent.parent();
            }
            sequenceDone.add(sequence);
        }
        return feMap;
    }
    
    public static Map<Element, FreqElementAttr> getFreqElement(Element root){
        Map<Element, FreqElementAttr> feMap  = getLatentFreqElement(root);
        if(feMap.size() > 1){
            feMap = getFilteredFreqElement(feMap, root);
        }
//        List<Element> eleList = new ArrayList<>(feMap.keySet());
//        for(Element ele : eleList){
//            Element previousEle = ele.previousElementSibling();
//            if(!feMap.containsKey(previousEle) && previousEle != null  && feMap.get(ele).getComponentSize() == 1){
//                FreqElementAttr fea = new FreqElementAttr();
//                fea.setComponentSize(1);
//                fea.setContinualNum(1);
//                List<String> startElementInfo = new ArrayList<>();
//                startElementInfo.add("@null");
//                fea.setStartElementsInfo(startElementInfo);
//                feMap.put(previousEle, fea);
//            }
//        }
        return feMap;
    }
    
    public static FreqElementAttr isFreqElement(Element element, boolean latentNodeChild){
        int continualOccourence;
        if(latentNodeChild){
            continualOccourence = 2;
        }else{
            continualOccourence = 5;
        }
        Elements childElements = element.children();
        if(childElements.size() < continualOccourence){
            return null;
        }
        List<String> childEleSequence = new ArrayList<>();
        for(Element ele : childElements){
            String sequence = getHierarchicalSequence(ele, 2, false, false);
            childEleSequence.add(sequence.replaceAll("@null", ""));
        }
        int maxOccourence = 0;
        int componetSize;
        List<String> startElementsInfo = new ArrayList<>();
        for(componetSize=1; componetSize<=childElements.size()/continualOccourence; componetSize++){
            int occourence = 1;
            maxOccourence = 0;
            for(int i=0; i<componetSize; i++){
                int currentIndex = i;
                String currentSequence = "";
                String nextSequence = "";
                for(int j=currentIndex; j<currentIndex+componetSize; j++){
                    currentSequence += childEleSequence.get(j);
                }
                while(currentIndex+2*componetSize <= childElements.size()){
                    if(occourence == 1 && currentIndex > (childElements.size() - componetSize * continualOccourence)){
                        break;
                    }
                    for(int j=currentIndex+componetSize; j<currentIndex+2*componetSize; j++){
                        nextSequence += childEleSequence.get(j);
                    }
                    if(currentSequence.compareTo(nextSequence) == 0){
                        if(occourence == 1){
                            startElementsInfo.clear();
                            String info = "";
                            for(int k=currentIndex; k<currentIndex+componetSize; k++){
                                Element eleInfo = childElements.get(k);
                                info = "@" + eleInfo.tagName();
                                for(Attribute attr : eleInfo.attributes()){
                                    info += " " + attr.getKey();
                                }
                            }
                            startElementsInfo.add(info);
                        }
                        occourence++;
                    }else{
                        if(occourence > maxOccourence && isSequenceSingleLevel(currentSequence)){
                            maxOccourence = occourence;
                        }
                        occourence = 1; 
                        currentSequence = nextSequence;
                    }
                    currentIndex += componetSize;
                    nextSequence = "";
                }
                if(occourence > maxOccourence && isSequenceSingleLevel(currentSequence)){
                    maxOccourence = occourence;
                }
                if(maxOccourence >= continualOccourence){
                    break;
                }
            }
            if(maxOccourence >= continualOccourence){
                break;
            }
        }
        if(maxOccourence >= continualOccourence){
            FreqElementAttr lfe = new FreqElementAttr();
            lfe.setComponentSize(componetSize);
            lfe.setContinualNum(maxOccourence);
            lfe.setStartElementsInfo(startElementsInfo);
            return lfe;
        }else{
            return null;
        }
    }
    
    public static boolean isSequenceSingleLevel(String sequence){
        Pattern pattern = Pattern.compile("<[^/]+?><[^/]+?>");
        Matcher matcher = pattern.matcher(sequence);
        return matcher.find();
    }
    
    public static Map<String, ArrayList<Element>> getSequenceMap(Element eleRoot, int level){
        List<Element> elementList = getElementList(eleRoot);
        Map<String, ArrayList<Element>> sequenceMap = new HashMap<>();
        for(Element ele : elementList){
            if(ele == eleRoot){
                continue;
            }
            String sequence = getVerifiedSequence(ele, level, false, false);
            if(sequence == null){
                continue;
            }
            if(sequenceMap.containsKey(sequence)){
                sequenceMap.get(sequence).add(ele);
            }else{
                ArrayList<Element> eleList = new ArrayList<>();
                eleList.add(ele);
                sequenceMap.put(sequence, eleList);
            }
        }
        return sequenceMap;
    }
    
    public static String getVerifiedSequence(Element element, int level, boolean includeAtt, boolean includeAttVal){
        String sequence = getHierarchicalSequence(element, level, includeAtt, includeAttVal);
        int emptyNodeNum = 0;
        int startIndex = 0;
        int findIndex = -1;
        while((findIndex = sequence.indexOf("@null", startIndex)) != -1){
            emptyNodeNum++;
            startIndex = findIndex + 5;
        }
        if(emptyNodeNum >= element.children().size()){
            return null;
        }else{
            return sequence.replaceAll("@null", "");
        }
    }
    
    public static String getHierarchicalSequence(Element element, int level, boolean includeAtt, boolean includeAttVal){
        if(level <= 0){
            return "";
        }
        String sequence = "<" + element.tagName();
        if(includeAtt){
            Attributes attributes = element.attributes();
            for(Attribute attr : attributes){
                sequence += " " + attr.getKey();
                if(includeAttVal){
                    sequence += "=\"" + attr.getValue() + "\"";
                }
            }
        }
        sequence += ">";
        if(level > 1 && element.children().isEmpty()){
            sequence += "@null";
        }
        for(Element ele : element.children()){
            sequence += getHierarchicalSequence(ele, level-1, includeAtt, includeAttVal);
        }
        sequence += "</" + element.tagName() + ">";
        return sequence;
    }
    
    public static List<Element> sortElementBySize(Element root){
        List<Element> elementList = getElementList(root);
        Collections.sort(elementList, new Comparator<Element>(){

            @Override
            public int compare(Element o1, Element o2) {
//                throw new UnsupportedOperationException("Not supported yet.");
                return o2.children().size() - o1.children().size();
            }
            
        });
        return elementList;
    }
    
    public static List<Element> getElementList(Element root){
        List<Element> elementList = new ArrayList<Element>();
        elementList.add(root);
        for(Element ele : root.children()){
            elementList.addAll(getElementList(ele));
        }
        return elementList;
    }
    
    public static Element findMaxChildEle(Element elementRoot, Element retEle){
        if(elementRoot.children().size() > retEle.children().size() ){
            retEle = elementRoot;
        }
        for(Element ele : elementRoot.children()){
//            Element childMax = findMaxChildEle(ele, retEle);
//            if(childMax.children().size() > retEle.children().size()){
//                retEle = childMax;
//            }
            retEle = findMaxChildEle(ele, retEle);
        }
        return retEle;
    }
    
    public static void cleanTree(Element element){
        if(StaticLib.tagSet == null){
            StaticLib.initialTagSet();
        }
        if(!element.tag().formatAsBlock() && !StaticLib.tagSet.contains(element.tagName())){
            element.remove();
        }else{
            Elements elements = element.children();
            for(Element ele : elements){
                cleanTree(ele);
            }
        }
    }
    

    
    public static void printElement(Element element, int count, int level){
        if(level > 0 && count >= level){
            return;
        }
        for(int i=0; i<count; i++){
            System.out.print(" ");
        }
        System.out.print(element.nodeName() + " ");
        Attributes attributes = element.attributes();
        for(Attribute attr : attributes){
            System.out.print(attr.getKey() + "=" + attr.getValue() + " ");
        }
        System.out.println();
        for(Element ele : element.children()){
            printElement(ele, count+1, level);
        }
    }
    
    public static void printNode(Node node, int count){
//        if(node instanceof TextNode || node instanceof DataNode){
//            return;
//        }
        for(int i=0; i<count; i++){
            System.out.print(" ");
        }
//        System.out.print(node.toString());
        System.out.print(node.nodeName() + " ");
        Attributes attributes = node.attributes();
        for(Attribute attr : attributes){
            System.out.print(attr.getKey() + "=" + attr.getValue() + " ");
        }
        System.out.println();
        for(Node nd : node.childNodes()){
            printNode(nd, count+1);
        }
    }
}
