package com.pinyougou.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import entity.Result;
import util.FastDFSClient;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 37269 on 2018/7/27.
 */
@RestController
public class UploadController {

    @Value("${FILE_SERVER_URL}")
    private String file_server_url;//服务器url

    @Autowired
    private HttpServletResponse response;

    /*@RequestMapping("/upload")
    public void upload(@RequestParam("imgFile") MultipartFile [] imgFile ){

        try {
            PrintWriter out = response.getWriter();

            FastDFSClient client=new FastDFSClient("classpath:config/fdfs_client.conf");

            for( MultipartFile file: imgFile){
                //获取上传文件的扩展名
                String fileName = file.getOriginalFilename();
                String extName= fileName.substring(fileName.lastIndexOf(".")+1);

                String path = client.uploadFile(file.getBytes(), extName);
                //error 0     url
                Map map=new HashMap<>();
                map.put("error",0);
                map.put("url",file_server_url+ path   );
                String json = JSON.toJSONString(map);
                System.out.println(json);
                out.print(json);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    @RequestMapping("/upload")
    public Result upload( MultipartFile file){
        //1、取文件的扩展名
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        try {
        //2、创建一个 FastDFS 的客户端
            FastDFSClient fastDFSClient
                    = new FastDFSClient("classpath:config/fdfs_client.conf");
            //3、执行上传处理
            String path = fastDFSClient.uploadFile(file.getBytes(), extName);
            //4、拼接返回的 url 和 ip 地址，拼装成完整的 url
            String url = file_server_url + path;
            System.out.println(url);
            return new Result(true,url);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "上传失败");
        }
    }

}
