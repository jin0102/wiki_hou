package com.frank.wiki.service.impl;

import com.frank.wiki.domain.Ebook;
import com.frank.wiki.domain.EbookExample;
import com.frank.wiki.mapper.EbookMapper;
import com.frank.wiki.req.EbookQueryReq;
import com.frank.wiki.req.EbookSaveReq;
import com.frank.wiki.resp.EbookResp;
import com.frank.wiki.resp.PageResp;
import com.frank.wiki.service.EbookService;
import com.frank.wiki.util.CopyUtil;
import com.frank.wiki.util.SnowFlake;
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

    @Resource
    private SnowFlake snowFlake;

    @Override
    public PageResp<EbookResp> getAll(EbookQueryReq ebookReq){
        PageHelper.startPage(ebookReq.getPage(),ebookReq.getSize());
        List<Ebook> ebookList = ebookMapper.selectByExample(null);
        //List<EbookResp> respList = CopyUtil.copyList(ebookList,EbookResp.class);
        List<EbookResp> respList = CopyUtil.copyList(ebookList,EbookResp.class);
        PageInfo<Object> pageInfo = new PageInfo<>();
        PageResp pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(respList);
        return pageResp;
    }

    @Override
    public PageResp<EbookResp> getEbook(EbookQueryReq ebookReq){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if (!ObjectUtils.isEmpty(ebookReq.getName())){
            criteria.andNameLike("%"+ebookReq.getName()+"%");
        }
        PageHelper.startPage(ebookReq.getPage(),ebookReq.getSize());
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        //List<EbookResp> respList = CopyUtil.copyList(ebookList, EbookResp.class);
        List<EbookResp> respList = CopyUtil.copyList(ebookList,EbookResp.class);
        PageInfo<Object> pageInfo = new PageInfo<>();
        PageResp pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(respList);
        return pageResp;
    }

    /**
     * 更新和添加方法
     */
    @Override
    public void save(EbookSaveReq req) {
        Ebook ebook = CopyUtil.copy(req, Ebook.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            // 新增
//            long id = snowFlake.nextId();
//            ebook.setId(id);
            ebook.setId(snowFlake.nextId());
            ebookMapper.insert(ebook);
        } else {
            // 更新
            ebookMapper.updateByPrimaryKey(ebook);
        }
    }

    /**
     * 删除方法
     * @param id
     */
    @Override
    public void delete(Long id) {
        ebookMapper.deleteByPrimaryKey(id);
    }
}
