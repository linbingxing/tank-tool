package org.tank.core.tool.utils;

import org.springframework.lang.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
  * @description 正则表达式工具
  * @author lbx
  * @date 2019/11/30 22:56
  * @version 1.0.0
 **/
public class RegexUtil {

    /**
     * 密码(以字母开头，长度在6~18之间，只能包含字母、数字和下划线)
     */
    public static final String PASSWORD ="^[a-zA-Z]\\w{5,17}$";
    /**
     * 邮箱
     */
    public static final String EMAIL = "^\\w+([-+.]*\\w+)*@([\\da-z](-[\\da-z])?)+(\\.{1,2}[a-z]+)+$";

    /**
     * 手机号
     */
    public static final String PHONE = "^1[3456789]\\d{9}$";

    /**
     * 手机号码正则表达式(模糊匹配版)=1 + 10位数字
     */
    public static final String	MOBILE_FUZZY = "^1\\d{10}$";

    /**
     * 固定电话
     */
    public static final String	TELEPHONE	= "^(([0-9-#]){1,20})$";

    /**
     * 手机号或者邮箱
     */
    public static final String EMAIL_OR_PHONE = EMAIL + "|" + PHONE;

    /**
     * URL路径
     */
    public static final String URL = "^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})(:[\\d]+)?([\\/\\w\\.-]*)*\\/?$";

    /**
     * 域名校验
     */
    public static final String DOMAIN = "^[0-9a-zA-Z]+[0-9a-zA-Z\\.-]*\\.[a-zA-Z]{2,4}$";

    /**
     * 纯数字
     */
    public static final String	NUMBER = "^\\d*$";

    /**
     * 以逗号隔开的字符串
     */
    public static final String	STRING_SPLIT = "^\\d+(,\\d+)*$";

    /**
     * 以逗号隔开的数字字符串
     */
    public static final String	INTEGER_SPLIT = "^\\d+(,\\d+)*$";

    /**
     * Integer正则表达式 ^-?(([1-9]\d*$)|0)
     */
    public static final String	INTEGER	= "^-?(([1-9]\\d*$)|0)";

    /**
     * 正整数正则表达式 >=0 ^[1-9]\d*|0$
     */
    public static final String	INTEGER_NEGATIVE = "^[1-9]\\d*$";
    /***
     * 浮点数
     * */
    public static final String  FLOAT ="^(-?\\d+)(\\.\\d+)?$";

    /**
     * 非中文正则
     */
    public static final String	NOT_CHINESE	= "[^\u4e00-\u9fa5]";

    /**
     * 中文字符正则
     */
    public static final String	CHINESE = "[\\u4e00-\\u9fa5]";

    /**
     * 中文词语正则
     */
    public static final String	CHINESES = "[\\u4e00-\\u9fa5]+";

    /**
     * 中文+减号+下划线+特殊符号正则
     */
    public static final String	ENGLISH_NUMBER_PROSKU	= "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\u4E00-\u9FA5 ]";
    /***
     * 日期正则 支持：
     * YYYY-MM-DD
     */
    public static final String	DATE_FORMAT = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
    /***
     * 日期正则 支持：
     *YYYY-MM-DD HH:mm:ss
     */
    public static final String	DATE_TIME_FORMAT = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
    /**
     * 过滤特殊字符串正则
     * regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]";
     */
    public static final String	STR_SPECIAL	= "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]";

    /**
     * 醉品密码可以包含数字，字母和标点符号
     */
    public static final String	ZUIPIN_PASSWORD	= "^[A-Za-z0-9`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]+";

    /**
     * 匹配由数字、26个英文字母或者下划线组成的字符串 ^\w+$
     */
    public static final String	STR_ENG_NUM_			= "^\\w+$";
    /**
     * 匹配由数字和26个英文字母组成的字符串 ^[A-Za-z0-9]+$
     */
    public static final String	STR_ENG_NUM				= "^[A-Za-z0-9]+";
    /**
     * 匹配由26个英文字母组成的字符串 ^[A-Za-z]+$
     */
    public static final String	STR_ENG					= "^[A-Za-z]+$";

