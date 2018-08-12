package com.justh5.experiment.util;
import org.apache.commons.lang.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangjiaxi
 *
 */
public class StringUtil {

    /**
     * <p>
     * 检查指定的字符串是否为空.
     * </p>
     *
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     *
     * @param str
     *            待检查字符串
     * @return <code>true</code> if the String is null, empty or whitespace
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * 检查指定的字符串是否非空.
     * </p>
     *
     * <pre>
     * StringUtils.isNotBlank(null)      = false
     * StringUtils.isNotBlank("")        = false
     * StringUtils.isNotBlank(" ")       = false
     * StringUtils.isNotBlank("bob")     = true
     * StringUtils.isNotBlank("  bob  ") = true
     * </pre>
     *
     * @param str
     *            待检查字符串
     * @return <code>true</code> if the String is not empty and not null and not
     *         whitespace
     */
    public static boolean isNotBlank(String str) {
        return !StringUtils.isBlank(str);
    }

    /**
     * <p>
     * Checks if a String is empty ("") or null.
     * </p>
     *
     * <pre>
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty("")        = true
     * StringUtils.isEmpty(" ")       = false
     * StringUtils.isEmpty("bob")     = false
     * StringUtils.isEmpty("  bob  ") = false
     * </pre>
     *
     * @param str
     *            the String to check, may be null
     * @return <code>true</code> if the String is empty or null
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * <p>
     * 去除字符串前后空格.
     * </p>
     *
     * <pre>
     * StringUtils.trim(null)          = null
     * StringUtils.trim("")            = ""
     * StringUtils.trim("     ")       = ""
     * StringUtils.trim("abc")         = "abc"
     * StringUtils.trim("    abc    ") = "abc"
     * </pre>
     *
     * @param str
     *            待去除空格字符串
     * @return the trimmed string, <code>null</code> if null String input
     */
    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    /**
     * <p>
     * 将blank字符串转化为<code>null</code>.
     * </p>
     *
     * <pre>
     * StringUtils.trimToNull(null)          = null
     * StringUtils.trimToNull("")            = null
     * StringUtils.trimToNull("     ")       = null
     * StringUtils.trimToNull("abc")         = "abc"
     * StringUtils.trimToNull("    abc    ") = "abc"
     * </pre>
     *
     * @param str
     *            待转换字符串
     * @return the trimmed String
     */
    public static String trimToNull(String str) {
        String ts = trim(str);
        return isBlank(ts) ? null : ts;
    }

