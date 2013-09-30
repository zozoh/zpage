package org.nutz.zpage;

import java.util.List;

public class ZPageConfig {

    private String tmpl;

    private String libs;

    private String[] rs;

    private List<ZPageRule> rules;

    public String tmpl() {
        return tmpl;
    }

    public ZPageConfig tmpl(String template) {
        this.tmpl = template;
        return this;
    }

    public String libs() {
        return libs;
    }

    public ZPageConfig libs(String library) {
        this.libs = library;
        return this;
    }

    public String[] rs() {
        return rs;
    }

    public ZPageConfig rs(String[] resources) {
        this.rs = resources;
        return this;
    }

    public List<ZPageRule> rules() {
        return rules;
    }

    public ZPageConfig rules(List<ZPageRule> rules) {
        this.rules = rules;
        return this;
    }

}
