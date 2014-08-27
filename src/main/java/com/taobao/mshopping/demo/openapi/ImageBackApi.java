package com.taobao.mshopping.demo.openapi;

import com.alibaba.appengine.server.service.pic.Pic;
import com.alibaba.appengine.server.service.pic.PicService;
import com.alibaba.appengine.server.service.pic.PicServiceFactory;
import com.alibaba.appengine.server.service.pic.Response;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xiangmao.cxm
 * Date: 14-8-20
 * Time: 下午2:27
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ImageBackApi {
//    private PicService picService = PicServiceFactory.getPicService();

    @RequestMapping(value = "/image/files")
    @ResponseBody
    public Object queryFile(String dirpath, String page, String pageSize) {
        if (StringUtils.isBlank(page)) {
            page = "1";
        }
        if (StringUtils.isBlank(pageSize)) {
            pageSize = "10";
        }
        HashMap ret = new HashMap();
        ret.put("success", true);
        ret.put("pageSize", pageSize);
        HashMap module = new HashMap();
        ret.put("module", module);
        module.put("page", page);
        module.put("pageSize", pageSize);
        List<HashMap> fileModule = new ArrayList<HashMap>();
        module.put("file_module", fileModule);
        long start = System.currentTimeMillis();
        Response<List<Pic>> response = PicServiceFactory.getPicService().getPicList(dirpath, Integer.valueOf(page), Integer.valueOf(pageSize));
        long end = System.currentTimeMillis();
        ret.put("elapse:", (end - start));
        if (response.isSuccess()) {
            List<Pic> picList = response.getResult();
            for (int i = 0; i < picList.size(); i++) {
                Pic fileDO = picList.get(i);
                HashMap map = new HashMap();
                map.put("name", fileDO.filename);
                map.put("sizes", fileDO.size);
                map.put("fullUrl", fileDO.fullUrl);
                map.put("gmtModified", fileDO.fileModified);
                fileModule.add(map);
            }
        } else {
            ret.put("message", response.getErrorMsg());
        }
        return ret;
    }

    @RequestMapping(value = "/image/dirtree")
    @ResponseBody
    public Object queryTree() {
        HashMap ret = new HashMap();
        ret.put("success", true);

        HashMap module = new HashMap();
        ret.put("module", module);
        module.put("id", "0");
        module.put("name", "我的图片");
        module.put("open", true);

        List<HashMap> children = querySubDir("/");
        module.put("children", children);

        return ret;
    }

    private List<HashMap> querySubDir(String dirpath) {
        List<HashMap> ret = new ArrayList<HashMap>();
        Response<List<String>> response = PicServiceFactory.getPicService().getDirList(dirpath);
        if (response.isSuccess() && response.getResult() != null) {
            List<String> stringList = response.getResult();
            for (int i = 0; i < stringList.size(); i++) {
                HashMap dirMap = new HashMap();
                String name = stringList.get(i);
                String newpath = "";
                if ("/".equals(dirpath)) {
                    newpath = "/" + name;
                } else {
                    newpath = dirpath + "/" + name;
                }
                dirMap.put("name", name);
                dirMap.put("dirpath", newpath);
                List<HashMap> children = querySubDir(newpath);
                dirMap.put("children", children);
                ret.add(dirMap);
            }
        }
        return ret;
    }

    private List<HashMap> querySubDir2(String dirpath) {
        List<HashMap> ret = new ArrayList<HashMap>();
        Response<List<String>> response = PicServiceFactory.getPicService().getDirList(dirpath);
        if (response.isSuccess() && response.getResult() != null) {
            List<String> stringList = response.getResult();
            for (int i = 0; i < stringList.size(); i++) {
                HashMap dirMap = new HashMap();
                String name = stringList.get(i);
                String newpath = "";
                if ("/".equals(dirpath)) {
                    newpath = "/" + name;
                } else {
                    newpath = dirpath + "/" + name;
                }
                dirMap.put("name", name);
                dirMap.put("dirpath", newpath);
                ret.add(dirMap);
            }
        }
        return ret;
    }

    @RequestMapping(value = "/image/subdir")
    @ResponseBody
    public Object querySub(String dirpath) {
        if (dirpath == null) {
            dirpath = "/";
        }
        HashMap ret = new HashMap();
        ret.put("success", true);

        HashMap module = new HashMap();
        ret.put("module", module);
        ret.put("dirpath", dirpath);

        List<HashMap> children = querySubDir2(dirpath);
        module.put("children", children);

        return ret;
    }
}
