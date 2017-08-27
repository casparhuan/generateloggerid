package person.caspar.commonlogger.util;

/**
 * Created by casparhuan on 2017/8/26.
 */
public enum StringUtil {


    INSTANCE;

    /**
     * 字符串从startIndex开始replaceLength个字符替换成replaceChar
     * @param targetStr 需要处理的字符串
     * @param startIndex 替换开始的位置
     * @param replaceLength 替换的长度
     * @param replaceChar 所要替换的目标字符
     * @return 处理后的字符串
     */
    public String replace(String targetStr,int startIndex,int replaceLength,char replaceChar){
        StringBuilder sb = startIndex != 0 ? new StringBuilder(targetStr.substring(0,startIndex)) : new StringBuilder() ;
        for (int i = 0; i < replaceLength; i++) {
            sb.append(replaceChar);
        }
        if (targetStr.length()-replaceLength-startIndex>0){
            sb.append(targetStr.substring(startIndex+replaceLength));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(StringUtil.INSTANCE.replace("12345678",2,"12345678".length()-4,'*'));

    }

}
