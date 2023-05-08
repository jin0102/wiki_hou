package com.frank.wiki.controller;

import com.frank.wiki.req.EbookQueryReq;
import com.frank.wiki.req.EbookSaveReq;
import com.frank.wiki.resp.CommonResp;
import com.frank.wiki.resp.EbookResp;
import com.frank.wiki.resp.PageResp;
import com.frank.wiki.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

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
    public CommonResp<PageResp<EbookResp>> selectAllEbook(@Valid EbookQueryReq ebookReq){
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
    public CommonResp<PageResp<EbookResp>> selectEbook(@Valid EbookQueryReq ebookReq){
        PageResp<EbookResp> respList = ebookService.getEbook(ebookReq);
        CommonResp<PageResp<EbookResp>> resp = new CommonResp<>();
//        if (respList.isEmpty()) {
//            resp.setSuccess(false);
//            resp.setMessage("查询失败！返回的数据为空。");
//            resp.setContent(respList);
//        }else {
//            resp.setSuccess(true);
//            resp.setMessage("查询成功！");
//            resp.setContent(respList);
//        }
        resp.setSuccess(true);
        resp.setMessage("查询成功！");
        resp.setContent(respList);
        return resp;
    }

    /**
     * 保存方法
     * @param req
     * @return
     */
    @PostMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq req) {
        CommonResp resp = new CommonResp<>();
        ebookService.save(req);
        return resp;
    }

    /**
     * 删除方法
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        ebookService.delete(id);
        return resp;
    }
}
