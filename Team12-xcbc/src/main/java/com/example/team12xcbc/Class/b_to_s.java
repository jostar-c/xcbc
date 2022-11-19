package com.example.team12xcbc.Class;
import java.math.BigDecimal;
public class b_to_s {

    private static char[] cnNum = new char[]{'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
    private static char[] unitArr = new char[]{'元', '拾', '佰', '仟', '万', '亿'};

    public static BigDecimal chinese2Number(String chineseNumber) {
        BigDecimal result = new BigDecimal(0);
        int lastUnitIndex = 0, num = 0;
        for (int i = 0; i < chineseNumber.length(); i++) {
            boolean isUnit = true;
            char c = chineseNumber.charAt(i);
            //把中文数值部分转换为cnNum数组对应元素的下标
            for (int j = 0; j < cnNum.length; j++) {
                // 是数字
                if (c == cnNum[j]) {
                    // 数字值 = 索引
                    num = j;
                    isUnit = false;
                    break;
                }
            }
            if (isUnit) {
                // 第一个就是单位，如：拾伍万元整
                if (i == 0) {
                    num = 1;
                }
                int unitIndex = getUnitIndex(c);
                BigDecimal unit = getUnit(c);
                if (unitIndex > lastUnitIndex) {
                    //左边单位比右边单位小的情况，如：拾伍万 中的“拾”和“万”理论上是不符合递减规律的
                    result = result.add(new BigDecimal(num)).multiply(unit);
                } else {
                    //正常从左往右单位递减
                    result = result.add(new BigDecimal(num).multiply(unit));
                }
                lastUnitIndex = unitIndex;
                num = 0;
            }
        }
        return result.setScale(2, BigDecimal.ROUND_DOWN);
    }

    private static int getUnitIndex(char c) {
        for (int j = 0; j < unitArr.length; j++) {
            if (c == unitArr[j]) {
                return j;
            }
        }
        return 0;
    }

    //把已经转换为单位数组unitArr下标的单位转换为位权
    private static BigDecimal getUnit(char c) {
        long num = 0;
        int unitIndex = getUnitIndex(c);
        switch (unitIndex) {
            // '元', '拾', '佰', '仟', '万', '亿'
            case 1:
                num = 10;
                break;
            case 2:
                num = 100;
                break;
            case 3:
                num = 1000;
                break;
            case 4:
                num = 10000;
                break;
            case 5:
                num = 100000000;
                break;
            case 0:
                num = 1;
                break;
            default:
                break;
        }
        return new BigDecimal(num);
    }
    public String c2u(String s){
        String str = String.valueOf(chinese2Number(s).longValue());
        return str;
    }
}
