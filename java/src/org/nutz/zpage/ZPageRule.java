package org.nutz.zpage;

import java.util.regex.Pattern;

public class ZPageRule {

    private Pattern regex;

    private String name;

    public ZPageRule(String regex, String name) {
        this.regex = Pattern.compile(regex);
        this.name = name;
    }

    public boolean match(String path) {
        return regex.matcher(path).find();
    }

    public Pattern getRegex() {
        return regex;
    }

    public void setRegex(Pattern regex) {
        this.regex = regex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
