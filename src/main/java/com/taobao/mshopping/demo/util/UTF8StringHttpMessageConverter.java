package com.taobao.mshopping.demo.util;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xinyuan on 14/6/26.
 */
public class UTF8StringHttpMessageConverter extends StringHttpMessageConverter {

    private static final MediaType utf8 = new MediaType("text", "plain", Charset.forName("UTF-8"));
    private boolean writeAcceptCharset = true;

    @Override
    protected MediaType getDefaultContentType(String dumy) {
        return utf8;
    }

    protected List<Charset> getAcceptedCharsets() {
        return Arrays.asList(utf8.getCharSet());
    }

    protected void writeInternal(String s, HttpOutputMessage outputMessage)
            throws IOException {
        if (this.writeAcceptCharset) {
            outputMessage.getHeaders().setAcceptCharset(getAcceptedCharsets());
        }
        Charset charset = utf8.getCharSet();
        FileCopyUtils.copy(s, new OutputStreamWriter(outputMessage.getBody(),
                charset));
    }

    public boolean isWriteAcceptCharset() {
        return writeAcceptCharset;
    }

    /**
     * Indicates whether the {@code Accept-Charset} should be written to any outgoing request.
     * <p>Default is {@code true}.
     */
    public void setWriteAcceptCharset(boolean writeAcceptCharset) {
        this.writeAcceptCharset = writeAcceptCharset;
    }


}
