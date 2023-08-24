package hikversion;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author:jinyandong
 * @description:测试配单入参处理结果
 * @Date:2023/6/30
 */
public class TestPeidan {
    public static void main(String[] args) {
//        getResult("Sum(N1,N2,N3,N4)&Sum(N5,N6,N7)&Sum(N8,N9,N10,N11)",)
    }
    public static Integer getResult(String rule, List<Integer> numList) {
        Stack<String> valueStack = parseRuleStr(rule, numList);
        String value = valueStack.pop();
        Integer result;
        if (value.matches(RegexString.NUMBERS)) {
            result = Integer.valueOf(value);
        } else {
            result = numList.get(Integer.parseInt(value.substring(1)) - 1);
        }
        return result;
    }

    private static Stack<String> parseRuleStr(String rule, List<Integer> numList) {
        if (StringUtils.isBlank(rule) || !rule.matches(RegexString.RULE) || CollectionUtils.isEmpty(numList)) {
            return new Stack<>();
        }
        Stack<String> methodStack = new Stack<>();
        Stack<String> valueStack = new Stack<>();
        int beginIndex = 0; // 截取字符串的开始位置索引值
        for (int i = 0; i < rule.length(); i++) {
            String charStr = String.valueOf(rule.charAt(i));
            if (!charStr.matches(RegexString.SYMBOL_SEPARATOR)) { // 不是分隔符则视情况更新截取字符串的索引
                if (beginIndex == -1) {
                    beginIndex = i;
                }
                if (i == rule.length() - 1) {
                    valueStack.push(rule.substring(beginIndex));
                }
            } else { // 是分隔符
                if (beginIndex != -1) { // 前一个字符不是分隔符
                    if (rule.substring(beginIndex, i).matches(RegexString.LETTERS)) { // 截取的字符串是纯字母则为方法名，存方法栈
                        methodStack.push(rule.substring(beginIndex, i));
                    } else { // 截取的字符串不是纯字母则为参数值或变量，存值栈
                        valueStack.push(rule.substring(beginIndex, i));
                    }
                    beginIndex = -1; // 更新索引值为中断状态值
                }
                if (!charStr.matches(RegexString.BRACKET_RIGHT)) { // 不是右括号视情况保存分隔符到值栈
                    if (charStr.matches(RegexString.SYMBOL_TO_PUSH)) {
                        valueStack.push(charStr);
                    }
                } else { // 是右括号则弹出方法栈中的方法和值栈中的值（直到弹出左括号为止）进行计算，将计算结果存值栈
                    calculate(numList, methodStack, valueStack);
                }
            }
        }
        return valueStack;
    }

    /**
     * 依据方法栈和值栈进行计算并将计算结果存值栈
     *
     * @param numList     需要计算的数据源
     * @param methodStack 方法栈，保存方法名字符串
     * @param valueStack  值栈，保存括号、计算参数和数据源变量
     */
    private static void calculate(List<Integer> numList, Stack<String> methodStack, Stack<String> valueStack) {
        String methodName = methodStack.pop();
        List<Integer> valueList = new ArrayList<>();
        for (String value = valueStack.pop(); !value.matches(RegexString.BRACKET_LEFT); value = valueStack.pop()) {
            if (value.matches(RegexString.NUMBERS)) { // 数字直接解析后添加到待计算集合
                valueList.add(Integer.valueOf(value));
            } else { // 变量解析出索引后取出具体数据添加到待计算集合
                valueList.add(numList.get(Integer.parseInt(value.substring(1)) - 1)); // 变量索引从1开始
            }
        }
        int result = 0;
        try {
            Class<?> mathUtilClazz = Class.forName("com.hikvision.udcp.module.calculation.util.MathUtil");
            Method method = mathUtilClazz.getMethod(methodName.toLowerCase(), List.class);
            result = (int) method.invoke(null, valueList);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e);
        }
        valueStack.push(String.valueOf(result));
    }
}
