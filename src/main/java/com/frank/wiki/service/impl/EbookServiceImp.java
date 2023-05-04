package com.frank.wiki.service.impl;

import com.frank.wiki.domain.Ebook;
import com.frank.wiki.domain.EbookExample;
import com.frank.wiki.mapper.EbookMapper;
import com.frank.wiki.req.EbookReq;
import com.frank.wiki.resp.EbookResp;
import com.frank.wiki.resp.PageResp;
import com.frank.wiki.service.EbookService;
import com.frank.wiki.util.CopyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookServiceImp implements EbookService {

    @Resource
    private EbookMapper ebookMapper;

    @Override
    public PageResp<EbookResp> getAll(EbookReq ebookReq){
        PageHelper.startPage(ebookReq.getPage(),ebookReq.getSize());
        List<Ebook> ebookList = ebookMapper.selectByExample(null);
        //List<EbookResp> respList = CopyUtil.copyList(ebookList,EbookResp.class);
        List<EbookResp> respList = CopyUtil.copyList(ebookList,EbookResp.class);
        PageInfo<Object> pageInfo = new PageInfo<>();
        PageResp pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(pageInfo.getList());
        return pageResp;
    }

    @Override
    public List<EbookResp> getEbook(EbookReq ebookReq){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if (!ObjectUtils.isEmpty(ebookReq.getName())){
            criteria.andNameLike("%"+ebookReq.getName()+"%");
        }
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        //List<EbookResp> respList = CopyUtil.copyList(ebookList, EbookResp.class);
        return CopyUtil.copyList(ebookList, EbookResp.class);
    }
}
