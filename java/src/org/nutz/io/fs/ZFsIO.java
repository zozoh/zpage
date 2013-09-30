package org.nutz.io.fs;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;

import org.nutz.io.ZIO;
import org.nutz.io.ZFile;
import org.nutz.lang.Files;
import org.nutz.lang.Lang;
import org.nutz.lang.Streams;

public class ZFsIO implements ZIO {

    @Override
    public void write(ZFile zf, InputStream ins) {
        File f = checkFile(zf);
        Files.write(f, ins);
    }

    @Override
    public void writeString(ZFile zf, Reader r) {
        File f = checkFile(zf);
        Files.write(f, r);
    }

    @Override
    public InputStream read(ZFile zf) {
        return Streams.fileIn(checkFile(zf));
    }

    @Override
    public Reader readString(ZFile zf) {
        return Streams.fileInr(checkFile(zf));
    }

    private File checkFile(ZFile zf) {
        File f = Files.findFile(zf.getPath());
        if (f == null)
            throw Lang.makeThrow("Fail to found %s", zf.getPath());
        return f;
    }
}
