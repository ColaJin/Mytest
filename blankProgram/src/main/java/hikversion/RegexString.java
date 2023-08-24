package hikversion;

/**
 * 正则字符串
 * @author chenbin19
 * @since
 */
public class RegexString {
    /**
     * 多个英文字母正则表达式
     */
    public static final String LETTERS = "^[a-zA-Z]+$";

    /**
     * 数字正则表达式
     */
    public static final String NUMBERS = "^[0-9]+$";

    /**
     * 英文左括号
     */
    public static final String BRACKET_LEFT = "[\\(]";

    /**
     * 英文右括号
     */
    public static final String BRACKET_RIGHT = "[\\)]";

    /**
     * 与符号
     */
    public static final String SYMBOL_AND = "[&]";

    /**
     * 分隔符号
     */
    public static final String SYMBOL_SEPARATOR = "[\\(, \t\\)&]";

    /**
     * 需要存进valueStack的符号
     */
    public static final String SYMBOL_TO_PUSH = "[\\(&]";

    /**
     * 计算规则字符串匹配
     */
    public static final String RULE = "^[\\w\\s\\(\\),&]+$";
}
