package manager;

public class StringTool {
    public static String nvl(String str, String d) {
        if (str == null)
            return d;
        else
            return str.trim();
    }
 
    public static String reFormat(String content) {
        content = content.replaceAll("(?is)\\s\\s", " ");
        content = content.replaceAll("(?is)</?br>", "\n");
        content = content.replaceAll("(?is)</?p>", "\n");
        content = content.replaceAll("(?is)&nbsp;", "");
        content = content.replaceAll("(?is)</?[a-z][a-z0-9]*[^<>]*>", "");
        content = content.replaceAll("<!¡V/?.*¡V>", "");
        content = content.replaceAll("¡@", "");
        content = content.trim();
        return content;
    }
 
}