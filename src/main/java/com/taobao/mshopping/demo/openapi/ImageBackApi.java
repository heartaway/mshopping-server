package com.taobao.mshopping.demo.openapi;

import com.alibaba.appengine.server.service.pic.Pic;
import com.alibaba.appengine.server.service.pic.PicServiceFactory;
import com.alibaba.appengine.server.service.pic.Response;
import com.alibaba.fastjson.JSON;
import com.taobao.mshopping.demo.util.ResultUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    final static Logger logger = LoggerFactory.getLogger(ImageBackApi.class);

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


    private static String getPatternName(String fileName) {
        if (StringUtils.isBlank(fileName)) {
            return null;
        } else {
            int index = fileName.lastIndexOf(".");
            if (index == -1) {
                return null;
            }
            String pattern = fileName.substring(index + 1, fileName.length());
            return pattern;
        }
    }

    private static boolean checkImg(String imgSuffix) {
        if (imgSuffix == null) {
            return false;
        }
        if ("jpg".equalsIgnoreCase(imgSuffix)
                || "jpeg".equalsIgnoreCase(imgSuffix)
                || "bmp".equalsIgnoreCase(imgSuffix)
                || "gif".equalsIgnoreCase(imgSuffix)
                || "png".equalsIgnoreCase(imgSuffix)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        assert "123".equals(getPatternName("asdasd.123"));
        assert null == getPatternName("asdasd");
        assert "456".equals(getPatternName("asdasd.123.456"));
        assert null == getPatternName("");
    }

    @RequestMapping(value = "/image/upload")
    @ResponseBody
    public Object uploadWithOutCheck(HttpServletRequest req
            , @RequestParam("files") MultipartFile[] myfiles
            , @RequestParam(value = "path", required = false) String path) throws IOException, ServletException {

        if (myfiles != null) {
            Map<String, String> urls = new HashMap<String, String>();
            for (MultipartFile file : myfiles) {
//                return ResultUtil.genSuccessResult();
                BufferedImage image = ImageIO.read(file.getInputStream());
                logger.warn("uploading {}", file.getOriginalFilename());
                if (image != null) {
                    String fileName = file.getOriginalFilename();
                    logger.warn("image is not null, uploading {}", file.getOriginalFilename());


                    String pattern = getPatternName(fileName);
                    if (!checkImg(pattern)) {
                        logger.warn("图片后缀名错误, uploading {}", file.getOriginalFilename());

                        return ResultUtil.genFailedResult("图片后缀名错误");
                    }

                    ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
                    ImageIO.write(image, pattern, byteOut);
                    byte[] bytes = byteOut.toByteArray();
                    PicServiceFactory.getPicService().deletePic(path, fileName);
                    Response<Pic> response = PicServiceFactory.getPicService().savePic(path, fileName, bytes);
                    logger.warn("response : {}, uploading {}", new Object[]{JSON.toJSONString(response), file.getOriginalFilename()});

                    if (response.isSuccess()) {
                        urls.put(fileName, response.getResult().fullUrl);
                    } else {
                        return ResultUtil.genFailedResult(response.getErrorMsg());
                    }
                }

            }
            return ResultUtil.genSuccessResult(urls);
        }
        return ResultUtil.genFailedResult("图片未上传或者格式错误");
    }
}