    /**
     * 是否为汉字 汉字范围为 19968 - 40869
     *
     * @param src
     * @return
     */
    public static boolean isChineseCharacter(String src) {
        boolean ret = true;
        if (src == null || src.trim().length() == 0) {
            return ret;
        }

        char[] charArr = src.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char ch = charArr[i];
            if (ch < 19968 || ch > 40869) {
                ret = false;
                break;
            }
        }
        return ret;
    }

    /**
     * 获取字符长度：汉、日、韩文字符长度为2，ASCII码等字符长度为1
     *
     * @param c
     *            字符
     * @return 字符长度
     */
    private static int getSpecialCharLength(char c) {
        if (isLetter(c)) {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * 判断一个字符是Ascill字符还是其它字符（如汉，日，韩文字符）
     *
     * @param
     *            c, 需要判断的字符
     * @return boolean, 返回true,Ascill字符
     */
    private static boolean isLetter(char c) {
        int k = 0x80;
        return c / k == 0;
    }

    public static boolean isChild(String id) {
        int age = getAgeByCardNo(id);
        return age <= 12 && age >= 2;
    }

    public static boolean isBaby(String pCardNo) {
        int age = getAgeByCardNo(pCardNo);
        return age < 2;
    }

    public static int getAgeByCardNo(String id) {
        if (id == null || (id.length() != 15 && id.length() != 18)) {
            return -1;
        }
        String year = id.length() == 15 ? "19" + id.substring(6, 8) : id.substring(6, 10);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int thisYear = calendar.get(Calendar.YEAR);
        int idYear = 0;
        try {
            idYear = Integer.parseInt(year);
        } catch (Exception e) {
        }

        return thisYear - idYear;
    }

    /**
     * 去除回车换行符
     *
     * @param src
     * @return
     */
    public static String deleteReturn(String src) {
        if (src == null || src.trim().length() == 0) {
            return "";
        }
        src = src.replaceAll("\r", " ");
        src = src.replaceAll("\n", " ");
        src = src.replaceAll("\t", " ");
        return src;
    }

    /**
     * 替换特殊字符
     *
     * @param str
     * @return
     */
    public static String replaceCharacter(String str) {
        if (str == null || str.trim().length() == 0) {
            return "";
        }
        str = str.replaceAll("\r", "");
        str = str.replaceAll("\n", "");
        str = str.replaceAll("\t", "");
        return str;
    }

    public static boolean containChineseChar(String str) {
        if (str == null || str.trim().length() == 0) {
            return false;
        }
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (!isLetter(charArr[i])) {
                return true;
            }
        }
        return false;
    }


    private static Pattern PAT_WORDS = Pattern.compile("^[0-9a-zA-Z]+$");
    /**
     * 判断证件号是否只为字母和数字的组合。为null或者空串都返回false
     *
     * @param cardNo
     * @return
     */
    public static boolean isCardIDAccordWithFormat(String cardNo) {
        if (StringUtils.isBlank(cardNo)) {
            return false;
        }
        return PAT_WORDS.matcher(cardNo).find();
    }

    /**
     * 过滤掉字符串中的特殊字符
     *
     * @param str
     * @return
     */
    public static String specialCharacterfilter(String str) {
        if (str == null) {
            return null;
        }
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\\\\\\ ]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

    public static String filterSpecialChar4Xss(String xssStr) {
        if (xssStr == null) {
            return null;
        }

        xssStr = xssStr.replaceAll("[''\\[\\]<>/“\\\\\\ ]", "");
        return xssStr;
    }

    /**
     * 校验手机号是否正确
     *
     * @param str
     * @return
     */
    public static boolean isPhoneNumber(String str) {
        if (str == null) {
            return false;
        }
        String regEx = "^1[0-9]{10}$";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static String htmlBr2NewLine(String html) {
        if (StringUtils.isBlank(html)) {
            return html;
        }
        // 将<br />替换为\n-换行符
        html = html.replaceAll("<br />", "\n");
        html = html.replaceAll("<.*?>", "");
        html = html.replaceAll("quot;", "");
        // 除,:.，。？：；;‘’！“”—……、\\u4e00-\\u9fa5a-zA-Z%％\\d\\n（）【】{}《》以外的字符都替换为空
        html = html.replaceAll("[^,:.，。？：；;‘’！“”—……、\\u4e00-\\u9fa5a-zA-Z%％\\d\\n（）【】{}《》]", "");

        return html;
    }

    public static String getDefalutString(String value) {
        if (StringUtils.isBlank(value)) {
            return StringUtils.EMPTY;
        }
        return value.trim();
    }

    /**
     * 获取字符串里的第一个字符
     */
    public static String getFirstCharacter(String value) {
        return value.substring(0, 1);
    }

    // 身份证正则表达式[15位或18位]
    private static String idNumber = "(^[1-9]\\d{13}[0-9a-zA-Z]$)|(^[1-9]\\d{16}[0-9a-zA-Z]$)";

    /**
     * 验证身份证的合法性
     *
     * @param idCardNumber
     * @return boolean
     */
    public static boolean isIDCard(String idCardNumber) {
        // 验证身份证的合法性的标志位
        boolean flag = true;
        // 获取解密后的IdNumber并进行合法性校验
        if (!idCardNumber.matches(idNumber)) {
            // 身份证格式不合法
            flag = false;
        } else { // 身份证格式合法, 判断出生日期
            String year = "", month = "", day = "";
            int intYear = 0, intMonth = 0, intDay = 0, days = 0;

            if ((15 == idCardNumber.length())) {
                year = idCardNumber.substring(6, 8);
                month = idCardNumber.substring(8, 10);
                day = idCardNumber.substring(10, 12);
                intYear = Integer.parseInt(year) + 1900;
                intMonth = Integer.parseInt(month);
                intDay = Integer.parseInt(day);
                days = getDaysInMonth(intYear, intMonth);
                if ((intMonth > 12) || (intDay > days)) {
                    // 输入的出生日期不正确
                    flag = false;
                }
            } else { // 18 == decryptIdNumber.length()
                Calendar cal = Calendar.getInstance();
                int nowYear = cal.get(Calendar.YEAR);
                year = idCardNumber.substring(6, 10);
                month = idCardNumber.substring(10, 12);
                day = idCardNumber.substring(12, 14);
                intYear = Integer.parseInt(year);
                intMonth = Integer.parseInt(month);
                intDay = Integer.parseInt(day);
                days = getDaysInMonth(intYear, intMonth);
                if ((intYear > nowYear) || (intMonth > 12) || (intDay > days)) {
                    // 输入的出生日期不正确
                    flag = false;
                }
            }
        }

        return flag; // 返回验证身份证的合法性的标志位
    }

    /**
     * 返回一个月份的天数
     *
     * @param year
     * @param month
     * @return
     */
    private static int getDaysInMonth(int year, int month) {

        int days = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    days = 29;
                    // 不是闰年
                } else {
                    days = 28;
                }
                break;
            default:
                break;
        }
        // 返回一个月份的天数
        return days;
    }

    /**
     * 判断字符串null或者""
     * @param str
     * @return
     */
    public static boolean isNullOrWhiteSpace(String str) {
        if (str != null && !"".equals(str) && !" ".equals(str)) {
            return false;
        } else {
            return true;
        }

    }
    private static Pattern PAT_NUM  = Pattern.compile("^\\d+$");
    /**
     * 非负整数（正整数   +   0）
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        Matcher isNum = PAT_NUM.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }



}