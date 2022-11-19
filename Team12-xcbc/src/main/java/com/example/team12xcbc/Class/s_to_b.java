package com.example.team12xcbc.Class;

//创建BigDecimal对象 并将数据存入对象，调用convert方法实现转换。
public class s_to_b {

    static String cashUnitMoney[] = {"元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万"};

    static String upperNumber[] = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    public String convert(String money) { //处理整数部分。

        int length = money.length(); //根据单位'亿','万','元'，把整数部分分为3种情况处理。

        if (length <= 4) { //金额在千元以内。

            if (length == 1 && Integer.valueOf(money) == 0) //金额为'0'元时的特殊情况。

                return "零元";

            return convertPart(money, length) + "整";

        } else if (length <= 8) { //金额在千万元以内。

            String part1 = money.substring(0, length - 4);//高位

            String part2 = money.substring(length - 4, length);//低4位

            String result1 = convertPart(part1, length);

            String result2 = convertPart(part2, 4);

            return result1 + result2 + "整";

        } else if (length <= 12) { //金额在千亿元以内。

            String part1 = money.substring(0, length - 8); //截取单位为'亿'部分数值。

            String part2 = money.substring(length - 8, length - 4); //截取单位为'万'部分数值。

            String part3 = money.substring(length - 4, length); //截取单位为'元'部分数值。

            String result1 = convertPart(part1, length); //转换单位为'亿'部分数值。

            String result2 = convertPart(part2, 8); //转换单位为'万'部分数值。

            String result3 = convertPart(part3, 4); //转换单位为'元'部分数值。

            String result = result1 + result2 + result3;

            return result + "整";

        } else {

            throw new IllegalArgumentException("超出转换数值范围！");

        }

    }

    public String convertPart(String part, int position) {

        String result = "";

        String number = "";

        String unit = "";

        if (part.equals("0000") && position == 8) //用于排除单位为'万'时，四位数值均为'0'的情况。

            return "";

        for (int i = 0; i < part.length(); i++) {

            int value = Integer.valueOf(String.valueOf(part.charAt(i)));

            number = upperNumber[value];

            unit = cashUnitMoney[position - 1 - i];

            result = result.concat(number).concat(unit);

        }

        result = result.replaceAll("零仟", "零").replaceAll("零佰", "零") //把单位'亿','万','元'放到最后替换。

                .replaceAll("零拾", "零").replaceAll("零零", "零")

                .replaceAll("零零", "零").replaceAll("零亿", "亿")

                .replaceAll("零万", "万").replaceAll("零元", "元");

        return result;

    }
}