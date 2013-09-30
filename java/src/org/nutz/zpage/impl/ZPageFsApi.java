package org.nutz.zpage.impl;

import java.util.ArrayList;
import java.util.List;

import org.nutz.io.ZDir;
import org.nutz.io.ZFile;
import org.nutz.io.ZIO;
import org.nutz.io.fs.ZFsIO;
import org.nutz.ioc.impl.PropertiesProxy;
import org.nutz.lang.Strings;
import org.nutz.zpage.ZPageApi;
import org.nutz.zpage.ZPageConfig;
import org.nutz.zpage.ZPageRule;

public class ZPageFsApi implements ZPageApi {

    private ZIO io;

    private ZDir home;

    private ZPageConfig conf;

    public ZPageFsApi() {
        this.io = new ZFsIO();
    }

    @Override
    public void outputTo(ZDir dest) {}

    @Override
    public void switchTo(ZDir home) {
        this.home = home;
        this.conf = new ZPageConfig();
        
        // 看看有木有特殊的配置信息
        ZFile zf = home.get("zpage.conf");
        if (null != zf) {
            PropertiesProxy pp = new PropertiesProxy(io.readString(zf));

            conf.tmpl(pp.trim("zpage-tmpl", conf.tmpl()));
            conf.libs(pp.trim("zpage-libs", conf.libs()));
            conf.rs(Strings.splitIgnoreBlank(pp.trim("zpage-rs", "imgs,js,css")));
            
            String rules = pp.get("zpage-rules", " .* : normal");
            String[] lines = Strings.splitIgnoreBlank(rules, "\n");
            List<ZPageRule> list = new ArrayList<ZPageRule>(lines.length);
            for (String line : lines) {
                int pos = line.lastIndexOf(':');
                ZPageRule rule = new ZPageRule(Strings.trim(line.substring(0,
                                                                           pos)),
                                               Strings.trim(line.substring(pos + 1)));
                list.add(rule);
            }

        }
    }

    @Override
    public ZPageConfig getConfig() {
        return conf;
    }

}
