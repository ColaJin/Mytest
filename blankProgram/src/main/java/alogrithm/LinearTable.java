package alogrithm;

import java.lang.annotation.ElementType;
import java.util.LinkedList;
import java.util.List;

public class LinearTable {
    Integer MAXSIZE = 100;//数组长度

    void union(List la, List lb) {
        int la_len, lb_len;
        la_len = la.size();
        lb_len = lb.size();
        for (int i = 0; i < lb_len; i++) {
            Object o = lb.get(i);
            for (int j = 0; j < la_len; j++) {

                if (la.get(j) == o) {
                    break;
                } else {
                    la.add(o);
                }
            }
        }
    }

    boolean ListInsert(LinkedList arrList, int i, ElementType e) {
        if (arrList.size() == MAXSIZE) {/*顺序线性表已经满*/
            return false;
        }
        if (i < 1 || i > arrList.size()) {/*当i不在范围内*/
            return false;
        }
        if (i <= arrList.size()) {/*若插入数据位置不在表尾*/
            for (int j = arrList.size(); j > 0; j--) {
                arrList.set(j + 1, arrList.get(j));
            }
        }
        arrList.set(i,e);/*将新元素插入*/

        return true;
    }

    boolean ListDelete(LinkedList arrList,int i,ElementType e) {
        if (arrList.size() == 0){/*线性表为空*/
            return false;
        }
        if (i<1 || i>arrList.size()){/*删除位置不正确*/
            return false;
        }
        if (i < arrList.size()){
            for (int j = 0; j < arrList.size(); j++) {/*将删除元素后继位置前移*/
                arrList.set(j-1,arrList.get(j));
            }
        }
        return true;
    }

}
