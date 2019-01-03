package com.study.spring.test;

/**
 * JUnit参数化测试
 * <pre>
 *     具体使用参照test/com.dranawhite.com.study.spring.study.CommonUtilsTest
 * </pre>
 *
 * @author dranawhite 2017/8/18
 * @version 1.0
 */
final class CommonUtils {

    public static final String transferCammel(String str) {
        str = str.toLowerCase();
        String[] strs = str.split("_");
        String result = "";
        for(int i = 0, len = strs.length; i < len; i++) {
            if (i > 0) {
                char[] chs = strs[i].toCharArray();
                chs[0] = (char) (chs[0] - 32);
                result += new String(chs);
            } else {
                result += strs[i];
            }
        }
        return result;
    }

}
