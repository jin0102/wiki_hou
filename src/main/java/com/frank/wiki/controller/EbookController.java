package com.frank.wiki.controller;

import com.frank.wiki.domain.Ebook;
import com.frank.wiki.req.EbookReq;
import com.frank.wiki.resp.CommonResp;
import com.frank.wiki.resp.EbookResp;
import com.frank.wiki.resp.PageResp;
import com.frank.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 对ebook表的操作都在此接口下执行
 */
@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;
    /**
     * 查询所有电子书的方法
     */
    @GetMapping("/getAllEbook")
    public CommonResp<PageResp<EbookResp>> selectAllEbook(EbookReq ebookReq){
        PageResp<EbookResp> respList = ebookService.getAll(ebookReq);
        CommonResp<PageResp<EbookResp>> resp = new CommonResp<>();
        resp.setSuccess(true);
        resp.setMessage("查询成功！");
        resp.setContent(respList);
//        if (respList.isEmpty()) {
//            resp.setSuccess(false);
//            resp.setMessage("查询失败！返回的数据为空。");
//            resp.setContent(respList);
//        }else {
//            resp.setSuccess(true);
//            resp.setMessage("查询成功！");
//            resp.setContent(respList);
//        }
        return resp;
    }

    @GetMapping("/getEbook")
    public CommonResp<List<EbookResp>> selectEbook(EbookReq ebookReq){
        CommonResp<List<EbookResp>> resp = new CommonResp<List<EbookResp>>();
        List<EbookResp> respList = ebookService.getEbook(ebookReq);
        if (respList.isEmpty()) {
            resp.setSuccess(false);
            resp.setMessage("查询失败！返回的数据为空。");
            resp.setContent(respList);
        }else {
            resp.setSuccess(true);
            resp.setMessage("查询成功！");
            resp.setContent(respList);
        }
        return resp;
    }
}