    /**
     * 匹配由数字和26个英文字母和'-'组成的字符串
     */
    public static final String	STR_ENG_NUM_LINE		= "^[A-Za-z0-9-]+";

    /**
     * 匹配数字组成的字符串 ^[0-9]+$
     */
    public static final String	STR_NUM					= "^[0-9]+$";

    /**
     * 身份证正则表达式
     */
    public static final String	IDCARD					= "((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65)[0-9]{4})"
            + "(([1|2][0-9]{3}[0|1][0-9][0-3][0-9][0-9]{3}" + "[Xx0-9])|([0-9]{2}[0|1][0-9][0-3][0-9][0-9]{3}))";

    /**
     * 负整数正则表达式 <=0 ^-[1-9]\d*|0$
     */
    public static final String	INTEGER_POSITIVE		= "^-[1-9]\\d*|0$";
    /**
     * Double正则表达式 ^-?([1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0)$
     */
    public static final String	DOUBLE					= "^-?([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0)$";
    /**
     * 正Double正则表达式 >=0 ^[1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0$　
     */
    public static final String	DOUBLE_NEGATIVE			= "^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0$";
    /**
     * 负Double正则表达式 <= 0 ^(-([1-9]\d*\.\d*|0\.\d*[1-9]\d*))|0?\.0+|0$
     */
    public static final String	DOUBLE_POSITIVE			= "^(-([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*))|0?\\.0+|0$";
    /**
     * 年龄正则表达式 ^(?:[1-9][0-9]?|1[01][0-9]|120)$ 匹配0-120岁
     */
    public static final String	AGE						= "^(?:[1-9][0-9]?|1[01][0-9]|120)$";
    /**
     * 邮编正则表达式 [0-9]\d{5}(?!\d) 国内6位邮编
     */
    public static final String	CODE					= "[0-9]\\d{5}(?!\\d)";
    /**
     * 编译传入正则表达式和字符串去匹配,忽略大小写
     *
     * @param regex        正则
     * @param beTestString 字符串
     * @return {boolean}
     */
    public static boolean match(String regex, String beTestString) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(beTestString);
        return matcher.matches();
    }

    /**
     * 编译传入正则表达式在字符串中寻找，如果匹配到则为true
     *
     * @param regex        正则
     * @param beTestString 字符串
     * @return {boolean}
     */
    public static boolean find(String regex, String beTestString) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(beTestString);
        return matcher.find();
    }

    /**
     * 编译传入正则表达式在字符串中寻找，如果找到返回第一个结果
     * 找不到返回null
     *
     * @param regex         正则
     * @param beFoundString 字符串
     * @return {boolean}
     */
    @Nullable
    public static String findResult(String regex, String beFoundString) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(beFoundString);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    /**
     * 判断字段是否为Email 符合返回ture
     * @param str
     * @return boolean
     */
    public static boolean isEmail(String str) {
        return match(str, EMAIL);
    }

    /**
     * 判断是否为电话号码 符合返回ture
     * @param str
     * @return boolean
     */
    public static boolean isPhone(String str) {
        return match(str, PHONE);
    }

    /**
     * 判断是否为电话号码 符合返回ture
     * @param str
     * @return boolean
     */
    public static boolean isTelePhone(String str) {
        return match(str, TELEPHONE);
    }

    /**
     * 判断是否为模糊手机号
     * @param str
     * @return boolean
     */
    public static boolean isMobileFuzzy(String str) {
        return match(str, MOBILE_FUZZY);
    }

    /**
     * 判断是否为手机号码 符合返回ture
     * @param str
     * @return boolean
     */
    public static boolean isMobile(String str) {
        return match(str, PHONE);
    }

    /**
     * 判断是否为Url 符合返回ture
     * @param str
     * @return boolean
     */
    public static boolean isUrl(String str) {
        return match(str, URL);
    }

    /**
     * 判断字段是否为数字 正负整数 正负浮点数 符合返回ture
     * @param str
     * @return boolean
     */
    public static boolean isNumber(String str) {
        return match(str, DOUBLE);
    }

    /**
     * 判断字段是否为INTEGER 符合返回ture
     * @param str
     * @return boolean
     */
    public static boolean isInteger(String str) {
        return match(str, INTEGER);
    }

    /**
     * 判断字段是否为正整数正则表达式 >=0 符合返回ture
     * @param str
     * @return boolean
     */
    public static boolean isINTEGER_NEGATIVE(String str) {
        return match(str, INTEGER_NEGATIVE);
    }

    /**
     * 判断字段是否为负整数正则表达式 <=0 符合返回ture
     * @param str
     * @return boolean
     */
    public static boolean isINTEGER_POSITIVE(String str) {
        return match(str, INTEGER_POSITIVE);
    }

    /**
     * 判断字段是否为DOUBLE 符合返回ture
     * @param str
     * @return boolean
     */
    public static boolean isDouble(String str) {
        return match(str, DOUBLE);
    }

    /**
     * 判断字段是否为正浮点数正则表达式 >=0 符合返回ture
     * @param str
     * @return boolean
     */
    public static boolean isDOUBLE_NEGATIVE(String str) {
        return match(str, DOUBLE_NEGATIVE);
    }

    /**
     * 判断字段是否为负浮点数正则表达式 <=0 符合返回ture
     * @param str
     * @return boolean
     */
    public static boolean isDOUBLE_POSITIVE(String str) {
        return match(str, DOUBLE_POSITIVE);
    }

    /**
     * 验证2010-12-10
     * @param str
     * @return
     */
    public static boolean isDate1(String str) {
        return match(str, DATE_FORMAT);
    }

    /**
     * 判断字段是否为年龄 符合返回ture
     * @param str
     * @return boolean
     */
    public static boolean isAge(String str) {
        return match(str, AGE);
    }

    /**
     * 判断字段是否超长
     * 字串为空返回fasle, 超过长度{leng}返回ture 反之返回false
     * @param str
     * @param leng
     * @return boolean
     */
    public static boolean isLengOut(String str, int leng) {
        return StringUtil.isEmpty(str) ? false : str.trim().length() > leng;
    }

    /**
     * 判断字段是否为身份证 符合返回ture
     * @param str
     * @return boolean
     */
    public static boolean isIdCard(String str) {
        if (StringUtil.isEmpty(str)) {
            return false;
        }
        if (str.trim().length() == 15 || str.trim().length() == 18) {
            return match(str,IDCARD);
        } else {
            return false;
        }

    }


    /**
     * 判断字符串是不是全部是英文字母
     * @param str
     * @return boolean
     */
    public static boolean isEnglish(String str) {
        return match(str, STR_ENG);
    }

    /**
     * 判断字符串是不是全部是英文字母+数字
     * @param str
     * @return boolean
     */
    public static boolean isENG_NUM(String str) {
        return match(str, STR_ENG_NUM);
    }

    /**
     * 判断字符串是不是全部是英文字母+数字+下划线
     * @param str
     * @return boolean
     */
    public static boolean isENG_NUM_(String str) {
        return match(str, STR_ENG_NUM_);
    }

    /**
     * 过滤特殊字符串 返回过滤后的字符串
     * @param str
     * @return boolean
     */
    public static String filterStr(String str) {
        Pattern p = Pattern.compile(STR_SPECIAL);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }


    /**
     * 判断字符串是不是数字组成
     * @param str
     * @return boolean
     */
    public static boolean isSTR_NUM(String str) {
        return match(str, STR_NUM);
    }
}
